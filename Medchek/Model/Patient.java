package Medchek.Model;

public class Patient {
    public static int id;
    private final int instanceId;
    private final String name;
    private final String lastName;
    private final int age;
    private final Gender gender;

    public Patient(String name, String lastName, int age, Gender gender) {
        this.instanceId=id++;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Patient.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }
    public int getAge() {
        return age;
    }



    @Override
    public String toString() {
        return "Patient{" +
                "instanceId=" + instanceId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
