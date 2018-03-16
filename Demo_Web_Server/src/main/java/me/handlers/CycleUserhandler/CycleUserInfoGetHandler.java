package me.handlers.CycleUserhandler;

import me.AbstractRequestHandler;
import me.Answer;
import me.handlers.CycleUserNewPostPayload;
import me.model.CycleUserInfo;
import me.model.Model;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class CycleUserInfoGetHandler extends AbstractRequestHandler<CycleUserNewPostPayload> {

    private Model model;

    public CycleUserInfoGetHandler(Model model) {
        super(CycleUserNewPostPayload.class, model);
        this.model = model;
    }

    @Override
    protected Answer processImpl(CycleUserNewPostPayload value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        String str = dataToJson(model.CycleUserInfoGetUserID(value.getCyclelogInType(), value.getCyclelogInID(), value.getCycleUserMessage()));
        return Answer.ok(str);
    }
}