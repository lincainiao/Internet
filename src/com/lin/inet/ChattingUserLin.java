package com.lin.inet;

public class ChattingUserLin {
    public static void main(String[] args) {
        //开启两个线程
        //Lin的端口地址：5555，目的端口地址：8888
        new Thread(new ChattingSend(5555,"localhost",8888)).start();
        new Thread(new ChattingReceive(7777)).start();
    }
}
