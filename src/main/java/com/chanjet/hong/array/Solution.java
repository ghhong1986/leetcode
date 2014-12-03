/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.array;

import java.util.*;

/**
 * <p>
 * TODO 这个文件的描述
 * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年11月01日 下午4:04
 */
public class Solution {
    public static void main(String[] args) {
        Solution  s = new Solution();
        int [] a = {1};
/*        int length = s.removeElement(a,1);
        System.out.println(a);
        System.out.println("length:" + length);*/

        int result;
        //result = s.divide(-1010369383,-2147483648);  //注意:-2147483648 这个负数太小了，转换为正数时，整形值装不下，溢出。
        result = s.divide(-2147483648, 1);
        System.out.println("result:"+ result);

        int [] sortArr = {1,2};
        int length = s.removeDuplicates(sortArr);
        System.out.println("length:"+length);

        int [] subArray = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSubArray = s.maxSubArray(subArray);
        System.out.println("maxSubArray:"+maxSubArray);

        int []inputNumbers1 = new int[]{2,7,11,5};
        int []inputNumbers2 = new int []{-3,4,3,90};
        int []eleArray =null;
        //eleArray = s.twoSum(inputNumbers1,7);
        eleArray = s.twoSum(inputNumbers2,0);
        System.out.printf("two Sum element:[%d,%d]\n",eleArray[0],eleArray[1]);


        int [] color = new int[]{1,2,1};
        s.sortColors(color);
        for (int i = 0; i < color.length; i++) {
            System.out.printf("%d ,",color[i]);
        }
        System.out.println();

        for (int matlen =2;matlen<8;matlen++){
            int [][] matrix = new int[matlen][matlen];
            for (int i = 0; i < matlen; i++)
                for (int j = 0; j < matlen; j++)
                    matrix[i][j]=i*matlen+j;
            s.printMartix(matrix);
            s.rotate(matrix);
            System.out.printf("rotated:\n");
            s.printMartix(matrix);
            System.out.println();

        }

    }

