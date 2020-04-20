package com.smith.algorithm.service;

import com.smith.algorithm.AlgorithmApplication;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgorithmApplication.class)
class AbstractSortTest {

  @Resource
  List<AbstractSort> abstractSortList;


  ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

  @Test
  void sort() {
    Integer[] arr = generateArrays(Integer.class, 100000L, 1L, 200000L, false);
    abstractSortList.forEach(abstractSort -> accept(abstractSort, arr));
    /*Long[]  longArr = generateArrays(Long.class, 20000L, 5000L, 100000L, false);
    abstractSortList.forEach(abstractSort -> accept(abstractSort, longArr));*/
  }

  private static <T extends Comparable<T>> void accept(AbstractSort abstractSort, T[] a) {
    long start = System.currentTimeMillis();
    abstractSort.sort(a);
    log.info("SortName({}):time({}ms):", abstractSort.getClass().getSimpleName(), System.currentTimeMillis() - start);
    checkSort(a);
  }


  /**
   * @param <T>
   * @param count
   * @param min
   * @param max
   * @return
   */
  private <T extends Comparable<T>> T[] generateArrays(Class<T> cls, Long count, Long min, Long max, boolean isSort) {

    if (Long.class.equals(cls)) {
      if (isSort) {
        return (T[]) threadLocalRandom.longs(count, min, max).boxed().sorted().toArray(Long[]::new);
      } else {
        return (T[]) threadLocalRandom.longs(count, min, max).boxed().toArray(Long[]::new);
      }
    } else if (Double.class.equals(cls)) {
      if (isSort) {
        return (T[]) threadLocalRandom.doubles(count, min, max).boxed().sorted().toArray(Double[]::new);
      } else {
        return (T[]) threadLocalRandom.doubles(count, min, max).boxed().toArray(Double[]::new);
      }
    } else {
      if (isSort) {
        return (T[]) threadLocalRandom.ints(count, min.intValue(), max.intValue()).boxed().sorted().toArray(Integer[]::new);
      } else {
        return (T[]) threadLocalRandom.ints(count, min.intValue(), max.intValue()).boxed().toArray(Integer[]::new);
      }
    }
  }

  private static <T extends Comparable<T>> void checkSort(T[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      Assert.assertTrue(a[i].compareTo(a[i + 1]) <= 0);
    }
  }
}