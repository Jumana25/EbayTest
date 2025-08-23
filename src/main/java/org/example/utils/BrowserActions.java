package org.example.utils;

import org.example.BaseWebDriver;

public class BrowserActions extends BaseWebDriver {

    public void openURL(String url){
        driver.navigate().to(url);
    }

}
