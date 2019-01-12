package com.mentoring.exception;

public enum  Country {
    VN ("Việt Nam", 84),
    EN ("English", 30),
    OTHER ("Other", 00);

    private static final Country defaultCountry;

    static {
        String envCountry = System.getenv("COUNTRY_CODE");
        defaultCountry = Country.createFromConfig(envCountry);
    }

    private static Country createFromConfig(String envCountry) {
        if (envCountry == null) {
            return OTHER;
        }
        switch (envCountry) {
            case "VN":
                return VN;
            case "EN":
                return EN;
            default:
                return OTHER;
        }
    }

    private final String name;
    private final int countryCode;

    Country(String name, int countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public static Country getDefaultCountry() {
        return defaultCountry;
    }

    public String getName() {
        return name;
    }

    public int getCountryCode() {
        return countryCode;
    }
}
