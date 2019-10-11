package org.studwork.model;

import static org.studwork.utils.Language.t;

public enum  ECountryCode {

    RUSSIA(
            "+7",
            t("country.code.russia.country.text"),
            "russia.svg",
            "+7 () -",
            "9265481313"
    ),

    UKRAINE(
            "+380",
            t("country.code.ukraine.country.text"),
            "ukraine.svg",
            "+380 -",
            "1234567890"
    ),

    BELARUS(
            "+375",
            t("country.code.belarus.country.text"),
            "belarus.svg",
            "+375 () --",
            "1234567890"
    ),

    KAZAKHSTAN(
            "+7",
            t("country.code.kazakhstan.country.text"),
            "kazakhstan.svg",
            "+7 () -",
            "1234567890"
    ),

    UZBEKISTAN(
            "+998",
            t("country.code.uzbekistan.country.text"),
            "uzbekistn.svg",
            "+998 -",
            "1234567890"
    ),

    OTHER(
            "+",
            t("country.code.other.country.text"),
            "?",
            t("phone.number.caption.placeholder"),
            "1234567890"
    );

    private String code;
    private String country;
    private String icon;
    private String defaultCode;
    private String validNumbers;

    ECountryCode(String code, String country, String icon, String defaultCode, String validNumbers) {
        this.code = code;
        this.country = country;
        this.icon = icon;
        this.defaultCode = defaultCode;
        this.validNumbers = validNumbers;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public String getIcon() {
        return icon;
    }

    public String getDefaultCode() {
        return defaultCode;
    }

    public String getValidNumbers() {
        return validNumbers;
    }
}
