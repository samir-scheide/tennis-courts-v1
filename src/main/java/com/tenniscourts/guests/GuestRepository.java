package com.tenniscourts.guests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository class to retrieve, update and create guests.
 * @author Samir Scheide
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

  /**
   * Find a guest by name. 
   * @param name the guest name.
   * @return a {@link Guest}
   */
  @Query("select g from Guest g where g.name LIKE %?1")
  Guest findByName(String name);
  
}
