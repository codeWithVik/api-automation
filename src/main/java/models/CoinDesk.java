package models;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class CoinDesk {

    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, Currency> bpi;
}
