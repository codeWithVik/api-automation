package testdata;

import common.testdata.TestData;

import java.util.stream.Stream;

public class CoinDeskTestData {

    static Stream<TestData> coinDeskGetDetailsTest() {
        TestData getDetails = new TestData().with("numberOfBpis", 3)
                .with("bpiValues", new String[]{"USD", "GBP", "EUR"})
                .with("gbpDescription", "British Pound Sterling");
        return Stream.of(getDetails);
    }

}
