package com.mstatkiewicz.decertoRecruitment.operation.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.mstatkiewicz.decertoRecruitment.repository.H2Repository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class H2GeneratorTest {

  @InjectMocks
  H2Generator h2Generator;

  @Mock
  H2Repository h2Repository;

  @Test
  void h2GeneratorTest() {

    Mockito
        .when(h2Repository.getDbRandom())
        .thenReturn(0.4);

    Integer generatedInteger = h2Generator.getRandomInteger();

    assertEquals((int) (0.4*(H2Generator.MAX-H2Generator.MIN)+H2Generator.MIN), generatedInteger);

    verify(h2Repository,times(1)).getDbRandom();

  }
}