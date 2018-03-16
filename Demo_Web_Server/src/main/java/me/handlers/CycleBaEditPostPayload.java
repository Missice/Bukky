package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;

@Data
public class CycleBaEditPostPayload implements Validable {

    private String cycleUserID;
    private int cyclebaseAddress;
    private String accessToken;
    public String getCycleUserID() {
        return cycleUserID;
    }

    public CycleBaEditPostPayload(String _cycleUserID, int _cyclebaseAddress,String _accessToken) {
        cycleUserID = _cycleUserID;
        cyclebaseAddress = _cyclebaseAddress;
        accessToken = _accessToken;
    }

    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T) new CycleBaEditPostPayload((String)Message.get("cycleUserID"),(int)Message.get("cyclebaseAddress"),(String)Message.get("accessToken"));
    }
}
