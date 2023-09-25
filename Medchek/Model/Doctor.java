package Medchek.Model;

public class Doctor {
    public static int id;
    private final int instanceId;
    private final String name;
    private final String lastName;
    private final Gender gender;
    private final int experienceYear;

    public Doctor( String name, String lastName, Gender gender, int experienceYear) {
        this.instanceId = id++;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Doctor.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "instance=" + instanceId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", experienceYear=" + experienceYear +
                '}';
    }
}

