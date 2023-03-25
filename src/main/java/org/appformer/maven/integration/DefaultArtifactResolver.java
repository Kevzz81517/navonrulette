package org.appformer.maven.integration;

import com.navonmesh.navonrulette.exception.ApplicationException;
import com.navonmesh.navonrulette.service.VendorService;
import org.apache.maven.project.MavenProject;
import org.appformer.maven.integration.embedder.EmbeddedPomParser;
import org.appformer.maven.support.AFReleaseId;
import org.appformer.maven.support.DependencyFilter;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.repository.RepositoryPolicy;
import org.eclipse.aether.util.repository.AuthenticationBuilder;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;

public class DefaultArtifactResolver extends ArtifactResolver {
    private final MavenRepository mavenRepository;
    protected final PomParser pomParser;

    public DefaultArtifactResolver() {
        this.pomParser = new EmbeddedPomParser();
        this.mavenRepository = MavenRepository.getMavenRepository();
        VendorService.PRODUCT_INFOS.forEach((tenantId, tenantInfo) -> {
            try {
                Field field = this.mavenRepository.getClass()
                        .getDeclaredField("remoteRepositoriesForRequest");
                field.setAccessible(true);
                ((Collection<RemoteRepository>) (field.get(this.mavenRepository))).add(
                        new RemoteRepository.Builder(tenantId, "default", tenantInfo.getUrl())
                                .setAuthentication(
                                        new AuthenticationBuilder().addUsername(tenantInfo.getUsername())
                                                .addPassword(tenantInfo.getPassword())
                                                .build()
                                )
                                .setSnapshotPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setReleasePolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .build()
                );
            } catch (NoSuchFieldException | IllegalAccessException ex) {

                throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Loading Artifact", ex);
            }
        });
    }

    DefaultArtifactResolver(MavenProject mavenProject) {
        this.pomParser = new EmbeddedPomParser(mavenProject);
        this.mavenRepository = MavenRepository.getMavenRepository(mavenProject);
        VendorService.PRODUCT_INFOS.forEach((tenantId, externalRepositoryInfo) -> {
            try {
                Field field = this.mavenRepository.getClass()
                        .getDeclaredField("remoteRepositoriesForRequest");
                field.setAccessible(true);
                ((Collection<RemoteRepository>) (field.get(this.mavenRepository))).add(
                        new RemoteRepository.Builder(tenantId, "default", externalRepositoryInfo.getUrl())
                                .setAuthentication(
                                        new AuthenticationBuilder().addUsername(externalRepositoryInfo.getUsername())
                                                .addPassword(externalRepositoryInfo.getPassword())
                                                .build()
                                )
                                .setSnapshotPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setReleasePolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .build()
                );
            } catch (NoSuchFieldException | IllegalAccessException ex) {

                throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Loading Artifact",ex);
            }
        });
    }

    DefaultArtifactResolver(PomParser pomParser) {
        this.pomParser = pomParser;
        this.mavenRepository = MavenRepository.getMavenRepository();
        VendorService.PRODUCT_INFOS.forEach((tenantId, externalRepositoryInfo) -> {
            try {
                Field field = this.mavenRepository.getClass()
                        .getDeclaredField("remoteRepositoriesForRequest");
                field.setAccessible(true);
                ((Collection<RemoteRepository>) (field.get(this.mavenRepository))).add(
                        new RemoteRepository.Builder(tenantId, "default", externalRepositoryInfo.getUrl())
                                .setAuthentication(
                                        new AuthenticationBuilder().addUsername(externalRepositoryInfo.getUsername())
                                                .addPassword(externalRepositoryInfo.getPassword())
                                                .build()
                                )
                                .setSnapshotPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setPolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .setReleasePolicy(new RepositoryPolicy(true, RepositoryPolicy.UPDATE_POLICY_ALWAYS, RepositoryPolicy.CHECKSUM_POLICY_WARN))
                                .build()
                );
            } catch (NoSuchFieldException | IllegalAccessException e) {

                throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Error Loading Artifact", e);
            }
        });
    }

    public Artifact resolveArtifact(AFReleaseId releaseId) {
        return this.mavenRepository.resolveArtifact(releaseId);
    }

    public List<DependencyDescriptor> getArtifactDependecies(String artifactName) {
        return this.mavenRepository.getArtifactDependecies(artifactName);
    }

    public List<DependencyDescriptor> getPomDirectDependencies(DependencyFilter dependencyFilter) {
        return this.pomParser.getPomDirectDependencies(dependencyFilter);
    }

    public ArtifactLocation resolveArtifactLocation(AFReleaseId releaseId) {
        try {
            Artifact artifact = this.resolveArtifact(releaseId);
            return artifact == null ? null : new ArtifactLocation(artifact, artifact.getFile().toURL(), false);
        } catch (MalformedURLException var3) {
            return null;
        }
    }
}
