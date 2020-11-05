package com.mstatkiewicz.decertoRecruitment.operation;

import com.mstatkiewicz.decertoRecruitment.operation.generator.Generator;
import com.mstatkiewicz.decertoRecruitment.operation.generator.H2Generator;
import com.mstatkiewicz.decertoRecruitment.operation.generator.JavaNumberGenerator;
import com.mstatkiewicz.decertoRecruitment.operation.generator.NumberGenerator;
import com.mstatkiewicz.decertoRecruitment.operation.generator.RandomOrgGenerator;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorOperation {

  private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorOperation.class);

  @Autowired
  H2Generator h2Generator;

  /**
   * generates random number based on provided source name
   * @param sourceName name of source of random value
   * @return random value
   */
  public Integer generateRandom(String sourceName) {
    
    NumberGenerator numberGenerator = parse(sourceName);

    Integer number = numberGenerator.getRandomInteger();

    LOGGER.debug(String.valueOf(number));
    return number;
  }

  /**
   * parse source name and return matching number generator
   * @param sourceName source name
   * @return matching number generator
   */
  private NumberGenerator parse(String sourceName) {

    if(Arrays.stream(Generator.values()).noneMatch(e -> e.name().equals(sourceName.toUpperCase()))){
      throw new IllegalArgumentException("Unexpected value: "+sourceName);
    }

    Generator generator = Generator.valueOf(sourceName.toUpperCase());
    NumberGenerator numberGenerator;
    switch (generator){
      case H2:
        numberGenerator = h2Generator;
        break;
      case JAVA:
        numberGenerator = new JavaNumberGenerator();
        break;
      case RANDOMORG:
        numberGenerator = new RandomOrgGenerator();
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + generator);
    }
    
    return numberGenerator;
  }

}
