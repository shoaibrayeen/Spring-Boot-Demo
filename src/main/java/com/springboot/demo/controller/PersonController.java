package com.springboot.demo.controller;

import com.springboot.demo.constants.Endpoints;
import com.springboot.demo.model.BaseResponse;
import com.springboot.demo.model.Person;
import com.springboot.demo.model.PersonRequest;
import com.springboot.demo.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Endpoints.DEMO_BASE_URL)
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping
  public BaseResponse<String> index() {
    return personService.index();
  }

  @GetMapping(value = Endpoints.ALL_DATA)
  public BaseResponse<List<Person>> allInfo() {
    return personService.findAll();
  }

  @GetMapping(value = Endpoints.GET_DATA)
  public BaseResponse<Person> getInfo(@PathVariable(value = Endpoints.ID) Long id) {
    return personService.findOne(id);
  }

  @PostMapping(value = Endpoints.CREATE_DATA)
  public <T> BaseResponse<T> addInfo(@RequestBody PersonRequest personRequest) {
    return personService.addOne(personRequest);
  }
}
