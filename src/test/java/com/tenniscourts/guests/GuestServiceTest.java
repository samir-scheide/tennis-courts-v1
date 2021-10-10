package com.tenniscourts.guests;

import static com.tenniscourts.guests.GuestUtils.mockGuestCreateDTO;
import static com.tenniscourts.guests.GuestUtils.mockGuest;
import static com.tenniscourts.guests.GuestUtils.mockGuestDTO;
import static com.tenniscourts.guests.GuestUtils.mockGuestDTOList;
import static com.tenniscourts.guests.GuestUtils.mockGuestList;
import static com.tenniscourts.guests.GuestUtils.mockGuestUpdateDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author Samir Scheide
 */
@RunWith(MockitoJUnitRunner.class)
public final class GuestServiceTest {

  @Mock
  private GuestRepository guestRepository;
  
  @Mock
  private GuestMapper guestMapper;
  
  @InjectMocks
  private GuestServiceImpl guestServiceImpl;
  
  @Before
  public void setUp() {
    Mockito.when(guestRepository.save(any(Guest.class))).thenReturn(mockGuest());
    Mockito.when(guestRepository.findByNameContainingIgnoreCase("DummyTest")).thenReturn(mockGuestList());
    Mockito.when(guestRepository.findById(anyLong())).thenReturn(Optional.of(mockGuest()));
  }
  
  @Test
  public void createAndRetrieveGuestByNameTest() throws GuestNotFoundException {
    Mockito.when(guestServiceImpl.create(mockGuestCreateDTO())).thenReturn(mockGuestDTO());
    Mockito.when(guestServiceImpl.find("DummyTest")).thenReturn(mockGuestDTOList());
    GuestDTO expectedGuestDTO = guestServiceImpl.create(mockGuestCreateDTO());
    assertTrue(guestServiceImpl.find(expectedGuestDTO.getName()).stream().anyMatch(guest -> guest.getName().contains(expectedGuestDTO.getName())));
  } 

  @Test
  public void updatendRetrieveGuestByIdTest() throws GuestNotFoundException {
    Mockito.when(guestServiceImpl.update(mockGuestUpdateDTO(), anyLong())).thenReturn(mockGuestDTO());
    Mockito.when(guestServiceImpl.get(anyLong())).thenReturn(mockGuestDTO());
    GuestDTO expectedGuestDTO = guestServiceImpl.update(mockGuestUpdateDTO(), anyLong());
    assertEquals(expectedGuestDTO.getId(), mockGuestDTO().getId());
    assertEquals(expectedGuestDTO.getName(), mockGuestDTO().getName());
  } 
  
}
