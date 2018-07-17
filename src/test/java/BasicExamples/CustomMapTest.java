package BasicExamples;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Map.Entry;

public class CustomMapTest extends TestCase {
	
	private CustomMap map;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public CustomMapTest( String testName ) {
        super(testName );
        map = new CustomMap();
	}

    public void testPut() {
        map.put("a", new Integer(1));
        map.put("b", new Integer(2));
        map.put("c", new Integer(3));
        map.put("d", new Integer(4));
        map.put("e", new Integer(5));

        assertTrue(map.values().toString().equals("[1, 2, 3, 4, 5]"));
    }
    
    public void testContainsKey() {
    	map.put("a", new Integer(1));

    	assertTrue(map.containsKey("a"));
    }
    
    public void testContainsValue() {
    	map.put("a", new Integer(1));

    	assertTrue(map.containsValue(new Integer(1)));
    }
    
    public void testGet() {
    	map.put("a", new Integer(1));
    	assertTrue(map.get("a").equals(new Integer(1)));
    }
    
    public void testRemove() {
    	map.put("a", new Integer(1));
    	assertTrue(map.remove("a").equals(new Integer(1)));


    }
    
    public void testClear() {
    
    	map.put("a", new Integer(1));
    	map.put("b", new Integer(2));
    	map.put("c", new Integer(3));
    	map.put("d", new Integer(4));
    	map.put("e", new Integer(5));
    	
    	map.clear();
    	assertTrue(map.keySet().toString() == "[]");
    	
    }
    
    public void testEntrySet() {
        
    	map.put("a", new Integer(1));
    	map.put("b", new Integer(2));
    	map.put("c", new Integer(3));
    	map.put("d", new Integer(4));
    	map.put("e", new Integer(5));
    	
    	HashSet<Entry<String, Integer>> set = (HashSet<Entry<String, Integer>>) map.entrySet();
    	System.out.println(set);
    	    	
    	assertTrue(true);
    	
    }
    
    
    
}
