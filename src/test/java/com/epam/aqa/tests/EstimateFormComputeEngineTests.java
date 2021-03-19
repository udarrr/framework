package com.epam.aqa.tests;

import com.epam.aqa.models.EstimateForm;
import com.epam.aqa.pages.CloudGoogleHomePage;
import com.epam.aqa.pages.PricingCalculatorPageFrame;
import com.epam.aqa.services.EstimateDataCreator;
import com.epam.aqa.utils.JavascriptUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EstimateFormComputeEngineTests extends CommonConditions {
    @Test(description = "Hardcore")
    public void createEstimateAndComparePriceCalculatorWithSentByEmail() {
        EstimateForm estimateForm = EstimateDataCreator.getEstimateFormData();
        String SEARCHING_QUERY = "Google Cloud Platform Pricing Calculator";

        PricingCalculatorPageFrame pricingCalculatorPageFrame = new CloudGoogleHomePage(driver, processData)
                .openPage()
                .fillSearchInput(SEARCHING_QUERY)
                .openPage()
                .chooseLinkDependingSearchingQuery()
                .moveToCalculatorPageFrame()
                .chooseComputerEngineForm()
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
                .pressButtonEmailEstimate();

       int indexTemporaryEmailTab = JavascriptUtils.createTab(driver);

        String totalPriceInTemporaryEmailLetter = pricingCalculatorPageFrame
                .openTemporaryEmailTab(indexTemporaryEmailTab)
                .openPage()
                .copyTemporaryEmail()
                .openPricingCalculatorTab(0)
                .enterEmail()
                .pressButtonSendEmail()
                .openTemporaryEmailTab(indexTemporaryEmailTab)
                .checkLetterInTemporaryEmailBox()
                .totalPriceInTemporaryEmailLetter();

        boolean expectedPriceInCalculatorLikeInEmail = processData.getCurrentPriceInCalculator().contains(totalPriceInTemporaryEmailLetter);

        Assert.assertTrue(expectedPriceInCalculatorLikeInEmail, "Price in letter don't have the same value like in calculator");
    }
}