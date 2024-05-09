package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MyPub pub = new MyPub(); // 신문사 생성
        MySub sub = new MySub(); // 구독자 생성

        pub.subscribe(sub);
    }
}