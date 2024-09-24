package com.itschool.library.utils.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class MainExecutionClass {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000_000;
        int[] arr = new int[number];

        for (int index = 0; index < number; index++) {
            arr[index] = index;
        }

        //single-thread
        long startTime = System.currentTimeMillis();
        AtomicLong singleThreadResult = new AtomicLong();
        new ThreadPractice(arr, 0, number, singleThreadResult).run();
        long endTime = System.currentTimeMillis();

        System.out.println("Single-thread result: " + singleThreadResult);
        System.out.println("Single-thread run: " + (endTime - startTime) + " ms");

        //multi-thread
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread count for local machine: " + threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = number / threadCount;
        long startTimeMultiThread = System.currentTimeMillis();
        AtomicLong multiThreadResult = new AtomicLong();
        for (int index = 0; index < threadCount; index++) {
            int start = index * partSize;
            int end = (index == threadCount - 1) ? number : start + partSize;
            executor.execute(new ThreadPractice(arr, start, end, multiThreadResult));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        long endTimeMultiThread = System.currentTimeMillis();
        System.out.println("Multi-thread result: " + multiThreadResult);
        System.out.println("Multi-thread run: " + (endTimeMultiThread - startTimeMultiThread) + " ms");
    }
}
