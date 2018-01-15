package com.tamco.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by TamCO on 15/01/2018.
 */
public class StringUtilsTest {

    @Test
    public void testUpper() {
        String message = "Something I want to show you!";
        Assert.assertEquals("SOMETHING I WANT TO SHOW YOU!", StringUtils.upper(message));
    }

    @Test
    public void testLower() {
        String message = "Something I want to show you!";
        Assert.assertEquals("something i want to show you!", StringUtils.lower(message));
    }

    @Test
    public void testEqualWithNull() {
        String str1 = null, str2 = null;
        Assert.assertTrue(StringUtils.equals(str1, str2));
    }

    @Test
    public void testEqualWithNotNull() {
        String str1 = "something", str2 = "something";
        Assert.assertTrue(StringUtils.equals(str1, str2));
    }

    @Test
    public void testNotEqualWithNull() {
        String str1 = null;
        String str2 = "Something";
        Assert.assertFalse(StringUtils.equals(str1, str2));
    }

    @Test
    public void testNotEqualWithNotNull() {
        String str1 = "something";
        String str2 = "something i want";
        Assert.assertFalse(StringUtils.equals(str1, str2));
    }
}
