package com.tenniscourts.exceptions;

/**
 * The type Business exception.
 */
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = -417250264451546216L;

  /**
   * Instantiates a new Business exception.
   * @param msg the msg
   */
  public BusinessException(String msg){
    super(msg);
  }
  
}
