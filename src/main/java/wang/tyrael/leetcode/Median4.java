package wang.tyrael.leetcode;


import java.util.Arrays;

//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5
public class Median4 {
    public static void main(String[] args){
        Median4 median4 = new Median4();
        double result = 0;
        result = median4.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println("1:2.0:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println("2:2.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{}, new int[]{2,3});
        System.out.println("3:2.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,1}, new int[]{1,2});
        System.out.println("4:1.0:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,2}, new int[]{1,2});
        System.out.println("1.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,2}, new int[]{1,1});
        System.out.println("1.0:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,4}, new int[]{2,3});
        System.out.println("2.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,6}, new int[]{2,3, });
        System.out.println("3.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{1,2,5}, new int[]{3,4,6});
        System.out.println("3.5:" + result);

        result = median4.findMedianSortedArrays(new int[]{2, 5}, new int[]{3,4});
        System.out.println("3.5:" + result);
    }



    /**
     * 缩小找中位数的范围
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            return find(nums2);
        }
        if(nums2.length == 0){
            return find(nums1);
        }
        return find(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }


    private double find(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2){
            if(start1 == end1){
                return find(nums2, start2, end2, nums1[start1]);
            }
            if(start2 == end2){
                return find(nums1, start1, end1, nums2[start2]);
            }
            int count1 = end1 - start1 +1;
            int count2 = end2 - start2 +1;
            //如果是奇数，则是中间的，可能是中位数
        //如果是偶数，则是偏左的那个数，不会是中位数
            int mid1 = (end1-start1)/2 + start1;
            int mid2 = (end2-start2)/2 + start2;
            int value1 = nums1[mid1];
            int value2 = nums2[mid2];
            if(value1 == value2){
                if((count1 + count2) %2 == 0){
                    int small = value1;
                    int big = 0;
                    if(nums1[mid1 +1] < nums2[mid2+1]){
                        big = nums1[mid1 +1];
                    }else{
                        big = nums2[mid2 +1];
                    }
                    return (small + big)/2.0;
                }else{
                    return value1;
                }

            }
            //由于两个数都左偏，导致较小的数，可能不参与中位数
            if(count1%2 == 0 && count2 %2==0){
                int value11 = nums1[mid1+1];
                int value22 = nums2[mid2+1];

                if(value1 < value2 ){
                    if(value11 < value2){
                        //原来
                        //中位数在value1后面，value2前面
                        //两个数组前后剔除相同的数，这样保证新的数组的中位数还是原来的数
                        int skip = 0;
                        if(count1 < count2){
                            //要保证至少移除了一个，这样规模才能变小。
                            //最左边的数，不可能是备选
                            skip = count1/2;
                        }else{
                            //最右的数，可能是备选
                            skip = count2/2;
                        }
                        return find(nums1, nums2 , start1+ skip, end1, start2, end2-skip);
                    }else{
                        if(value11 < value22){
                            return (value2 + value11)/2.0;
                        }else{
                            return (value2 + value22)/2.0;
                        }
                    }
                }else{
                    if(value22 < value1){
                        //中位数在value2后面，value1前面
                        int skip = 0;
                        if(count1 < count2){
                            skip = count1/2;
                        }else{
                            skip = count2/2;
                        }
                        return find(nums1, nums2, start1, end1-skip, start2 + skip, end2);
                    }else{
                        if(value11 < value22){
                            return (value1 + value11)/2.0;
                        }else{
                            return (value1 + value22)/2.0;
                        }
                    }
                }
            }else{
                if(value1 < value2){
                    //中位数在value1后面，value2前面
                    //两个数组前后剔除相同的数，这样保证新的数组的中位数还是原来的数
                    int skip = 0;
                    if(count1 < count2){
                        //要保证至少移除了一个，这样规模才能变小。
                        //最左边的数，不可能是备选
                        skip = count1/2;
                    }else{
                        //最右的数，可能是备选
                        skip = count2/2;
                    }
                    return find(nums1, nums2 , start1+ skip, end1, start2, end2-skip);
                }else{
                    //中位数在value2后面，value1前面
                    int skip = 0;
                    if(count1 < count2){
                        skip = count1/2;
                    }else{
                        skip = count2/2;
                    }
                    return find(nums1, nums2, start1, end1-skip, start2 + skip, end2);
                }
            }




    }

    private double find(int[] nums, int start, int end, int key){
        //不能修改原排序数组，增加了时间复杂度
        int insert = Arrays.binarySearch(nums, start, end +1, key);
        if(insert >= start ){

        }else{
            insert = -(insert +1);
        }
        int count = end -start +1 + 1;
        if(count %2 == 0){
            int mid = (end +1 -start) /2 + start;
            int mid1 = mid +1;
            int value = get(mid, nums, insert, key);
            int value1 = get(mid1, nums, insert, key);
            return (value + value1)/2.0;
        }else{
            int mid = (end+1 -start) /2 + start;
            int value = get(mid, nums, insert, key);
            return value;
        }
    }

    /**
     * 从一个数组和一个额外值中返回索引对应的值
     * @param index 范围 0 - nums.length,新数组的index
     * @param nums
     * @param insert 范围 0 - nums.length，旧数组的index
     * @param value
     * @return
     */
    private int get(int index, int nums[], int insert, int value){
        if(index < insert){
            return nums[index];
        }else if(index == insert){
            return value;
        }else{
            return nums[index-1];
        }
    }

    private double find(int[] nums){
        if(nums.length % 2== 0){
            int mid = nums.length /2;
            int mid1 = mid-1;
            return (nums[mid] + nums[mid1])/2.0;
        }else{
            int mid = nums.length /2;
            return nums[mid];
        }
    }

}
