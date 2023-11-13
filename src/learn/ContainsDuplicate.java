package learn;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums2));

        int[] nums3 = {};
        System.out.println(solution.containsDuplicate(nums3));

        int[] nums4 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums4));
    }
}
