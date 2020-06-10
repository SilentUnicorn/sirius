package tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class CleanTicketData {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/Desktop/fail/fail4.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/Desktop/fail/t1.txt");
        FileWriter fileWriter = new FileWriter(resultFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            String str1 = str.substring(str.indexOf("request=")+8, str.indexOf(", e={}"));
            JSONObject jsonObject = JSON.parseObject(str1);
            Long ticketId = jsonObject.getLong("ticketId");
            Long orderId = jsonObject.getLong("orderId");
            if (orderId == 0){
                bufferedWriter.write(ticketId + "\r\n");
            }else{
                System.out.println(str);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
