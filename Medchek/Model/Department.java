package Medchek.Model;

import java.util.List;

public class Department {
        public static int id;
        private int instanceId;

        private final String departmentName;
        private final List<Doctor> doctors;

        public Department(String departmentName, List<Doctor> doctors) {
            this.instanceId = id++;
            this.departmentName = departmentName;
            this.doctors = doctors;
        }

        public static int getId() {
            return id;
        }

        public static void setId(int id) {
            Department.id = id;
        }

        public int getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(int instanceId) {
            this.instanceId = instanceId;
        }

        public String getDepartmentName() {
            return departmentName;
        }
        public List<Doctor> getDoctors() {
            return doctors;
        }



        @Override
        public String toString() {
            return "Department{" +
                    "instanceId=" + instanceId +
                    ", departmentName='" + departmentName + '\'' +
                    ", doctors=" + doctors +
                    '}';
        }
    }
