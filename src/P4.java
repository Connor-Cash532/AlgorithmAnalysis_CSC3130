public class P4 {
    public static void main(String[] args){
        System.out.println(findInNotFibonacci(6279));
        //System.out.println(findInNotFibonacci(8));

    }

    /*
    n = notFibonacci.length
    O(1) + O(1) + O(1) + O(1) + O(1) + O(1) + O(target) + O(n)
    O(target + n)

    So the total worst case time complexity is, O(target + n). The best case time complexity would be if target == 0
    in which the first if statement would be true and 1 would be returned, then the time complexity would be OMEGA(1).
     */
    public static int findInNotFibonacci(int target){
        if(target == 0) //O(1)
            return 1; //O(1)
        if(target == 1) //O(1)
            return 2; //O(1)
        Long[] notFibonacci = new Long[target]; //O(1)
        notFibonacci[0] = 0L; //O(1)
        notFibonacci[1] = 1L; //O(1)

        Long currentNumber = 0L; //O(1)

        for(int i = 2; i < target; i++){ //O(target)
            notFibonacci[i] = (3L * notFibonacci[i-1]) + (2L * notFibonacci[i-2]); //O(1)
        }
        
        for(int i = 0; i < notFibonacci.length; i++){ //O(notFibonacci.length)
            if(notFibonacci[i] == target) //O(1)
                return i+1; //O(1)
            if(notFibonacci[i] > target) //O(1)
                return i; //O(1)
        }
        
        return -1; //O(1)
    }
}
