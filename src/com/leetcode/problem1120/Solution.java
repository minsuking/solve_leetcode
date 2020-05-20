package com.leetcode.problem1120;


import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int t=0;
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                int cnt = map.get(arr2[i]);

                while(cnt>0){
                    ans[t++]=arr2[i];
                    cnt--;
                }
                map.remove(arr2[i]);
            }
        }
        List<Integer> tempList = new ArrayList<>();
        int tCnt=0;
        for(int k : map.keySet()){
            int cnt = map.get(k);
            while(cnt>0){
                tempList.add(k);
                cnt--;
            }
        }
        Collections.sort(tempList);
        for(int temp : tempList){
            ans[t++] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();



        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, arr2 = {2,42,38,0,43,21};
        System.out.println(solution.relativeSortArray(arr1,arr2));
    }
}