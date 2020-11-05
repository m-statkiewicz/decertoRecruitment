package com.mstatkiewicz.decertoRecruitment.operation.generator;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JavaNumberGeneratorTest {

  JavaNumberGenerator javaNumberGenerator = new JavaNumberGenerator();

  @Test
  void javaNumberGeneratorTest(){

    List<Integer> generatedList = new ArrayList<>();
    generatedList.add(javaNumberGenerator.getRandomInteger());
    generatedList.add(javaNumberGenerator.getRandomInteger());

    assertNotEquals(generatedList.get(0),generatedList.get(1));
    for(Integer gen:generatedList) {
      assertTrue(gen <= JavaNumberGenerator.MAX);
      assertTrue(gen >= JavaNumberGenerator.MIN);
    }
  }
}