package com.mstatkiewicz.decertoRecruitment.operation.joiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumJoinerTest {

  SumJoiner sumJoiner = new SumJoiner();

  @Test
  void sumJoinerTest(){
    Integer i1 = 12;
    Integer i2 = 34;
    Integer expectedResult = i1+i2;

    assertEquals(expectedResult, sumJoiner.join(i1,i2));
  }

}