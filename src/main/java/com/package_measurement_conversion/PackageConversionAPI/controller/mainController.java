package com.package_measurement_conversion.PackageConversionAPI.controller;

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
  public String convertMeasurements(@RequestParam(value = "input", defaultValue = "no measurement") String input) {
    int[] measurements = {1, 2, 1}; // replace with your own logic for converting measurements
    String body = Arrays.toString(measurements);
    if (input.equals("no measurement") ){
      input = "coco";
    }

    return input;
  }
}

