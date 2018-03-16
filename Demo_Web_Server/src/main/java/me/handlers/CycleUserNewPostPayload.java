package me.handlers;

import lombok.Data;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import me.Validable;
@Data
public class CycleUserNewPostPayload implements Validable { //通过userID来获取信息
    String cycleUserID;  //维持的用户的唯一标识
    String cyclelogInType; //登录的类型
    String cyclelogInID; //登陆的用户的名字
    JSON cycleUserMessage;//用来存储用户的ID

    public CycleUserNewPostPayload(String cycleUserID, String cyclelogInType, String cyclelogInID, JSON cycleUserMessage) {
        this.cycleUserID = cycleUserID;
        this.cyclelogInType = cyclelogInType;
        this.cyclelogInID = cyclelogInID;
        this.cycleUserMessage = cycleUserMessage;
    }

    public boolean isValid() {
        return cyclelogInID!=null&&cyclelogInID.length()>0;
    }

    public CycleUserNewPostPayload() {
    }
    @Override
    public <T> T AnalyJson(JSONObject Message, Class<T> valueType) {
        return (T)new CycleUserNewPostPayload((String)Message.get("cycleUserId"),(String)Message.get("cyclelogInType"),(String)Message.get("cyclelogInId"),(JSONObject)Message.get("cycleUserMessage"));
    }
}
