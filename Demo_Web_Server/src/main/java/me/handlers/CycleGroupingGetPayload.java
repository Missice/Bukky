package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;
@Data
public class CycleGroupingGetPayload implements Validable {
    private String accessToken;
    private String cycleUserID;
    public CycleGroupingGetPayload(String accessToken,String cycleUserId) {
        this.cycleUserID=cycleUserId;
        this.accessToken = accessToken;
    }

    public CycleGroupingGetPayload() {
    }

    @Override

    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T) new CycleGroupingGetPayload((String)Message.get("accessToken"),(String)Message.get("cycleUserId"));
    }
}
