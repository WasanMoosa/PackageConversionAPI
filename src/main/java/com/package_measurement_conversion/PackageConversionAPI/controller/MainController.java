package com.package_measurement_conversion.PackageConversionAPI.controller;

import com.package_measurement_conversion.PackageConversionAPI.Service.ConversionMeasurementService;
import com.package_measurement_conversion.PackageConversionAPI.Service.InputValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class MainController {

    @Autowired
    private ConversionMeasurementService conversionMeasurementService;

    @Autowired
    private InputValidationService inputValidationService;

    /**
     * Convert measurements based on the provided input.
     *
     * @param input The input string for measurements conversion.
     * @return The response entity containing the converted measurements or an empty List.
     */
    @GetMapping("/convert-measurements")
    public ResponseEntity<List<Integer>> convertMeasurements(@RequestParam(value = "input") String input) {
        if (inputValidationService.checkInputValidation(input)) {

            // If the input is valid, apply the special logic for measurement conversion
            List<Integer> convertedMeasurements = conversionMeasurementService.applySpecialLogic(input);
            return ResponseEntity.ok(convertedMeasurements);
        } else if (inputValidationService.isEmptyString(input)) {

            // If the input is an empty string, return an empty list
            return ResponseEntity.ok().body(new ArrayList<>());
        } else {

            // If the input is invalid, return an empty list with HTTP status 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
        }
    }
}
