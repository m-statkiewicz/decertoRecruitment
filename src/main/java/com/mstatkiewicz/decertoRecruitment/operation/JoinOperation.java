package com.mstatkiewicz.decertoRecruitment.operation;

import com.mstatkiewicz.decertoRecruitment.operation.joiner.Joiner;
import com.mstatkiewicz.decertoRecruitment.operation.joiner.SumJoiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinOperation {

  private static final Logger LOGGER = LoggerFactory.getLogger(JoinOperation.class);

  @Autowired
  GeneratorOperation generatorOperation;

  private final Joiner<Integer> joiner = new SumJoiner();

  /**
   * joins values from provided sources
   * @param firstSourceName source name for first value to join
   * @param secondSourceName source name for second value to join
   * @return joined value
   */
  public Integer join(String firstSourceName, String secondSourceName) {

    Integer number = joiner.join(generatorOperation.generateRandom(firstSourceName),generatorOperation.generateRandom(secondSourceName));

    LOGGER.debug(String.valueOf(number));
    return number;
  }
}
