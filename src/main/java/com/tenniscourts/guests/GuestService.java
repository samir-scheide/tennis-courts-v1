package com.tenniscourts.guests;

import java.util.List;

/**
 * @author Samir Scheide
 */
public interface GuestService {

  /**
   * Register a guest.
   * @param guest a {@link GuestCreateDTO} instance.
   * @return a {@link GuestDTO} instance.
   */
  GuestDTO create(GuestCreateDTO guest);

  /**
   * Retrieve all guets.
   * @return a {@link List} containing all guests {@link Guest} as {@link GuestDTO}.
   */
  List<GuestDTO> list();

  /**
   * Retrieve a guest by its unique identifier.
   * @param id the {@link Guest} unique identifier.
   * @return a {@link GuestDTO} instance with the {@link Guest} found.
   * @throws GuestNotFoundException if no guest is found.
   */
  GuestDTO get(Long id) throws GuestNotFoundException;

  /**
   * Find a guest by its name.
   * @param name the {@link Guest} name.
   * @return a list of {@link GuestDTO} instance with the guests {@link Guest} found.
   * @throws GuestNotFoundException if no guest is found.
   */
  List<GuestDTO> find(String name) throws GuestNotFoundException;

  /**
   * Update a guest.
   * @param guest the {@link GuestUpdateDTO}.
   * @param id guest unique identifier.
   * @return a {@link GuestDTO} instance with the {@link Guest} updated.
   * @throws GuestNotFoundException if no guest is found.
   */
  GuestDTO update(GuestUpdateDTO guest, Long id) throws GuestNotFoundException;

  /**
   * Delete a guest.
   * @param id the {@link Guest} unique identifier.
   * @throws GuestNotFoundException if no guest is found.
   */
  void delete(Long id) throws GuestNotFoundException;;
  
}
