package com.tenniscourts.exceptions;

/**
 * The type Already exists entity exception.
 */
public class AlreadyExistsEntityException extends RuntimeException {
  
  private static final long serialVersionUID = -3882709800738762080L;

  /**
   * Instantiates a new Already exists entity exception.
   * @param msg the msg
   */
  public AlreadyExistsEntityException(String msg){
    super(msg);
  }
  
}
