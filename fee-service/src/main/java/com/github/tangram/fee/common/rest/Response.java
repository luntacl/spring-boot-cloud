package com.github.tangram.fee.common.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.io.Serializable;
import java.util.Set;

public class Response implements Serializable {

    private static final long serialVersionUID = -3272004536045592039L;

    private JSONObject result = null;
    private static final String DATA = "data";

    private static final String CODE = "code";

    private static final String MESSAGE = "message";

    // 默认的正确响应
    private static final String SUCCESS_CODE = "0000";
    private static final String FAILURE_CODE = "9999";
    private static final String SUCCESS_MESSAGE = "接口成功执行";

    private Response(Builder builder) {
        result = new JSONObject();
        result.put(CODE, builder.code);
        result.put(MESSAGE, builder.message);
        result.put(DATA, builder.data);
    }

    public String toJSONString() {
        return result.toJSONString();
    }

    public String toJSONString(final String... args) {
        final Set<String> set = Sets.newHashSet(args);
        return toJSONString(set);
    }

    public String toJSONString(final Set<String> set) {
        final SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
        final Set<String> includes = filter.getIncludes();
        set.add(DATA);
        set.add(CODE);
        set.add(MESSAGE);
        includes.addAll(set);
        return JSON.toJSONString(result, filter);
    }

    public String toJSONString(final SimplePropertyPreFilter filter) {
        return JSON.toJSONString(result, filter);
    }

    @Override
    public String toString() {
        return result.toJSONString();
    }

    public static Builder successBuilder() {
        return new Builder(SUCCESS_CODE);
    }

    public static Builder failureBuilder() {
        return new Builder(FAILURE_CODE);
    }

    public static Builder builder(String code) {
        return new Builder(code);
    }

    public static final class Builder {
        private final String code;
        private Object data;
        private String message = SUCCESS_MESSAGE;

        private Builder(String code) {
            this.code = code;
        }

        public Builder setData(Object data) {
            this.data = data;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Response Build() {
            return new Response(this);
        }

        public String BuildString() {
            return new Response(this).toJSONString();
        }

        public String BuildString(String... args) {
            return new Response(this).toJSONString(args);
        }
    }

    public static void main(String[] args) {
        String buildString = Response.successBuilder().setData(ImmutableMap.of("1", "wd", "2", "cc")).setMessage("xxx").BuildString();
        System.out.println(buildString);
        String buildString2 = Response.failureBuilder().setMessage("123").BuildString();
        System.out.println(buildString2);
        Response build = Response.builder("888").setMessage("www").Build();
        System.out.println(build);
        String s = Response.successBuilder().setData(ImmutableMap.of("1", "wd", "2", "cc")).setMessage("xxx").BuildString("2");
        System.out.println(s);
    }
}
