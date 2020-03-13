package tool;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 统计数据
 */
public class StatisticsData1 {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/didi/init2.txt");
        BufferedReader bufferedReader = new BufferedReader(f);
        String str;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        while (!StringUtils.isEmpty(str=bufferedReader.readLine())){
            Double d = Double.valueOf(str);
            if (d>0){
                count1++;
            }else if(d==0){
                count2++;
            }else{
                count3++;
            }
        }
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}
