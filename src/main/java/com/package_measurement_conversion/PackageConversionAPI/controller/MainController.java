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
import java.util.List;


@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private ConversionMeasurementService conversionMeasurementService;

    @Autowired
    private InputValidationService inputValidationService;

    /**
     * Convert measurements based on the provided input.
     *
     * @param input The input string for measurements conversion.
     * @return The converted measurements or an error message.
     */
    @GetMapping("/convert-measurements")
    public Object convertMeasurements(@RequestParam(value = "input") String input) {
        List<Integer> numList = new ArrayList<>();

        if (inputValidationService.checkInputValidation(input)) {

            // If the input is valid, apply the special logic for measurement conversion
            return conversionMeasurementService.applySpecialLogic(input);
        } else if (inputValidationService.isEmptyString(input)) {

            // If the input is an empty string, return an empty list
            return numList;
        } else {

            // If the input is invalid, return an error message
            return "You are typing something wrong!!" + "\nYou can only type letters and underscores";
        }
    }
}
