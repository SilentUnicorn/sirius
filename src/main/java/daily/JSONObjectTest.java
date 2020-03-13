package daily;

import com.alibaba.fastjson.JSONObject;

public class JSONObjectTest {

    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\"errno\":\"0\",\"errmsg\":\"SUCCESS\",\"dutyResult\":{\"passenger\":{\"id\":null,\"is_duty\":100000,\"duty_reason\":null,\"confidence_degree\":null},\"driver\":{\"id\":null,\"is_duty\":100001,\"duty_reason\":\"{\\\"zh-CN\\\":\\\"\\u5ba2\\u670dQA\\u6d4b\\u8bd5\\u7528\\\",\\\"en-US\\\":\\\" test for QA\\\"}\",\"confidence_degree\":null}}}");
        String string = jsonObject.getJSONObject("dutyResult").getString("driver");
        System.out.println(string);

        //JSONObject jsonObject1 = JSONObject.parseObject("{\"errno\":\"0\",\"errmsg\":\"SUCCESS\",\"dutyResult\":{\"passenger\":{\"id\":null,\"is_duty\":100000,\"duty_reason\":null,\"confidence_degree\":null},\"driver\":\"{\\\"id\\\":null,\\\"is_duty\\\":100001,\\\"duty_reason\\\":\\\"{\\\\\\\"zh-CN\\\\\\\":\\\\\\\"\\\\u5ba2\\\\u670dQA\\\\u6d4b\\\\u8bd5\\\\u7528\\\\\\\",\\\\\\\"en-US\\\\\\\":\\\\\\\" test for QA\\\\\\\"}\\\",\\\"confidence_degree\\\":null}\"}}");
        JSONObject jsonObject1 = JSONObject.parseObject("{\n" +
                "    \"errno\": \"0\",\n" +
                "    \"errmsg\": \"SUCCESS\",\n" +
                "    \"dutyResult\": {\n" +
                "        \"passenger\": \"{\\\"id\\\":null,\\\"is_duty\\\":100000,\\\"duty_reason\\\":null,\\\"confidence_degree\\\":null}\",\n" +
                "        \"driver\": \"{\\\"id\\\":null,\\\"is_duty\\\":100000,\\\"duty_reason\\\":null,\\\"confidence_degree\\\":null}\"\n" +
                "    }\n" +
                "}");
        String string1 = jsonObject1.getJSONObject("dutyResult").getString("driver");
        JSONObject jsonObject2 = jsonObject1.getJSONObject("dutyResult").getJSONObject("driver");

        System.out.println(string1);
        System.out.println(jsonObject2);
    }
}
