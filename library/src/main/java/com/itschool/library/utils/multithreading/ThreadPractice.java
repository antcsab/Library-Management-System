package com.itschool.library.utils.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadPractice implements Runnable {

    private final int[] arr;
    private final int start;
    private final int end;
    private final AtomicLong result;

    public ThreadPractice(int[] arr, int start, int end, AtomicLong result) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int index = start; index < end; index++) {
            sum += (long) arr[index] * arr[index];
        }
        result.addAndGet(sum);
    }
}
