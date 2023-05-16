package com.package_measurement_conversion.PackageConversionAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class PackageConversionApiApplication {

    public static void main(String[] args) {
//		SpringApplication.run(PackageConversionApiApplication.class, args);


// This is just to convert letters to numbers
		String input =  "zdaaaaaaaabaaaaaaaabaaaaaaaabbaa";
		input = input.toLowerCase();
		ArrayList<Integer> numberArrayList = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length();) {
			int alpNum;
			if (input.charAt(i) != 'z') {
				if (input.charAt(i) == '_') {
					alpNum = 0;
				} else {
					alpNum = input.charAt(i) - 'a' + 1;
				}
				numberArrayList.add(alpNum);
				i++;} else {
				boolean isItZ = true;
				int zValue = 26;

				for (; i < input.length() && isItZ; i++) {
					int currentCharNum;
					int nextCharNum;
					if (input.charAt(i)=='_'){
						currentCharNum = 0;
					}
					else{currentCharNum = input.charAt(i) - 'a' + 1; }
					if (input.charAt(i+1)=='_'){
						nextCharNum  = 0;
					}
					else{nextCharNum = input.charAt(i+1) - 'a' + 1; }


					if (input.charAt(i) == 'z') {
						zValue = zValue + nextCharNum;
					} else {
						isItZ = false;

					}
				}
				numberArrayList.add(zValue);
			}
		}
		System.out.println(numberArrayList.toString());


		// Now, here we convert number array to packate of code


		//Just to test logic
		int pointer=0;
		while (pointer < numberArrayList.size()) {
			// Stage 1
			int countMove = numberArrayList.get(pointer);

			int value = 0;
			int j = pointer + 1;
			for (int p = 0; p < countMove; p++) {
				value = value +numberArrayList.get(j);
				j++;
			}
			result.add(value);


			pointer = pointer + countMove + 1;


		}
		System.out.println(result.toString());

	}

}
