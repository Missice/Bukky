package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;
@Data
public class CycleGetFanLikePayload implements Validable {
    String  cycleUserID;//请求操作的ID
    private String accessToken;

    public CycleGetFanLikePayload(String cycleID, String accessToken) {
        this.cycleUserID = cycleID;
        this.accessToken = accessToken;
    }

    public CycleGetFanLikePayload() {
    }

    @Override
    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T) new CycleGetFanLikePayload((String)Message.get("cycleUserId"),(String) Message.get("accessToken"));
    }
}