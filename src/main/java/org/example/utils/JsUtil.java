package org.example.utils;

import org.example.BaseWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JsUtil extends BaseWebDriver {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ZERO);

    public void waitForDocumentReady(int timeoutInSecounds) {
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                // Execute JavaScript to check if the document is ready
                return ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].style.border='3px solid red';", element);

        // Optionally add a delay to visualize the highlight
        try {
            Thread.sleep(100); // Highlight for 500ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Restore original style
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }
}
