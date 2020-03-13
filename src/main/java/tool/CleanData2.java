package tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class CleanData2 {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/test.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/distance321.txt");
        FileWriter fileWriter = new FileWriter(resultFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            JSONObject jsonObject = JSON.parseObject(str);
            String orderId = jsonObject.getString("orderId");
            Integer orderDest2FinishDistance = jsonObject.getInteger("orderStrat2BegunDistance");
            bufferedWriter.write(orderId + ":" + orderDest2FinishDistance + "\r\n");
        }
    }
}
