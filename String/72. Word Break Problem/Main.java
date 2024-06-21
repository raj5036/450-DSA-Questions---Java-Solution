import java.util.*;

public class Main {
	// Function to check if the given word can be broken
	// down into words from the wordList
	static boolean wordBreak(List<String> wordList,
			String word) {
		// If the word is empty, it can be broken down into
		// an empty list of words
		if (word.isEmpty()) {
			return true;
		}

		int wordLen = word.length();

		// Check if the word can be broken down into
		// words from the wordList
		for (int i = 1; i <= wordLen; ++i) {
			String prefix = word.substring(0, i);

			if (wordList.contains(prefix)
					&& wordBreak(wordList, word.substring(i))) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList(
				"mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i", "like",
				"ice", "cream");

		boolean result = wordBreak(wordList, "likesamsung");

		System.out.println(result + " ."); // Output: true
	}
}

class GFG {

	/*
	 * A utility function to check whether a word is present in dictionary or not.
	 * An array of Strings is used for dictionary. Using array of Strings for
	 * dictionary is definitely not a good idea. We have used for simplicity of
	 * the program
	 */
	static boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango",
				"icecream", "and", "go", "i", "like", "ice", "cream" };
		int size = dictionary.length;
		for (int i = 0; i < size; i++)
			if (dictionary[i].compareTo(word) == 0)
				return true;
		return false;
	}

	// Returns true if String can be segmented into space separated
	// words, otherwise returns false
	static boolean wordBreak(String str) {
		int size = str.length();
		if (size == 0)
			return true;

		// Create the DP table to store results of subproblems. The value wb[i]
		// will be true if str[0..i-1] can be segmented into dictionary words,
		// otherwise false.
		boolean[] wb = new boolean[size + 1];

		for (int i = 1; i <= size; i++) {
			// if wb[i] is false, then check if current prefix can make it true.
			// Current prefix is "str.substring(0, i)"
			if (wb[i] == false && dictionaryContains(str.substring(0, i)))
				wb[i] = true;

			// wb[i] is true, then check for all subStrings starting from
			// (i+1)th character and store their results.
			if (wb[i] == true) {
				// If we reached the last prefix
				if (i == size)
					return true;

				for (int j = i + 1; j <= size; j++) {
					// Update wb[j] if it is false and can be updated
					// Note the parameter passed to dictionaryContains() is
					// subString starting from index 'i' and length 'j-i'
					if (wb[j] == false && dictionaryContains(str.substring(i, j)))
						wb[j] = true;

					// If we reached the last character
					if (j == size && wb[j] == true)
						return true;
				}
			}
		}

		/*
		 * Uncomment these lines to print DP table "wb[]"
		 * for (int i = 1; i <= size; i++)
		 * System.out.print(" " + wb[i];
		 */

		// If we have tried all prefixes and none of them worked
		return false;
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		if (wordBreak("ilikesamsung"))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
		if (wordBreak("iiiiiiii"))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
		if (wordBreak(""))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
		if (wordBreak("ilikelikeimangoiii"))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
		if (wordBreak("samsungandmango"))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
		if (wordBreak("samsungandmangok"))
			System.out.print("Yes\n");
		else
			System.out.print("No\n");
	}
}

// A recursive program to print all possible
// partitions of a given string into dictionary
// words

class PrintAll {

	// Prints all possible word breaks of given string
	static void wordBreak(int n, List<String> dict, String s) {
		String ans = "";
		wordBreakUtil(n, s, dict, ans);
	}

	static void wordBreakUtil(int n, String s, List<String> dict, String ans) {
		for (int i = 1; i <= n; i++) {

			// Extract substring from 0 to i in prefix
			String prefix = s.substring(0, i);

			// If dictionary contains this prefix, then
			// we check for remaining string. Otherwise
			// we ignore this prefix (there is no else for
			// this if) and try next
			if (dict.contains(prefix)) {
				// If no more elements are there, print it
				if (i == n) {

					// Add this element to previous prefix
					ans += prefix;
					System.out.println(ans);
					return;
				}
				wordBreakUtil(n - i, s.substring(i, n), dict, ans + prefix + " ");
			}
		}
	}

	// main function
	public static void main(String args[]) {
		String str1 = "iloveicecreamandmango"; // for first test case
		String str2 = "ilovesamsungmobile"; // for second test case
		int n1 = str1.length(); // length of first string
		int n2 = str2.length(); // length of second string

		// List of strings in dictionary
		List<String> dict = Arrays.asList("mobile", "samsung", "sam", "sung",
				"man", "mango", "icecream", "and",
				"go", "i", "love", "ice", "cream");
		System.out.println("First Test:");

		// call to the method
		wordBreak(n1, dict, str1);
		System.out.println("\nSecond Test:");

		// call to the method
		wordBreak(n2, dict, str2);
	}
}

// This code is contributed by mohitjha727.
