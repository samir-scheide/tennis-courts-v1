package com.tenniscourts.guests;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class GuestUtils {

  public static GuestUpdateDTO mockGuestUpdateDTO() {
    return GuestUpdateDTO.builder().name("DummyTest").build();
  }
  
  public static GuestCreateDTO mockGuestCreateDTO() {
    return GuestCreateDTO.builder().name("DummyTest").build();
  }
  
  public static GuestDTO mockGuestDTO() {
    return GuestDTO.builder().id(1L).name("DummyTest").build();
  }
  
  public static Guest mockGuest() {
    Guest guest = new Guest("DummyTest");
    guest.setId(1L);
    return guest;
  }

  public static List<Guest> mockGuestList() {
    List<Guest> list = new ArrayList<>();
    list.add(mockGuest());
    return list;
  }
  
  public static List<GuestDTO> mockGuestDTOList() {
    List<GuestDTO> list = new ArrayList<>();
    list.add(mockGuestDTO());
    return list;
  }
  
  public static <T> String toJSONString(T value) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(value);
  }
  
}
