package test;

import common.services.HttpService;
import common.services.Request;
import common.testdata.TestData;
import io.restassured.response.Response;
import models.CoinDesk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utilities.PropertyReader;

import static constants.constants.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static request.RequestBuilder.buildRequest;

public class CoinDeskTest {
    private PropertyReader prop;
    private HttpService httpService;

    @BeforeEach
    void beforeTestSetUp() {
        prop = new PropertyReader();
        httpService = new HttpService();
    }

    @ParameterizedTest
    @MethodSource("testdata.CoinDeskTestData#coinDeskGetDetailsTest")
    public void verifyGetService(final TestData testData) {
        final Request request = buildRequest();
        final Response response = httpService.sendRequest(request);
        assertEquals(SC_OK, response.getStatusCode());

        CoinDesk coinDesk = response.as(CoinDesk.class);
        assertEquals(testData.getInt("numberOfBpis"), coinDesk.getBpi().size());
        assertArrayEquals(testData.getStringArray("bpiValues"), coinDesk.getBpi().keySet().toArray());
        assertEquals(testData.getString("gbpDescription"), coinDesk.getBpi().get(GBP).getDescription());
    }
}
