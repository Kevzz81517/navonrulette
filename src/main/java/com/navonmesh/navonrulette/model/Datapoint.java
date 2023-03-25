package com.navonmesh.navonrulette.model;

import com.navonmesh.navonrulette.configuration.type.IdentificationType;
import com.navonmesh.navonrulette.rule.MetaColumnType;
import com.navonmesh.navonrulette.rule.MetaDataType;
import com.navonmesh.navonrulette.exception.ApplicationException;
import com.navonmesh.navonrulette.rule.DataAttribute;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Datapoint {

    private IdentificationType identificationType;

    private Calendar beginning;

    private Calendar ending;

    private String meta1;

    private String meta2;

    private String meta3;

    private String meta4;

    private String meta5;

    private String meta6;

    private String meta7;

    private String primaryMeta1;

    private List<DataAttribute> dataAttributes;

    public Datapoint(IdentificationType identificationType, List<DataAttribute> dataAttributes, Map<MetaDataType, String> meta) {
        this.identificationType = identificationType;
        Map<MetaColumnType, String> metaColumnsData = this.identificationType.trasformMetaDataTypeToMetaColumnType(meta);
        List<String> primaryMetas = new ArrayList<>();
        List<MetaColumnType> primaryMetaColumnTypes =
                identificationType.getPrimaryMetaDataTypes().stream()
                        .map(pmd -> identificationType.getMetaToColumnMapping().get(pmd))
                        .collect(Collectors.toList());
        for (MetaColumnType metaColumnType : metaColumnsData.keySet()) {
            try {

                this.getClass().getDeclaredField(metaColumnType.getColumnName()).setAccessible(true);
                Object value = (metaColumnType.getMetaColumnTypeDataType().getTypeClass()).cast(metaColumnType.getMetaColumnTypeDataType().convert(metaColumnsData.get(metaColumnType)));
                if (primaryMetaColumnTypes.contains(metaColumnType)) {
                    primaryMetas.add((String) value);
                }
                this.getClass().getDeclaredField(metaColumnType.getColumnName()).set(this, value);
            } catch (NoSuchFieldException | IllegalAccessException ex) {

                throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Request", ex);
            }

        }
        if (identificationType.getPrimaryMetaDataTypes().size() > 0) {
            this.setPrimaryMeta1(primaryMetas.get(0));
        }
        this.dataAttributes = dataAttributes;
    }


}
