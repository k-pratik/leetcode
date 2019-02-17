import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] n1 = {3,2,4};
        int target = 6;

        int[] nums = Arrays.copyOf(n1,n1.length);
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) {
                break;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            }
        }

        int[] result = new int[2];
        int a = 0;

        for (int k = 0; k < nums.length; k++) {
            if (n1[k]==nums[i] || n1[k]==nums[j]){
                result[a] = k;
                a++;
            }
        }


        for (int b : result) {
            System.out.println(b);
        }
//        System.out.println(Arrays.asList(result));
    }
}
