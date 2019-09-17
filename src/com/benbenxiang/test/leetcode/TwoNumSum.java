package com.benbenxiang.test.leetcode;

import java.util.Arrays;

/**
 * 两数之和
 */
public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        int[] temp=new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);
        int[] indexs=new int[]{-1,-1};
        for(int i=0,j=temp.length-1;i<j;){
            if((temp[i]+temp[j])==target){
                for(int k=0;k<nums.length;k++){
                    if(nums[k]==temp[i] && indexs[0]==-1){
                        indexs[0]=k;
                    }else if(nums[k]==temp[j] && indexs[1]==-1){
                        indexs[1]=k;
                    }
                    if(indexs[0]!=-1&&indexs[1]!=-1){
                        return indexs;
                    }
                }
            }else if((temp[i]+temp[j])<target){
                i++;
            }else{
                j--;
            }
        }
        return indexs;
    }

    public int[] demo2(int[] nums, int target){
        int cap = 4;
        while (cap < nums.length)
            cap <<= 1;
        int[] map = new int[cap + nums.length * 3];
        int idx = cap--;
        NEXT:
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int index = key & cap;
            int ei;
            for (ei = map[index]; ei != 0; ei = map[ei]) {
                if (map[ei + 1] == key) {
                    return new int[] { map[ei + 2], i };
                }
            }
            key = nums[i];
            index = key & cap;
            for (ei = map[index]; ei != 0; ei = map[ei]) {
                if (map[ei + 1] == key)
                    continue NEXT;
            }
            ei = idx++;
            map[ei] = map[index];
            map[index] = ei;
            map[idx++] = key;
            map[idx++] = i;
        }
        return null;
    }
}
