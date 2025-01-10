package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Time {
    private String updated;
    @JsonProperty("updatedISO")
    private String updatedIso;
    @JsonProperty("updateduk")
    private String updatedUk;
}
