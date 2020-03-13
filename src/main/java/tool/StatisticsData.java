package tool;

import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 统计数据
 */
public class StatisticsData {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/distance.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        String str;
        int count200 = 0;
        int count200To500 = 0;
        int count500 = 0;
        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            String[] split = str.split(":");
            if (split.length > 1){
                if (Integer.valueOf(split[1]) < 200){
                    count200++;
                }else if (Integer.valueOf(split[1]) >= 200 && Integer.valueOf(split[1]) < 500){
                    count200To500++;
                }else{
                    count500++;
                }
            }
        }
        System.out.println("< 200:" + count200);
        System.out.println(">= 200 && < 500:" + count200To500);
        System.out.println("> 500:" + count500);
        System.out.println("总数:" + (count200+count200To500+count500));
    }
}
