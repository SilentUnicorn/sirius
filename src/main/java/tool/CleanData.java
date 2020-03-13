package tool;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 清洗数据
 */
public class CleanData {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/test2.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        File resultFile = new File("/Users/didi/distance.txt");
        FileWriter fileWriter = new FileWriter(resultFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            if (str.startsWith("\"orderDest2FinishDistance\":")){
                bufferedWriter.write(str + "\r\n");
                bufferedWriter.flush();
            }
        }
    }
}
