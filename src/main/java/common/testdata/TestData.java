package common.testdata;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class TestData {
    private final Map<String, Object> data;

    public TestData() {
        data = new HashMap<>();
    }

    public String getString(String key) {
        return (String) data.getOrDefault(key, null);
    }

    public int getInt(String key) {
        return (int) data.getOrDefault(key, 0);
    }

    public String[] getStringArray(String key) {
        return (String[]) data.get(key);
    }

    public <T> TestData with(String key, T value) {
        data.put(key, value);
        return this;
    }

}
