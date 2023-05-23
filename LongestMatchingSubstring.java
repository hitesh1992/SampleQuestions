public class LongestMatchingSubstring {
  
  /* method takes two strings str1 and str2 as input and returns the longest matching substring between them. The program uses a dynamic programming approach to solve the problem. 
  The dp array stores the lengths of the longest matching substrings found so far. The program iterates through each character of str1 and str2 and updates the dp array accordingly. Whenever a match is found between the characters of str1 and str2, the length of the common substring is incremented by 1.
  Finally, the program checks the dp array to find the maximum length of the common substring and its ending index. The longest matching substring is then extracted from str1 using the ending index and the maximum length. */
  
    public static String findLongestMatchingSubstring(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }

        if (maxLength == 0) {
            return "";
        } else {
            return str1.substring(endIndex - maxLength + 1, endIndex + 1);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "defghij";
        String longestMatchingSubstring = findLongestMatchingSubstring(str1, str2);
        System.out.println("Longest matching substring: " + longestMatchingSubstring);
    }
}
