package com.navonmesh.navonrulette.configuration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.navonmesh.navonrulette.rule.MetaColumnType;
import com.navonmesh.navonrulette.rule.MetaDataType;
import com.navonmesh.navonrulette.rule.type.DataAttributeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

interface IdentificationTypeMethod {

    default List<PreProcessingType> getPreprocessings() {

        return Collections.emptyList();
    }

    default List<Pair<MetaDataType, Boolean>> getMetaDataTypes() {

        return this.getMetaToColumnMapping().keySet().stream().map(item -> Pair.of(item, true))
                .collect(Collectors.toList());
    }

    default Map<MetaDataType, MetaColumnType> getMetaToColumnMapping() {

        return Collections.emptyMap();
    }

    default boolean isMetaValid(Map<MetaDataType, String> meta) {

        List<Pair<MetaDataType, Boolean>> expectedMeta = this.getMetaDataTypes();

        return expectedMeta.size() == meta.size() &&
                expectedMeta.stream().noneMatch((metaDataType) -> (metaDataType.getSecond() && meta.get(metaDataType.getFirst()) == null));
    }

    default HashMap<MetaColumnType, String> trasformMetaDataTypeToMetaColumnType(Map<MetaDataType, String> meta) {

        HashMap<MetaColumnType, String> metaColumnMapping = new HashMap<>();

        meta.forEach((metaDataType, value) -> metaColumnMapping.put(this.getMetaToColumnMapping().get(metaDataType), value));

        return metaColumnMapping;
    }

}

@JsonSerialize(converter = IdentificationType.IdentificationTypeToDtoConverter.class)
public enum IdentificationType implements IdentificationTypeMethod {

