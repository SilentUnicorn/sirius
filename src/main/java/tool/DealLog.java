package tool;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class DealLog {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/Desktop/擎天柱需求/totalFee问题数据处理/log7.log");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/Desktop/擎天柱需求/totalFee问题数据处理/deal_log/resultLog.log");
        FileWriter fileWriter = new FileWriter(resultFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            if (str.contains("人工确认") || str.contains("deal success")){
                bufferedWriter.write(str + "\r\n");
                bufferedWriter.flush();
            }
        }
    }
}
