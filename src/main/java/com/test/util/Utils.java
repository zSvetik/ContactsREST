package com.test.util;

public class Utils {

	public static String javaPatternToSQL(String pattern) {
		if (pattern == null || "".equals(pattern)) {
			return "%";
		}
		if (pattern.startsWith("^")) {
			pattern = pattern.substring(1);
		}
		if (pattern.endsWith("$")) {
			pattern = pattern.substring(0, pattern.length() - 1);
		}
		if (pattern.length() == 0) {
			return "%";
		}
		return pattern.replaceAll("\\.\\*", "%").replaceAll("\\.", "_");
	}
}
