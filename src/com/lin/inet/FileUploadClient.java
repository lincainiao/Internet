package com.lin.inet;
//文件上传客户端
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) throws Exception{
        //连接服务器IP地址
        InetAddress serIPAddress = InetAddress.getByName("localhost");
        //服务器端口
        int port = 4567;
        //连接服务器
        Socket socket = new Socket(serIPAddress,port);
        //创建输入流，读取文件
        BufferedInputStream bip = new BufferedInputStream(new FileInputStream(new File("D:\\JAVAProgram\\IO\\TestFile","a.txt")));
        //创建输出流，输出到服务器
        OutputStream outputStream = socket.getOutputStream();
        int len;
        byte[] buf = new byte[1024];
        while ((len = bip.read(buf)) != -1) {
            outputStream.write(buf,0,len);
        }
        //通知服务器传输完
        socket.shutdownOutput();

        //确定服务端接收完毕才能断开连接
        InputStream isOver = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lenOver;
        byte[] bufOver = new byte[1024];
        while ((lenOver = isOver.read(bufOver)) != -1) {
            baos.write(bufOver,0,lenOver);
        }
        System.out.println(baos.toString());

        outputStream.close();
        bip.close();
        isOver.close();
        baos.close();
        socket.close();
    }
}
