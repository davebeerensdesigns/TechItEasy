package com.techiteasy.techiteasy.exceptions;

import java.io.Serial;

public class RecordIsEmptyException extends RuntimeException {
   
   @Serial
   private static final long serialVersionUID = 1L;
   
   public RecordIsEmptyException() {
      super();
   }
   
   public RecordIsEmptyException(String message) {
      super(message);
      System.out.println(message);
   }
   
}
