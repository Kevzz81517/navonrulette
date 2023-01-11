package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.DataAttributeTag;
import com.navonmesh.navonrulette.rule.type.DataAttributeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndividualEquifaxReportFlatFactEntityV1 {

    @DataAttributeTag(dataAttributeType = DataAttributeType.NO_OF_ACCOUNTS)
    private Double noOfAccounts;

    @DataAttributeTag(dataAttributeType = DataAttributeType.EQUIFAX_SCORE)
    private Double score;

    @DataAttributeTag(dataAttributeType = DataAttributeType.NO_OF_ACTIVE_ACCOUNTS)
    private Double noOfActiveAccounts;

    @DataAttributeTag(dataAttributeType = DataAttributeType.NO_OF_ZERO_BALANCE_ACCOUNTS)
    private Double noOfZeroBalanceAccounts;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_BALANCE_AMOUNT)
    private Double totalBalanceAmount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_PAST_DUE_AMOUNT)
    private Double totalPastDueAmount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_HIGH_CREDIT)
    private Double totalHighCredit;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_CREDIT_LIMIT)
    private Double totalCreditLimit;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_SANCTION_AMOUNT)
    private Double totalSanctionAmount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_MONTHLY_PAYMENT_AMOUNT)
    private Double totalMonthlyPaymentAmount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SINGLE_HIGHEST_SANCTION_AMOUNT)
    private Double singleHighestSanctionAmount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SINGLE_HIGHEST_CREDIT)
    private Double singleHighestCredit;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SINGLE_HIGHEST_BALANCE)
    private Double singleHighestBalance;

    @DataAttributeTag(dataAttributeType = DataAttributeType.AVERAGE_OPEN_BALANCE)
    private Double avgOpenBalance;

    @DataAttributeTag(dataAttributeType = DataAttributeType.NO_OF_WRITE_OFFS)
    private Double noOfWriteOffs;

    @DataAttributeTag(dataAttributeType = DataAttributeType.MOST_SEVERE_STATUS_WITH_IN24_MONTHS)
    private String mostSevereStatusWithIn24Months;

    @DataAttributeTag(dataAttributeType = DataAttributeType.NO_OF_PAST_DUE_ACCOUNTS)
    private Double noOfPastDueAccounts;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_INQUIRIES_IN_LAST_90_DAYS)
    private Double totalInquiriesInLast90Days;

    @DataAttributeTag(dataAttributeType = DataAttributeType.RECENT_ACCOUNT)
    private String recentAccount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.OLDEST_ACCOUNT)
    private String oldestAccount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ACCOUNTS_DELIQUENT_IN_LAST_90_DAYS)
    private Double accountDeliquentInLast90Days;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ACCOUNTS_OPENED_IN_LAST_90_DAYS)
    private Double accountsOpenedInLast90Days;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ACCOUNTS_UPDATED_IN_LAST_90_DAYS)
    private Double accountUpdatedInLast90Days;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_000_COUNT)
    private Double paymentStatus000Count;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_01PLUS_COUNT)
    private Double paymentStatus01PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_30PLUS_COUNT)
    private Double paymentStatus30PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_60PLUS_COUNT)
    private Double paymentStatus60PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_90PLUS_COUNT)
    private Double paymentStatus90PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_120PLUS_COUNT)
    private Double paymentStatus120PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_180PLUS_COUNT)
    private Double paymentStatus180PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_360PLUS_COUNT)
    private Double paymentStatus360PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_540PLUS_COUNT)
    private Double paymentStatus540PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_720PLUS_COUNT)
    private Double paymentStatus720PlusCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_CLSD_COUNT)
    private Double paymentStatusCLSDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_NEW_COUNT)
    private Double paymentStatusNEWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_LNSB_COUNT)
    private Double paymentStatusLNSBCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_LAND_COUNT)
    private Double paymentStatusLANDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_INAC_COUNT)
    private Double paymentStatusINACCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_CON_COUNT)
    private Double paymentStatusCONCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_DBT_COUNT)
    private Double paymentStatusDBTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_FPD_COUNT)
    private Double paymentStatusFPDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_WDF_COUNT)
    private Double paymentStatusWDFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_PWOS_COUNT)
    private Double paymentStatusPWOSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_NON_DELIQUENT_COUNT)
    private Double paymentStatusNonDeliquentCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_STD_COUNT)
    private Double paymentStatusSTDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_LOSS_COUNT)
    private Double paymentStatusLOSSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_SFR_COUNT)
    private Double paymentStatusSFRCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_SFWD_COUNT)
    private Double paymentStatusSFWDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_WOF_COUNT)
    private Double paymentStatusWOFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_SFWO_COUNT)
    private Double paymentStatusSFWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_WDWO_COUNT)
    private Double paymentStatusWDWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAYMENT_STATUS_SWDW_COUNT)
    private Double paymentStatusSWDWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_000_COUNT)
    private Double suitFiledStatus000Count;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_CLSD_COUNT)
    private Double suitFiledStatusCLSDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_NEW_COUNT)
    private Double suitFiledStatusNEWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_LNSB_COUNT)
    private Double suitFiledStatusLNSBCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_LAND_COUNT)
    private Double suitFiledStatusLANDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_INAC_COUNT)
    private Double suitFiledStatusINACCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_CON_COUNT)
    private Double suitFiledStatusCONCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_DEC_COUNT)
    private Double suitFiledStatusDECCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_01PLUS_COUNT)
    private Double suitFiledStatus01PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_30PLUS_COUNT)
    private Double suitFiledStatus30PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_60PLUS_COUNT)
    private Double suitFiledStatus60PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SPM_COUNT)
    private Double suitFiledStatusSPMCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SUB_COUNT)
    private Double suitFiledStatusSUBCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_RES_COUNT)
    private Double suitFiledStatusRESCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_RGM_COUNT)
    private Double suitFiledStatusRGMCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_RNC_COUNT)
    private Double suitFiledStatusRNCCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SET_COUNT)
    private Double suitFiledStatusSETCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SF_COUNT)
    private Double suitFiledStatusSFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_BASIC_COUNT)
    private Double suitFiledStatusBASICCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_CLIENT_COUNT)
    private Double suitFiledStatusCLIENTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_REPORT_COUNT)
    private Double suitFiledStatusREPORTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_REFERENCE_COUNT)
    private Double suitFiledStatusREFERENCECount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_COPYRIGHT_COUNT)
    private Double suitFiledStatusCOPYRIGHTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_DBT_COUNT)
    private Double suitFiledStatusDBTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_FPD_COUNT)
    private Double suitFiledStatusFPDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_WDF_COUNT)
    private Double suitFiledStatusWDFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_PWOS_COUNT)
    private Double suitFiledStatusPWOSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_NON_DELIQUENT_COUNT)
    private Double suitFiledStatusNonDeliquentCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_STD_COUNT)
    private Double suitFiledStatusSTDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_LOSS_COUNT)
    private Double suitFiledStatusLOSSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SFR_COUNT)
    private Double suitFiledStatusSFRCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SFWD_COUNT)
    private Double suitFiledStatusSFWDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_WOF_COUNT)
    private Double suitFiledStatusWOFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SFWO_COUNT)
    private Double suitFiledStatusSFWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_WDWO_COUNT)
    private Double suitFiledStatusWDWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUIT_FILED_STATUS_SWDW_COUNT)
    private Double suitFiledStatusSWDWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_000_COUNT)
    private Double assetClassificationStatus000Count;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_CLSD_COUNT)
    private Double assetClassificationStatusCLSDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_NEW_COUNT)
    private Double assetClassificationStatusNEWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_LNSB_COUNT)
    private Double assetClassificationStatusLNSBCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_LAND_COUNT)
    private Double assetClassificationStatusLANDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_INAC_COUNT)
    private Double assetClassificationStatusINACCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_CON_COUNT)
    private Double assetClassificationStatusCONCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_01PLUS_COUNT)
    private Double assetClassificationStatus01PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_30PLUS_COUNT)
    private Double assetClassificationStatus30PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_DEC_COUNT)
    private Double assetClassificationStatusDECCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_60PLUS_COUNT)
    private Double assetClassificationStatus60PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SPM_COUNT)
    private Double assetClassificationStatusSPMCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SUB_COUNT)
    private Double assetClassificationStatusSUBCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_RES_COUNT)
    private Double assetClassificationStatusRESCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_RGM_COUNT)
    private Double assetClassificationStatusRGMCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_RNC_COUNT)
    private Double assetClassificationStatusRNCCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SET_COUNT)
    private Double assetClassificationStatusSETCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SF_COUNT)
    private Double assetClassificationStatusSFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_BASIC_COUNT)
    private Double assetClassificationStatusBASICCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_CLIENT_COUNT)
    private Double assetClassificationStatusCLIENTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_REPORT_COUNT)
    private Double assetClassificationStatusREPORTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_REFERENCE_COUNT)
    private Double assetClassificationStatusREFERENCECount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_COPYRIGHT_COUNT)
    private Double assetClassificationStatusCOPYRIGHTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_90PLUS_COUNT)
    private Double assetClassificationStatus90PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_120PLUS_COUNT)
    private Double assetClassificationStatus120PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_180PLUS_COUNT)
    private Double assetClassificationStatus180PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_360PLUS_COUNT)
    private Double assetClassificationStatus360PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_540PLUS_COUNT)
    private Double assetClassificationStatus540PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_720PLUS_COUNT)
    private Double assetClassificationStatus720PLUSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_DBT_COUNT)
    private Double assetClassificationStatusDBTCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_FPD_COUNT)
    private Double assetClassificationStatusFPDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_WDF_COUNT)
    private Double assetClassificationStatusWDFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_PWOS_COUNT)
    private Double assetClassificationStatusPWOSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_NON_DELIQUENT_COUNT)
    private Double assetClassificationStatusNonDeliquentCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_STD_COUNT)
    private Double assetClassificationStatusSTDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_LOSS_COUNT)
    private Double assetClassificationStatusLOSSCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFR_COUNT)
    private Double assetClassificationStatusSFRCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFWD_COUNT)
    private Double assetClassificationStatusSFWDCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_WOF_COUNT)
    private Double assetClassificationStatusWOFCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SFWO_COUNT)
    private Double assetClassificationStatusSFWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_WDWO_COUNT)
    private Double assetClassificationStatusWDWOCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ASSET_CLASSIFICATION_STATUS_SWDW_COUNT)
    private Double assetClassificationStatusSWDWCount;

    @DataAttributeTag(dataAttributeType = DataAttributeType.TOTAL_LOAN_TO_INCOME_RATIO)
    private Double totalLoanToIncomeRatio;

    @DataAttributeTag(dataAttributeType = DataAttributeType.MONTHLY_INCOME)
    private Double monthlyIncome;

    @DataAttributeTag(dataAttributeType = DataAttributeType.FULL_NAME)
    private String fullName;

    @DataAttributeTag(dataAttributeType = DataAttributeType.FIRST_NAME)
    private String firstName;

    @DataAttributeTag(dataAttributeType = DataAttributeType.MIDDLE_NAME)
    private String middleName;

    @DataAttributeTag(dataAttributeType = DataAttributeType.LAST_NAME)
    private String lastName;

    @DataAttributeTag(dataAttributeType = DataAttributeType.ADDITIONAL_MIDDLE_NAME)
    private String additionalMiddleName;

    @DataAttributeTag(dataAttributeType = DataAttributeType.SUFFIX)
    private String suffix;

    @DataAttributeTag(dataAttributeType = DataAttributeType.DATE_OF_BIRTH)
    private String dateOfBirth;

    @DataAttributeTag(dataAttributeType = DataAttributeType.GENDER)
    private String gender;

    @DataAttributeTag(dataAttributeType = DataAttributeType.OCCUPATION)
    private String occupation;

    @DataAttributeTag(dataAttributeType = DataAttributeType.MARITAL_STATUS)
    private String maritalStatus;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PAN_NO)
    private String panNo;

    @DataAttributeTag(dataAttributeType = DataAttributeType.PASSPORT_NO)
    private String passportNo;

    @DataAttributeTag(dataAttributeType = DataAttributeType.DRIVER_LICENCE_NO)
    private String driverLicenceNo;

    @DataAttributeTag(dataAttributeType = DataAttributeType.VOTER_NO)
    private String voterNo;

    @DataAttributeTag(dataAttributeType = DataAttributeType.NATIONAL_ID_CARD_NO)
    private String nationalIdCardNo;

    @DataAttributeTag(dataAttributeType = DataAttributeType.RATION_CARD_NO)
    private String rationCardNo;

    private Calendar datasourceDate;
}
