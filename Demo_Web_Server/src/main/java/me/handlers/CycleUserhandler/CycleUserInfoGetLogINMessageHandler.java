package me.handlers.CycleUserhandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.model.Model;
import me.model.CycleUserInfo;
import me.handlers.*;
import net.sf.json.JSONObject;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class CycleUserInfoGetLogINMessageHandler extends AbstractRequestHandler<CycleUserNewGetUserPayload> {

    private Model model;

    public CycleUserInfoGetLogINMessageHandler(Model model) {
        super(CycleUserNewGetUserPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleUserNewGetUserPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
      if(!model.CycleIsAccessToken(value.getAccessToken())){
          return Answer.ok(JSONObject.fromObject(new CycleOperationPayload("CycleKey","failed")).toString());
          }
      return Answer.ok(dataToJson(model.CycleUserInfoGetUserMessage(value.getCycleUserID())));
    }
}
