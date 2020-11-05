package com.mstatkiewicz.decertoRecruitment.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.mstatkiewicz.decertoRecruitment.operation.generator.H2Generator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneratorOperationTest {

  @InjectMocks
  GeneratorOperation generatorOperation;

  @Mock
  H2Generator h2Generator;

  @Test()
  void generateRandomWhenSourceInvalid() {

    String sourceName = "123Unknown";
    String expectedMessage = "Unexpected value: " + sourceName;

    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> generatorOperation.generateRandom(sourceName));

    assertEquals(expectedMessage, exception.getMessage());

  }

  @Test
  void generateRandomWhenSourceH2() {

    String sourceName = "H2";

    generatorOperation.generateRandom(sourceName);

    verify(h2Generator, times(1)).getRandomInteger();
  }
}