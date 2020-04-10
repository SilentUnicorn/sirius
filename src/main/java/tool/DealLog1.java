package tool;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class DealLog1 {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/Desktop/擎天柱需求/totalFee问题数据处理/deal_log/alldata.txt");
        BufferedReader bufferedReader = new BufferedReader(f);

        File resultFile = new File("/Users/didi/Desktop/擎天柱需求/totalFee问题数据处理/deal_log/lose.txt");
        FileWriter fileWriter = new FileWriter(resultFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            FileReader f2 = new FileReader("/Users/didi/Desktop/擎天柱需求/totalFee问题数据处理/deal_log/resultLog.log");
            BufferedReader bufferedReader2 = new BufferedReader(f2);
            String str2;
            boolean flag = false;
            while(!StringUtils.isEmpty(str2=bufferedReader2.readLine()) && !flag){
                if (str2.contains(str)){
                    flag = true;
                }
            }
            if (!flag){
                bufferedWriter.write(str + "\r\n");
                bufferedWriter.flush();
            }
            bufferedReader2.close();
            f2.close();
        }
    }
}
