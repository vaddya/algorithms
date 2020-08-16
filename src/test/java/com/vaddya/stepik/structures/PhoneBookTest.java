package com.vaddya.stepik.structures;

import org.junit.Assert;
import org.junit.Test;

public class PhoneBookTest {

    @Test
    public void testPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        Assert.assertNull(phoneBook.find(3839442));
        phoneBook.add(123456, "me");
        phoneBook.add(0, "granny");
        Assert.assertEquals("granny", phoneBook.find(0));
        Assert.assertEquals("me", phoneBook.find(123456));
        phoneBook.del(0);
        phoneBook.del(0);
        Assert.assertNull(phoneBook.find(0));
    }
}
