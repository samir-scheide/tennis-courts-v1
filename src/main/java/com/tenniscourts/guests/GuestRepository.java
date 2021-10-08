package com.tenniscourts.guests;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samir Scheide
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

  /**
   * Find a guest by name. 
   * @param name the guest name.
   * @return a {@link Guest}
   */
  List<Guest> findByNameContainingIgnoreCase(String name);
  
}
