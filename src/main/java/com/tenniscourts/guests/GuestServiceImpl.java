package com.tenniscourts.guests;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/**
 * @author Samir Scheide
 */
@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
  
  @Autowired
  private final GuestRepository guestRepository;
 
  @Autowired
  private final GuestMapper guestMapper;
  
  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO create(GuestCreateDTO guest) {
    Guest entity = guestMapper.map(GuestDTO.builder().name(guest.getName()).build());
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
  public List<GuestDTO> find(String name) throws GuestNotFoundException {
    Optional<List<Guest>> guest = Optional.ofNullable(guestRepository.findByNameContainingIgnoreCase(name));
    if (guest.isPresent() && !guest.get().isEmpty()) return guestMapper.map(guest.get());
    else {
      throw new GuestNotFoundException(name);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GuestDTO update(GuestUpdateDTO guest, Long id) throws GuestNotFoundException {
    Optional<Guest> entity = guestRepository.findById(id);
    if (!entity.isPresent()) throw new GuestNotFoundException(id);
    else {
      entity.get().setName(guest.getName());
      guestRepository.save(entity.get());
    }
    return guestMapper.map(entity.get());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(Long id) throws GuestNotFoundException {
    guestRepository.deleteById(id);
  }
  
}
