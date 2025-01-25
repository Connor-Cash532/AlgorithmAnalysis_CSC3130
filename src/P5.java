public class P5 {
    public static void main(String[] args){

        int[] nums3 = {3,3,3,3}; //O(1)
        removeElements(nums3, 3);

        int[] nums4 = {}; //O(1)
        removeElements(nums4, 3);


    }

    /*
    n = nums.length
    m = numsWithoutVal.length
    k = occurencesOfVal
     O(1) + O(n(2)) + O(1) + O(1) + O(m(k + 1 + 1)  + O(n(1+1))
     O(2n) + O(mk+2m) + O(2n)
     O(mk + 4n + 2m)
     O(mk + n + m)

     So the worst case time complexity is O(mk + n + m)

     The best case time complexity would be OMEGA(1) which would happen if nums was an empty array,
     which would imply that n=0, m=0, and k=0
     which would lead to the following time complexity OMEGA(1) + OMEGA(n(2)) + OMEGA(1) + OMEGA(1) + OMEGA(m(k + 1 + 1) + OMEGA(n(2))=OMEGA(6)=OMEGA(1)
     */
    public static int removeElements(int[] nums, int val){
        int occurencesOfVal = 0; //O(1)
        for(int i = 0; i < nums.length; i++){ //O(nums.length)
            if(nums[i] == val) { //O(1)
                occurencesOfVal++; //O(1)
            }
        }

        int[] numsWithoutVal = new int[nums.length-occurencesOfVal]; //O(1)

        int count = 0; //O(1)
        for(int i = 0; i < numsWithoutVal.length; i++){ //O(numsWithousVal.length)
            while(nums[count] == val){ //O(occurencesOfVal)
                count++; //O(1)
            }
            numsWithoutVal[i] = nums[count]; //O(1)
            count++; //O(1)
        }

        for(int i = 0; i < nums.length; i++){ //O(nums.length)
            if(i < numsWithoutVal.length){ //O(1)
                nums[i] = numsWithoutVal[i]; //O(1)
            }
            else //O(1)
                nums[i] = 0; //O(1)
        }



        return numsWithoutVal.length; //O(1)
    }
}
