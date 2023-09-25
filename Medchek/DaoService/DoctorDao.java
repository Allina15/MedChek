package Medchek.DaoService;

import Medchek.Model.Doctor;

import java.util.List;

public interface DoctorDao {
    Doctor findDoctorById(Long id);
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);

    String addDoctorToDepartment(Long id, List<Doctor> doctors);
}
