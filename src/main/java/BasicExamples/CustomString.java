
package BasicExamples;

import java.util.Arrays;

/**
 * String class
 * 
 * @author Munib Emre Sevilgen
 */

public class CustomString implements Comparable<CustomString> {

	private char[] data;
	private int count;
	private int first;

	public CustomString() {
		data = new char[0];
		first = 0;
		count = 0;
	}
	
	public CustomString(String s) {
		this(s.toCharArray());
	}

	public CustomString(CustomString s) {
		if (s.count > data.length)
			data = new char[s.count];

		count = s.length();
		for (int i = 0; i < s.count; i++) {
			data[i] = s.data[i + s.first];
		}

	}

	public CustomString(char value[]) {
		int size = value.length;
		first = 0;
		count = size;
		data = value.clone();
	}

	public CustomString(char value[], int offset, int count) {
		if (offset < 0)
			throw new StringIndexOutOfBoundsException(offset);

		if (count < 0)
			throw new StringIndexOutOfBoundsException(count);

		if (offset > data.length - count)
			throw new StringIndexOutOfBoundsException(offset + count);

		this.first = 0;
		this.count = count;
		this.data = Arrays.copyOfRange(value, offset, offset + count);
	}

	/**
	 * Returns the length of the string
	 * 
	 * @return the length of the string
	 */
	public int length() {
		return count;
	}

