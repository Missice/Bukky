package me.handlers;

import lombok.Data;
import net.sf.json.JSONObject;

import me.Validable;
@Data
public class EditPostPayload implements Validable {
    private String accesstoken;
    private String cycleUserID;
    private int cyclebaseAddress;
    public boolean isValid() {
        return true;
    }

    public EditPostPayload(String _cycleUserID, int _cyclebaseAddress) {
        cycleUserID = _cycleUserID;
        cyclebaseAddress = _cyclebaseAddress;
    }

    public EditPostPayload() {
    }

    public EditPostPayload(String accesstoken, String cycleUserID, int cyclebaseAddress) {
        this.accesstoken = accesstoken;
        this.cycleUserID = cycleUserID;
        this.cyclebaseAddress = cyclebaseAddress;
    }

    @Override


    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T)new EditPostPayload((String)Message.get("accesstoken"),(String)Message.get("cycleUserId"),(int)Message.get("cyclebaseAddress"));
    }
}
