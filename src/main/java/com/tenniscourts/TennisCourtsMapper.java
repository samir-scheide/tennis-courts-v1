package com.tenniscourts;

import com.tenniscourts.config.persistence.BaseEntity;

/**
 * This interfacecontract ensures that a mapper will have both methods to transform an entity to DTO and vice-versa.
 * @author Samir Scheide
 *
 * @param <T> the DTO (data transfer object) class
 * @param <B> the entity class
 */
public interface TennisCourtsMapper<T, B extends BaseEntity<?>> {

  /**
   * With a given stance of B, returns a instance of T
   * @param source the entity {@link BaseEntity} instance
   * @return a DTO instance
   */
  T map(B source);

  /**
   * With a given stance of T, returns a instance of B
   * @param source a DTO instance  
   * @return the entity {@link BaseEntity} instance
   */
  B map(T source);
  
}
