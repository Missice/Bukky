package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSONObject;

@Data
public class CycleBaNewPostPayload implements Validable {
    private String cycleUserID;
    private int cyclebaseAddress;
    private String accessToken;
    public String getCycleUserID() {
        return cycleUserID;
    }

    public void setCycleUserID(int cycleUserID) {
        cycleUserID = cycleUserID;
    }

    public int getCyclebaseAddress() {
        return cyclebaseAddress;
    }

    public void setCyclebaseAddress(int cyclebaseAddress) {
        cyclebaseAddress = cyclebaseAddress;
    }

    public CycleBaNewPostPayload(String cycleUserID, int cyclebaseAddress) {
        this.cycleUserID = cycleUserID;
        cyclebaseAddress = cyclebaseAddress;
    }

    public CycleBaNewPostPayload(String cycleUserID, int cyclebaseAddress, String accessToken) {
        this.cycleUserID = cycleUserID;
        this.cyclebaseAddress = cyclebaseAddress;
        this.accessToken = accessToken;
    }

    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return  (T)new CycleBaNewPostPayload((String)Message.get("cycleUserID"),(int)Message.get("cyclebaseAddress"),(String)Message.get("accessToken"));
    }
}
