package com.package_measurement_conversion.PackageConversionAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping
public class mainController {
  @GetMapping("/convert-measurements")
  public HashMap<String, Object> convertMeasurements(@RequestParam(value = "input", defaultValue = "no measurement") String input) {
    HashMap<String, Object> response = new HashMap<>();

    response.put("body", input);

    HttpStatus httpStatus = HttpStatus.OK;

    // check if response is not OK and set the status accordingly
    if (httpStatus.isError()) {
      response.put("status", httpStatus.value());
    } else {
      response.put("status", "200 OK");
    }
    return response;
  }
}

