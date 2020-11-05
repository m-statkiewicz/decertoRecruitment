package com.mstatkiewicz.decertoRecruitment.controller;

import com.mstatkiewicz.decertoRecruitment.operation.JoinOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/join")
public class JoinController {

  @Autowired
  JoinOperation joinOperation;

  /**
   * @param firstSourceName source name for first value to join
   * @param secondSourceName source name for second value to join
   * @return ResponseEntity with joined values
   */
  @GetMapping("")
  public ResponseEntity join (
      @RequestParam(value="firstSource", defaultValue = "java") String firstSourceName,
      @RequestParam(value="secondSource", defaultValue = "randomorg") String secondSourceName) {

      return new ResponseEntity(joinOperation.join(firstSourceName,secondSourceName), HttpStatus.OK);
  }
}
