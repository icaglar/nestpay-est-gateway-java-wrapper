package gkhts.payment.utils;

public class StringUtils {

	public static boolean isNullOrEmpty(String string){
		
		if (string==null){
			return true;
		}else{
			return string.trim().isEmpty();
		}
		
	}
	
	public static boolean isNullOrEmpty(Object string){
		if (string==null){
			return true;
		}else{
			return string.toString().trim().isEmpty();
		}
	}
}
