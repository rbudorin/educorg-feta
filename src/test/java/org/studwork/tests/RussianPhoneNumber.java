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
public class RussianPhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"9265481313", "926 548 13 13", "+7 (926) 548 13-13"},
                {"926548131",  "926 548 13 1", "+7 (926) 548 13-1"},
                {"92654813",  "926 548 13", "+7 (926) 548 13-"},
                {"9265481",  "926 548 1", "+7 (926) 548 1-"},
                {"926548",  "926 548", "+7 (926) 548 -"},
                {"92654",  "926 54", "+7 (926) 54 -"},
                {"9265",  "926 5", "+7 (926) 5 -"},
                {"926",  "926", "+7 (926) -"},
                {"92",  "92", "+7 (92) -"},
                {"9",  "9", "+7 (9) -"}
        });
    }

    private final String numbers;
    private final String phoneNumber;
    private final String formattedPhoneNumber;

    public RussianPhoneNumber(String numbers, String phoneNumber, String formattedPhoneNumber) {
        this.numbers = numbers;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber= formattedPhoneNumber;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyRussianPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.enterPhoneNumber(numbers);
        phoneFormSteps.phoneInputValueShouldBeEqualTo(phoneNumber);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(formattedPhoneNumber);
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.RUSSIA);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.RUSSIA);
    }
}
