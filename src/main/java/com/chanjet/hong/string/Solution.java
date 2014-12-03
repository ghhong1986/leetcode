/* 
 * Copyright 畅捷通股份有限公司  @ 2014 版权所有    
 */
package com.chanjet.hong.string;

import java.util.*;

/**
 * <p>
 * TODO 这个文件的描述
 * </p>
 *
 * @author 洪光华 </br>
 * @Email honggh@chanjet.com
 * @date 2014年11月15日 下午7:33
 */
public class Solution {


    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int extra = 0;
        for (int i = 1; i <= Math.max(a.length(), b.length()); i++) {
            //三个数的代码之和
            int ta = 0, tb = 0;
            if (i <= a.length())
                ta = a.charAt(a.length() - i) - '0';
            if (i <= b.length())
                tb = b.charAt(b.length() - i) - '0';
            extra = extra + ta + tb;
            if (extra >= 2) {
                sb.append(extra - 2);
                extra = 1;
            } else {
                sb.append(extra);
                extra = 0;
            }
        }
        if (extra == 1)
            sb.append('1');
        sb.reverse();
        return sb.toString();
    }

    public int atoi(String str) {
        if(str.isEmpty())
            return 0;
        return Integer.valueOf(str);
    }

    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     1, 11, 21, 1211, 111221, ...

     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth sequence.
     */
    public String countAndSay(int n) {
        if (n<=0) return "";
        if (n==1) return "1";
        String ret="1";
        for (int i = 2; i <= n; i++) {
            ret = getNext(ret);
        }
        return ret;
    }

    String getNext(String str){
        StringBuffer sb = new StringBuffer();
        char [] data = String.valueOf(str).toCharArray();
        int count = 1;
        for (int i = 0; i < data.length-1; i++) {
            if(data[i]==data[i+1])
                count++;
            else{
                sb.append(count).append(data[i]);
                count = 1;
            }
        }
        sb.append(count).append(data[data.length - 1]);
        return sb.toString();
    }

    /**
     * Longest Common Prefix
     * Write a function to find the longest common prefix string amongst an array of strings.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++)
            list.add(strs[i]);
        Collections.sort(list);
        String first = list.get(0);
        String last = list.get(strs.length - 1);
        int commonLength = 0;
        for (int i = 0; i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i); i++)
            commonLength++;
        return first.substring(0, commonLength);
    }

    /**
     * Roman to Integer
     * Given a roman numeral, convert it to an integer.
     * Input is guaranteed to be within the range from 1 to 3999.
     * .        .             .
     * I  V     X       L     C     D     M
     * 1  5    10       50    100   500   1000
     * 罗马数字构成共有五条规则
     * 1.基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；
     * 放在大数的左边只能用一个。
     * 2.不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；
     * 放在大数的右边采用相加的方式构成数目，只能使用一个
     * 3.V 和X 左边的小数字只能用Ⅰ
     * 4.L 和C 左边的小数字只能用X
     * 5.D 和M 左边的小数字只能用C
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int [] values = new int[]{1,5,10,50,100,500,1000};
        char [] symbols = new char[]{'I','V','X','L','C','D','M'};
        Map<Integer,String> value2Symobl = new HashMap<Integer,String>();
        Map<String,Integer> symbol2value = new HashMap<String,Integer>();
        for (int i = 0; i < values.length; i++){
            value2Symobl.put(values[i],String.valueOf(symbols[i]));
            symbol2value.put(String.valueOf(symbols[i]),values[i]);
        }
        int  value=0;
        char [] schar =s.toCharArray();
        for (int i = 0; i < schar.length; i++) {
            //...
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String c1 = sl.getNext("1");
        System.out.printf("%s\n",c1);
    }
}
