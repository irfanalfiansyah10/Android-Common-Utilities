package com.mcnmr.utilities.extension;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

@SuppressWarnings("ALL")
public class JSONUtils {
    public static JSONObject getJsonFromMap(Map<String, Object> map) throws JSONException {
        JSONObject jsonData = new JSONObject();
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof Map<?, ?>) {
                value = getJsonFromMap((Map<String, Object>) value);
            }
            jsonData.put(key, value);
        }
        return jsonData;
    }
}
