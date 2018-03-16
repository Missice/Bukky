package me.handlers.CyclePihandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.model.Model;
import me.handlers.*;
import net.sf.json.JSONObject;

import java.util.Map;
import java.util.ArrayList;

public class CyclePointInfoDeleteHandler extends AbstractRequestHandler<CycleKeyPayload> {

    private Model model;

    public CyclePointInfoDeleteHandler(Model model) {
        super(CycleKeyPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleKeyPayload  value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if(model.CycleIsAccessToken(value.getAccessToken()))
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        model.CyclePointInfoDelete(value.getCycleUserID(),value.getCycleStartDate());
        return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CyclePointInfo","sucess")).toString());
    }
}
