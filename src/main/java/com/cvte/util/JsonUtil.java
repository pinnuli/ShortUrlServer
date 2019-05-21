package com.cvte.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author linxiaoyi
 * @date 2019/4/29
 */
public class JsonUtil {

    public static String objectToJson(Object object) {
        return JSON.toJSONString(object);
    }

    public static Object jsonToObject(String jsonString, Class objectClass) {
        JSONObject jsonObject =  JSON.parseObject(jsonString);
        return JSON.toJavaObject(jsonObject, objectClass);
    }
}
