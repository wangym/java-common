package me.yumin.java.common.util.test;

import me.yumin.java.common.util.PrivateKeeper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author xuanyin
 * @since 2015-03-02 14:53
 */
public class PrivateKeeperTest {

    @Test
    public void testGetFieldValueForPrivate() throws Exception {
        String fieldName = "name";
        String fieldValue = "yumin";

        Person person = new Person();
        person.setName(fieldValue);
        String result = (String) PrivateKeeper.getFieldValue(person, fieldName);

        System.out.println("[testGetFieldValueForPrivate]" + result);
        Assert.assertEquals(fieldValue, result);
    }

    @Test
    public void testGetFieldValueForProtected() throws Exception {
        String fieldName = "country";
        String fieldValue = "china";

        Person person = new Person();
        String result = (String) PrivateKeeper.getFieldValue(person, fieldName);

        System.out.println("[testGetFieldValueForProtected]" + result);
        Assert.assertEquals(fieldValue, result);
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
