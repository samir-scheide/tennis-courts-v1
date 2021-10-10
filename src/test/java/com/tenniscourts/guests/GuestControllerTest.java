package com.tenniscourts.guests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Mock
  GuestServiceImpl guestService;
  
  @Before
  public void setup() {
      MockitoAnnotations.initMocks(this);
      final GuestController guestController = new GuestController(guestService);
      mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
  }

  @Test
  public void createGuestSuccess() throws Exception {
    Mockito.when(guestService.create(ArgumentMatchers.any(GuestCreateDTO.class))).thenReturn(GuestUtils.mockGuestDTO());
    mockMvc.perform(post("/v2/api/guest").content(GuestUtils.toJSONString(GuestUtils.mockGuestCreateDTO())).contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").value(GuestUtils.mockGuestDTO().getId()))
      .andExpect(jsonPath("$.name").value(GuestUtils.mockGuestDTO().getName()))
      .andDo(print());
  }
  
  @Test
  public void noGuestsFoundEmptyList() throws Exception {
    Mockito.when(guestService.list()).thenReturn(new ArrayList<GuestDTO>());
    mockMvc.perform(get("/v2/api/guest")).andExpect(status().isNoContent()).andDo(print());
  }
  
  @Test
  public void guestsFoundByName() throws Exception {
    List<GuestDTO> list = new ArrayList<>();
    list.add(GuestUtils.mockGuestDTO());
    Mockito.when(guestService.find(GuestUtils.mockGuestDTO().getName())).thenReturn(list);
    mockMvc.perform(get("/v2/api/guest").param("name", GuestUtils.mockGuestDTO().getName()))
      .andExpect(status().isOk())
      .andExpect(content().json(new ObjectMapper().writeValueAsString(list)))
      .andDo(print());
  }
  
  @Test
  public void guestsFoundById() throws Exception {
    Mockito.when(guestService.get(GuestUtils.mockGuestDTO().getId())).thenReturn(GuestUtils.mockGuestDTO());
    mockMvc.perform(get("/v2/api/guest/" + GuestUtils.mockGuestDTO().getId()))
      .andExpect(status().isOk())
      .andExpect(content().json(GuestUtils.toJSONString(GuestUtils.mockGuestDTO())))
      .andDo(print());
  }
  
}
