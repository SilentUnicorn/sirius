package jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjingsi
 * @date 2018/4/23下午5:43
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 */
public class JvaMethodAreaOom {
    public static void main(String[] args) {
        URL url;
        List<ClassLoader> classLoaderList = new ArrayList<>();
        int count = 0;
        try {
            url = new File("/Users/macpro/Downloads/mail.py").toURI().toURL();
            URL[] urls = {url};
            while (true){
                count++;
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("jvm.JvaMethodAreaOom");
            }
        } catch (Exception e) {
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
