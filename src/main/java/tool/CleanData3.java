package tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 清洗数据
 */
public class CleanData3 {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/init.sql");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/init2.txt");
        FileWriter fileWriter = new FileWriter(resultFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            JSONObject jsonObject = JSON.parseObject(str);
            BigDecimal totalFee = jsonObject.getBigDecimal("totalFee");
            BigDecimal preTotalFee = jsonObject.getBigDecimal("preTotalFee");
            String orderId = jsonObject.getString("orderId");
            if (!StringUtils.isEmpty(orderId) && Objects.nonNull(totalFee) && Objects.nonNull(preTotalFee)){
                //bufferedWriter.write(orderId + ":" + totalFee + "," + preTotalFee +","+ (totalFee.subtract(preTotalFee)) + "\r\n");
                bufferedWriter.write(totalFee.subtract(preTotalFee) + "\r\n");
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
