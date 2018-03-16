package me.handlers.CycleFanHandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.handlers.CycleFanEditPayload;
import me.handlers.CycleGetFanLikePayload;
import me.handlers.CycleOperationPayload;
import me.model.Model;
import net.sf.json.JSONObject;

import java.util.Map;

public class CycleGetLikeHandler extends AbstractRequestHandler<CycleGetFanLikePayload> {//得到他关注了谁
    private Model model;

    public CycleGetLikeHandler(Model model) {
        super(CycleGetFanLikePayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleGetFanLikePayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if(!model.CycleIsAccessToken(value.getAccessToken())){
            return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
        }
         return Answer.ok(dataToJson(model.CycleGetLike(value.getCycleUserID())));
    }
}
