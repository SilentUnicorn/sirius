package think.in.java;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjingsi
 * @date 2019/3/27上午10:57
 */
@Slf4j
public class HttpServer {

    private final static String HEADER_START = "HTTP/1.1 200 OK";
    private final static String HEADER_END = "\r\n\r\n";
    private final static String CONTENT_TYPE_JSON = "Content-Type: Application/json";
    private final static String CONTENT_LENGTH = "Content-Length:";
    private final static String CONTENT_TYPE_IMAGE = "Content-Type: image/jpeg";
    private final static String CONTENT_TYPE_ZIP = "Content-Type: application/zip";


    private static ExecutorService executorService = new ThreadPoolExecutor(10,20,0, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            log.error("create ServerSocket error", e);
        }

        while(true){
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(() -> dealRequest(socket));
            } catch (IOException e) {
                log.error("accept socket error", e);
            }
        }

    }

    private static void dealRequest(Socket socket){
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine();
            String[] request = line.split(" ");
            if (request.length >= 3){
                String method = request[0];
                String uri = request[1];
                String protocol = request[2];
                log.info("method:" + method);
                log.info("uri:" + uri);
                log.info("protocol:" + protocol);
                if (uri.endsWith("jpeg")){
                    showImg(socket, uri);
                }else if (uri.endsWith("zip")){
                    download(socket, uri);
                }else{
                    sayHello(socket);
                }
            }
        } catch (IOException e) {
            log.error("getInputStream error", e);
        }
    }

    private static void sayHello(Socket socket){
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(HEADER_START.getBytes());
            outputStream.write(CONTENT_TYPE_JSON.getBytes());
            outputStream.write(HEADER_END.getBytes());
            outputStream.write("hello wold".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showImg(Socket socket, String uri){
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        File file = new File("/Users/macpro/Desktop" + uri);
        if (!file.exists()){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(HEADER_START.getBytes());
            outputStream.write(CONTENT_TYPE_IMAGE.getBytes());
            outputStream.write(CONTENT_LENGTH.getBytes());
            outputStream.write(Long.valueOf(file.length()).byteValue());
            outputStream.write(HEADER_END.getBytes());

            /**10k缓冲*/
            byte[] buf = new byte[1024*10];
            while(fileInputStream.read(buf) != -1){
                outputStream.write(buf);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                fileInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void download(Socket socket, String uri){
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        File file = new File("/Users/macpro/Desktop" + uri);
        if (!file.exists()){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStream = socket.getOutputStream();
            outputStream.write(HEADER_START.getBytes());
            outputStream.write(CONTENT_TYPE_ZIP.getBytes());
            outputStream.write(CONTENT_LENGTH.getBytes());
            outputStream.write(Long.valueOf(file.length()).byteValue());
            outputStream.write(HEADER_END.getBytes());
            /**10k缓冲*/
            byte[] buf = new byte[1024*10];
            while(fileInputStream.read(buf) != -1){
                outputStream.write(buf);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                fileInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void notFound(Socket socket){

    }
}
