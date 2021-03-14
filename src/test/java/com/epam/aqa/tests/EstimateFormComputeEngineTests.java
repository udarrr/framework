package com.epam.aqa.tests;

import com.epam.aqa.pages.CloudGoogleHomePage;
import com.epam.aqa.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EstimateFormComputeEngineTests extends CommonConditionsJSON{
    @Test(description = "Hardcore")
    public void createEstimateAndComparePriceCalculatorWithSentByEmail() {

        boolean expectedPriceInCalculatorLikeInEmail = new CloudGoogleHomePage(driver)
                .openPage()
                .fillSearchInput()
                .openPage()
                .chooseComputerEngine()
                .fillInputNumberInstances(getQuantityInstances())
                .chooseOperationSystem(getOperationSystem())
                .chooseMachineClass(getMachineClass())
                .chooseSeries(getSeries())
                .chooseMachineType(getMachineType())
                .addGPUs(getGpuQuantity(), getGpuType())
                .chooseLocalSSD(getLocalSSD())
                .chooseDataCenterLocation(getDataCenterLocation())
                .chooseCommittedUsage(getCommittedUsage())
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