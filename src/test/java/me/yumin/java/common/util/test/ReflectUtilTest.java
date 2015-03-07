package me.yumin.java.common.util.test;

import me.yumin.java.common.util.ReflectUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yumin
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
    public void testInvokeMethod() throws Exception {
        String whatIsYourName = null;
        String whereAreYouFrom = null;
        String howOldAreYou = null;
        String name = "yumin";
        String country = null;
        int age = 18;
        Person person = new Person();

        if (ReflectUtil.setFieldValue(person, "name", name)) {
            country = (String) ReflectUtil.getFieldValue(person, "country");
            whatIsYourName = (String) ReflectUtil.invokeMethod(person, "whatIsYourName", null, null);
            whereAreYouFrom = (String) ReflectUtil.invokeMethod(person, "whereAreYouFrom", null, null);
            howOldAreYou = (String) ReflectUtil.invokeMethod(person, "howOldAreYou", new Class[]{int.class}, new Object[]{age});
        }

        Assert.assertEquals(Person.whatIsYourName + name, whatIsYourName);
        Assert.assertEquals(Person.whereAreYouFrom + country, whereAreYouFrom);
        Assert.assertEquals(Person.howOldAreYou + age, howOldAreYou);
    }

    /**
     * 测试用类
     */
    public class Person {

        public static final String whatIsYourName = "My name is ";
        public static final String whereAreYouFrom = "I'm from ";
        public static final String howOldAreYou = "I'm ";
        private String name; // 姓名
        protected String country = "china"; // 国家

        public void setName(String name) {
            this.name = name;
        }

        private String whatIsYourName() {
            return whatIsYourName + name;
        }

        private String whereAreYouFrom() {
            return whereAreYouFrom + country;
        }

        private String howOldAreYou(int age) {
            return howOldAreYou + age;
        }
    }
}
