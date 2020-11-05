package com.mstatkiewicz.decertoRecruitment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2Repository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * gets random value from h2 database
   * @return random value
   */
  public Double getDbRandom(){

    String sql = "select rand()";

    return jdbcTemplate.queryForObject(sql, Double.class);
  }

}