    INDIVIDUAL_EQUIFAX_REPORT("Equifax Report",
            Arrays.asList(
                    DataAttributeType.NO_OF_ACCOUNTS,
                    DataAttributeType.NO_OF_ACTIVE_ACCOUNTS,
                    DataAttributeType.NO_OF_WRITE_OFFS,
                    DataAttributeType.TOTAL_PAST_DUE_AMOUNT,
                    DataAttributeType.MOST_SEVERE_STATUS_WITH_IN24_MONTHS,
                    DataAttributeType.SINGLE_HIGHEST_CREDIT,
                    DataAttributeType.SINGLE_HIGHEST_SANCTION_AMOUNT,
                    DataAttributeType.TOTAL_HIGH_CREDIT,
                    DataAttributeType.AVERAGE_OPEN_BALANCE,
                    DataAttributeType.SINGLE_HIGHEST_BALANCE,
                    DataAttributeType.NO_OF_PAST_DUE_ACCOUNTS,
                    DataAttributeType.NO_OF_ZERO_BALANCE_ACCOUNTS,
                    DataAttributeType.RECENT_ACCOUNT,
                    DataAttributeType.OLDEST_ACCOUNT,
                    DataAttributeType.TOTAL_BALANCE_AMOUNT,
                    DataAttributeType.TOTAL_SANCTION_AMOUNT,
                    DataAttributeType.TOTAL_CREDIT_LIMIT,
                    DataAttributeType.TOTAL_MONTHLY_PAYMENT_AMOUNT,
                    DataAttributeType.ACCOUNTS_DELIQUENT_IN_LAST_90_DAYS,
                    DataAttributeType.ACCOUNTS_OPENED_IN_LAST_90_DAYS,
                    DataAttributeType.ACCOUNTS_UPDATED_IN_LAST_90_DAYS,
                    DataAttributeType.TOTAL_INQUIRIES_IN_LAST_90_DAYS,
                    DataAttributeType.EQUIFAX_SCORE,
                    DataAttributeType.PAYMENT_STATUS_000_COUNT,
                    DataAttributeType.PAYMENT_STATUS_01PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_30PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_60PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_CLSD_COUNT,
                    DataAttributeType.PAYMENT_STATUS_NEW_COUNT,
                    DataAttributeType.PAYMENT_STATUS_LNSB_COUNT,
                    DataAttributeType.PAYMENT_STATUS_LAND_COUNT,
                    DataAttributeType.PAYMENT_STATUS_INAC_COUNT,
                    DataAttributeType.PAYMENT_STATUS_CON_COUNT,
                    DataAttributeType.PAYMENT_STATUS_01PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_30PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_60PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_90PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_120PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_180PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_360PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_540PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_720PLUS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_DBT_COUNT,
                    DataAttributeType.PAYMENT_STATUS_FPD_COUNT,
                    DataAttributeType.PAYMENT_STATUS_WDF_COUNT,
                    DataAttributeType.PAYMENT_STATUS_PWOS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_NON_DELIQUENT_COUNT,
                    DataAttributeType.PAYMENT_STATUS_STD_COUNT,
                    DataAttributeType.PAYMENT_STATUS_LOSS_COUNT,
                    DataAttributeType.PAYMENT_STATUS_SFR_COUNT,
                    DataAttributeType.PAYMENT_STATUS_SFWD_COUNT,
                    DataAttributeType.PAYMENT_STATUS_WOF_COUNT,
                    DataAttributeType.PAYMENT_STATUS_SFWO_COUNT,
                    DataAttributeType.PAYMENT_STATUS_WDWO_COUNT,
                    DataAttributeType.PAYMENT_STATUS_SWDW_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_000_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_CLSD_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_NEW_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_LNSB_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_LAND_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_INAC_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_CON_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_DEC_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_01PLUS_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_30PLUS_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_60PLUS_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_DEC_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SPM_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SUB_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_RES_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_RGM_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_RNC_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SET_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SF_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_BASIC_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_CLIENT_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_REPORT_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_REFERENCE_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_COPYRIGHT_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_DBT_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_FPD_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_WDF_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_PWOS_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_NON_DELIQUENT_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_STD_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_LOSS_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SFR_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SFWD_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_WOF_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SFWO_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_WDWO_COUNT,
                    DataAttributeType.SUIT_FILED_STATUS_SWDW_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_000_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_CLSD_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_NEW_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_LNSB_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_LAND_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_INAC_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_CON_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_01PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_30PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_DEC_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_60PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SPM_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SUB_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_RES_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_RGM_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_RNC_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SET_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SF_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_BASIC_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_CLIENT_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_REPORT_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_REFERENCE_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_COPYRIGHT_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_90PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_120PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_180PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_360PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_540PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_720PLUS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_DBT_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_FPD_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_WDF_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_PWOS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_NON_DELIQUENT_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_STD_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_LOSS_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFR_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFWD_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_WOF_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFWO_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_WDWO_COUNT,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SWDW_COUNT,
                    DataAttributeType.MONTHLY_INCOME,
                    DataAttributeType.FULL_NAME,
                    DataAttributeType.FIRST_NAME,
                    DataAttributeType.MIDDLE_NAME,
                    DataAttributeType.LAST_NAME,
                    DataAttributeType.ADDITIONAL_MIDDLE_NAME,
                    DataAttributeType.SUFFIX,
                    DataAttributeType.DATE_OF_BIRTH,
                    DataAttributeType.GENDER,
                    DataAttributeType.OCCUPATION,
                    DataAttributeType.MARITAL_STATUS,
                    DataAttributeType.PAN_NO,
                    DataAttributeType.PASSPORT_NO,
                    DataAttributeType.DRIVER_LICENCE_NO,
                    DataAttributeType.VOTER_NO,
                    DataAttributeType.NATIONAL_ID_CARD_NO,
                    DataAttributeType.RATION_CARD_NO,
                    DataAttributeType.TOTAL_LOAN_TO_INCOME_RATIO,
                    DataAttributeType.ASSET_CLASSIFICATION_STATUS_SWDW_COUNT,
                    DataAttributeType.PREVIOUS_NAMES
            ),
            Collections.emptyList()
    ) {
        @Override
        public Map<MetaDataType, MetaColumnType> getMetaToColumnMapping() {
            Map<MetaDataType, MetaColumnType> map;
            map = new HashMap<>();
            map.put(MetaDataType.FROM, MetaColumnType.FROM);
            return map;
        }
    };


    private final String displayName;

    private final List<DataAttributeType> dataAttributeTypes;

    private final List<MetaDataType> primaryMetaDataTypes;

    IdentificationType(String displayName, List<DataAttributeType> dataAttributeTypes, List<MetaDataType> primaryMetaDataTypes) {
        this.displayName = displayName;
        this.dataAttributeTypes = dataAttributeTypes;
        this.primaryMetaDataTypes = primaryMetaDataTypes;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public List<DataAttributeType> getDataAttributeTypes() {
        return this.dataAttributeTypes;
    }

    public List<MetaDataType> getPrimaryMetaDataTypes() {
        return this.primaryMetaDataTypes;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IdentificationTypeDto {

        private String name;

        private String displayName;

    }

    public static class IdentificationTypeToDtoConverter extends StdConverter<IdentificationType, IdentificationTypeDto> {
        @Override
        public IdentificationTypeDto convert(IdentificationType identificationType) {
            return IdentificationTypeDto.builder()
                    .name(identificationType.toString())
                    .displayName(identificationType.getDisplayName())
                    .build();
        }
    }

    public static class DtoToIdentificationTypeConverter extends StdConverter<IdentificationTypeDto, IdentificationType> {
        @Override
        public IdentificationType convert(IdentificationTypeDto IdentificationTypeDto) {
            return IdentificationType.valueOf(IdentificationTypeDto.name);
        }
    }


}
