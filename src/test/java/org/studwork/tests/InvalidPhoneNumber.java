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
public class InvalidPhoneNumber {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"A"},
                {"a"},
                {"@"},
                {"$"},
                {"%"},
                {"^"},
                {"&"},
        });
    }

    private final String symbols;

    public InvalidPhoneNumber(String symbols) {
        this.symbols = symbols;
    }

    @Steps
    PhoneFormSteps phoneFormSteps;

    @Test
    public void verifyInvalidPhoneNumberFormatting() {
        phoneFormSteps.openPhoneFormPage();
        phoneFormSteps.selectCountryCode(ECountryCode.BELARUS);
        phoneFormSteps.enterPhoneNumber(symbols);
        phoneFormSteps.phoneNumberCaptionShouldBeEqualTo(ECountryCode.BELARUS.getDefaultCode());
        phoneFormSteps.countryCodeIconShouldBeEqualTo(ECountryCode.BELARUS);
        phoneFormSteps.countryCodeShouldBeEqualTo(ECountryCode.BELARUS);
        phoneFormSteps.phoneInputShouldBeEmpty();
        phoneFormSteps.phoneInputPlaceholderShouldBeDisplayed();
    }
}
