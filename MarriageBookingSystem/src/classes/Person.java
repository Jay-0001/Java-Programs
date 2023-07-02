package classes;

public class Person {
    private int applicationId;
    private String name;
    private int age;
    private String sex;
    public Person() {

    }
    public Person(int applicationId, String name, int age, String sex) {
        this.applicationId = applicationId;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "applicationId=" + applicationId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
