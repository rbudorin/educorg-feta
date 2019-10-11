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
public class BelarusPhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"123456789", "123 45 67 89", "+375 (123) 45-67-89"},
                {"12345678", "123 45 67 8", "+375 (123) 45-67-8"},
                {"1234567", "123 45 67", "+375 (123) 45-67-"},
                {"123456", "123 45 6", "+375 (123) 45-6-"},
                {"12345", "123 45", "+375 (123) 45--"},
                {"1234", "123 4", "+375 (123) 4--"},
                {"123", "123", "+375 (123) --"},
                {"12", "12", "+375 (12) --"},
                {"1", "1", "+375 (1) --"}
        });
    }

    private final String numbers;
    private final String phoneNumber;
    private final String formattedPhoneNumber;

    public BelarusPhoneNumber(String numbers, String phoneNumber, String formattedPhoneNumber) {
        this.numbers = numbers;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber= formattedPhoneNumber;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyBelarusPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.BELARUS);
        phoneFormSteps.enterPhoneNumber(numbers);
        phoneFormSteps.phoneInputValueShouldBeEqualTo(phoneNumber);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(formattedPhoneNumber);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.BELARUS);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.BELARUS);
    }
}
