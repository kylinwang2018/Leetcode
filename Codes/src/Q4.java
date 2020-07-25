/*


There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

public class Q4 {

}

class Solution4 {
    // Try every cut in binary search way. Making sure every left part is smaller
    // than the right part and the median is around the parition
    // which mean: When you cut first array at i then you cut second array
    // at (m + n + 1)/2-i. Now try to find the i where a[i-1] <= b[j]
    // and b[j-1] <= a[i]. So this i is partition around the median.
    // Time: O(log(min(m, n))), Space: O(1)
    /*
      2      4
      L      R
    x1 x2| x3 x4 x5 x6    
    y1 y2  y3 y4 y5 |y6 y7 y8
           5            3
    Our Goal: Do the binary search on the combined array such that, each size of the array is the same and Lmax_x <= Rmin_y && Lmax_y <= Rmin_x
    e.x in this example, Left = 2 + 5 = 7, Right = 4 + 3 = 7
    x2 <= y6 && y5 <= x3
    1. partitionX = (lo + hi)/2;
       partitionY = (x + y + 1)/2 - partitionX;
    2.Found:Lmax_x <= Rmin_y && Lmax_y <= Rmin_x
    else if Lmax_x > Rmin_y
        move towards left in X
    else move towards right in X
    3. avg = avg(max(x2,y5), min(x3, y6)) - even len
       avg = max(x2,y5) - odd len
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length, y = nums2.length;

        int lo = 0, hi = x;
        while (lo <= hi) {
            int partitionX = (lo + hi) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int Lmax_x = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int Rmin_x = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int Lmax_y = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int Rmin_y = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (Lmax_x <= Rmin_y && Lmax_y <= Rmin_x) {

                if ((x + y) % 2 == 0)
                    return (double) ((Math.max(Lmax_x, Lmax_y) + Math.min(Rmin_x, Rmin_y)) / 2.0);
                else
                    return (double) (Math.max(Lmax_x, Lmax_y));
            } else if (Lmax_x > Rmin_y) {
                hi = partitionX - 1;
            } else {

                lo = partitionX + 1;
            }
        }
        return -1;
    }
}