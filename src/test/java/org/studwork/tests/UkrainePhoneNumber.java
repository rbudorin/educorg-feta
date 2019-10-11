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
public class UkrainePhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"123456789", "123 456 78 9", "+380 12 345 67-89"},
                {"12345678", "123 456 78", "+380 12 345 67-8"},
                {"1234567", "123 456 7", "+380 12 345 67-"},
                {"123456", "123 456", "+380 12 345 6-"},
                {"12345", "123 45", "+380 12 345 -"},
                {"1234", "123 4", "+380 12 34 -"},
                {"123", "123", "+380 12 3 -"},
                {"12", "12", "+380 12 -"},
                {"1", "1", "+380 1 -"}
        });
    }

    private final String numbers;
    private final String phoneNumber;
    private final String formattedPhoneNumber;

    public UkrainePhoneNumber(String numbers, String phoneNumber, String formattedPhoneNumber) {
        this.numbers = numbers;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber= formattedPhoneNumber;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyUkrainianPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.UKRAINE);
        phoneFormSteps.enterPhoneNumber(numbers);
        phoneFormSteps.phoneInputValueShouldBeEqualTo(phoneNumber);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(formattedPhoneNumber);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.UKRAINE);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.UKRAINE);
    }
}
