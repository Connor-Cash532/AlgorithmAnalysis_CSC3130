public class P2 {
    public static void main(String[] args){
        System.out.println(commonSubstring("gears of war", "History of warriors"));
        System.out.println(commonSubstring("spy family", "jujutzu"));
        System.out.println(commonSubstring("spy family", "jujutsu kaisen"));


    }

    /*
    n = text1.length()
    m = text2.length()
    i is the firstIteratorVariable in the first loop
    j is the secondIterator variable in the second loop
    k is the third iterator variable in the third loop
    l is the fourth iterator variable in the fourth loop

    O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O( (n( n * (j-i)* ( m (m  (l - k + 4) -1)  / 2 )- 1)) / 2) + O(1)
    O( (n( n * (j-i) * ( m * (m  (l - k + 4) -1)  / 2 )- 1)) / 2)
    O( (n( n * (j-i) * ( m * (ml -mk +4 - 1) / 2) - 1 )) / 2)
    O( (n( n * (j-i) * ( m^2*l - m^2*k + 3m) / 2) - 1)) / 2)
    O( (n( nj - ni * (m^2*l - m^2*k + 3m) - 1)) / 2)
    O( (n( nj - ni * (m^2*l - m^2*k + 3m))) / 2)
    O( (n^2j - n^2i * (m^2*l - m^2*k + 3m))) / 2)
    O( (n^2j - n^2i * (m^2*l - m^2*k))) / 2)
    O( (n^2*j * m^2*l - n^2*j * m^2*k - n^2i * m^2*l + n^2i * m^2*k)/2)
    O(n^2*j * m^2*l - n^2*j * m^2*k - n^2i * m^2*l + n^2i * m^2*k)

    Since the for loops always iterates the same amount of times and there is not a break in any of the for loops
    the best case time complexity is also OMEGA(n^2*j * m^2*l - n^2*j * m^2*k - n^2i * m^2*l + n^2i * m^2*k) and since the
    bounds are equal we can define a bound for theta as THETA(n^2*j * m^2*l - n^2*j * m^2*k - n^2i * m^2*l + n^2i * m^2*k)
     */
    public static String commonSubstring(String text1, String text2){

        String text1Substring = ""; // O(1)
        String text2Substring = ""; // O(1)
        int numOfTotalSubstringsText1 = (text1.length()*(text1.length()+1))/2; // O(1)
        int numOfTotalSubstringsText2 = (text2.length()*(text2.length()+1))/2; // O(1)

        String[] allText1Substrings = new String[numOfTotalSubstringsText1]; // O(1)
        String[] allText2Substrings = new String[numOfTotalSubstringsText2]; // O(1)

        int maxLength = -1; // O(1)
        String maxString = ""; // O(1)
        for(int i = 0; i < text1.length(); i++){ //O(text1.length())
            for(int j = i+1; j < text1.length()+1; j++){ //O(text1.length() - i)
                //text1Substring = text1.substring(i,j);
                text1Substring = substring(text1, i,j); //O(j-i)
                for(int k = 0; k < text2.length(); k++){ // O(text2.length())
                    for(int l = k+1; l < text2.length()+1; l++){ // O(text2.length() - k)
                        //text2Substring = text2.substring(k,l);
                        text2Substring = substring(text2, k,l); //O(l-k)
                        if(text1Substring.equals(text2Substring)){ //O(1)
                            if(text1Substring.length() > maxLength && text1Substring.charAt(0) != ' ') { //O(1)
                                maxLength = text1Substring.length(); //O(1)
                                maxString = text1Substring; //O(1)
                            }
                        }
                    }
                }
            }
        }
        return maxString; //O(1)
    }

    /*
    O(1) + O( (index2 - index1) * 1)
    O(index2 - index1)

    Total time complexity
    So the total time complexity is O(index2 - index1)

    Since the for loops always iterates the same amount of times and there is not a break in the for loop
    the best case time complexity is also OMEGA(index2 - index1)
     */
    public static String substring(String str, int index1, int index2){
        String strSubstring = ""; //O(1)
        for(int i = index1; i < index2; i++){ //O(index2 - index1)
            strSubstring += str.charAt(i); //O(1)
        }

        return strSubstring;
    }
}
