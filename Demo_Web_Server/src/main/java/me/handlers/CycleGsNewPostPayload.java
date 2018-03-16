package me.handlers;

import lombok.Data;
import me.Validable;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Data
public class CycleGsNewPostPayload implements Validable{
    String cycleUserID;
    String cycleStartDate;
    JSONArray groupMessage;//直接用json来每一个Group的数据
    private String accessToken;
    public CycleGsNewPostPayload(String _cycleUserID,String _cycleStartdate, JSONArray GroupMessage) {
        cycleUserID = _cycleUserID;
        groupMessage = GroupMessage;
        cycleStartDate=_cycleStartdate;

    }

    public CycleGsNewPostPayload() {
    }

    public CycleGsNewPostPayload(String cycleUserID, String cycleStartdate, JSONArray groupMessage, String accessToken) {
        this.cycleUserID = cycleUserID;
        this.groupMessage = groupMessage;
        this.accessToken = accessToken;
        this.cycleStartDate=cycleStartdate;
    }

    public boolean isValid() {
        return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        System.out.println(Message.toString());
         return (T)new CycleGsNewPostPayload((String)Message.get("cycleUserId"), (String)Message.get("cycleStartDate"),(JSONArray) Message.get("groupMessage"),(String)Message.get("accessToken"));
    }
}
