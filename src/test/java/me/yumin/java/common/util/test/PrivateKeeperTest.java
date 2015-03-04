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
    public void testGetFieldValue() throws Exception {
        String fieldName = "name";
        String fieldValue = "yumin";
        Person person = new Person();
        person.setName(fieldValue);
        String result = (String) PrivateKeeper.getFieldValue(person, fieldName);

        System.out.println(result);
        Assert.assertEquals(fieldValue, result);
    }

    /**
     * 测试用类
     */
    public class Person {

        private String name; // 姓名

        public void setName(String name) {
            this.name = name;
        }

        private String hello() {
            return new StringBuilder("My name is").append(name).toString();
        }
    }
}
