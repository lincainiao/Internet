package com.lin.inet;
//文件上传服务端
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FileUploadServer {
    public static void main(String[] args) throws Exception{
        //创建端口
        ServerSocket serverSocket = new ServerSocket(4567);
        //接收，会一直等待客户端连接
        Socket socket = serverSocket.accept();
        //创建输入流，读取服务器接收的内容
        InputStream inputStream = socket.getInputStream();
        //文件输出
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\JAVAProgram\\IO\\TestFile","ab.txt")));
        int len;
        byte[] buf = new byte[1024];
        while ((len = inputStream.read(buf)) != -1) {
            bos.write(buf,0,len);
        }

        //通知客户端接收完毕
        OutputStream over = socket.getOutputStream();
        over.write("Done!".getBytes());

        bos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
