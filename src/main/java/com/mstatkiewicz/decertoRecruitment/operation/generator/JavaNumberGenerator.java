package com.mstatkiewicz.decertoRecruitment.operation.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaNumberGenerator implements NumberGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(JavaNumberGenerator.class);
  public static final int MIN = 0;
  public static final int MAX = 100_000;


  /**
   * get random integer from Math library
   * @return random integer
   */
  @Override
  public Integer getRandomInteger() {

    Integer number = (int) ((MAX - MIN) * Math.random() + MIN);

    LOGGER.debug(String.valueOf(number));
    return number;
  }
}
