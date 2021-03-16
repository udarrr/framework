package com.epam.aqa.tests;

import com.epam.aqa.utils.PingUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePagesAvailableTest {
    @Test(description = "Smoke")
    public void checkAvailableCloudPage() {
        String CLOUD_HOME_PAGE_URL = "cloud.google.com";
        boolean expectedPagesAvailable = new PingUtils().pingHomePages(CLOUD_HOME_PAGE_URL, 80, 5000);

        Assert.assertTrue(expectedPagesAvailable, "Page isn't available");
    }

    @Test(description = "Smoke")
    public void checkAvailableTemporaryEmailPage() {
        String TEMPORARY_EMAIL_HOME_PAGE_URL = "10minutemail.com";
        boolean expectedPagesAvailable = new PingUtils().pingHomePages(TEMPORARY_EMAIL_HOME_PAGE_URL, 80, 5000);

        Assert.assertTrue(expectedPagesAvailable, "Page isn't available");
    }
}
