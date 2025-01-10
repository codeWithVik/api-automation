package request;

import common.services.Request;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

import static constants.constants.BASE_URL;

public class RequestBuilder {

    public static Request buildRequest() {
        Request request = new Request();
        request.setContentType(ContentType.JSON);
        request.setMethod(Method.GET);
        request.setEndpoint(BASE_URL);
        return request;
    }
}