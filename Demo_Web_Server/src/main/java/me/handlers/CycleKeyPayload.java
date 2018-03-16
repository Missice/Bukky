package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;
@Data
public class CycleKeyPayload implements Validable {
    private String accessToken;
    private String cycleUserID;
    private String cycleStartDate;
    public CycleKeyPayload(String accessToken,String cycleUserId,String cycleStartDate) {
        this.cycleUserID=cycleUserId;
        this.accessToken = accessToken;
        this.cycleStartDate=cycleStartDate;
    }

    public CycleKeyPayload() {
    }

    @Override

    public boolean isValid() {
        return cycleStartDate!=null&&cycleStartDate.length()>0&&cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T) new CycleKeyPayload((String)Message.get("accessToken"),(String)Message.get("cycleUserId"),(String)Message.get("cycleStartDate"));
    }
}
