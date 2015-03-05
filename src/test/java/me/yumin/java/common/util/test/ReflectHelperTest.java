package me.yumin.java.common.util.test;

import me.yumin.java.common.util.ReflectHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yumin
 * @since 2015-03-02 14:53
 */
public class ReflectHelperTest {

    @Test
    public void testGetFieldValueForPrivate() throws Exception {
        String fieldName = "name";
        String fieldValue = "yumin";
        Person person = new Person();
        person.setName(fieldValue);

        String result = (String) ReflectHelper.getFieldValue(person, fieldName);

        System.out.println("[testGetFieldValueForPrivate]" + result);
        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testGetFieldValueForProtected() throws Exception {
        String fieldName = "country";
        String fieldValue = "china";

        String result = (String) ReflectHelper.getFieldValue(new Person(), fieldName);

        System.out.println("[testGetFieldValueForProtected]" + result);
        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testSetFieldValue() throws Exception {
        String result = null;
        String fieldName = "name";
        Object fieldValue = "yumin";
        Person person = new Person();

        if (ReflectHelper.setFieldValue(person, fieldName, fieldValue)) {
            result = (String) ReflectHelper.getFieldValue(person, fieldName);
        }

        System.out.println("[testSetFieldValue]" + result);
        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testInvokeMethod() throws Exception {
        String whatIsYourName = null;
        String whereAreYouFrom = null;
        String fieldName = "name";
        Object fieldValue = "yumin";
        Person person = new Person();

        if (ReflectHelper.setFieldValue(person, fieldName, fieldValue)) {
            whatIsYourName = (String) ReflectHelper.invokeMethod(person, "whatIsYourName", null, null);
            whereAreYouFrom = (String) ReflectHelper.invokeMethod(person, "whereAreYouFrom", null, null);
        }

        System.out.println("[testInvokeMethod.whatIsYourName]" + whatIsYourName);
        System.out.println("[testInvokeMethod.whereAreYouFrom]" + whereAreYouFrom);
        Assert.assertEquals("My name is " + fieldValue, whatIsYourName);
    }

    /**
     * 测试用类
     */
    public class Person {

        private String name; // 姓名
        protected String country = "china"; // 国家

        public void setName(String name) {
            this.name = name;
        }

        private String whatIsYourName() {
            return "My name is " + name;
        }

        private String whereAreYouFrom() {
            return "I'm from " + country;
        }
    }
}
