package me.handlers.CycleGsHandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.handlers.CycleOperationPayload;
import me.model.Model;
import me.handlers.CycleKeyPayload;
import net.sf.json.JSONObject;

import java.util.Map;
import java.util.ArrayList;

public class CycleGroupingSituationDeleteHandler extends AbstractRequestHandler<CycleKeyPayload> {

    private Model model;

    public CycleGroupingSituationDeleteHandler(Model model) {
        super(CycleKeyPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleKeyPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken())) {
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        }
        model.CycleGroupingSituationDelete(value.getCycleUserID(),value.getCycleStartDate());

        return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleGroupongSituation","sucess")).toString());
    }
}
