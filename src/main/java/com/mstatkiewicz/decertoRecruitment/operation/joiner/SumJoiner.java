package com.mstatkiewicz.decertoRecruitment.operation.joiner;

public class SumJoiner implements Joiner<Integer> {

  /**
   * Join, that implements sum operation
   * @param t1 value to join
   * @param t2 value to join
   * @return joined value
   */
  @Override
  public Integer join(Integer t1, Integer t2) {
    return t1+t2;
  }
}
