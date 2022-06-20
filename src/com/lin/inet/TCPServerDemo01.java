package com.lin.inet;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端，自身要有端口地址
public class TCPServerDemo01 {
    public static void main(String[] args) throws Exception{
        //服务端，自身要有端口地址
        ServerSocket serverSocket = new ServerSocket(9999);//localhost:9999
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        boolean flag = true;
        while (flag){
            //等待客户连接过来
            socket = serverSocket.accept();
            //读取客户端数据
            inputStream = socket.getInputStream();
            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) != -1){
                baos.write(buf,0,len);
            }
            System.out.println(baos.toString());
        }

        if (baos != null) {
            baos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (socket != null) {
            socket.close();
        }
        if (serverSocket != null){
            serverSocket.close();
        }
    }
}
