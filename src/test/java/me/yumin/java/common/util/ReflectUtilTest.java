package me.yumin.java.common.util;

import org.junit.Assert;
import org.junit.Test;
import pojo.Person;
import pojo.SexEnum;

/**
 * @author chinawym@gmail.com
 * @since 2015-03-02 14:53
 */
public class ReflectUtilTest {
    @Test
    public void testGetFieldValueForPrivate() throws Exception {
        String fieldValue = "yumin";
        Person person = new Person();
        person.setName(fieldValue);

        String result = (String) ReflectUtil.getFieldValue(person, "name");

        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testGetFieldValueForProtected() throws Exception {
        String result = (String) ReflectUtil.getFieldValue(new Person(), "country");

        Assert.assertEquals("china", result);
    }

    @Test
    public void testSetFieldValue() throws Exception {
        String result = null;
        String fieldName = "name";
        String fieldValue = "yumin";
        Person person = new Person();

        if (ReflectUtil.setFieldValue(person, fieldName, fieldValue)) {
            result = (String) ReflectUtil.getFieldValue(person, fieldName);
        }

        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testGetAndSetFieldValue() throws Exception {
        SexEnum result = null;
        String fieldName = "sex";
        SexEnum fieldValue = SexEnum.MALE;
        Person person = new Person();

        if (ReflectUtil.setFieldValue(person, fieldName, fieldValue)) {
            result = (SexEnum) ReflectUtil.getFieldValue(person, fieldName);
        }

        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testInvokeMethod() throws Exception {
        String whatIsYourName = null;
        String howOldAreYou = null;
        String whereAreYouFrom = null;
        String name = "yumin";
        int age = 18;
        String country = null;
        Person person = new Person();

        if (ReflectUtil.setFieldValue(person, "name", name)) {
            whatIsYourName = (String) ReflectUtil.invokeMethod(person, "whatIsYourName", null, null);
            howOldAreYou = (String) ReflectUtil.invokeMethod(person, "howOldAreYou", new Class[]{int.class}, new Object[]{age});
            country = (String) ReflectUtil.getFieldValue(person, "country");
            whereAreYouFrom = (String) ReflectUtil.invokeMethod(person, "whereAreYouFrom", null, null);
        }

        Assert.assertEquals(Person.whatIsYourName + name, whatIsYourName);
        Assert.assertEquals(Person.howOldAreYou + age, howOldAreYou);
        Assert.assertEquals(Person.whereAreYouFrom + country, whereAreYouFrom);
    }

    @Test
    public void testInvokeMethodPlusForInt() throws Exception {
        int age = 18;
        Person person = new Person();

        String howOldAreYou = (String) ReflectUtil.invokeMethodPlus(person, "howOldAreYou", age);

        Assert.assertEquals(Person.howOldAreYou + age, howOldAreYou);
    }

    @Test
    public void testInvokeMethodPlusForString() throws Exception {
        String name = "xuanyin";
        Person person = new Person();

        ReflectUtil.invokeMethodPlus(person, "setName", name);
        String whatIsYourName = (String) ReflectUtil.invokeMethodPlus(person, "whatIsYourName");

        Assert.assertEquals(Person.whatIsYourName + name, whatIsYourName);
    }
}
