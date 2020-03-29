package com.cyr.algorithm;

import java.util.HashSet;
import java.util.Set;

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
    //滑动窗口 拿不重复的最长子串
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
}
