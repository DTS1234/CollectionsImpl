package uo.mp.check;

public class ArgumentsCheck {
	
	public static void isNull(Object object) {
		
		if(object == null)
			throw new IllegalArgumentException();
		
	}
	
	public static void isTrue(boolean condition) {
		
		if(condition == true)
			throw new IndexOutOfBoundsException();
		
	}
	
}
