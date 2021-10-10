package com.tenniscourts.guests;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Samir Scheide
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class GuestRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private GuestRepository guestRepository;
  
  private Guest actualGuest = new Guest();
  
  @Before
  public void setUp() {
    actualGuest.setName("Samir Scheide");
    entityManager.persistAndFlush(actualGuest);
  }
  
  @Test
  public void findByNameContainingIgnoreCaseTest() {
    List<Guest> expectedGuestsList = guestRepository.findByNameContainingIgnoreCase(actualGuest.getName());
    assertTrue(expectedGuestsList.stream().anyMatch(guest -> actualGuest.getName().contains(guest.getName())));
  }
  
  @Test
  public void peristAndListAllGuestsTest() {
    Guest expectedGuest = guestRepository.save(new Guest("Suami Scheide"));
    List<Guest> expectedGuestsList = guestRepository.findAll();
    assertTrue(expectedGuestsList.size() > 0 && expectedGuestsList.stream().anyMatch(guest -> expectedGuest.getName().contains(guest.getName())));
  }
  
  @Test
  public void findByIdUpdateAndRetrieveByNameTest() {
    Optional<Guest> expectedGuest = guestRepository.findById(actualGuest.getId());
    expectedGuest.ifPresent(guest -> {
      guest.setName("Samiroquai");
      guestRepository.saveAndFlush(guest);
    });
    List<Guest> expectedGuestsList = guestRepository.findByNameContainingIgnoreCase(actualGuest.getName());
    assertTrue(expectedGuestsList.stream().anyMatch(guest -> actualGuest.getName().contains(guest.getName()) && actualGuest.getId() == guest.getId()));
  }
  
  @Test
  public void deleteById() {
    guestRepository.delete(actualGuest);
    Optional<Guest> expectedGuests = guestRepository.findById(actualGuest.getId());
    assertTrue(!expectedGuests.isPresent());
  }
  
}
