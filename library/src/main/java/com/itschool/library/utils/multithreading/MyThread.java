package com.itschool.library.utils.multithreading;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("My thread is running");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
