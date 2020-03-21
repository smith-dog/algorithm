package com.smith.algorithm.service.impl;

import java.util.concurrent.CountDownLatch;

public class SystemApiPerfTest {

  public static void main(String[] args) throws InterruptedException {
    final int count = 10000;

    long elapsedTime = serialCurrentTime(count);
    System.out.format("[%s] thread serial test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime, elapsedTime / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime2 = serialCurrentTime(count);
    System.out.format("[%s] thread serial test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime2, elapsedTime2 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime4 = serialCurrentTime(count);
    System.out.format("[%s] thread serial test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime4, elapsedTime4 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime5 = serialCurrentTime(count);
    System.out.format("[%s] thread serial test <CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime5, elapsedTime5 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime3 = serialCurrentTimeByTimeUtil(count);
    System.out.format("[%s] thread serial test <TimeUtil-CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime3,
        elapsedTime3 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime6 = serialCurrentTimeByTimeUtil(count);
    System.out.format("[%s] thread serial test <TimeUtil-CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime6,
        elapsedTime6 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    long elapsedTime7 = serialCurrentTimeByTimeUtil(count);
    System.out.format("[%s] thread serial test <TimeUtil-CurrentTime> cost total time [%s]ns, average time [%s]ns.\n", count, elapsedTime7,
        elapsedTime7 / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    /**并发*/
    long interval = concurrentTest(count, System::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    /**并发*/
    interval = concurrentTest(count, System::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    /**并发*/
    interval = concurrentTest(count, System::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    /**并发*/
    interval = concurrentTest(count, TimeUtil::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <TimeUtil-currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

    /**并发*/
    interval = concurrentTest(count, TimeUtil::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <TimeUtil-currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
    /**并发*/
    interval = concurrentTest(count, TimeUtil::currentTimeMillis);
    System.out.format("[%s] thread concurrent test <TimeUtil-currentTimeMillis> cost total time [%s]ns, average time [%s]ns.\n", count, interval, interval / count);
    System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");

  }

  private static long concurrentTest(int threads, final Runnable r) throws InterruptedException {
    final CountDownLatch start = new CountDownLatch(1);
    final CountDownLatch end = new CountDownLatch(threads);

    for (int i = 0; i < threads; i++) {
      new Thread(() -> {
        try {
          start.await();
          try {
            r.run();
          } finally {
            end.countDown();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }

    long stime = System.nanoTime();
    start.countDown();
    end.await();
    return System.nanoTime() - stime;
  }

  private static long serialNanoTime(int count) {
    long startTime = System.nanoTime();
    for (int i = 0; i < count; i++) {
      System.nanoTime();
    }
    return System.nanoTime() - startTime;
  }

  private static long serialCurrentTime(int count) {
    long startTime = System.nanoTime();
    for (int i = 0; i < count; i++) {
      System.currentTimeMillis();
    }
    return System.nanoTime() - startTime;
  }

  private static long serialCurrentTimeByTimeUtil(int count) {
    long startTime = System.nanoTime();
    for (int i = 0; i < count; i++) {
      TimeUtil.currentTimeMillis();
    }
    return System.nanoTime() - startTime;
  }
}