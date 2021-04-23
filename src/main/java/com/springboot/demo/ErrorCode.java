package com.springboot.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@ToString
public enum ErrorCode {

  REPO_WRITE_FAILED("500", "Error while saving data into repository", HttpStatus.INTERNAL_SERVER_ERROR);

  private String code;

  private String message;

  private HttpStatus httpStatus;
}
