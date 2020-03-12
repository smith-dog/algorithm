package com.smith.algorithm.service;

import static org.junit.jupiter.api.Assertions.*;

import com.smith.algorithm.AlgorithmApplication;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgorithmApplication.class)
class AbstractSortTest {

  @Resource
  List<AbstractSort> abstractSortList;

  @Test
  void sort() {
    abstractSortList.forEach(abstractSort -> {
      log.info("current sort : {}" , abstractSort.getClass().getName());

    });
  }
}