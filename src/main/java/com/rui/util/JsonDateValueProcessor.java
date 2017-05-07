package com.rui.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/15.
 */
public class JsonDateValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd HH:mm:ss";

    public JsonDateValueProcessor(String format) {
        this.format = format;
    }

    public JsonDateValueProcessor() {
    }

    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return process(o);
    }

    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return process(o);
    }

    private Object process(Object value){
        if(value instanceof Date){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(value);
        }
        return value == null ? "" : value.toString();
    }
}
