package org.studwork.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.studwork.model.CountryCode;
import org.studwork.model.ECountryCode;

import java.util.ArrayList;
import java.util.List;

public class PhoneFormPage extends Page {

    @FindBy(css = ".phone__print")
    private WebElement phoneNumberCaption;

    @FindBy(css = ".sw-phone-country__flag img")
    private WebElement countryCodeImage;

    @FindBy(css = ".sw-phone-country")
    private WebElement countryCodesExpandeControl;

    @FindBy(css = ".sw-phone-country-code")
    private WebElement countryCodeCaption;

    @FindBy(css = ".sw-phone-number__input")
    private WebElement phoneNumberInput;

    @FindBy(css = ".sw-phone-country__flag")
    private WebElement countryFlagIconWrapper;

    private String countryCodeXpathLocator = "//span[@class=\"sw-phone-country__title\" and text()=\"%s\"]/..";
    private String countryCodesCssLocator = ".sw-phone-country__dropdown .sw-phone-country__dropdown-item";

    public PhoneFormPage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneNumberCaptionText() {
        return element(phoneNumberCaption).getText();
    }

    public String getCountryCodeImageSource() {
        String imageSrc;

        try {
            imageSrc = element(countryCodeImage).getAttribute("src");
        } catch (Exception e) {
            imageSrc = element(countryFlagIconWrapper).getText();
        }

        return imageSrc;
    }

    public void clickCountryCodesExpandControl() {
        clickOn(countryCodesExpandeControl);
    }

    public List<CountryCode> getCountryCodes() {
        List<CountryCode> countryCodes = new ArrayList<>();
        List<WebElementFacade> elements = findAll(By.cssSelector(countryCodesCssLocator));

        for (WebElementFacade element: elements) {
            String imageSrc;

            try {
                imageSrc = element.findElement(By.cssSelector(".sw-phone-country__flag img"))
                        .getAttribute("src");
            } catch (Exception e) {
                imageSrc = element.findElement(By.cssSelector(".sw-phone-country__flag")).getText();
            }

            CountryCode countryCode = new CountryCode.Builder()
                    .setImageSrc(imageSrc)
                    .setCode(element.findElement(By.cssSelector(".sw-phone-country__code")).getText())
                    .setCountry(element.findElement(By.cssSelector(".sw-phone-country__title")).getText())
                    .build();

            countryCodes.add(countryCode);
        }

        return countryCodes;
    }

    public void selectCountry(ECountryCode code) {
        element(By.xpath(String.format(countryCodeXpathLocator, code.getCountry()))).click();
    }

    public String getCountryCodeCaptionText() {
        return element(countryCodeCaption).getText();
    }

    public void setPhoneNumberInputValue(String numbers) {
        enter(numbers).into(phoneNumberInput);
    }

    public String getPhoneInputValue() {
        return element(phoneNumberInput).getValue();
    }

    public String getPhoneInputPlaceholderText() {
        return element(phoneNumberInput).getAttribute("placeholder");
    }
}
