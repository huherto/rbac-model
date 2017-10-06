package io.github.huherto.rbac.util;




import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringUtils extends org.springframework.util.StringUtils {
	
	public static ObjectMapper om = new ObjectMapper();
	
	/*
	 * Features:
	 *    - checks both are strings.
	 *    - Handles nulls.
	 *    - Ignores spaces at the end.
	 *    - Ignores case. 
	 */
	public static boolean safeEquals(String s1, String s2) {
		
		if (s1 == s2 || s1 == null || s2 == null) {
			return s1 == s2;
		}
		
		s1 = s1.trim();
		s2 = s2.trim();
		
		return s1.equalsIgnoreCase(s2);
		
	}

	/*
	 * return String with contents of object as json in one line.
	 */
	public static String simpleJson(Object obj) {
		try {
			return om.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}		
	}
	
	/*
	 * return string with contents of object.
	 */
	public static String prettyJson(Object obj) {
		try {
			return om.writer(new DefaultPrettyPrinter()).writeValueAsString(obj);			
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
