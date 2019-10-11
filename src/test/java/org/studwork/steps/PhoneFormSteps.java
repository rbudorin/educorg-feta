package org.studwork.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.studwork.model.CountryCode;
import org.studwork.model.ECountryCode;
import org.studwork.pages.PhoneFormPage;

import java.util.List;

import static org.junit.Assert.*;
import static org.studwork.utils.Language.t;

public class PhoneFormSteps {

    PhoneFormPage phoneFormPage;

    @Step
    public void openPhoneFormPage() {
        phoneFormPage.open();
    }

    @Step
    public void phoneNumberCaptionShouldBeEqualTo(String formattedPhoneNumber) {
        assertEquals(formattedPhoneNumber, phoneFormPage.getPhoneNumberCaptionText());
    }

    @Step
    public void phoneNumberCaptionPlaceholderShouldBeDisplayed() {
        assertEquals(t("phone.number.caption.placeholder"), phoneFormPage.getPhoneNumberCaptionText());
    }

    @Step
    public void countryCodeIconShouldBeEqualTo(ECountryCode countryCode) {
        assertTrue(phoneFormPage.getCountryCodeImageSource().contains(countryCode.getIcon()));
    }

    @Step
    public void countryCodeShouldBeEqualTo(ECountryCode countryCode) {
        assertEquals(countryCode.getCode(), phoneFormPage.getCountryCodeCaptionText());
    }

    @Step
    public void selectCountryCode(ECountryCode countryCode) {
        phoneFormPage.clickCountryCodesExpandControl();
        phoneFormPage.selectCountry(countryCode);
    }

    @Step
    public void enterPhoneNumber(String numbers) {
        phoneFormPage.setPhoneNumberInputValue(numbers);
    }

    @Step
    public void phoneInputShouldBeEmpty() {
        assertEquals("", phoneFormPage.getPhoneInputValue());
    }

    @Step
    public void phoneInputValueShouldBeEqualTo(String phone) {
        assertEquals(phone, phoneFormPage.getPhoneInputValue());
    }

    @Step
    public void phoneInputPlaceholderShouldBeDisplayed() {
        assertEquals(t("phone.input.placeholder"), phoneFormPage.getPhoneInputPlaceholderText());
    }

    @Step
    public void countryCodesShouldBePresent() {
        phoneFormPage.clickCountryCodesExpandControl();
        List<CountryCode> countryCodes = phoneFormPage.getCountryCodes();
        int position = 0;

        for (ECountryCode expectedCountryCode: ECountryCode.values()) {
            CountryCode countryCode = countryCodes.get(position);

            assertTrue(countryCode.getImageSrc().contains(expectedCountryCode.getIcon()));
            assertEquals(expectedCountryCode.getCode(), countryCode.getCode());
            assertEquals(expectedCountryCode.getCountry(), countryCode.getCountry());

            position++;
        }

        assertEquals(ECountryCode.values().length, countryCodes.size());
    }

    @StepGroup
    public void phoneFormShouldBeDefaultState() {
        phoneNumberCaptionPlaceholderShouldBeDisplayed();
        countryCodeIconShouldBeEqualTo(ECountryCode.RUSSIA);
        countryCodeShouldBeEqualTo(ECountryCode.RUSSIA);
        phoneInputShouldBeEmpty();
        phoneInputPlaceholderShouldBeDisplayed();
    }
}
