package com.mstatkiewicz.decertoRecruitment.controller;

import static org.hamcrest.Matchers.matchesRegex;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mstatkiewicz.decertoRecruitment.operation.JoinOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JoinController.class)
class JoinControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  JoinOperation joinOperation;

  @Test
  public void shouldReturnNumber() throws Exception {
    when(joinOperation.join(any(),any())).thenReturn(100);

    this.mockMvc.perform(get("/join")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(matchesRegex("^\\d*$")));
  }
}