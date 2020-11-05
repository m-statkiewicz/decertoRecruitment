package com.mstatkiewicz.decertoRecruitment.operation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JoinOperationTest {

  @InjectMocks
  JoinOperation joinOperation;

  @Mock
  GeneratorOperation generatorOperation;

  @Test
  void joinTestFromDifferentSources() {

    String firstSourceName = "H2";
    String secondSourceName = "JAVA";

    joinOperation.join(firstSourceName, secondSourceName);

    verify(generatorOperation, times(1)).generateRandom(firstSourceName);
    verify(generatorOperation, times(1)).generateRandom(secondSourceName);
  }

  @Test
  void joinTestFromOneSource() {

    String sourceName = "H2";

    joinOperation.join(sourceName, sourceName);

    verify(generatorOperation, times(2)).generateRandom(sourceName);
  }
}