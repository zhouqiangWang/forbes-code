import java.util.Arrays;

class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (nums[l] >= pivot) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }

        swap(nums, start, r);

        if (r == k) {
            return nums[r];
        } else if (r > k) {
            return quickSelect(nums, start, r - 1, k);
        }

        return quickSelect(nums, r + 1, end, k);
    }

    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        QuickSelect instance = new QuickSelect();
        System.out.println(instance.findKthLargest(arr, 1));
    }
}