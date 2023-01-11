package org.appformer.maven.integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.maven.project.MavenProject;
import org.appformer.maven.integration.MavenPomModelGenerator.MavenModel;
import org.appformer.maven.integration.embedder.MavenProjectLoader;
import org.appformer.maven.support.AFReleaseId;
import org.appformer.maven.support.DependencyFilter;
import org.appformer.maven.support.MinimalPomParser;
import org.appformer.maven.support.PomModel;
import org.eclipse.aether.artifact.Artifact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ArtifactResolver {
    private static final Logger log = LoggerFactory.getLogger(ArtifactResolver.class);

    public ArtifactResolver() {
    }

    public static ArtifactResolver getResolverFor(ClassLoader classLoader, AFReleaseId releaseId, boolean allowDefaultPom) {
        InJarArtifactResolver inJarResolver = new InJarArtifactResolver(classLoader, releaseId);
        if (inJarResolver.isLoaded()) {
            return inJarResolver;
        } else {
            ArtifactResolver resolver = getResolverFor(releaseId, allowDefaultPom);
            return resolver != null ? resolver : null;
        }
    }

    public static ArtifactResolver getResolverFor(AFReleaseId releaseId, boolean allowDefaultPom) {
        File pomFile = getPomFileForGAV(releaseId, allowDefaultPom);
        if (pomFile != null) {
            ArtifactResolver artifactResolver = getResolverFor(pomFile);
            if (artifactResolver != null) {
                return artifactResolver;
            }
        }

        return allowDefaultPom ? new DefaultArtifactResolver() : null;
    }

    public static ArtifactResolver getResolverFor(URI uri) {
        return getResolverFor(new File(uri));
    }

    public static ArtifactResolver getResolverFor(File pomFile) {
        try {
            return new DefaultArtifactResolver(MavenProjectLoader.parseMavenPom(pomFile));
        } catch (RuntimeException var3) {
            log.warn("Cannot use native maven pom parser, fall back to the internal one", var3);
            PomParser pomParser = createInternalPomParser(pomFile);
            return pomParser != null ? new DefaultArtifactResolver(pomParser) : null;
        }
    }

    public static ArtifactResolver getResolverFor(InputStream pomStream) {
        MavenProject mavenProject = MavenProjectLoader.parseMavenPom(pomStream);
        return new DefaultArtifactResolver(mavenProject);
    }

    private static File getPomFileForGAV(AFReleaseId releaseId, boolean allowDefaultPom) {
        String artifactName = releaseId.getGroupId() + ":" + releaseId.getArtifactId() + ":pom:" + releaseId.getVersion();
        Artifact artifact = MavenRepository.getMavenRepository().resolveArtifact(artifactName, !allowDefaultPom);
        return artifact != null ? artifact.getFile() : null;
    }

    public static ArtifactResolver getResolverFor(InputStream pomStream, AFReleaseId releaseId, boolean allowDefaultPom) {
        if (pomStream != null) {
            ArtifactResolver artifactResolver = getResolverFor(pomStream);
            if (artifactResolver != null) {
                return artifactResolver;
            }
        }

        return getResolverFor(releaseId, allowDefaultPom);
    }

    public static ArtifactResolver getResolverFor(PomModel pomModel) {
        return pomModel instanceof MavenModel ? new DefaultArtifactResolver(((MavenModel) pomModel).getMavenProject()) : new DefaultArtifactResolver();
    }

    private static ArtifactResolver.InternalPomParser createInternalPomParser(File pomFile) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(pomFile);
            ArtifactResolver.InternalPomParser var2 = new ArtifactResolver.InternalPomParser(MinimalPomParser.parse(pomFile.getAbsolutePath(), fis));
            return var2;
        } catch (FileNotFoundException var12) {
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException var11) {
                    log.error("Cannot create internal pom parser", var11);
                }
            }

        }

        return null;
    }

    public static ArtifactResolver create() {
        return new DefaultArtifactResolver();
    }

    public Collection<DependencyDescriptor> getAllDependecies(DependencyFilter dependencyFilter) {
        Set<DependencyDescriptor> dependencies = new HashSet();
        Iterator var3 = this.getPomDirectDependencies(dependencyFilter).iterator();

        while (var3.hasNext()) {
            DependencyDescriptor dep = (DependencyDescriptor) var3.next();
            dependencies.add(dep);
            Iterator var5 = this.getArtifactDependecies(dep.toString()).iterator();

            while (var5.hasNext()) {
                DependencyDescriptor transitiveDep = (DependencyDescriptor) var5.next();
                if (dependencyFilter.accept(dep.getReleaseId(), dep.getScope())) {
                    dependencies.add(transitiveDep);
                }
            }
        }

        return dependencies;
    }

    public Collection<DependencyDescriptor> getAllDependecies() {
        return this.getAllDependecies((releaseId, scope) -> {
            return true;
        });
    }

    public abstract List<DependencyDescriptor> getPomDirectDependencies(DependencyFilter var1);

    public abstract Artifact resolveArtifact(AFReleaseId var1);

    public abstract List<DependencyDescriptor> getArtifactDependecies(String var1);

    public abstract ArtifactResolver.ArtifactLocation resolveArtifactLocation(AFReleaseId var1);

    public static class ArtifactLocation {
        private boolean classPath;
        private URL url;
        private Artifact artifact;

        public ArtifactLocation(Artifact artifact, URL url, boolean classPath) {
            this.url = url;
            this.artifact = artifact;
            this.classPath = classPath;
        }

        public Artifact getArtifact() {
            return this.artifact;
        }

        public URL toURL() {
            return this.url;
        }

        public boolean isClassPath() {
            return this.classPath;
        }
    }

    private static class InternalPomParser implements PomParser {
        private final PomModel pomModel;

        private InternalPomParser(PomModel pomModel) {
            this.pomModel = pomModel;
        }

        public List<DependencyDescriptor> getPomDirectDependencies(DependencyFilter filter) {
            List<DependencyDescriptor> deps = new ArrayList();
            Iterator var3 = this.pomModel.getDependencies(filter).iterator();

            while (var3.hasNext()) {
                AFReleaseId rId = (AFReleaseId) var3.next();
                deps.add(new DependencyDescriptor(rId));
            }

            return deps;
        }
    }
}
