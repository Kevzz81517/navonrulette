package com.navonmesh.navonrulette.rule;

import com.navonmesh.navonrulette.rule.historicalData.DoubleHistoricalDataV1;
import com.navonmesh.navonrulette.rule.historicalData.StringHistoricalDataV1;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class IndividualEquifaxReportFactEntityV1 extends FactEntityV1 {

    private DoubleHistoricalDataV1 noOfAccounts = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 score = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 noOfActiveAccounts = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 noOfZeroBalanceAccounts = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalBalanceAmount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalPastDueAmount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalHighCredit = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalCreditLimit = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalSanctionAmount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalMonthlyPaymentAmount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 singleHighestSanctionAmount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 singleHighestCredit = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 singleHighestBalance = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 avgOpenBalance = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 noOfWriteOffs = new DoubleHistoricalDataV1();

    private StringHistoricalDataV1 mostSevereStatusWithIn24Months = new StringHistoricalDataV1();

    private DoubleHistoricalDataV1 noOfPastDueAccounts = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalInquiriesInLast90Days = new DoubleHistoricalDataV1();

    private StringHistoricalDataV1 recentAccount = new StringHistoricalDataV1();

    private StringHistoricalDataV1 oldestAccount = new StringHistoricalDataV1();

    private DoubleHistoricalDataV1 accountDeliquentInLast90Days = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 accountsOpenedInLast90Days = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 accountUpdatedInLast90Days = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus000Count = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus01PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus30PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus60PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus90PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus120PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus180PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus360PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus540PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatus720PlusCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusCLSDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusNEWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusLNSBCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusLANDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusINACCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusCONCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusDBTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusFPDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusWDFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusPWOSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusNonDeliquentCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusSTDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusLOSSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusSFRCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusSFWDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusWOFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusSFWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusWDWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 paymentStatusSWDWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatus000Count = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusCLSDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusNEWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusLNSBCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusLANDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusINACCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusCONCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusDECCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatus01PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatus30PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatus60PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSPMCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSUBCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusRESCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusRGMCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusRNCCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSETCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusBASICCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusCLIENTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusREPORTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusREFERENCECount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusCOPYRIGHTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusDBTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusFPDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusWDFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusPWOSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusNonDeliquentCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSTDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusLOSSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSFRCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSFWDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusWOFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSFWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusWDWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 suitFiledStatusSWDWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus000Count = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusCLSDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusNEWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusLNSBCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusLANDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusINACCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusCONCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus01PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus30PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusDECCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus60PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSPMCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSUBCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusRESCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusRGMCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusRNCCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSETCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusBASICCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusCLIENTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusREPORTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusREFERENCECount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusCOPYRIGHTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus90PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus120PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus180PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus360PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus540PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatus720PLUSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusDBTCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusFPDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusWDFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusPWOSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusNonDeliquentCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSTDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusLOSSCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSFRCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSFWDCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusWOFCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSFWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusWDWOCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 assetClassificationStatusSWDWCount = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 totalLoanToIncomeRatio = new DoubleHistoricalDataV1();

    private DoubleHistoricalDataV1 monthlyIncome = new DoubleHistoricalDataV1();

    private StringHistoricalDataV1 fullName = new StringHistoricalDataV1();

    private StringHistoricalDataV1 firstName = new StringHistoricalDataV1();

    private StringHistoricalDataV1 middleName = new StringHistoricalDataV1();

    private StringHistoricalDataV1 lastName = new StringHistoricalDataV1();

    private StringHistoricalDataV1 additionalMiddleName = new StringHistoricalDataV1();

    private StringHistoricalDataV1 suffix = new StringHistoricalDataV1();

    private StringHistoricalDataV1 dateOfBirth = new StringHistoricalDataV1();

    private StringHistoricalDataV1 gender = new StringHistoricalDataV1();

    private StringHistoricalDataV1 occupation = new StringHistoricalDataV1();

    private StringHistoricalDataV1 maritalStatus = new StringHistoricalDataV1();

    private StringHistoricalDataV1 panNo = new StringHistoricalDataV1();

    private StringHistoricalDataV1 passportNo = new StringHistoricalDataV1();

    private StringHistoricalDataV1 driverLicenceNo = new StringHistoricalDataV1();

    private StringHistoricalDataV1 voterNo = new StringHistoricalDataV1();

    private StringHistoricalDataV1 nationalIdCardNo = new StringHistoricalDataV1();

    private StringHistoricalDataV1 rationCardNo = new StringHistoricalDataV1();

    private List<IndividualEquifaxReportFlatFactEntityV1> entities = new ArrayList<>();

    public IndividualEquifaxReportFactEntityV1() {
        super("Equifax Report");
    }
}
