package com.springboot.demo.service;

import com.springboot.demo.enums.ErrorCode;
import com.springboot.demo.constants.Constants;
import com.springboot.demo.exception.CustomException;
import com.springboot.demo.model.BaseResponse;
import com.springboot.demo.model.Person;
import com.springboot.demo.model.PersonRequest;
import com.springboot.demo.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public BaseResponse<String> index() {
    return BaseResponse.<String>builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).response("Hello World").build();
  }

  public BaseResponse<List<Person>> findAll() {
    return BaseResponse.<List<Person>>builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).response(
        (List<Person>) personRepository.findAll()).build();
  }

  public BaseResponse<Person> findOne(Long id) {
    if(personRepository.existsById(id)) {
      return BaseResponse.<Person>builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).response(
          personRepository.findById(id)).build();
    }
    return BaseResponse.<Person>builder().code(Constants.SUCCESS_CODE).message(Constants.NOT_FOUND).build();
  }

  public <T> BaseResponse<T> addOne(PersonRequest personRequest) {
    try {
      personRepository.save(new Person(personRequest.getName(), personRequest.getAge()));
      return BaseResponse.<T>builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
    }
    catch (Exception ex) {
      throw new CustomException(ErrorCode.REPO_WRITE_FAILED, Constants.REPO_WRITE_FAILED + ex.getMessage());
    }
  }
}
