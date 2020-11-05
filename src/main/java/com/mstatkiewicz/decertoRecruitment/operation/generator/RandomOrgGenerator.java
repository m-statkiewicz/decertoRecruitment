package com.mstatkiewicz.decertoRecruitment.operation.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RandomOrgGenerator implements NumberGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(RandomOrgGenerator.class);

  public static final int MIN = 1;
  public static final int MAX = 100_000;

  /**
   * get random integer from RandomOrg API
   * @return random integer
   */
  @Override
  public Integer getRandomInteger() {

    String url = "https://www.random.org/integers/?num=1&col=1&base=10&format=plain&rnd=new"
        +"&min="+MIN+""
        +"&max="+MAX;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    Integer number = Integer.valueOf(response.getBody().replace("\n",""));
    LOGGER.debug(String.valueOf(number));

    return number;
  }
}
