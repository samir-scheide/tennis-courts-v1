package com.tenniscourts.guests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Samir Scheide
 */
@RunWith(SpringRunner.class)
public final class GuestServiceTest {

  @Autowired
  private GuestService guestService;

  @MockBean
  private GuestRepository guestRepository;
  
  private List<Guest> actualGuestsList = new ArrayList<Guest>();
  
  private Guest actualGuest = new Guest();
  
  @Before
  public void setUp() {
    actualGuest.setName("Samir Scheide");
    actualGuestsList.add(actualGuest);
    Mockito.when(guestRepository.findByNameContainingIgnoreCase(actualGuest.getName())).thenReturn(actualGuestsList);
  }
  
  public void createTest() {} 

  public void listTest() {} 
  
  public void findTest() {} 
  
  public void updateTest() {} 
  
  public void deleteTest() {} 
  
}
