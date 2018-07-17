/**
 * 
 */
package BasicExamples;

import junit.framework.TestCase;

/**
 * @author Munib Emre Sevilgen
 *
 */
public class CustomStringTest extends TestCase {

	/**
	 * @param name
	 */
	public CustomStringTest(String name) {
		super(name);
	}
		
	public void testEquals() {
		
		CustomString customString = new CustomString("EMRE");
			
		CustomString customString2 = new CustomString("EMRE");
		
		assertEquals(customString, customString2);
	}
	
	
	 public void testNotEquals() {
		
		 CustomString customString = new CustomString("EMRE");
		 
		 CustomString customString2 = new CustomString("EMRE2");
		
		 assertFalse(customString.equals(customString2));
	 }

}
