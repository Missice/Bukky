package me.handlers.CyclePihandler;

import java.util.Map;
import java.util.ArrayList;

import me.*;
import me.model.Model;
import me.model.CyclePointInfo;
import me.handlers.*;
import net.sf.json.JSONObject;

public class CyclePointInfoGetHandler extends AbstractRequestHandler<CycleKeyPayload> {

    public CyclePointInfoGetHandler(Model model) {
        super(CycleKeyPayload.class, model);
    }

    @Override
    protected Answer processImpl(CycleKeyPayload value, Map<String,String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken()))
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        return Answer.ok(dataToJson(model.CyclePointInfoGet(value.getCycleUserID(),value.getCycleStartDate())));
    }
}       // 返回所有对象的Json集合
