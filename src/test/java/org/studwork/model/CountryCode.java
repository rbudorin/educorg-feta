package org.studwork.model;

public class CountryCode {

    private String imageSrc;
    private String code;
    private String country;

    private CountryCode(Builder builder) {
        imageSrc = builder.imageSrc;
        code = builder.code;
        country = builder.country;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {

        private String imageSrc;
        private String code;
        private String country;

        public Builder() {}

        public Builder setImageSrc(String imageSrc) {
            this.imageSrc = imageSrc;

            return this;
        }

        public Builder setCode(String code) {
            this.code = code;

            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;

            return this;
        }

        public CountryCode build() {
            return new CountryCode(this);
        }
    }
}
