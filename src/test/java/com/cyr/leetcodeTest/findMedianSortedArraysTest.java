package com.cyr.leetcodeTest;

import com.cyr.algorithm.Solution;
import com.cyr.algorithm.SpringConfigure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)// SpringJUnit支持，由此引入Spring-Test框架支持！
@ContextConfiguration(classes = {SpringConfigure.class})
public class findMedianSortedArraysTest {
    @Autowired
    private Solution solution;
    @Test
    public void test()
    {
        int nums1[]={1,2};
        int nums2[]={3,4};
        System.out.println (solution.findMedianSortedArrays (nums1,nums2));
        Assert.assertEquals ("","");
    }
}
