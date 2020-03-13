package http;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.*;

public class HttpServer {
    private static final Integer PORT = 1234;
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("server start...");
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            singleThreadPool.execute(() -> {
                OutputStream outputStream;
                InputStream inputStream;
                try {
                    inputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String s = bufferedReader.readLine();
                    String[] s1 = s.split(" ");
                    if (!(s1.length > 1 && s1[1].endsWith("json"))){
                        return;
                    }
                    /*byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    String request = new String(buffer);
                    if (StringUtils.isEmpty(request)){
                        return;
                    }
                    System.out.println("request:\n" + request);*/

                    //将响应头发送给客户端
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("HTTP/1.1 200 OK\r\n");
                    stringBuilder.append("Content-Type:" + "application/json" +"\r\n");
                    stringBuilder.append("\r\n");
                    stringBuilder.append("{\"msg\":\"hello world\"}");

                    outputStream = socket.getOutputStream();
                    outputStream.write(stringBuilder.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("return");
        }
    }
}
