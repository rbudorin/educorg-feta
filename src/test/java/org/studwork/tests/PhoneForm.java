package org.studwork.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.studwork.model.ECountryCode;
import org.studwork.steps.PhoneFormSteps;

@RunWith(SerenityRunner.class)
public class PhoneForm {

    @Managed
    WebDriver driver;

    @ManagedPages
    Pages pages;

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyPhoneNumberFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.phoneFormShouldBeDefaultState();
    }

    @Test
    public void verifyCountryCodeList() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.countryCodesShouldBePresent();
    }

    @Test
    public void verifyKazahstanPhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.KAZAKHSTAN);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.KAZAKHSTAN.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.KAZAKHSTAN);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.KAZAKHSTAN);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }

    @Test
    public void verifyBelarusPhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.BELARUS);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.BELARUS.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.BELARUS);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.BELARUS);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }

    @Test
    public void verifyUkrainePhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.UKRAINE);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.UKRAINE.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.UKRAINE);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.UKRAINE);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }

    @Test
    public void verifyUzbekistanPhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.UZBEKISTAN);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.UZBEKISTAN.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.UZBEKISTAN);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.UZBEKISTAN);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }

    @Test
    public void verifyRussianPhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.KAZAKHSTAN);
        phoneFormSteps.selectCountryCode(ECountryCode.RUSSIA);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.RUSSIA.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.RUSSIA);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.RUSSIA);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }

    @Test
    public void verifyOtherPhoneFormDefaultState() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.OTHER);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.OTHER.getDefaultCode());
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.OTHER);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.OTHER);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }
}
