package com.cyr.algorithm;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Solution {
/*    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int carry=0;
        while(l1!=null||l2!=null)
        {
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;
            sum=sum%10;
            cur.next=new ListNode(sum);
            cur=cur.next;
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }
        }
        if(carry==1){
            cur.next=new ListNode(carry);
        }
        return result.next;
    }
    //滑动窗口 拿不重复的最长子串 m
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        Set<Character> set=new HashSet();
        int result=0,i=0,j=0; //i 滑动窗口左索引，j滑动窗口右索引
        while(i<length && j<length)
        {
            if(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i++));
            }
            else{
                set.add(s.charAt(j++));
                result=Math.max(result,j-i);
            }
        }
        return result;
    }
    public long findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length=nums1.length;
        int nums2Length=nums2.length;
        if(nums1Length==0)
        {
            if(nums1Length/2==0)
            {
                return (nums1[nums1Length/2]+nums1[nums1Length/2+1])/2;
            }
            else{
                return nums1[nums1Length/2+1];
            }
        }
        if(nums2Length==0)
        {

            if(nums2Length/2==0)
            {
                return (nums2[nums2Length/2]+nums2[nums2Length/2+1])/2;
            }
            else{
                return nums2[nums2Length/2+1];
            }
        }
        if((nums1Length+nums2Length)%2==1)//长度合为奇数
        {
            return find_kth(nums1,0,nums2,0,(nums1Length+nums2Length)/2+1);
        }
        else//长度合为偶数
        {
            return (find_kth(nums1,0,nums2,0,(nums1Length+nums2Length)/2)+find_kth(nums1,0,nums2,0,(nums1Length+nums2Length)/2+1))/2;
        }
    }
    //寻找a 和 b 数组中，第k个数字
    long find_kth(int[] a, int a_begin, int[] b, int b_begin, int k)
    {

        if(a_begin>=a.length)//递归进来的a的开始下标大于
        {
            return b[b_begin+k-1];
        }
        if(b_begin>=b.length)
        {
            return a[a_begin+k-1];
        }
        //k为1时，两数组最小的那个为第一个数 边界条件
        if (k == 1){
            return Math.min(a[a_begin], b[b_begin]);
        }
        int Acompare=Integer.MAX_VALUE;
        int Bcompare=Integer.MAX_VALUE;
        if(a_begin+k/2-1<a.length){
            Acompare=a[a_begin+k/2-1];
        }
        if(b_begin+k/2-1<b.length){
            Bcompare=b[b_begin+k/2-1];
        }
        if(Acompare<Bcompare) ////如果a数组的第 k / 2 个数小于b数组的第 k / 2 个数，表示总的第 k 个数位于 a的第k / 2个数的后半段，或者是b的第 k / 2个数的前半段
        //由于范围缩小了 k / 2 个数，此时总的第 k 个数实际上等于新的范围内的第 k - k / 2个数，依次递归
        {
            return find_kth(a,a_begin+k/2,b,b_begin,k-k/2);
        }
        else{
            return find_kth(a,a_begin,b,b_begin+k/2,k-k/2);
        }

    }
}
