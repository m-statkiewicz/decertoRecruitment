package com.mstatkiewicz.decertoRecruitment.operation.generator;

import com.mstatkiewicz.decertoRecruitment.repository.H2Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class H2Generator implements NumberGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(H2Generator.class);
  public static final int MIN = 1;
  public static final int MAX = 100_000;

  @Autowired
  H2Repository h2Repository;


  /**
   * get random integer from H2 DB
   * @return random integer
   */
  @Override
  public Integer getRandomInteger() {
    Integer number = (int) ((MAX - MIN) * h2Repository.getDbRandom() + MIN);

    LOGGER.debug(String.valueOf(number));
    return number;
  }
}
