package com.package_measurement_conversion.PackageConversionAPI.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * The ConversionMeasurementService class provides methods for converting input string to list of numbers
 * based on special logic .
 */
public class ConversionMeasurementService {
    /**
     * Applies a special logic to the input string and returns a List of numbers based on the logic.
     * The logic involves converting the input string to a List of numbers using the "convertInputToNumbers"
     * function, and then applying further calculations based on specific rules.
     * <p>
     * The rules for the special logic are as follows:
     * - Each measurement cycle consists of a count number followed by a series of values.
     * - For each cycle, the count number is used to determine the number of values to be considered.
     * - The subsequent values are added together to obtain a single value for that cycle.
     * - The obtained values are added to the result ArrayList.
     * <p>
     * Example:
     * Input: "abbcc"
     * After applying the "convertInputToNumbers" function, the output will be: [1, 2, 2, 3, 3]
     * Calculation:
     * - 1 (count number) => Take 1 value
     * - 2 (value) => Add 2 to the result ArrayList
     * - 2 (count number) => Take 2 values
     * - [3, 3] (values) => Add 3 + 3 = 6 to the result ArrayList
     * Output: [2, 6]
     *
     * @param input The input string to be processed.
     * @return An ArrayList of numbers representing the result of applying the special logic.
     */
    public List<Integer> applySpecialLogic(String input) {
        List<Integer> result = new ArrayList<>();
        List<Integer> numberList = convertInputToNumbers(input);

        // pointer starts from 0 and moves to the last value
        int pointer = 0;
        while (pointer < numberList.size()) {

            // determine count number
            int countNum = numberList.get(pointer);
            int value = 0;

            // Determine the index of the first value in the cycle
            int valueNum = pointer + 1;

            try {
                // Iterate through the value numbers and add them to the value
                for (int p = 0; p < countNum; p++) {
                    value += numberList.get(valueNum);
                    valueNum++;
                }

                // Add the final value to the result list
                result.add(value);

                // Move to the next cycle
                pointer = pointer + countNum + 1;
            } catch (Exception e) {
                logger.error("Error occurred while processing input: {}", e.getMessage());

                // return Empty list
                List<Integer> emptyList = new ArrayList<>();
                return emptyList;
            }
        }

        logger.info("Input processed successfully. Result: {}", result);
        return result;
    }


    /**
     * Converts the input string to a List of numbers based on a specific logic.
     * The logic involves converting alphabetic characters and underscore to corresponding numerical values:
     * - '_' corresponds to 0
     * - 'a' corresponds to 1
     * - 'b' corresponds to 2
     * - 'c' corresponds to 3
     * - 'd' corresponds to 4
     * - and so on.
     * If the character is 'z', it is treated differently, and the character after z will be added with it:
     * -'za' corresponds to 27
     * 'zzb' corresponds to 54
     *
     * @param input The input string to be converted.
     * @return An ArrayList of numbers representing the converted values.
     */
    private List<Integer> convertInputToNumbers(String input) {
        List<Integer> numberList = new ArrayList<>();

        // Convert input to lowerCase
        input = input.toLowerCase();

        // Iterate through each character in the input string
        for (int iteration = 0; iteration < input.length(); ) {
            int num;

            // Convert  non-'z' characters to corresponding numerical values and add it to arrayList
            if (input.charAt(iteration) != 'z') {
                num = (input.charAt(iteration) == '_') ? 0 : input.charAt(iteration) - 'a' + 1;
                numberList.add(num);
                iteration++;
            }

            // Special treatment for 'z' character and subsequent character
            else {
                boolean isItZ = true;
                int zValue = input.charAt(iteration) - 'a' + 1;

                // Iterate through subsequent characters until a non-'z' character is encountered
                for (; iteration < input.length() - 1 && isItZ; iteration++) {
                    int currentCharNum = (input.charAt(iteration) == '_') ? 0 : input.charAt(iteration) - 'a' + 1;
                    int nextCharNum = (input.charAt(iteration + 1) == '_') ? 0 : input.charAt(iteration + 1) - 'a' + 1;

                    // Calculate the final value based on subsequent characters
                    if (input.charAt(iteration) == 'z') {
                        zValue += nextCharNum;

                        // If it is non-'z' characters, stop the loop
                    } else {
                        isItZ = false;
                    }
                }

                // Add the final value to the numberList
                numberList.add(zValue);
            }
        }
        logger.info("Input has been successfully converted to a list of numbers. Number list: {}", numberList);
        return numberList;

    }
    private static final Logger logger = LoggerFactory.getLogger(ConversionMeasurementService.class);

}
