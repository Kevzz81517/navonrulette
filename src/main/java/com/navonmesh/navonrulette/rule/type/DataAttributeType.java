package com.navonmesh.navonrulette.rule.type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DataAttributeTypeMethod {

}

@JsonSerialize(converter = DataAttributeType.DataAttributeTypeToDtoConverter.class)
public enum DataAttributeType {

    MONTHLY_INCOME("Monthly Income", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    FULL_NAME("Full Name", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    FIRST_NAME("First Name", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    MIDDLE_NAME("Middle Name", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    LAST_NAME("Last Name", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    ADDITIONAL_MIDDLE_NAME("Additional Middle Name", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SUFFIX("Suffix", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DATE_OF_BIRTH("Date Of Birth", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    GENDER("Gender", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    OCCUPATION("Occupation", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    MARITAL_STATUS("Marital Status", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    PAN_NO("Pan No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    TRADE_LICENSE_NO("Trade License No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    PASSPORT_NO("Passport No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DRIVER_LICENCE_NO("Driving Licence No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    VOTER_NO("Voter No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NATIONAL_ID_CARD_NO("National ID Card No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    RATION_CARD_NO("Ration Card No", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NO_OF_ACCOUNTS("No Of Accounts", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NO_OF_ACTIVE_ACCOUNTS("No Of Active Accounts", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NO_OF_WRITE_OFFS("No Of Writeoffs", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    MOST_SEVERE_STATUS_WITH_IN24_MONTHS("Most Severe Status Within 24Month", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SINGLE_HIGHEST_CREDIT("Single Highest Credit", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SINGLE_HIGHEST_SANCTION_AMOUNT("Single Highest Amount", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    TOTAL_HIGH_CREDIT("Total High Credit", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    AVERAGE_OPEN_BALANCE("Average Open Balance", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SINGLE_HIGHEST_BALANCE("Single Highest Balance", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NO_OF_PAST_DUE_ACCOUNTS("No Of Past Due Accounts", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    NO_OF_ZERO_BALANCE_ACCOUNTS("No Of Zero Balance Accounts", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    RECENT_ACCOUNT("Recent Account", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    OLDEST_ACCOUNT("Oldest Account", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    TOTAL_BALANCE_AMOUNT("Total Balance Amount", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_SANCTION_AMOUNT("Total Sanction Amount", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_CREDIT_LIMIT("Total Credit Limit", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_MONTHLY_PAYMENT_AMOUNT("Total Monthly Payment Amount", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ACCOUNTS_DELIQUENT_IN_LAST_90_DAYS("Accounts Deliquent In Last 90 Days", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ACCOUNTS_OPENED_IN_LAST_90_DAYS("Accounts Opened In Last 90 Days", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ACCOUNTS_UPDATED_IN_LAST_90_DAYS("Accounts Updated In Last 90 Days", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_INQUIRIES_IN_LAST_90_DAYS("Total Inquiries In Last 90 Days", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    EQUIFAX_SCORE("Equifax Score", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    AECB_SCORE("AECB Score", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_PAST_DUE_AMOUNT("Total Past Due Amount", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_DBT_COUNT("Payment Status DBT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_FPD_COUNT("Payment Status FPD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_WDF_COUNT("Payment Status WDF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_PWOS_COUNT("Payment Status PWOS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_NON_DELIQUENT_COUNT("Payment Status Non Deliquent Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_STD_COUNT("Payment Status STD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_LOSS_COUNT("Payment Status LOSS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_SFR_COUNT("Payment Status SFR Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_SFWD_COUNT("Payment Status SFWD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_WOF_COUNT("Payment Status WOF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_SFWO_COUNT("Payment Status SFWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_WDWO_COUNT("Payment Status WDWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_SWDW_COUNT("Payment Status SWDW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_000_COUNT("Payment Status 000 Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_000_COUNT("Payment Status 000 Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_01PLUS_COUNT("Payment Status 01PLUS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_30PLUS_COUNT("Payment Status 30 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_60PLUS_COUNT("Payment Status 60 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_CLSD_COUNT("Payment Status CLSD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_NEW_COUNT("Payment Status NEW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_LNSB_COUNT("Payment Status LNSB Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_LAND_COUNT("Payment Status LAND Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_INAC_COUNT("Payment Status INAC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_CON_COUNT("Payment Status CON Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_90PLUS_COUNT("Payment Status 90 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_120PLUS_COUNT("Payment Status 120 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_180PLUS_COUNT("Payment Status 180 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_360PLUS_COUNT("Payment Status 360 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_540PLUS_COUNT("Payment Status 540 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    PAYMENT_STATUS_720PLUS_COUNT("Payment Status 720 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_CLSD_COUNT("Suit Filed Status  CLSD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_NEW_COUNT("Suit Filed Status  NEW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_LNSB_COUNT("Suit Filed Status  LNSB Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_LAND_COUNT("Suit Filed Status  LAND Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_INAC_COUNT("Suit Filed Status  INAC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_CON_COUNT("Suit Filed Status  CON Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_DEC_COUNT("Suit Filed Status  DEC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_01PLUS_COUNT("Suit Filed Status  01PLUS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_30PLUS_COUNT("Suit Filed Status  30 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_60PLUS_COUNT("Suit Filed Status  60 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SPM_COUNT("Suit Filed Status  SPM Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SUB_COUNT("Suit Filed Status  SUB Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_RES_COUNT("Suit Filed Status  RES Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_RGM_COUNT("Suit Filed Status  RGM Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_RNC_COUNT("Suit Filed Status  RNC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SET_COUNT("Suit Filed Status  SET Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SF_COUNT("Suit Filed Status  SF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_BASIC_COUNT("Suit Filed Status  BASIC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_CLIENT_COUNT("Suit Filed Status  CLIENT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_REPORT_COUNT("Suit Filed Status  REPORT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_REFERENCE_COUNT("Suit Filed Status  REFERENCE Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_COPYRIGHT_COUNT("Suit Filed Status  COPYRIGHT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_DBT_COUNT("Suit Filed Status  DBT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_FPD_COUNT("Suit Filed Status  FPD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_WDF_COUNT("Suit Filed Status  WDF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_PWOS_COUNT("Suit Filed Status  PWOS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_NON_DELIQUENT_COUNT("Suit Filed Status  Non Deliquent Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_STD_COUNT("Suit Filed Status  STD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_LOSS_COUNT("Suit Filed Status  LOSS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SFR_COUNT("Suit Filed Status  SFR Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SFWD_COUNT("Suit Filed Status  SFWD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_WOF_COUNT("Suit Filed Status  WOF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SFWO_COUNT("Suit Filed Status  SFWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_WDWO_COUNT("Suit Filed Status  WDWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    SUIT_FILED_STATUS_SWDW_COUNT("Suit Filed Status  SWDW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_000_COUNT("Asset Classification Status 000 Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_CLSD_COUNT("Asset Classification Status CLSD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_NEW_COUNT("Asset Classification Status NEW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_LNSB_COUNT("Asset Classification Status LNSB Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_LAND_COUNT("Asset Classification Status LAND Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_INAC_COUNT("Asset Classification Status INAC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_CON_COUNT("Asset Classification Status CON Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_01PLUS_COUNT("Asset Classification Status 01PLUS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_30PLUS_COUNT("Asset Classification Status 30 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_DEC_COUNT("Asset Classification Status DEC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_60PLUS_COUNT("Asset Classification Status 60 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SPM_COUNT("Asset Classification Status SPM Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SUB_COUNT("Asset Classification Status SUB Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_RES_COUNT("Asset Classification Status RES Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_RGM_COUNT("Asset Classification Status RGM Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_RNC_COUNT("Asset Classification Status RNC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SET_COUNT("Asset Classification Status SET Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SF_COUNT("Asset Classification Status SF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_BASIC_COUNT("Asset Classification Status BASIC Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_CLIENT_COUNT("Asset Classification Status CLIENT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_REPORT_COUNT("Asset Classification Status REPORT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_REFERENCE_COUNT("Asset Classification Status REFERENCE Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_COPYRIGHT_COUNT("Asset Classification Status COPYRIGHT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_90PLUS_COUNT("Asset Classification Status 90 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_120PLUS_COUNT("Asset Classification Status 120 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_180PLUS_COUNT("Asset Classification Status 180 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_360PLUS_COUNT("Asset Classification Status 360 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_540PLUS_COUNT("Asset Classification Status 540 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_720PLUS_COUNT("Asset Classification Status 720 Plus Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_DBT_COUNT("Asset Classification Status DBT Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_FPD_COUNT("Asset Classification Status FPD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_WDF_COUNT("Asset Classification Status WDF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_PWOS_COUNT("Asset Classification Status PWOS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_NON_DELIQUENT_COUNT("Asset Classification Status Non Deliquent Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_STD_COUNT("Asset Classification Status STD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_LOSS_COUNT("Asset Classification Status LOSS Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SFR_COUNT("Asset Classification Status SFR Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SFWD_COUNT("Asset Classification Status SFWD Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_WOF_COUNT("Asset Classification Status WOF Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SFWO_COUNT("Asset Classification Status SFWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_WDWO_COUNT("Asset Classification Status WDWO Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION_STATUS_SWDW_COUNT("Asset Classification Status SWDW Count", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),
    TOTAL_LOAN_TO_INCOME_RATIO("Total Loan to Income Ratio", DataAttributeDataType.NUMBER, new HashMap<>(), Collections.emptyList()),

    ACCOUNT_NUMBER("Account Number", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    INSTITUTION("Institution", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    ACCOUNT_TYPE("Account Type", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    OWNERSHIP_TYPE("Ownership Type", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    BALANCE("Balance", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    PAST_DUE_AMOUNT("Past Due Amount", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    LAST_PAYMENT("Last Payment", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    WRITE_OFF_AMOUNT("Write Off Amount", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    OPEN("Open", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SANCTION_AMOUNT("Sanction Amount", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    LAST_PAYMENT_DATE("Last Payment Date", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    HIGH_CREDIT("High Credit", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DATE_REPORTED("Date Reported", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DATE_OPENED("Date Opened", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DATE_CLOSED("Date Closed", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    REASON("Reason", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    INTEREST_RATE("Interest Rate", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    REPAYMENT_TENURE("Repayment Tenure", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    DISPUTE_CODE("Dispute Code", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    INSTALLMENT_AMOUNT("Installment Amount", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    TERM_FREQUENCY("Term Frequesncy", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    CREDIT_LIMIT("Credit Limit", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    COLLATERAL_VALUE("Collateral Value", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    COLLATERAL_TYPE("Collateral Type", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    ACCOUNT_STATUS("Account Status", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    ASSET_CLASSIFICATION("Asset Classification", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),
    SOURCE("Source", DataAttributeDataType.TEXT, new HashMap<>(), Collections.emptyList()),

    MAX_BALANCE("Maximum Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MIN_BALANCE("Minimum Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTHLY_SURPLUS("Monthly Surplus", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EXPENSE_TO_INCOME_RATIO("Expense To Income Ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_MAXIMUM_EXPENSE("Monthly Maximum Expense", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_MINIMUM_EXPENSE("Monthly Minimum Expense", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_MAXIMUM_INCOME("Month Maximum Income", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_MINIMUM_INCOME("Month Minimum Income", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVERAGE_BANK_BALANCE("Average Bank Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_2ND("Balance As On 2nd", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_5TH("Balance As On 5th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_7TH("Balance As On 7th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_10TH("Balance As On 10th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_14TH("Balance As On 14th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_21TH("Balance As On 21th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BALANCE_AS_ON_28TH("Balance As On 28th", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_CREDIT_TRANSACTIONS("Total Count Of Credit Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_CREDIT_TRANSACTIONS("Total Amount Of Credit Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_INCOME_TRANSACTIONS("Total Count Of Income Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_INCOME_TRANSACTIONS("Total Amount Of Income Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_INTEREST_TRANSACTIONS("Total Count Of Interest Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_INTEREST_TRANSACTIONS("Total Amount Of Interest Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_FUND_TRANSFERS("Total Count Of Fund Transfers", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_FUND_TRANSFERS("Total Amount Of Fund Transfers", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_CASH_DEPOSITS("Total Count Of Cash Deposits", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_CASH_DEPOSITS("Total Amount Of Cash Deposits", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_CHEQUE_DEPOSITS("Total Count Of Cheque Deposits", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_AMOUNT_OF_CHEQUE_DEPOSITS("Total Amount Of Cheque Deposits", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REMAINING_COUNT_OF_CREDIT_TRANSACTIONS("Remaining Count Of Credit Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REMAINING_AMOUNT_OF_CREDIT_TRANSACTIONS("Remaining Amount Of Credit Transactions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    FRAUD_INDICATION_SUSPICIOUS_RTGS_TRANSACTIONS("Fraud Indication Suspicious RIGS Transactions", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_BOUNCE_AMOUNT("Total Bounce Amount", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    CLOSING_BALANCE("Closing Balance", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    OPENING_BALANCE("Opening Balance", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_BOUNCE_COUNT("Total Bounce Count", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    PROBABLE_SALARY("Salary", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_BALANCE_RECONCILIATION("Fraud Indication Balance Reconsiliation", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_EQUAL_DEBIT_CREDIT("Fraud Indication Equal Debit Credit", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_SUSPECTED_INCOME_INFUSION("Fraud Indication Suspected Income Infusion", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_NEGATIVE_EOD_BALANCE("Fraud Indication Negative EOD Balance", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_TRANSACTIONS_ON_BANK("Fraud Indication Transactions On Bank", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_SUSPICIOUS_TAX_PAYMENTS("Fraud Indication Suspicious Tax Payements", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_ABNORMAL_CASH_DEPOSITS("Fraud Indication Abnormal Cash Deposits", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_IRREGULAR_CREDIT_CARD("Fraud Indication Irregular Credit Card", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_IRREGULAR_SALARY_CREDITS("Fraud Indication Irregular Salary Credits", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_UNCHANGED_SALARY_CREDIT("Fraud Indication Unchanged Salary Credits", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_IRREGULAR_TRANSFERS_TO("Fraud Indication Irregular Salary Credits", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    FRAUD_INDICATION_DATA_DUPLICITY("Fraud Indication Data Duplicity", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    MONTHLY_AVERAGE_INFLOW_BALANCES("Monthly Average Inflow Balances", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTHLY_AVERAGE_OUTFLOW_BALANCES("Monthly Average Outflow Balances", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTHLY_AVERAGE_CREDIT_AMOUNT("Monthly Average Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTHLY_AVERAGE_DEBIT_AMOUNT("Monthly Average Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_CREDIT_AMOUNT("Total Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DEBIT_AMOUNT("Total Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_CREDIT("Total Count Of Credit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_COUNT_OF_DEBIT("Total Count Of Debit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVERAGE_MONTHLY_SURPLUS("Average Monthly Surplus", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FIXED_OBLIGATION_TO_INCOME("Fixed Obligation To Income", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    MAXIMUM_BALANCE("Maximum Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MINIMUM_BALANCE("Minimum Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MAXIMUM_CREDIT("Maximum Credit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MINIMUM_CREDIT("Minimum Credit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MAXIMUM_DEBIT("Maximum Debit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MINIMUM_DEBIT("Minimum Debit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_END_BALANCE_IN_LAST_3_MONTHS("Month End Balance In Last 3 Months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MONTH_END_BALANCE_IN_LAST_6_MONTHS("Month End Balance In Last 6 Months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    VELOCITY_BY_AMB_IN_THE_LAST_3_MONTHS("Velocity By AMB In Last 3 Months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    VELOCITY_BY_AMB_IN_THE_LAST_6_MONTHS("Velocity By AMB In Last 6 Months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AMOUNT("Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAYMENT_MODE("Payment Mode", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    PAYMENT_TYPE("Payment Type", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    EMI_DATE("EMI Date", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    VARIANCE_OF_BALANCE("Variance of balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    STANDARD_DEVIATION_OF_BALANCE("Standard deviation of balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    COEFFICIENT_OF_VARIATION_OF_BALANCE("Coefficient Of Variation Of Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    VARIANCE_OF_CREDIT("Variance Of Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    STANDARD_DEVIATION_OF_CREDIT("Standard deviation Of Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    COEFFICIENT_OF_VARIATION_OF_CREDIT("Coefficient Of Variation Of Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    VARIANCE_OF_DEBIT("Variance Of Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    STANDARD_DEVIATION_OF_DEBIT("Standard deviation Of Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    COEFFICIENT_OF_VARIATION_OF_DEBIT("Coefficient Of Variation Of Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVERAGE_BALANCE("Average Balance", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVERAGE_CREDIT_AMOUNT("Average Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVERAGE_DEBIT_AMOUNT("Average Debit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_NO_OF_CREDIT("Total No Of Credit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_NO_OF_DEBIT("Total No Of Debit", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MAXIMUM_EXPENSE("Max Expense", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MINIMUM_EXPENSE("Min Expense", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MAXIMUM_INCOME("Max Income", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MINIMUM_INCOME("Min Income", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_CREDIT_PLUS_DEBIT_AMOUNT("Total Debit Plus Credit Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SURPLUS("Surplus", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_APPS("Count Of Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DISTINCT_APPS_CATEGORIES("Count Of Distinct App Categories", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SOCIAL_APPS_COUNT("Count Of Social Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    HEALTH_AND_FITNESS_APPS_COUNT("Count Of Fitness Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHOPPING_APPS_COUNT("Count Of Shopping Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    WALLET_APPS_COUNT("Count Of Wallet Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FINANCE_APPS_COUNT("Count Of Finance Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    COMMUNICATION_APPS_COUNT("Count Of Communication Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_APPS_COUNT("Count Of Other Apps", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_NAMES("Previous Names", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    FINANCIAL_CREDIT_TRANSACTIONS("Financial Credit Transactions", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    FINANCIAL_DEBIT_TRANSACTIONS("Financial Debit Transactions", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    COUNTER_PARTY_ANALYTICS("Counter Party Analytics", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    DIRECTORS("Directors", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    NEWS("News", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    OPERATING_MARGIN("Operating Margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_PROFIT_MARGIN("Net Profit Margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RETURN_ON_EQUITY("Return On Equity (%)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RETURN_ON_ASSETS("Return On Assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    QUICK_RATIO("Quick Ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_RATIO("Current Ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    ASSET_TURNOVER("Asset Turnover", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INVENTORY_TURNOVER("Inventory Turnover", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBT_TO_EBITDA_RATIO("Debt/EBITDA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBT_TO_EQUITY_RATIO("Debt to Equity", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INVENTORY_TO_SALES_RATIO("Inventory/Sales (Days)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EBITDA_TO_TOTAL_ASSETS("EBITDA/Total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_ASSETS("Total Assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    WORKING_CAPITAL("Working Capital", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAYOUT_RATIO("Payout Ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    INDUSTRY_AVG_OPERATING_MARGIN("Industry avg operating margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_OPERATING_MARGIN("Avg last 3 year operating margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_OPERATING_MARGIN("Avg last 5 year operating margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INDUSTRY_AVG_NET_PROFIT_MARGIN("Net profit margin industry average", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_NET_PROFIT_MARGIN("3yr average profit margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_NET_PROFIT_MARGIN("5yr average profit margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INDUSTRY_AVG_RETURN_ON_EQUITY("Industry avg ROE", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_RETURN_ON_EQUITY("Last 3 year avg ROE", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_RETURN_ON_EQUITY("Last 5 year avg ROE", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INDUSTRY_AVG_RETURN_ON_ASSETS("Industry avg ROA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_RETURN_ON_ASSET("Last 3 year avg ROA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_RETURN_ON_ASSET("Last 5 year avg ROA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_QUICK_RATIO("Last 3 year avg quick ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_QUICK_RATIO("Last 5 year avg quick ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_THREE_YEAR_CURRENT_RATIO("Last 3 year avg current ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_FIVE_YEAR_CURRENT_RATIO("Last 5 year avg current ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_QUARTER_TOTAL_ASSETS("Previous Quarter total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    LAST_YEAR_TOTAL_ASSETS("Last year total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_QUARTER_WORKING_CAPITAL("Previous Quarter total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    LAST_YEAR_WORKING_CAPITAL("Last year total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MANAGEMENT_SCORE("Management Score", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    CHECK_BOUNCES_LAST_YEAR("Cheque bounces last year", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DPD_CLASSIFIED_AS_STD("% DPD classified as STD", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DPD_CLASSIFIED_AS_SUB("% DPD classified as SUB", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DPD_CLASSIFIED_AS_DBT("% DPD classified as DBT", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DPD_CLASSIFIED_AS_LSS("% DPD classified as LSS", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_ENQUIRIES("Number of enquiries", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    ENQUIRIES_FOR_SAME_PURPOSE_AND_AMT("Enquiries for same purpose and amt", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TRANSACTION_IN_LAST_QUARTER("transactions in last quarter", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MISSED_EMI_PAYMENTS_IN_LAST_12_MONTHS("Missed EMI payments in past 12 months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    CURRENT_STOCK_PRICE("current stock price", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_STOCK_PRICE_LAST_3_MONTHS("average stock price over last 3 months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_STOCK_PRICE_LAST_6_MONTHS("average stock price over last 6 months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_STOCK_PRICE_LAST_12_MONTHS("average stock price over last 12 months", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    MARKET_CAP("Market Cap", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SENTIMENT_SCORE("Sentiment Score", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    PREVIOUS_YEAR_GDP("Previous year GDP", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    GDP("Current GDP", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_3_YEAR_GDP("Average of last 3 year GDP", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_YEAR_INFLATION("Previous year Inflation", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INFLATION("Current Inflation", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AVG_LAST_3_YEAR_INFLATION("Average of last 3 year Inflation", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_YEAR_GNS("Previous year GNS", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    GNS("Current GNS", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    GENERAL_GOVERNMENT_DEBT("Current year General govt debt", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PREVIOUS_YEAR_GENERAL_GOVERNMENT_DEBT("Previous year General govt debt", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    GEOGRAPHY_OUTLOOK_RISKSCORE("Geography outlook Risk Score", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INDUSTRY_OUTLOOK_RISKSCORE("Industry outlook Risk Score", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    DECLINING_OPERATING_CASH_FLOW("Declining operating cash flows", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INCREASE_IN_COST_OF_SALE("Increase in cost of sales", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DECREASE_IN_SALES_REVENUE("Decrease in sales revenue", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DECREASE_IN_RETAINED_EARNING("Decrease in retained earnings", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DECREASE_IN_TOTAL_NET_WORTH("Decrease in total net worth", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DECREASE_IN_TOTAL_ASSETS("Decrease in total assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DECREASE_IN_PROFIT_MARGIN("Decrease in profit margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INCREASE_IN_LOAN_PAYABLE_TO_CURRENT_ASSET_RATIO("Increase in loans payable to current asset ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    AUDITOR_OPINION("Auditor Opinion", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    P_E_RATIO("P/E Ratio", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRICE_TO_SALE("Price to sale", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRICE_TO_CASH_FLOW("Price to cash flow", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRICE_TO_FREE_CASH_FLOW("Price to Free Cash Flow", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRICE_TO_BOOK("Price to Book", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRICE_TO_TANGIBLE_BOOK("Price to Tangible Book", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    GROSS_MARGIN("Price to Free Cash Flow", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PRETAX_MARGIN("Pretax Margin", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_SHARE("Revenue/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BASIC_EPN("Revenue/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DILUTED_EPS("Diluted EPS", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    BOOK_VALUE_SHARE("Book Value/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TANGIBLE_BOOK_VALUE_SHARE("Tangible Book Value/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CASH_SHARE("Cash/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CASH_FLOW_SHARE("Cash Flow/Share", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RETURN_ON_INVESTMENT("Return On Investment", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    LT_DEBT_TO_EQUITY("LT Debt to Equity", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DEBT_TO_EQUITY("Total Debt to Equity", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_EMPLOYEE("Revenue/Employee", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_INCOME_EMPLOYEE("Net Income/Employee", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RECEIVABLE_TURNOVER("Receivable Turnover", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DIVIDEND_YIELD_5_YEAR_AVG("Dividend Yield 5 Year Avg.", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DIVIDEND_GROWTH_RATE("Dividend Growth Rate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FIVE_YEAR_EPS_GROWTH_RATE("5 Year EPS Growth 5YA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FIVE_YEAR_SALE_GROWTH_RATE("5 Year Sales Growth 5YA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FIVE_YEAR_CAPITAL_SPENDING_GROWTH("5 Year Capital Spending Growth 5YA", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    VELOCITY("Velocity", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    // =====================================Standalone Financial Data======================================
    /* BALANCE SHEET - AOC-4 (Rs. Crore) */

    /* Equity and Liabilities */
    EQUITY_SHARE_CAPITAL("Share Capital (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EQUITY_RESERVES_AND_SURPLUS("Reserves and Surplus (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EQUITY_OTHER_EQUITY("Other Equity (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EQUITY_TOTAL_EQUITY("Total Equity (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NON_CONCURRENT_LIABILITIES_LONG_TERM_BORROWINGS("Long Term Borrowings (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NON_CONCURRENT_LIABILITIES_NET_DEFERRED_TAX_LIABILITIES("Net Deferred Tax Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NON_CONCURRENT_LIABILITIES_OTHER_LONG_TERM_LIABILITIES("Other Long Term Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NON_CONCURRENT_LIABILITIES_LONG_TERM_PROVISIONS("Long Term Provisions (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NON_CONCURRENT_LIABILITIES_TOTAL_NON_CONCURRENT_LIABILITIES("Total Non-current Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_LIABILITIES_SHORT_TERM_BORROWINGS("Short Term Borrowings (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_LIABILITIES_TRADE_PAYABLES("Trade Payables (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_LIABILITIES_OTHER_CURRENT_LIABILITIES("Other Current Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_LIABILITIES_SHORT_TERM_PROVISIONS("Short Term Provisions (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_LIABILITIES_TOTAL_CURRENT_LIABILITIES("Total Current Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_EQUITY_AND_LIABILITIES("Total Equity and Liabilities (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
/*
String cin = mappingAboutTheCompany.get("CIN").get(0);
            String listingStatus = mappingAboutTheCompany.get("Listing Status").get(0);
            String authorisedCapital = mappingAboutTheCompany.get("Authorised Capital (Crore)").get(0);
            String paidUpCapital = mappingAboutTheCompany.get("Paid Up Capital (Crore)").get(0);
            String sumOfCharges = mappingAboutTheCompany.get("Sum of Charges (Crore)").get(0);
            String eFilingStatus = mappingAboutTheCompany.get("E-Filing Status").get(0);
            String activeCompliance = mappingAboutTheCompany.get("Active Compliance").get(0);
            String aboutTheCompany = mappingAboutTheCompany.get("About the Company").get(0);
            String typeOfEntity = mappingAboutTheCompany.get("Type of Entity").get(0);
            String dateOfLastAGM = mappingAboutTheCompany.get("Date of Last AGM").get(0);
 */

    /* Company Information */
    LISTING_STATUS("Listing status", DataAttributeDataType.BOOLEAN, Collections.emptyMap(), Collections.emptyList()),
    CIN("CIN", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    AUTHORISED_CAPITAL("Authorised Capital (Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAID_UP_CAPITAL("Paid Up Capital (Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SUM_OF_CHARGES("Sum of Charges (Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    E_FILING_STATUS("E-Filing Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    ACTIVE_COMPLIANCE("Active Compliance", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    ABOUT_THE_COMPANY("About the Company", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    TYPE_OF_ENTITY("Type of Entity", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DATE_OF_LAST_AGM("Date of Last AGM", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    /* Assets */
    NET_FIXED_ASSETS_TANGIBLE_ASSETS("Tangible Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_FIXED_ASSETS_INTANGIBLE_ASSETS("Intangible Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_FIXED_ASSETS_TOTAL_NET_FIXED_ASSETS("Total Net Fixed Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CAPITAL_WORK_IN_PROGRESS("Capital Work-in-progress (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_NON_CURRENT_ASSETS_NON_CURRENT_INVESTMENT("Non-current Investments (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_NON_CURRENT_ASSETS_NET_DEFERRED_TAX_ASSETS("Net Deferred Tax Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_NON_CURRENT_ASSETS_LONG_TERM_LOANS_AND_ADVANCES("Long Term Loans and Advances (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_NON_CURRENT_ASSETS_TOTAL_OTHER_NON_CURRENT_ASSETS("Total Other Non-current Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_CURRENT_INVESTMENTS("Current Investments (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_INVENTORIES("Inventories (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_TRADE_RECEIVABLES("Trade Receivables (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_CASH_AND_BANK_BALANCE("Cash and Bank Balances (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_SHORT_TERM_LOAN_AND_ADVANCES("Short Term Loans and Advances (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_OTHER_CURRENT_ASSETS("Other Current Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CURRENT_ASSETS_TOTAL_CURRENT_ASSETS("Total Current Assets (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    //  Already Defined ->  TOTAL_ASSETS(" (Rs. Crore)",DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList())

    /* PROFIT & LOSS - AOC-4 (Rs. Crore) */
    NET_REVENUE("Net Revenue (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_COST_OF_MATERIAL_CONSUMED("Cost of Materials Consumed (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_PURCHASES_OF_STOCK_IN_TRADE("Purchases of Stock-in-trade (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_CHANGES_IN_INVENTORIES_FINISHED_GOODS("Changes in Inventories / Finished Goods (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_EMPLOYEE_BENEFIT_EXPENSE("Employee Benefit Expense (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_OTHER_EXPENSES("Other Expenses (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_COST_TOTAL_OPERATING_COST("Total Operating Cost (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OPERATING_PROFIT_EBITDA("Operating Profit ( EBITDA ) (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    OTHER_INCOME("Other Income (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEPRECATION_AND_AMORTIZATION_EXPENSE("Depreciation and Amortization Expense (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_BEFORE_INTEREST_AND_TAX("Profit Before Interest and Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    FINANCE_COSTS("Finance Costs (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_BEFORE_TAX_AND_EXCEPTIONAL_ITEMS_BEFORE_TAX("Profit Before Tax and Exceptional Items Before Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EXCEPTIONAL_ITEMS_BEFORE_TAX("Exceptional Items Before Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_BEFORE_TAX("Profit Before Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INCOME_TAX("Income Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_FOR_THE_PERIOD_FROM_CONTINUING_OPERATIONS("Profit for the Period from Continuing Operations (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_FROM_DISCOUNTING_OPERATIONS_AFTER_TAX("Profit from Discontinuing Operations After Tax (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PROFIT_FOR_THE_PERIOD("Profit for the Period (Rs. Crore)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    /* RATIOS - AOC-4 */
    REVENUE_GROWTH("Revenue Growth (%)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EBITDA_MARGIN("EBITDA Margin (%)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_MARGIN("Net Margin (%)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBTORS_TO_SALES("Debtors / Sales (Days)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAYABLES_TO_SALES("Payables / Sales (Days)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CASH_CONVERSION_CYCLE("Cash Conversion Cycle (Days)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SALES_TO_NET_FIXED_ASSETS("Sales / Net Fixed Assets", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    // ===================================== Structure ==================================
    /* Share Holding Summary */
    SHARE_HOLDING_SUMMARY_PROMOTER("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHARE_HOLDING_SUMMARY_PUBLIC("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHARE_HOLDING_SUMMARY_NO_OF_SHARE_HOLDERS("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHARE_HOLDING_SUMMARY_NO_OF_PROMOTER_SHARE_HOLDERS("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHARE_HOLDING_SUMMARY_TOTAL_EQUITY_SHARE("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SHARE_HOLDING_SUMMARY_TOTAL_PREFERENCE_SHARE("", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    /* Share Holding Structure */
    NUMBER_OF_SHARES_INDIAN("Indian", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_NON_RESIDENT_INDIAN("Non-resident Indian (others)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_FOREIGN_NATIONAL("Foreign national (other than NRI)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_CENTRAL_GOVERNMENT("Central Government", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_STATE_GOVERNMENT("State Government", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_GOVERNMENT_COMPANIES("Government companies", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_INSURANCE_COMPANIES("Insurance companies", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_BANK("Bank", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_FINANCIAL_INSTITUTIONS("Financial institutions", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_FOREIGN_INSTITUTIONAL_INVESTORS("Foreign institutional investors", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_MUTUAL_FUNDS("Mutual Funds", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_VENTURE_CAPITALS("Venture capital", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_BODY_CORPORATE("Body corporate (not mentioned above)", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_OTHERS("Others", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARES_TOTAL("Total", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    /*================SHARE HOLDING SUMMARY==========================*/
    PROMOTER_PERCENTAGE("Promoter %", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PUBLIC_PERCENTAGE("Public %", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_SHARE_HOLDERS("No. of Shareholders", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NUMBER_OF_PROMOTER_SHARE_HOLDERS("No. of Promoter Shareholders", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_EQUITY_SHARES("Total Equity Shares", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_PREFERENCE_SHARES("Total Preference Shares", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    //==================SECURITIES ALLOTMENT=========================
    SECURITIES_ALLOTMENT_DATA("Securities Allotment", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    //==============OPEN CHARGES SEQUENCE==============================
    IS_OPEN("STATUS", DataAttributeDataType.BOOLEAN, Collections.emptyMap(), Collections.emptyList()),
    DATE("Date", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    FILING_DATE("Filing Date", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    HOLDER_NAME("Holder Name", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    //==============TOTAL SUMMARY CHARGE=============================
    TOTAL_CHARGE_AMOUNT("TOTAL CHARGE AMOUNT", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    LATEST_CHARGE_AMOUNT("LATEST CHARGE AMOUNT", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    //===========================LEGAL HISTORY=========================
    LEGAL_HISTORY_CASE_TYPE("Case Type", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_CASE_STATUS("Case Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_CASE_CATEGORY("Case Category", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_COURT("Court", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_LITIGANTS("Litigant(s)", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_CASE_NUMBER("Case No.", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    LEGAL_HISTORY_DATE_OF_JUDGEMENT("Date of Last Hearing / Judgement", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    LEGAL_HISTORY("Legal History", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),

    //=======================LEGAL HISTORY SUMMARY======================
    TOTAL_PENDING_CASES("Total Pending Cases", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DISPOSED_CASES("Total Disposed Cases", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_CASES_FILED_BY_CORPORATE("Number of cases filed by corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_CASES_FILED_AGAINST_CORPORATE("Number of cases filed against corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_PENDING_CASES_FILED_BY_CORPORATE("Number pending of cases filed by corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DISPOSED_CASES_FILED_BY_CORPORATE("Number of disponse cases filed by corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_PENDING_CASES_FILED_AGAINST_CORPORATE("Number pending of cases filed against corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_DISPOSED_CASES_FILED_AGAINST_CORPORATE("Number of disposed cases filed against corporate", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    //======================GST==========================================
    STATUS("Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    GSTR1_STATUS("GSTR1 Filing Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    GSTR3_STATUS("GSTR3 Filing Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    STATE("State", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DATE_OF_REGISTRATION("Date of Registration", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    NATURE_OF_BUSINESS("Date of Registration", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    IS_GSTR1_TIMELY_FILED("GSTR1 Timely Filed", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    IS_GSTR3_TIMELY_FILED("GSTR3 Timely Filed", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    //==========================ANNEXTURE - FINACIAL PARAMETERS============
    INCOME_IN_FOREIGN_CURRENCY("Income in foreign currency", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    EXPENSE_IN_FOREIGN_CURRENCY("Expense in foreign currency", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    EMPLOYEE_BENEFITS_EXPENSE("Employee benefits expense", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    GROSS_VALUE_OF_THE_TXN_WITH_RELATED_PARTIES("Gross value of the transaction with the related parties as per AS-18", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    GROSS_FIXED_ASSETS("Gross fixed assets (including intangible assets)", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    TRADE_RECEIVABLE_EXCEDING_SIX_MONTHS("Trade receivables exceding six months", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    PROPOSED_DIVIDEND("Proposed dividend", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),


    // ===================================== DIRECTORS ========================================
    /* DIRECTOR */
    DIRECTOR_NAME("Name", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_AGE("Age", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_GENDER("Gender", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    PRESENT_DESIGNATION("Present Designation", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    APPOINTMENT_DATE("Appointment Date", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    DATE_OF_CESSATION("Date Of Cessation", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    FLAGS("Flags", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_DIN("DIN", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_PAN("PAN", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_DOB("Date Of Birth", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_NATIONALITY("Nationality", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_ADDRESS("Address", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DSC_EXPIRY("DSC Expiry", DataAttributeDataType.DATE, Collections.emptyMap(), Collections.emptyList()),

    /* Directors Statistics */
    TOTAL_NUMBER_OF_DIRECTORS("Total Number Of Directors", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_NUMBER_ACTIVE_DIRECTORS("Total Number Of Active Directors", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    TOTAL_NUMBER_OF_INACTIVE_DIRECTORS("Total Number Of Inactive Directors", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    //Kvb Individual Directors
    DIRECTOR_STATUS("Director Status", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_ID("Director Id", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),
    DIRECTOR_COMPANY_ID("Director Company Id", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    //EPFO
    EPFO_NUMBER_OF_EMPLOYEE("Number of employee", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EPFO_AMOUNT("Amount", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),


    //=====================PEER COMPARISON===========================
    NUMBER_OF_PEERS_IN_SAMPLE("# of Peers in Sample", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_ACTUAL_VALUE("Revenue (Rs. Crore) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_MEDIAN("Revenue (Rs. Crore) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_GROWTH_ACTUAL_VALUE("Revenue Growth (%) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVENUE_GROWTH_MEDIAN("Revenue Growth (%) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EBITDA_MARGIN_ACTUAL_VALUE("EBITDA Margin (%) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    EBITDA_MARGIN_MEDIAN("EBITDA Margin (%) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_MARGIN_ACTUAL_VALUE("Net Margin (%) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NET_MARGIN_MEDIAN("Net Margin (%) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RETURN_ON_EQUITY_ACTUAL_VALUE("Return on Equity (%) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    RETURN_ON_EQUITY_MEDIAN("Return on Equity (%) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBT_TO_EQUITY_ACTUAL_VALUE("Debt / Equity Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBT_TO_EQUITY_MEDIAN("Debt / Equity Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INVENTORY_TO_SALES_ACTUAL_VALUE("Inventory / Sales (Days) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    INVENTORY_TO_SALES_MEDIAN("Inventory / Sales (Days) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBTORS_TO_SALES_ACTUAL_VALUE("Debtors / Sales (Days) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DEBTORS_TO_SALES_MEDIAN("Debtors / Sales (Days) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAYABLES_TO_SALES_ACTUAL_VALUE("Payables / Sales (Days) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    PAYABLES_TO_SALES_MEDIAN("Payables / Sales (Days) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CASH_CONVERSION_CYCLE_ACTUAL_VALUE("Cash Conversion Cycle (Days) Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    CASH_CONVERSION_CYCLE_MEDIAN("Cash Conversion Cycle (Days) Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SALES_TO_NET_FIXED_ASSETS_ACTUAL_VALUE("Sales / Net Fixed Assets Actual Value", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    SALES_TO_NET_FIXED_ASSETS_MEDIAN("Sales / Net Fixed Assets Median", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    //5 Closest Peers by Revenue
    CLOSEST_PEERS_BY_REVENUE("5 Closest Peers by Revenue", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),

    RELATED_CORPORATES("Related Corporates", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),

    OTHER_DIRECTORSHIPS("Other Directorships", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),

    AUDITORS_COMMENTS("Auditors' Comments", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),

    QUALIFIED("Qualified", DataAttributeDataType.TEXT, Collections.emptyMap(), Collections.emptyList()),

    CREDIT_RATINGS("Credit Ratings", DataAttributeDataType.MULTI_PART_TEXT, new HashMap<String, Object>() {{
        put("typeReference", new TypeReference<List<Map<String, String>>>() {
        });
    }}, Collections.emptyList()),
    AFFIRMED_STATUS_COUNT("Affirmed Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    ASSIGNED_STATUS_COUNT("Assigned Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    DOWNGRADED_STATUS_COUNT("Downgraded Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REAFFIRMED_STATUS_COUNT("Reaffirmed Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    REVISED_STATUS_COUNT("Revised Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    UPGRADED_STATUS_COUNT("Upgraded Status Count", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),

    //Charges Summary
    INCREASE_IN_CHARGES("Increase in Charge", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList()),
    NEW_CHARGES_CREATIONS("New Charges Creation", DataAttributeDataType.NUMBER, Collections.emptyMap(), Collections.emptyList());

    private final String displayName;

    private final DataAttributeDataType dataAttributeDataType;

    private final Map<String, Object> additionalInformation;

    private final List<RegularizationType> regularizationTypeList;

    DataAttributeType(String displayName, DataAttributeDataType dataAttributeDataType, Map<String, Object> additionalInformation, List<RegularizationType> regularizationTypeList) {
        this.displayName = displayName;
        this.dataAttributeDataType = dataAttributeDataType;
        this.additionalInformation = additionalInformation;
        this.regularizationTypeList = regularizationTypeList;
    }

    public String getDisplayName() {
        return displayName;
    }

    public DataAttributeDataType getDataAttributeDataType() {
        return dataAttributeDataType;
    }

    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }

    public List<RegularizationType> getRegularizationTypeList() {
        return regularizationTypeList;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DataAttributeTypeDto {

        private String name;

        private String displayName;

        private DataAttributeDataType dataType;

        private Map<String, Object> additionalInformation;

    }

    public static class DataAttributeTypeToDtoConverter extends StdConverter<DataAttributeType, DataAttributeTypeDto> {
        @Override
        public DataAttributeTypeDto convert(DataAttributeType dataAttributeType) {
            return DataAttributeTypeDto.builder()
                    .name(dataAttributeType.toString())
                    .dataType(dataAttributeType.getDataAttributeDataType())
                    .displayName(dataAttributeType.getDisplayName())
                    .additionalInformation(dataAttributeType.getAdditionalInformation())
                    .build();
        }
    }

    public static class DtoToDataAttributeTypeConverter extends StdConverter<DataAttributeTypeDto, DataAttributeType> {
        @Override
        public DataAttributeType convert(DataAttributeTypeDto dataAttributeTypeDto) {
            return DataAttributeType.valueOf(dataAttributeTypeDto.name);
        }
    }

}
