package java8.in.action.lambda;


import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author zhangjingsi
 * @date 2018/8/3下午4:34
 */
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        System.out.println(ExecuteAround.processFile(bufferedReader -> bufferedReader.readLine()));
        System.out.println("-------------------------------------------------------------");
        System.out.println(ExecuteAround.processFile(bufferedReader -> bufferedReader.readLine() + bufferedReader.readLine()));
        System.out.println("-------------------------------------------------------------");
        System.out.println(ExecuteAround.processFile((bufferedReader -> {
            String file = "";
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())){
                file += line + "\n";
            }
            return file;
        })));
    }
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/macpro/GitHub/sirius/src/main/java/java8/in/action/lambda/Apple.java"))){
            return bufferedReaderProcessor.process(bufferedReader);
        }
    }
}

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader)throws IOException;
}

