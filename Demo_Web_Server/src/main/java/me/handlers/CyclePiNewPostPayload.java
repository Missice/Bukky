package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Data
public class CyclePiNewPostPayload implements Validable {
    String cycleUserID;                   // 用户的ID
    String cycleStartDate;                    // 指引，来判断是那一段路程
    JSONArray cyclePointMessage;  //直接存储传进来的信息
    private String accessToken;
    public CyclePiNewPostPayload(String cycleUserID,   String CycleStartDate, JSONArray cyclePointMessage) {
        cycleUserID = cycleUserID;
        cycleStartDate = CycleStartDate;
        cyclePointMessage = cyclePointMessage;
    }

    public CyclePiNewPostPayload() {
    }

    public CyclePiNewPostPayload(String cycleUserID, String CycleStartDate, JSONArray cyclePointMessage, String accessToken) {
        this.cycleUserID = cycleUserID;
        this.cycleStartDate = CycleStartDate;
        this.cyclePointMessage = cyclePointMessage;
        this.accessToken = accessToken;
    }

    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T)new CyclePiNewPostPayload((String)Message.get("cycleUserId"),(String)Message.get("cycleStartDate"),(JSONArray)Message.get("cyclePointMessage"),(String)Message.get("accessToken"));
    }
}
