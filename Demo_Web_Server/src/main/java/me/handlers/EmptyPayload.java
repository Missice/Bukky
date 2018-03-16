package me.handlers;

import me.Validable;
import net.sf.json.JSONObject;

public class EmptyPayload implements Validable {
    @Override
    public boolean isValid() {
        return true;
    }

    public EmptyPayload() {
    }

    @Override

    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return null;
    }
}
