package org.studwork.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.studwork.model.ECountryCode;
import org.studwork.steps.PhoneFormSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class UzbekistanPhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"123456789", "12 345 67 89", "+998 12 345 67-89"},
                {"12345678", "12 345 67 8", "+998 12 345 67-8"},
                {"1234567", "12 345 67", "+998 12 345 67-"},
                {"123456", "12 345 6", "+998 12 345 6-"},
                {"12345", "12 345", "+998 12 345 -"},
                {"1234", "12 34", "+998 12 34 -"},
                {"123", "12 3", "+998 12 3 -"},
                {"12", "12", "+998 12 -"},
                {"1", "1", "+998 1 -"}
        });
    }

    private final String numbers;
    private final String phoneNumber;
    private final String formattedPhoneNumber;

    public UzbekistanPhoneNumber(String numbers, String phoneNumber, String formattedPhoneNumber) {
        this.numbers = numbers;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber= formattedPhoneNumber;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyUzbekistanPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.UZBEKISTAN);
        phoneFormSteps.enterPhoneNumber(numbers);
        phoneFormSteps.phoneInputValueShouldBeEqualTo(phoneNumber);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(formattedPhoneNumber);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.UZBEKISTAN);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.UZBEKISTAN);
    }
}
