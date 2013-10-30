package com.firstProject.utils;

import org.springframework.ui.ModelMap;

import static java.util.Arrays.asList;
import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

/**
 * Author: Øyvind Bjerke
 * Date: 10/23/13
 * Time: 9:19 AM
 */
public class Utils {
	public static void addMessage(ModelMap model, String messageCode, Object... messageArguments) {
		Object messageArgumentCSV = collectionToCommaDelimitedString(asList(messageArguments));
		model.addAttribute("messageCode", messageCode);
		model.addAttribute("messageArguments", messageArgumentCSV);
	}
}
