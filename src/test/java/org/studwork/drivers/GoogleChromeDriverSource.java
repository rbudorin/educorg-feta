package org.studwork.drivers;

import org.studwork.utils.Environment;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class GoogleChromeDriverSource implements DriverSource {

    @Override
    public WebDriver newDriver() {
        ClassLoader classLoader =  GoogleChromeDriverSource.class.getClassLoader();

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(classLoader.getResource(
                        Environment.get("webdriver.chrome.driver")).getFile()))
                .usingAnyFreePort()
                .build();

        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(service, options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}