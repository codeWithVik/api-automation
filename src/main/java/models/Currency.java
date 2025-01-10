package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Currency {

    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonProperty("rate_float")
    private float rateFloat;
}
