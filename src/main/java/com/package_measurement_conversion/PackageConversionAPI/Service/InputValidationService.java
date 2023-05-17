package com.package_measurement_conversion.PackageConversionAPI.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
/**
 * The InputValidationService class provides methods for validating input strings.
 */
public class InputValidationService {

    /**
     * Checks if the input string is empty.
     *
     * @param input The input string to be checked.
     * @return {@code true} if the input string is empty, {@code false} otherwise.
     */
    public boolean isEmptyString(String input) {
        if (input.isEmpty()) {
            logger.debug("Input String is empty: {}", input);
            return true;
        } else {
            logger.debug("Input String is not empty: {}", input);
            return false;
        }
    }

    /**
     * Checks the validation of the input string based on a regular expression pattern.
     *
     * @param input The input string to be validated.
     * @return {@code true} if the input string matches the pattern, indicating a valid input.
     *         {@code false} if the input string does not match the pattern, indicating an invalid input.
     */
    public boolean checkInputValidation(String input) {
        // Regular expression pattern to validate the input string (alphabet and underscore)
        String regex = "^[A-Za-z_]*$";

        boolean isValid = input.matches(regex);

        if (isValid) {
            logger.debug("Input String is valid: {}", input);
        } else {
            logger.debug("Input String is invalid: {}", input);
        }

        return isValid;
    }


    private static final Logger logger = LoggerFactory.getLogger(InputValidationService.class);

}
