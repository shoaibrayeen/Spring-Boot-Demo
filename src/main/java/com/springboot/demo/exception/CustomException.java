package com.springboot.demo.exception;

import com.springboot.demo.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {

  final ErrorCode errorCode;

  public CustomException(ErrorCode errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public CustomException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }
}
