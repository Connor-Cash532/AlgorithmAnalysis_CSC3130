public class P3 {
    public static void main(String[] args){
        notFibonacci(10); //O(1)
    }

    /*
    O(1) + O(1) O(1) + O(1) + O(1) + O( (n -2) * (1+1))
    O( (n -2) * (2))
    O( (n -2) * (2))
    O(2n -4)
    O(n)

    So the total time complexity O(n)

    The loops have not conditional breaks in them besides i < n, so the best case is the same as the worst case
    making OMEGA(n) the best case time complexity. Additionally, since the worst case and best case time complexity are the same
    theta can be defined as THETA(n)
     */
    public static void notFibonacci(int n){
        Long[] notFibonacci = new Long[n]; //O(1)
        notFibonacci[0] = 0L; //O(1)
        notFibonacci[1] = 1L; //O(1)

        System.out.println(notFibonacci[0]); //O(1)
        System.out.println(notFibonacci[1]); //O(1)
        for(int i = 2; i < n; i++){ //O(n-2)
            notFibonacci[i] = (3L * notFibonacci[i-1]) + (2L * notFibonacci[i-2]); //O(1)
            System.out.println(notFibonacci[i]); //O(1)
        }
    }
}
