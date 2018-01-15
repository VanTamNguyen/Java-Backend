package com.tamco.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hainv_000 on 15/01/2018.
 */
public class StringUtilsTest {

    @Test
    public void testUpper() {
        String message = "Something I want to show you!";
        Assert.assertEquals("SOMETHING I WANT TO SHOW YOU!", StringUtils.upper(message));
    }
}
