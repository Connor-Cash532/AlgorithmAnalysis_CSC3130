public class P1 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","abc"));
        System.out.println(longestCommonSubsequence("almanacs","albatross"));
        System.out.println(longestCommonSubsequence("almanac","ferris"));
    }


    /*
    p = word1.length
    k = word2.length
    n = word1SubsequenceTotal.length
    m = word2SubsequenceTotal.length
    Total Time Complexity
    O(p * 2^p) + O(k * 2^k) + O(p * 2^p) + O(k * 2^k) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(p * 2^p * (k * 2^k))
    O(p * 2^p * (k * 2^k)) + 2O(p * 2^p) + 2O(k * 2^k)
    O(p * 2^p * (k * 2^k))

    O(p * 2^p) + O(k * 2^k)  + O(1) + O(1) + O(1) + O(p * 2^p * (2 * (k * 2^k)) + O(1)
    O(p * 2^p * 2k * 2^k)
    O(p * 2^p * k * 2^k)

    So , the worst case time complexity is O(p * 2^p * k * 2^k)

    Since the for loops always iterates the same amount of times and there is not a break in the for loop
    the best case time complexity is also OMEGA(p * 2^p * k * 2^k)
     */
    public static int longestCommonSubsequence(String word1, String word2){
        String[] word1SubsequenceTotal = allSubsequences(word1); // O(word1.length() * 2^word1.length())
        String[] word2SubsequenceTotal = allSubsequences(word2); // O(word2.length() * 2^word2.length())

        int n = word1SubsequenceTotal.length; //O(1)
        int m = word2SubsequenceTotal.length; //O(1)
        int maxLength = 0; //O(1)
        for(int i = 0; i < n; i++){ // O(n) or O(word1.length() * 2^word1.length())
            for(int j = 0; j < m; j++){ // O(m) or O(word2.length() * 2^word2.length())
                if(word1SubsequenceTotal[i].equals(word2SubsequenceTotal[j]) && word1SubsequenceTotal[i].length() > maxLength){ //O(1)
                    maxLength = word1SubsequenceTotal[i].length(); //O(1)
                }
            }
        }

        return maxLength; //O(1)
    }

    /*
        n = str.length();
        O(1) + O(1) + O(1) + O(2^n * (1 + 2n + 1)) + O(1)
        O(2*2^n + 2n*2^n)
        O(2n*2^n)
        O(n*2^n)
        Total Time Complexity
        O(n*2^n) where n = str.length()
     */
    public static String[] allSubsequences(String str) {
        int n = str.length(); //O(1)
        int totalSubsequences = (int) Math.pow(2, n); //(1)

        String[] subsequences = new String[totalSubsequences]; //O(1)
        for (int i = 0; i < totalSubsequences; i++) { //O(totalSubsequences) or O(2^n)
            String subsequence = ""; //O(1)

            for (int j = 0; j < n; j++) { // O(n)
                //System.out.print((i / (int) Math.pow(2, str.length() - j - 1)) % 2);
                if ((i / (int) Math.pow(2, n - j - 1)) % 2 == 1) { //O(1)
                    subsequence += str.charAt(j); //O(1)
                }
            }
            //System.out.println();

            subsequences[i] = subsequence; //O(1)
        }
        return subsequences; //O(1)
    }
}

