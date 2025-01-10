package constants;

import utilities.PropertyReader;

public class constants {
    public static final String BASE_URL = PropertyReader.getProperty("coindesk");

    public static final String EUR = "EUR";
    public static final String GBP = "GBP";
    public static final String USD = "USD";
    public static final String BRITISH_POUND_STERLING = "British Pound Sterling";
}
