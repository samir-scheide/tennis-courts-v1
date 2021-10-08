package com.tenniscourts.guests;

import java.util.List;

/**
 * Constains most of the operation to retrieve, update and create a guest into the aplication.
 * @author Samir Scheide
 */
public interface GuestService {

  /**
   * Register a guest.
   * @param guest a {@link Guest} instance.
   * @return a {@link GuestDTO} instance.
   */
  GuestDTO create(Guest entity);

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
   * @return a {@link GuestDTO} instance with the {@link Guest} found.
   * @throws GuestNotFoundException if no guest is found.
   */
  GuestDTO find(String name) throws GuestNotFoundException;

  /**
   * Update a guest.
   * @param guest the {@link Guest} entity.
   * @return a {@link GuestDTO} instance with the {@link Guest} updated.
   * @throws GuestNotFoundException if no guest is found.
   */
  GuestDTO update(Guest entity) throws GuestNotFoundException;

  /**
   * Delete a guest.
   * @param id the {@link Guest} unique identifier.
   * @throws GuestNotFoundException if no guest is found.
   */
  void delete(Long id) throws GuestNotFoundException;;
  
}
