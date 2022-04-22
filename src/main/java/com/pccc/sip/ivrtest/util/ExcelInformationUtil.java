package com.pccc.sip.ivrtest.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ExcelInformationUtil {

    private static JsonObject jsonObject = new JsonObject();
    private static final String fileName = "json/ExcelInformation.json";

    public static void init(){
        jsonObject = GsonUtil.readerJsonObject(fileName);
    }

    /**
     *
     * @param keys key值按层级输入
     * @return
     */
    public static String getString(String... keys){
        int length = keys.length;
        JsonObject json = null;
        String s = null;
        for (int i= 0;i< keys.length;i++){
            if (i == length - 1 ){
                if (i == 0){
                    s = jsonObject.get(keys[i]).getAsString();
                }else {
                    s = json.get(keys[i]).getAsString();
                }
            }else {
                json = jsonObject.getAsJsonObject(keys[i]);
            }
        }
        return s;
    }

    /**
     *
     * @param keys key值按层级输入
     * @return
     */
    public static String[] getStringArray(String... keys){
        int length = keys.length;
        JsonObject json = null;
        JsonArray array = new JsonArray();
        for (int i= 0;i< keys.length;i++){
            if (i == length - 1 ){
                if (i == 0){
                    array = jsonObject.get(keys[i]).getAsJsonArray();
                }else {
                    array = json.get(keys[i]).getAsJsonArray();
                }
            }else {
                json = jsonObject.getAsJsonObject(keys[i]);
            }
        }
        String[] s = new String[array.size()];
        for (int j = 0;j<array.size();j++){
            s[j] = array.get(j).getAsString();
        }
        return s;
    }


}