	/**
	 * Returns whether the string is empty or not
	 * 
	 * @return whether the string is empty or not
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the char at the given index
	 * 
	 * @param i
	 *            index of the char
	 * @return the char at the given index
	 */
	public char charAt(int i) {
		if ((i < 0) || (i >= count)) {
			throw new StringIndexOutOfBoundsException(i);
		}
		return data[i + first];
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object instanceof CustomString) {
			CustomString string = (CustomString) object;
			int n = count;
			if (n == string.count) {
				char[] data1 = data;
				char[] data2 = string.data;
				int i = first;
				int j = string.first;
				while (n != 0) {
					if (data1[i] != data2[j]) {
						return false;
					}
					n--;
					i++;
					j++;
				}
				return true;
			}
		}
		return false;
	}

	
	public int compareTo(CustomString anotherString) {
		int count1 = count;
		int count2 = anotherString.count;
		int min = Math.min(count1, count2);
		int i = first;
		int j = anotherString.first;

		for (int n = 0; n < min; n++) {
			int compare = this.charAt(n + i) - anotherString.charAt(n + j);
			if (compare != 0)
				return compare;
		}
		return (count1 - count2);
	}

	/**
	 * Returns the index of the given char
	 * 
	 * @param ch
	 *            a character
	 * @return the index of the first occurrence of the character
	 */
	public int indexOf(int ch) {
		return indexOf(ch, 0);
	}

	/**
	 * Returns index of the given char from the given index
	 * 
	 * @param ch
	 *            a character
	 * @param fromIndex
	 *            the index to start the search from
	 * @return the index of the first occurrence of the character
	 */
	public int indexOf(int ch, int fromIndex) {
		if (fromIndex < 0)
			fromIndex = 0;

		else if (fromIndex >= count)
			return -1;

		int last = first + count;
		for (int i = first + fromIndex; i < last; i++) {
			if (data[i] == ch) {
				return i - first;
			}
		}
		return -1;
	}

	/**
	 * Returns the index within this string of the last occurrence of the specified
	 * character
	 * 
	 * @param ch
	 * @param fromIndex
	 *            the index to start the search from
	 * @return the index of the last occurrence of the character
	 */
	public int lastIndexOf(int ch, int fromIndex) {
		if (fromIndex < count) {
			for (int i = first + fromIndex; i >= first; i--) {
				if (data[i] == ch)
					return i - first;
			}
		}
		return -1;

	}

	/**
	 * Returns the index within this string of the last occurrence of the specified
	 * character
	 * 
	 * @param ch
	 *            a character
	 * @return the index of the last occurrence of the character
	 */
	public int lastIndexOf(int ch) {
		return lastIndexOf(ch, count - 1);
	}

	/**
	 * Returns a new string that is a substring of this string
	 * 
	 * @param beginIndex
	 * @return the specified substring
	 */
	public CustomString substring(int beginIndex) {
		return substring(beginIndex, count);
	}

	/**
	 * Returns a new string that is a substring of this string
	 * 
	 * @param beginIndex
	 *            the beginning index, inclusive
	 * @param endIndex
	 *            the ending index, exclusive.
	 * @return the specified substring
	 */
	public CustomString substring(int beginIndex, int endIndex) {
		if (beginIndex < 0)
			throw new StringIndexOutOfBoundsException(beginIndex);

		if (endIndex > count)
			throw new StringIndexOutOfBoundsException(endIndex);

		if (beginIndex > endIndex)
			throw new StringIndexOutOfBoundsException(endIndex - beginIndex);

		if ((beginIndex == 0) && (endIndex == count))
			return this;

		CustomString anotherString = new CustomString();
		anotherString.count = endIndex - beginIndex;
		anotherString.data = new char[anotherString.count];

		for (int i = 0; i < count; i++) {
			anotherString.data[i] = this.charAt(i + beginIndex);
		}

		return anotherString;
	}

	/**
	 * Copies characters from this string into the destination character array
	 * 
	 * @param srcBegin
	 *            index of the first character in the string to copy
	 * @param srcEnd
	 *            index after the last character in the string to copy
	 * @param dst
	 *            the destination array
	 * @param dstBegin
	 *            the start offset in the destination array
	 */
	public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
		if (srcBegin < 0)
			throw new StringIndexOutOfBoundsException(srcBegin);

		if (srcEnd > count)
			throw new StringIndexOutOfBoundsException(srcEnd);

		if (srcBegin > srcEnd)
			throw new StringIndexOutOfBoundsException(srcEnd - srcBegin);

		System.arraycopy(data, first + srcBegin, dst, dstBegin, srcEnd - srcBegin);
	}

	/**
	 * Concatenates the specified string to the end of this string
	 * 
	 * @param str
	 *            the String that is concatenated to the end of this string
	 * @return a string that represents the concatenation of this object's
	 *         characters followed by the string argument's characters.
	 */
	public CustomString concat(CustomString str) {
		int length = str.length();
		if (length == 0)
			return this;

		char[] value = new char[count + length];
		getChars(0, count, value, 0);
		str.getChars(0, length, value, count);

		CustomString result = new CustomString();
		result.data = value;
		result.count = count + length;
		return result;

	}

	/**
	 * Returns a new string resulting from replacing all occurrences of oldChar in
	 * this string with newChar
	 * 
	 * @param oldChar
	 *            the char that will be replaced with newChar
	 * @param newChar
	 *            the char that will take the place of the oldChar
	 * @return a new string resulting from replacing all occurrences of oldChar in
	 *         this string with newChar
	 */
	public CustomString replace(char oldChar, char newChar) {
		if (oldChar != newChar) {
			CustomString result = new CustomString(this);

			for (int i = 0; i < result.count; i++) {
				if (result.data[i + first] == oldChar)
					result.data[i + first] = newChar;
			}
			return result;
		}
		return this;
	}

	/**
	 * @param regex
	 * @param limit
	 * @return
	 */
	public CustomString[] split(CustomString regex, int limit) {
		return null;

	}

	/**
	 * @param regex
	 * @return
	 */
	public CustomString[] split(CustomString regex) {
		return null;
	}

	/**
	 * Returns a copy of the string, with leading and trailing whitespace omitted
	 * 
	 * @return a copy of the string, with leading and trailing whitespace omitted
	 */
	public CustomString trim() {
		CustomString result = new CustomString(this);
		int start = 0;
		int end = 0;
		int i = result.first;
		while (result.data[i] == ' ') {
			start++;
			i++;
		}

		i = result.first + result.count;
		while (result.data[i] == ' ') {
			end++;
			i--;
		}

		result.first = result.first + start;
		result.count = result.count - (start + end);
		return result;
	}

	/**
	 * Returns the string that generated to lower case
	 * 
	 * @return the string that generated to lower case
	 */
	public CustomString toLowerCase() {
		CustomString result = new CustomString(this);
		for (int i = 0; i < result.count; i++) {
			result.data[i + result.first] = Character.toLowerCase(result.data[i + result.first]);
		}
		return result;
	}

	/**
	 * Returns the string that generated to upper case
	 * 
	 * @return the string that generated to upper case
	 */
	public CustomString toUpperCase() {
		CustomString result = new CustomString(this);
		for (int i = 0; i < result.count; i++) {
			result.data[i + result.first] = Character.toUpperCase(result.data[i + result.first]);
		}
		return result;
	}

}
