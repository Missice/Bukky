package me;
import java.util.Map;
import java.util.ArrayList;

public interface RequestHandler<V extends Validable> {
    Answer process(V value, Map<String, String> urlParams, boolean shouldReturnHtml);
}

// <V extends Validable> 这意味着, 这个泛型V必须是 Validable 的子类(包括 Validable)
