package com.mstatkiewicz.decertoRecruitment.operation.joiner;


public interface Joiner<T> {

  /**
   * Join definition
   * @param t1 value to join
   * @param t2 value to join
   * @return joined value
   */
  T join(T t1, T t2);
}
