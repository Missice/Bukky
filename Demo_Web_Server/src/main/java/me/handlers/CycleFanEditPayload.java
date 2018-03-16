package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;
@Data
public class CycleFanEditPayload implements Validable {
    String  cycleUserID;
    String cycleLikeID;
    private String accessToken;

    public CycleFanEditPayload(String accessToken) {
        this.accessToken = accessToken;
    }

    public CycleFanEditPayload() {
    }

    public CycleFanEditPayload(String cycleUserID, String likeID, String accessToken) {
        this.cycleUserID = cycleUserID;
        this.cycleLikeID = likeID;
        this.accessToken = accessToken;
    }

    @Override
    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T) new CycleFanEditPayload((String) Message.get("cycleUserId"),(String) Message.get("cycleLikeId"),(String) Message.get("accessToken"));
    }
}