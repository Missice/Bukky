package me.handlers.CycleFanHandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.handlers.CycleFanEditPayload;
import me.handlers.CycleOperationPayload;
import me.model.Model;
import net.sf.json.JSONObject;

import java.util.Map;
public class CycleAddFanHandler extends AbstractRequestHandler<CycleFanEditPayload> {//增加关注

    private Model model;

    public CycleAddFanHandler(Model model) {
        super(CycleFanEditPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleFanEditPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken())){
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        }
        model.CycleAddLike(value.getCycleUserID(),value.getCycleLikeID());
        return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleFan","sucess")).toString());
    }
}