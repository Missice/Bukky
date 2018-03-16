package me.handlers.CycleKeyHandler;

import me.AbstractRequestHandler;
import me.handlers.CycleOperationPayload;
import me.handlers.EmptyPayload;
import me.AbstractRequestHandler;
import me.Answer;
import me.model.CycleFanDbEntity;
import me.model.CycleKeyEntity;
import me.model.Model;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CycleGetKeyHandler extends AbstractRequestHandler<EmptyPayload> {
    public CycleGetKeyHandler(Model model) {
        super(EmptyPayload.class, model);
    }

    @Override
    protected Answer processImpl(EmptyPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if (!urlParams.containsKey(":userid")||!urlParams.containsKey(":apikey")) {
            throw new IllegalArgumentException();
        }
        String UserId,ApiKey;
        try {
            UserId=urlParams.get(":userid");
            ApiKey=urlParams.get(":apikey");
        } catch (IllegalArgumentException e) {
            return new Answer(404);
        }
        String str="9a842f5b-4840-488a-ba93-90ae05828355";
        if(!ApiKey.equals(str)) {
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleAppKey","failed")).toString());
        }
        List<CycleKeyEntity> CyclecleUserTempList = new ArrayList<CycleKeyEntity>();
            if(model.CycleGetAccessToken(UserId)==null){
                return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
            }
            CyclecleUserTempList.add(model.CycleGetAccessToken(UserId).get(0));
        return Answer.ok(JSONObject.fromObject(CyclecleUserTempList.get(0)).toString());
    }
}