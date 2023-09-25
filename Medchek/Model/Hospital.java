package Medchek.Model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public static int id;
    private final int instanceId;
    private final String hospitalName;

    private final String address;
    private final List<Department> departments;
    private final List<Doctor> doctors;
    private final List<Patient> patients;

    public Hospital(String hospitalName, String address, List<Department> departments) {
        this.instanceId=id++;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Hospital.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }
    public String getAddress() {
        return address;
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public List<Patient> getPatients() {
        return patients;
    }




    @Override
    public String toString() {
        return "Hospital{" +
                "instanceId=" + instanceId +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
