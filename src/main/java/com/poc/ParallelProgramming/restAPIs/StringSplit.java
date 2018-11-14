package com.poc.ParallelProgramming.restAPIs;

import java.util.ArrayList;
import java.util.List;

import com.nimsoft.events.common.utils.EMMessageUtils;

public class StringSplit {

	public static void main(String[] args) {
		List<String> inputs = new ArrayList<>();
		inputs.add("test");
		inputs.add("substr(event.eventType\\,10)");
		for (String input : inputs) {
			System.out.println("Input::"+input);
			if(checkKeyIsString(input) && input.contains("substr(")) {
			String getEventKeyDefined = input.substring(input.indexOf("(") + 1, input.indexOf("\\,"));
			System.out.println(getEventKeyDefined);
			String eventValue = "Dummy Test desc came";
			int subStringLength = Integer.valueOf(input.substring(input.indexOf("\\,") + 2, input.indexOf(")")));
			System.out.println(eventValue.substring(0, subStringLength));
			}
		}
	}
	
	private static boolean checkKeyIsString(String correlation) {
        return (correlation.startsWith("\"") && correlation.endsWith("\""))
                || (correlation.startsWith("'") && correlation.endsWith("'"));
    }

}
