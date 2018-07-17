/**
 * 
 */
package BasicExamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Munib Emre Sevilgen
 *
 */
public class CustomMap implements Map<String, Integer> {
	
	private ArrayList<String> keys;
	private ArrayList<Integer> values;
	private int count;
	
	public CustomMap () {
		keys = new ArrayList<String>();
		values = new ArrayList<Integer>();
		count = 0;
	}

	public int size() {
		return count;
		
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((keys == null) ? 0 : keys.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomMap other = (CustomMap) obj;
		if (count != other.count)
			return false;
		if (keys == null) {
			if (other.keys != null)
				return false;
		} else if (!keys.equals(other.keys))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	public boolean containsKey(Object key) {
		if ( key instanceof String) {
			return keys.contains(key);
		}
		return false;
	}

	public boolean containsValue(Object value) {
		if ( value instanceof Integer) {
			return values.contains(value);
		}
		return false;
	}

	public Integer get(Object key) {
		if ( key instanceof String) {
			return values.get( keys.indexOf(key));
		}
		return null;
	}

	public Integer put(String key, Integer value) {
		if ( keys.contains(key)) {
			int index = keys.indexOf(key);
			Integer previous = values.get(index);
			values.remove(index);
			values.add(index, value);
			return previous;
		}
		else {
			keys.add(key);
			values.add(value);
			count++;
			return null;
		}
	}

	public Integer remove(Object key) {

		if (key instanceof String) {
			if (keys.contains(key)) {
				int index = keys.indexOf(key);
				Integer previous = values.get(index);
				keys.remove(index);
				values.remove(index);
				return previous;
			}		
		}
		return null;
	}

	public void putAll(Map<? extends String, ? extends Integer> m) {
		Iterator<? extends String> iterator = m.keySet().iterator();
		while( iterator.hasNext()) {
			String key = iterator.next();
			this.put(key, m.get(key));
		}
		
	}

	public void clear() {
		keys.clear();
		values.clear();
		count = 0;
	}

	public Set<String> keySet() {
		return new HashSet<String>(keys);
	}

	public Collection<Integer> values() {
		// TODO Auto-generated method stub
		return values;
	}

	public Set<Entry<String, Integer>> entrySet() {
		HashSet<Entry<String, Integer>> set = new HashSet<Entry<String, Integer>>();
		Iterator<String> iterator = keys.iterator();
		CustomEntry entry;
		String key;
		Integer value;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = get(key);
			entry = new CustomEntry( key, value);
			set.add(entry);
		}
		return set;
	} 
	
	private class CustomEntry implements Map.Entry<String, Integer> {

		private String key;
		private Integer value;
		
		public CustomEntry( String key, Integer value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return key;
		}

		public Integer getValue() {
			return value;
		}

		public Integer setValue(Integer value) {
			throw new UnsupportedOperationException("setValue");
		}
		
		public String toString() {
			return key + "=" + value + " ";
		}
	}
}
