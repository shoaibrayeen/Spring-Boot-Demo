package com.springboot.demo.constants;

public interface Endpoints {

  String ID = "id";
  String DEMO_BASE_URL = "/api/v1";
  String ALL_DATA = "/all";
  String GET_DATA = "/{" + ID + "}";
  String CREATE_DATA = "/create";
}
