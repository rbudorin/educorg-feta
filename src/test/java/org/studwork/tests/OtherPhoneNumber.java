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
public class OtherPhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"12345678900", "1 234 567 89 00", "+1 (234) 567 89-00"},
                {"1234567890", "1 234 567 89 0", "+1 (234) 567 89-0"},
                {"123456789", "1 234 567 89", "+1 (234) 567 89-"},
                {"12345678", "1 234 567 8", "+1 (234) 567 8-"},
                {"1234567", "1 234 567", "+1 (234) 567 -"},
                {"123456", "1 234 56", "+1 (234) 56 -"},
                {"12345", "1 234 5", "+1 (234) 5 -"},
                {"1234", "1 234", "+1 (234) -"},
                {"123", "1 23", "+1 (23) -"},
                {"12", "1 2", "+1 (2) -"},
                {"1", "1", "+1 () -"}
        });
    }

    private final String numbers;
    private final String phoneNumber;
    private final String formattedPhoneNumber;

    public OtherPhoneNumber(String numbers, String phoneNumber, String formattedPhoneNumber) {
        this.numbers = numbers;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber= formattedPhoneNumber;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyOtherPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.OTHER);
        phoneFormSteps.enterPhoneNumber(numbers);
        phoneFormSteps.phoneInputValueShouldBeEqualTo(phoneNumber);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(formattedPhoneNumber);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.OTHER);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.OTHER);
    }
}