    public int removeElement(int[] A, int elem) {
        int equalCount = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if(A[i] == elem){
                A[i] = A[A.length-1-equalCount];
                equalCount++;
            }
        }
        return A.length-equalCount;
    }

    /**
     * Remove Duplicates from Sorted Array
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * @param A
     * @return
     */

    public int removeDuplicates(int[] A) {
        if(A.length < 2)
            return A.length;
        int end = 0;
        for(int i=1;i<A.length;i++){
            if (A[i] != A[end])
                A[++end] = A[i];
        }
        return end+1;
    }

    /**
     * Plus One
     * Given a non-negative number represented as an array of digits, plus one to the number.
     *  代码优美一点
     * @param digits
     * @return
     */
    public int [] plusOne(int [] digits){
        int nineCount =0;
        for(int i=0;i<digits.length;i++)
            if(digits[i]==9)
                nineCount++;
        if(nineCount==digits.length){
            int [] resultArr =new int [digits.length +1];
            resultArr[0] =1;
            for(int i =1;i< resultArr.length;i++)
                resultArr[i] =0;
            return resultArr;
        }else{
            int extra = 0;
            if(digits[digits.length-1] == 9 ){
                digits[digits.length-1]=0;
                extra = 1;
            }else{
                digits[digits.length-1] += 1;
            }

            for (int i = digits.length -2 ;i >= 0;i--){
                if(digits[i] + extra > 9 ){
                    digits[i] = 0;
                    extra = 1;
                }else{
                    digits[i] += extra;
                    break;
                }
            }
        }
        return digits;
    }

    /**
     * 思路二:
     * @param digits
     * @return
     */
    public int [] plusOne2(int [] digits){
       int carry =1;
       int i = digits.length -1;
       for(;i>=0;i--){
           carry += digits[i];
           digits[i] = carry%10;
           carry /= 10;
           if(carry==0)
               break;
       }
       if(i<0){
           int [] tmpArr = new int[digits.length+1];
           tmpArr[0] = carry;
           for (int j=1 ;j<tmpArr.length;j++){
               tmpArr[j] = digits[j-1];
           }
           digits = tmpArr;
       }
      return digits;
    }

    /**
     * Pascal's Triangle(杨辉三角形)
     * Given numRows, generate the first numRows of Pascal's triangle.
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleLines = new ArrayList<List<Integer>>();
        for(int i=0;i<Math.min(2,numRows);i++){
            List<Integer> line = new ArrayList<Integer>();
            triangleLines.add(line);
            for(int j =0;j<i+1;j++){
                line.add(1);
            }
        }
        for(int i = 2;i < numRows;i++){
            List<Integer> lastLine = triangleLines.get(i-1);
            List<Integer> iLine = new ArrayList<Integer>(i+1);
            iLine.add(1);
            for(int j =1;j< i;j++){
                iLine.add(lastLine.get(j-1)+lastLine.get(j));
            }
            iLine.add(1);
            triangleLines.add(iLine);
        }
        return triangleLines;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangleLines = new ArrayList<List<Integer>>();
        for(int i = 0;i < numRows;i++){
            List<Integer> iLine = new ArrayList<Integer>(i+1);
            if( i==0 ){
                iLine.add(1);
            }else{
                List<Integer> lastLine = triangleLines.get(i-1);
                iLine.add(1);
                for(int j =1;j< i;j++){
                    iLine.add(lastLine.get(j-1)+lastLine.get(j));
                }
                iLine.add(1);
            }
            triangleLines.add(iLine);
        }
        return triangleLines;
    }

    /**
     *  除法,不允许使用乘,除和取模
     *  还需要考虑负号的问题
     *
     *  总结:1、关于位运算
     *  2、运算符的优先级，需要复习
     *  3、测试边界条件，int正负数最大值，以及转换时溢出;类型转换是精度的溢出
     * @param dividend
     * @param divisor
     * @return
     */
    private int positive_divide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        int i = 0;
        long tmpDivisor = divisor;
        for (; dividend >= tmpDivisor; i++) {
            tmpDivisor = tmpDivisor << 1;
        }
        int left = positive_divide(dividend - (tmpDivisor >> 1), divisor);
        return left + (1 << (i - 1));
    }

    public int divide(int dividend ,int divisor){
        long ldividend = dividend,ldivisor = divisor;
        boolean negativeFlag = false;
        if(ldividend<0){
            ldividend =  ~ldividend + 1;
            negativeFlag = !negativeFlag;
        }
        if(ldivisor<0){
            ldivisor = ~ldivisor + 1;
            negativeFlag = !negativeFlag;
        }
        int res = positive_divide(ldividend,ldivisor);
        if(negativeFlag)
            res = ~res + 1;
        return res;
    }

    /**
     * Merge Sorted Array
     * Given two sorted integer arrays A and B, merge B into A as one sorted array.
     * Note:
     * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements
     * from B. The number of elements initialized in A and B are m and n respectively.
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int mergeIndex = m + n -1;
        boolean isAsc = true;
        if((m>0 && A[0] > A[m-1]) || (n>0 && B[0] > B[n-1]))
            isAsc =false;
        m--;
        n--;
        while(mergeIndex>=0){
            if(m<0 || n< 0)
                break;
            if(isAsc){
                if(A[m] > B[n])
                    A[mergeIndex--] = A[m--];
                else
                    A[mergeIndex--] = B[n--];
            }else{
                if(A[m] > B[n])
                    A[mergeIndex--] = B[m--];
                else
                    A[mergeIndex--] = A[n--];
            }
        }
        if(m<0){
            while(n>=0)
                A[n] = B[n--];
        }
    }

    /**
     * Maximum Subarray
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
     * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        //{-2,1,-3,4,-1,2,1,-5,4};
        int prevMax =A[0];
        int maxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            prevMax = Math.max(prevMax+A[i],A[i]);
            maxSum = Math.max(maxSum,prevMax);
        }
        return maxSum;
    }

    class val {
        int l, m, r, s;
        val(int l, int m, int r, int s){
            this.l =l;
            this.m = m;
            this.r = r;
            this.s = s;

        }
    }

    val dac(int A[], int start, int end) {
        if (end == 1) return new val(A[0], A[0], A[0], A[0]);
        val v1 = dac(A, start, end / 2);
        val v2 = dac(A, end / 2, end - end / 2);
        int l, m, r, s;

        l = Math.max(v1.l, v1.s + v2.l);
        m = Math.max(v1.r + v2.l, Math.max(v1.m, v2.m));
        r = Math.max(v2.r, v1.r + v2.s);
        s = v1.s + v2.s;
        return new val(l, m, r, s);
    }

    /**
     * 如上题:
     * divide and conquer(分而治之，各个击破)
     *  TODO
     * the idea is: for each sub array we calculate 4 values in O(1) time based on the
     * return values of its two halves. The meaning of the values:
         l: the sum of the sub array with largest sum starting from the first element
         m: the sum of the sub array with largest sum
         r: the sum of the sub array with largest sum ending at the last element
         s: the sum of the whole array
     * @param A
     * @return
     */
    public int maxSubArray2(int[] A){
        val v = dac(A,0,A.length);
        return v.m;
    }

    /**
     * Median of Two Sorted Arrays  (计算两个有序数组的中位数)
     * There are two sorted arrays A and B of size m and n respectively. Find the median of the
     * two sorted arrays. The overall run time complexity should be O(log (m+n)).  [时间效率]
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        int halfCount = (A.length + B.length) / 2;
        int lowA = 0, lowB = 0;
        int highA = A.length - 1, highB = B.length - 1;
        /*暂时默认升序*/
        while (halfCount-->0){
            //低端下标
            if(A[lowA] > B[lowB])
                lowB++;
            else
                lowA++;

            //高端下标
            if(A[highA] > B[highB])
                highA--;
            else
                highB--;

            //数据集中到一个数组中，怎么处理

        }
        return 0f;
    }

    class ItemValue{
        int value;
        int index;
        ItemValue(int index,int value){
            this.value =value;
            this.index =index;
        }
    }

    /**
     * Two Sum
     * The function twoSum should return indices of the two numbers such that they add up to
     * the target, where index1 must be less than index2. Please note that your returned
     * answers (both index1 and index2) are not zero-based.
     * 思路1:两次循环，求和并与目标值进行判断(不可取)
     * 思路2:封装所有元素，然后进行排序，从两端向中间逼近求和
     * 思路3:使用map存储当前下标值和下标的映射，然后扫描整个数组，查找向差值，如果找到则说明条件符合，时间效率O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        List<ItemValue> lessValueList = new ArrayList<ItemValue>();
        for (int i = 0; i < numbers.length; i++) {
            //需要考虑负数的情况~
            lessValueList.add(new ItemValue(i,numbers[i]));
        }
        Collections.sort(lessValueList,new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o1.value-o2.value;
            }
        });
        int low =0,high =lessValueList.size()-1;
        while(low<high){
            int sum = lessValueList.get(low).value + lessValueList.get(high).value;
            if(sum == target){
                int lowIndex = lessValueList.get(low).index;
                int highIndex = lessValueList.get(high).index;
                int [] ret = null;
                if(lowIndex<highIndex)
                    ret = new int[]{lowIndex+1,highIndex+1};
                else
                    ret = new int[]{highIndex+1,lowIndex+1};
                return ret;
            }
            if(sum < target)
                low++;
            else
                high--;
        }
        return null;
    }
    /*
        不适用现有的结构或者定义新的结构
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if(!m.keySet().contains(target-numbers[i])){
                m.put(numbers[i],i);
            }else{
                return new int [] {m.get(target-numbers[i])+1,i+1};
            }
        }
        return null;
    }

    /**
     * Best Time to Buy and Sell Stock II
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions
     * as you like (ie, buy one and sell one share of the stock multiple times). However, you
     * may not engage in multiple transactions at the same time (ie, you must sell the stock
     * before you buy again).
     * 我的思路:低买高卖，(波谷时买,波峰时卖) ,求所有升区间的最大值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int oneMax = 0, totalMax = 0;
        int begin = 0, end = 0;

        for (int i = 0; i < prices.length; i++) {
            end = i;
            int delta = prices[end] - prices[begin];
            if(delta > oneMax)
                oneMax = delta;
            else{
                totalMax += oneMax;
                oneMax = 0;
                begin = i;
            }
        }
        totalMax += oneMax;

        return totalMax;
    }

    //低价在前,高价在后  ,之间最大差值(其实就是求几个增区间的最大值)
    public int maxProfit1(int[] prices) {
        //两次扫描价目标就可以了,但是这是最次的办法
        int begin=0,end= 0 ,max=0,delta=0;
        for(int i=0;i<prices.length;i++){
            end = i;
            delta = prices[end]-prices[begin];
            if(delta <0){
                begin = i;
            }
            if(delta > max){
                max = delta;
            }
        }
        return max;
    }

    /*
    Search Insert Position
    Given a sorted array and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.
    我的思路:折半查找法,找到相应的插入位置
     */
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length - 1;
        if (target < A[low])
            return low;
        if (target > A[high])
            return high + 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == A[mid])
                return mid;
            if (A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }


    /*
    Sort Colors
    Given an array with n objects colored red, white or blue, sort them so that objects
     of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and
    blue respectively.
     */
    public void sortColors(int[] A) {
        final int red =0 , white =1 ,blue =2;
        int low =0,high = A.length-1;
        while (low < high) {

            while (A[low] == red && low <high)
                low++;
            while (A[high] == blue && low <high)
                high--;
            if(low>high)
                break;

            if(A[low] == blue || A[high] == red)
                swap(A,low,high);
            else{
                //扫描中间的数据段,把不符合要求的交换出来
                int tmp = low+1;
                while(tmp<high){
                    if (A[tmp] ==red){
                        swap(A,tmp,low);
                        break;
                    }else if(A[tmp] == blue){
                        swap(A,tmp,high);
                        break;
                    }
                    tmp++;
                }
                if(tmp>=high)
                    break;
            }

        }
    }
    /*
      从两端向中间遍历,把符合条件元交出去
      两个if是有先后顺序的
    */
    public void sortColors2(int[] A) {
        final int red =0 , blue =2;
        int zero =0, two = A.length-1;
        for (int i = zero; i <= two; i++) {
            if(A[i]==red){
                swap(A,i,zero);
                zero++;
            }
            if(A[i]==blue){
                swap(A,i,two);
                two--;
                i--;   //高位和地位交换后,需要与当前值重新判断
            }

        }
    }
    public void swap(int [] A,int left,int right){
        int tmp =A[left];
        A[left] = A[right];
        A[right] = tmp;

    }


    /**
     * Container With Most Water
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     *
     * Find two lines, which together with x-axis forms a container, such that the container contains the
     * most water.
     *
     * 最傻的办法还是两次循环,求最大值
     * @param height
     * @return
     */

    public int maxArea(int[] height) {
  /*    超时
        int maxArea =0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int tmpArea = Math.min(height[i],height[j])*(j-i);
                if(tmpArea >maxArea)
                    maxArea = tmpArea;
            }
        }
        return maxArea;*/
        int left =0 ,right = height.length-1;
        int maxArea =0;
        while(left<right){
            int tmpArea = (right-left)*Math.min(height[right],height[left]);
            if(tmpArea>maxArea)
                maxArea = tmpArea;
            if(height[left] > height[right])
                right--;
            else
                left ++;
       }
        return maxArea;
    }

    /**
     * 方阵的顺时针旋转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length =matrix.length;
        int slen = length/2;
        int n =length;
      /*  for (int i = 0; i < slen; i++) {
            for (int j = 0; j < slen; j++) {
                //四个位置进行交换
                int tmp = matrix[i][j];  //(0,1)
                matrix[i][j] = matrix[length-1-j][i];  // (0,1) <- (2,0)
                matrix[length-1-j][i] = matrix[length-1-j][length-1-i];  //(2,0)  <- (2,3)
                matrix[length-1-j][length-1-i] = matrix[j][length-1-i];  //(2,3)  <- (1,3)
                matrix[j][length-1-i] = tmp;       //(1,3) <- (0,1)
            }
        }
        if(length%2!=0){
            //轴线上的数据进行交换
            for (int i = 0; i < slen; i++) {
                int tmp = matrix[i][slen];
                matrix[i][slen] = matrix[slen][i];
                matrix[slen][i] = matrix[length-1-i][slen];
                matrix[length-1-i][slen] = matrix[slen][length-1-i];
                matrix[slen][length-1-i] = tmp;
            }
        }*/
        /*图像肢解有问题,应该以同心圆的形式,逐层移动数据*/
        for( int i=0; i<slen; i++ ){
            int low=i, high=n-i-1;  //这两个值初始化很关键
            for (int j=low; j<high; j++){   //关键是不能相等,否则某些元素移动了多次
                int tmp;
                System.out.printf("(%d,%d)", i, j);
                tmp = matrix[i][j];
                // left to top
                matrix[i][j] = matrix[n-j-1][i];
                // bottom to left
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                // right to bottom
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                // top to right
                matrix[j][n-i-1] = tmp;
            }
        }
        System.out.println();
    }

    void printMartix(int [][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%02d ,",matrix[i][j]);
            }
            System.out.println();
        }

    }

}
