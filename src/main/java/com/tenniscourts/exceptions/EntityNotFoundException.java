package com.tenniscourts.exceptions;

/**
 * The type Entity not found exception.
 */
public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -4691343621128003232L;

  /**
   * Instantiates a new Entity not found exception.
   * @param msg the msg
   */
  public EntityNotFoundException(String msg){
    super(msg);
  }
  
}
