package com.bape.map;

import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class JsonBodyHandler<T> implements HttpResponse.BodyHandler<T> {
    private final Class<T> targetClass;

    public JsonBodyHandler(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public HttpResponse.BodySubscriber<T> apply(HttpResponse.ResponseInfo responseInfo) {
        return HttpResponse.BodySubscribers.mapping(HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8),
                body -> {
                    System.out.println(body);
                    return new Gson().fromJson(body, targetClass);
                });
    }
}
