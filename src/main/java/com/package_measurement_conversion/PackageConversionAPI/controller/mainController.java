package com.package_measurement_conversion.PackageConversionAPI.controller;

import com.package_measurement_conversion.PackageConversionAPI.Service.ConversionMeasurementService;
import com.package_measurement_conversion.PackageConversionAPI.Service.InputValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class mainController {
    @Autowired
    ConversionMeasurementService conversionMeasurementService;

    @Autowired
    InputValidationService inputValidationService;

    @GetMapping("/convert-measurements")
    public Object convertMeasurements(@RequestParam(value = "input") String input) {
        List<Integer> numList = new ArrayList<>();
        if (inputValidationService.checkInputValidation(input)) {
            return conversionMeasurementService.applySpecialLogic(input);
        } else if (inputValidationService.isEmptyString(input)) {
            return numList;
        } else {
            return "You are typing something wrong!!" + "\n You can only type letters and under score";
        }

    }
}

