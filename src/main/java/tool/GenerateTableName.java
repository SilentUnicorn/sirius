package tool;

import org.springframework.util.StringUtils;

import java.io.*;

public class GenerateTableName {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/didi/Desktop/擎天柱需求/分表/o_flow_instance_all_0.sql");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("/Users/didi/Desktop/擎天柱需求/分表/o_flow_instance_all_1.sql");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String content;
        int i = 0;
        while (!StringUtils.isEmpty(content=bufferedReader.readLine())){
            if (content.contains("o_flow_instance_")){
                content = content.replace("o_flow_instance_","o_flow_instance_"+i++);
            }
            bufferedWriter.write(content+"\n");
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
