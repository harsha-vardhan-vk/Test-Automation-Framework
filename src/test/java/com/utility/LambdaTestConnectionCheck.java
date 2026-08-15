package com.utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestConnectionCheck {

    public static void main(String[] args) {
        
        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");
        
        System.out.println("========================================");
        System.out.println("USERNAME    : " + username);
        System.out.println("ACCESS_KEY  : " + (accessKey != null ? accessKey.substring(0, 5) + "..." : "NULL"));
        System.out.println("KEY LENGTH  : " + (accessKey != null ? accessKey.length() : 0));
        System.out.println("========================================");
        
        if (username == null || accessKey == null) {
            System.out.println("ERROR: Environment variables not set!");
            return;
        }
        
        String hubURL = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
        System.out.println("Connecting to LambdaTest...");
        
        WebDriver driver = null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "latest");
            
            Map<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("user", username);
            ltOptions.put("accessKey", accessKey);
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("build", "Connection Test");
            ltOptions.put("name", "ConnectionCheck");
            capabilities.setCapability("LT:Options", ltOptions);
            
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
            
            System.out.println("SUCCESS! Connected to LambdaTest");
            System.out.println("Session ID: " + ((RemoteWebDriver) driver).getSessionId());
            
            driver.get("https://www.google.com");
            System.out.println("Page Title: " + driver.getTitle());
            
        } catch (Exception e) {
            System.out.println("FAILED to connect!");
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed.");
            }
        }
    }
}