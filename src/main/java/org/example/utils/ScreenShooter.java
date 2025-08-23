package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShooter {

    private final WebDriver driver;

    public ScreenShooter(WebDriver driver) {
        this.driver = driver;
    }

    public byte[] takeScreenshot() {
        // Capture screenshot and return it as a byte array
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
