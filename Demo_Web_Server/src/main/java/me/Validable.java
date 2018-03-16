package me;
import net.sf.json.JSONObject;

public interface Validable {
    boolean isValid();
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType);
}
