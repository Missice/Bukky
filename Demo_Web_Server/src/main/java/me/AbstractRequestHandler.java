package me;

import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import me.handlers.EmptyPayload;
import me.model.Model;
import spark.Request;
import spark.Response;
import spark.Route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public abstract class AbstractRequestHandler<V extends Validable> implements RequestHandler<V>, Route{
    private Class<V> valueClass;              // V类型的类值
    protected Model model;                      // model

    private static final int HTTP_BAD_REQUEST = 400;

    public AbstractRequestHandler(Class<V>valueClass, Model model){
        this.valueClass = valueClass;
        this.model = model;
    }

    private static boolean shouldReturnHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }       // request.headers中必须为Accept且 其包含 text/html

    public static String dataToJson(Object data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(data);
        } catch (IOException e){
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }       // 返回data的Json

    public final Answer process(V value, Map<String, String> urlParams, boolean shouldReturnHtml) {
        if (value != null && !value.isValid()) {
            return new Answer(HTTP_BAD_REQUEST);
        } else {
            return processImpl(value, urlParams, shouldReturnHtml);
        }
    }                                                                    // value首先是Validable的子类了,得合格

    protected abstract Answer processImpl(V value, Map<String, String> urlParams, boolean shouldReturnHtml);


    @Override
    public Object handle(Request request, Response response) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Validable s=valueClass.newInstance();
            V value = null;
            if (!valueClass.equals(EmptyPayload.class)) {                           // 如果负载非空
                     value=s.AnalyJson(JSONObject.fromObject(request.body()),valueClass);
            }
            Map<String, String> urlParams = request.params();                 // 相当于url中所有值对的map
            Answer answer = process(value, urlParams, shouldReturnHtml(request));
            response.status(answer.getCode());                                // 实际上是processImpl返回的一个Answer对象
            if (shouldReturnHtml(request)) {
                response.type("text/html");
            } else {
                response.type("application/json");
            }
            response.body(answer.getBody());
            return answer.getBody();
        } catch (InstantiationException e) {
            response.status(400);
            response.body(e.getMessage());
            return e.getMessage();
        }
    }
}
