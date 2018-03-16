package me.handlers.CyclePihandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.model.Model;
import me.handlers.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;
import java.util.ArrayList;
public class CyclePointInfoCreateHandler extends AbstractRequestHandler<CyclePiNewPostPayload> {

    private Model model;

    public CyclePointInfoCreateHandler(Model model) {
        super(CyclePiNewPostPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CyclePiNewPostPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if (!model.CycleIsAccessToken(value.getAccessToken()))
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        model.CyclePointInfoCreate(value.getCycleUserID(), value.getCycleStartDate(),JSONArray.fromObject(value.getCyclePointMessage()));
        return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CyclePointInfo","sucess")).toString());
    }
}
