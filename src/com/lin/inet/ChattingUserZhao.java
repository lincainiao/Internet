package com.lin.inet;

public class ChattingUserZhao {
    public static void main(String[] args) {
        new Thread(new ChattingSend(6666,"localhost",7777)).start();
        new Thread(new ChattingReceive(8888)).start();
    }
}
