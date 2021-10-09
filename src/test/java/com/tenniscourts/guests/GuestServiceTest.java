package com.tenniscourts.guests;

import static com.tenniscourts.guests.GuestUtils.mockCreateGuestDTO;
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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Samir Scheide
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {GuestService.class,GuestRepository.class})
public final class GuestServiceTest {

  @Mock
  private GuestRepository guestRepository;
  
  @Mock
  private GuestMapper guestMapper;
  
  @InjectMocks
  private GuestServiceImpl guestService;
  
  @Before
  public void setUp() {
    Mockito.when(guestRepository.save(any(Guest.class))).thenReturn(mockGuest());
    Mockito.when(guestRepository.findByNameContainingIgnoreCase("DummyTest")).thenReturn(mockGuestList());
    Mockito.when(guestRepository.findById(anyLong())).thenReturn(Optional.of(mockGuest()));
  }
  
  @Test
  public void createAndRetrieveGuestByNameTest() throws GuestNotFoundException {
    Mockito.when(guestService.create(mockCreateGuestDTO())).thenReturn(mockGuestDTO());
    Mockito.when(guestService.find("DummyTest")).thenReturn(mockGuestDTOList());
    GuestDTO expectedGuestDTO = guestService.create(mockCreateGuestDTO());
    assertTrue(guestService.find(expectedGuestDTO.getName()).stream().anyMatch(guest -> guest.getName().contains(expectedGuestDTO.getName())));
  } 

  @Test
  public void updatendRetrieveGuestByIdTest() throws GuestNotFoundException {
    Mockito.when(guestService.update(mockGuestUpdateDTO(), anyLong())).thenReturn(mockGuestDTO());
    Mockito.when(guestService.get(anyLong())).thenReturn(mockGuestDTO());
    GuestDTO expectedGuestDTO = guestService.update(mockGuestUpdateDTO(), anyLong());
    assertEquals(expectedGuestDTO.getId(), mockGuestDTO().getId());
    assertEquals(expectedGuestDTO.getName(), mockGuestDTO().getName());
  } 
  
}
