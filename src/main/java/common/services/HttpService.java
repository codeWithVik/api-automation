package common.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Objects;

public class HttpService {

    public Response sendRequest(final Request request) {
        RequestSpecification reqSpec = RestAssured.given();
        setContentType(reqSpec, request);
        setHeaders(reqSpec, request);
        setQueryParams(reqSpec, request);
        setBody(reqSpec, request);
        return send(reqSpec, request);
    }

    private Response send(RequestSpecification reqSpec, Request request) {
        if (Objects.isNull(request.getMethod())) {
            throw new IllegalArgumentException("Request Method can not be empty.");
        }
        return reqSpec.request(request.getMethod(), request.getEndpoint()).then().log().all().extract().response();
    }

    private void setQueryParams(RequestSpecification reqSpec, Request request) {
        if (!Objects.isNull(request.getQueryParameters())) {
            reqSpec.queryParams(request.getQueryParameters());
        }
    }

    private void setBody(RequestSpecification reqSpec, Request request) {
        if (!Objects.isNull(request.getRequestBody())) {
            reqSpec.body(request.getRequestBody());
        }
    }

    private void setHeaders(RequestSpecification reqSpec, Request request) {
        if (!Objects.isNull(request.getHeaders())) {
            reqSpec.headers(request.getHeaders());
        }
    }

    private void setContentType(RequestSpecification reqSpec, Request request) {
        if (!Objects.isNull(request.getContentType())) {
            reqSpec.contentType(request.getContentType());
        }
    }
}
