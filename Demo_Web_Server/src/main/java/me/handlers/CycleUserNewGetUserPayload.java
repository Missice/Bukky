package me.handlers;

import lombok.Data;
import net.sf.json.JSONObject;
import me.Validable;
@Data
public class CycleUserNewGetUserPayload  implements Validable { //通过userID来获取信息
    String cycleUserID;  //维持的用户的唯一标识
    String cyclelogInType; //登录的类型
    String cyclelogInID; //登陆的用户的名字
    JSONObject cycleUserMessage;//用来存储用户的ID
    String accessToken;
    public CycleUserNewGetUserPayload(){}
    public CycleUserNewGetUserPayload(String _cycleUserID, String _cyclelogInType, String _cyclelogInID, JSONObject _cycleUserMessage) {
        cycleUserID = _cycleUserID;
        cyclelogInType = _cyclelogInType;
        cyclelogInID = _cyclelogInID;
        cycleUserMessage = _cycleUserMessage;
    }


    public CycleUserNewGetUserPayload(String cycleUserID, String cyclelogInType, String cyclelogInID, JSONObject cycleUserMessage, String accessToken) {
        this.cycleUserID = cycleUserID;
        this.cyclelogInType = cyclelogInType;
        this.cyclelogInID = cyclelogInID;
        this.cycleUserMessage = cycleUserMessage;
        this.accessToken = accessToken;
    }

    public boolean isValid() {
         return cycleUserID!=null&&cycleUserID.length()>0&&accessToken!=null&&accessToken.length()>0;
    }

    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T)new CycleUserNewGetUserPayload((String)Message.get("cycleUserId"),(String)Message.get("cyclelogInType"),(String)Message.get("cyclelogInId"),(JSONObject)Message.get("cycleUserMessage"),(String)Message.get("accessToken"));
    }
}
