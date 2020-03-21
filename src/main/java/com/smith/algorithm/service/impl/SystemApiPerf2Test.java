package com.smith.algorithm.service.impl;


public class SystemApiPerf2Test {

    public static void main(String[] args) {
        final int count = 1000;
        long elapsedTime = serialCurrentTime(count);
        System.out.format("[%s] thread concurrent test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime, elapsedTime/count);

       /* CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    startLatch.await();
                    System.currentTimeMillis();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown();
                }
            }).start();
        }
        long beginTime = System.nanoTime();
        startLatch.countDown();
        endLatch.await();
        elapsedTime =System.nanoTime() - beginTime;
        System.out.format("[%s] thread concurrent test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime, elapsedTime/count);*/

        //System.out.println("100 System.currentTimeMillis() parallel calls: " +elapsedTime + " ns" + ", average time:" + elapsedTime/count);
    }

    private static long serialCurrentTime(int count){
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            System.currentTimeMillis();
        }
        return System.nanoTime() - startTime;
    }
}