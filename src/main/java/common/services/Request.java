package common.services;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Request {
    private ContentType contentType;
    private Map<String, String> headers;
    private Map<String, String> queryParameters;
    private Object requestBody;
    private Method method;
    private String endpoint;
}
