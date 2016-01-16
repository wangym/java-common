package type;

/**
 * @author chinawym@gmail.com
 * @since 2015-04-09
 */
public class Person {
    public static final String whatIsYourName = "My name is ";
    public static final String howOldAreYou = "I'm ";
    public static final String whereAreYouFrom = "I'm from ";
    private String name; // 姓名
    private SexEnum sex;
    protected String country = "china"; // 国家

    public void setName(String name) {
        this.name = name;
    }

    private String whatIsYourName() {
        return whatIsYourName + name;
    }

    private String howOldAreYou(int age) {
        return howOldAreYou + age;
    }

    private String whereAreYouFrom() {
        return whereAreYouFrom + country;
    }
}
