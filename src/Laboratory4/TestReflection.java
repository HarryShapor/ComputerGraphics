package Laboratory4;

class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class TestReflection {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
