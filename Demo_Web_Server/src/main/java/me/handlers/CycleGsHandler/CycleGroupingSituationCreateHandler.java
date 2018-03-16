package me.handlers.CycleGsHandler;

import me.handlers.CycleGsNewPostPayload;
import me.handlers.CycleOperationPayload;
import me.model.Model;
import me.AbstractRequestHandler;
import me.Answer;
import net.sf.json.JSONObject;

import java.util.Map;
public class CycleGroupingSituationCreateHandler extends AbstractRequestHandler<CycleGsNewPostPayload> {

    private Model model;

    public CycleGroupingSituationCreateHandler(Model model) {
        super(CycleGsNewPostPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleGsNewPostPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken())) {
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        }
        model.CycleGroupingSituationCreate(value.getCycleUserID(),value.getCycleStartDate(), value.getGroupMessage());
        return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleGroupongSituation","sucess")).toString());
    }
}
