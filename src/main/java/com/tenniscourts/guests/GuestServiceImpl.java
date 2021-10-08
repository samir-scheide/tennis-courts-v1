package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Samir Scheide
 */
@Service
@AllArgsConstructor
public final class GuestServiceImpl implements GuestService {
  
  @Autowired
  private final GuestRepository guestRepository;
 
  @Autowired
  private final GuestMapper guestMapper;
  
  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO create(Guest entity) {
    return guestMapper.map(guestRepository.save(entity));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<GuestDTO> list() {
    return guestMapper.map(guestRepository.findAll());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO get(Long id) throws GuestNotFoundException {
    Optional<Guest> guest = guestRepository.findById(id);
    if (guest.isPresent()) return guestMapper.map(guest.get());
    else {
      throw new GuestNotFoundException(id);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO find(String name) throws GuestNotFoundException {
    Optional<Guest> guest = Optional.ofNullable(guestRepository.findByName(name));
    if (guest.isPresent()) return guestMapper.map(guest.get());
    else {
      throw new GuestNotFoundException(name);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO update(Guest entity) throws GuestNotFoundException {
    Optional<Guest> guest = guestRepository.findById(entity.getId());
    if (!guest.isPresent()) throw new GuestNotFoundException(entity.getId());
    else {
      guest.get().setName(entity.getName());
    }
    return guestMapper.map(guest.get());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) throws GuestNotFoundException {
    guestRepository.deleteById(id);
  }
  
}
