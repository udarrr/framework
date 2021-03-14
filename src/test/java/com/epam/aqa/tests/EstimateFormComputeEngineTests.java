package com.epam.aqa.tests;

import com.epam.aqa.model.EstimateForm;
import com.epam.aqa.model.ProgressData;
import com.epam.aqa.pages.CloudGoogleHomePage;
import com.epam.aqa.services.EstimateDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EstimateFormComputeEngineTests extends CommonConditions {
    @Test(description = "Hardcore")
    public void createEstimateAndComparePriceCalculatorWithSentByEmail() {
        EstimateForm estimateForm = EstimateDataCreator.getEstimateFormData();
        ProgressData progressData = new ProgressData();

        boolean expectedPriceInCalculatorLikeInEmail = new CloudGoogleHomePage(driver, progressData)
                .openPage()
                .fillSearchInput()
                .openPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(estimateForm.getQuantityInstances())
                .chooseOperationSystem(estimateForm.getOperationSystemID())
                .chooseMachineClass(estimateForm.getMachineClassID())
                .chooseSeries(estimateForm.getSeriesID())
                .chooseMachineType(estimateForm.getMachineTypeID())
                .addGPUs(estimateForm.getGpuQuantityID(), estimateForm.getGpuTypeID())
                .chooseLocalSSD(estimateForm.getLocalSSDID())
                .chooseDataCenterLocation(estimateForm.getDataCenterLocationID())
                .chooseCommittedUsage(estimateForm.getCommittedUsageID())
                .pressButtonAddToEstimate()
                .saveCalculatorTotalPriceResult()
                .pressButtonEmailEstimate()
                .openNewTab()
                .openPage()
                .copyTemporaryEmail()
                .comeBackToCalculator()
                .enterEmail()
                .pressButtonSendEmail()
                .switchTabToTemporaryEmailHomePage()
                .checkLetterInTemporaryEmailBox()
                .compareCalculatorTotalPriceResultHasTheSamePriceLikeInTemporaryEmailLetter();

        Assert.assertTrue(expectedPriceInCalculatorLikeInEmail, "Price in letter don't have the same value like in calculator");
    }

}