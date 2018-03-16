package me.handlers.CycleGsHandler;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import me.*;


import me.handlers.CycleOperationPayload;
import me.model.Model;
import me.model.CycleGroupingSituation;
import me.handlers.CycleGroupingGetPayload;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CycleGroupingSituationGetHandler extends AbstractRequestHandler<CycleGroupingGetPayload> {

    public CycleGroupingSituationGetHandler(Model model) {
        super(CycleGroupingGetPayload.class, model);
    }

    @Override
    protected Answer processImpl(CycleGroupingGetPayload value, Map<String,String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken())) {
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        }
        List<CycleGroupingSituation> groupingSituationList = model.CycleGroupingSituationGet(value.getCycleUserID());

        return Answer.ok(JSONArray.fromObject(groupingSituationList).toString());
    }
}       // 返回所有对象的Json集合
