package tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class CleanTicketData1 {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/Desktop/fail/failAll.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/Desktop/fail/f1.txt");
        FileWriter fileWriter = new FileWriter(resultFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            String str1 = str.substring(str.indexOf("request=")+8, str.indexOf(", e={}"));
            JSONObject jsonObject = JSON.parseObject(str1);
            String canonicalCountryCode = jsonObject.getString("flowKey");
            bufferedWriter.write(canonicalCountryCode + "\r\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
