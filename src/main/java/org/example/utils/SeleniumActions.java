package org.example.utils;

import org.example.BaseWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumActions extends BaseWebDriver {

    private final int default_timeout_second = 45;
    private final WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ZERO);

    public int getTimeout(int... timeoutInSecoonds) {
        return (timeoutInSecoonds.length > 0) ? timeoutInSecoonds[0] : default_timeout_second;
    }

    public WebElement waitForElementToBePresent(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement waitForElementToBeDisplayed(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element, int... timeoutInSeconds) {
        return webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(By element, int... timeoutInSeconds) {
        waitForElementToBePresent(element, timeoutInSeconds);
        waitForElementToBeDisplayed(element, timeoutInSeconds);
        waitForElementToBeClickable(element, timeoutInSeconds).click();
    }

    public void writeInELement(By element, String text, int... timeoutInSeconds) {
        waitForElementToBeDisplayed(element, timeoutInSeconds).clear();
        waitForElementToBeClickable(element, timeoutInSeconds).sendKeys(text);
    }

    public void waitForElementToBeGone(By element, int... timeoutInSeconds) {
        webDriverWait.withTimeout(Duration.ofSeconds(getTimeout(timeoutInSeconds))).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public String getPatternFromElementText(By element, String regexPattern, int... timeoutInSeconds) {
        waitForElementToBePresent(element, getTimeout(timeoutInSeconds));
        String matchedText = "";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(waitForElementToBeDisplayed(element, getTimeout(timeoutInSeconds)).getText());
        if (matcher.find()) {
            matchedText = matcher.group();
        }
        return matchedText;
    }

}
