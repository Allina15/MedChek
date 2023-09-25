package Medchek.DaoServiceImpl;

import Medchek.Dao;
import Medchek.DaoService.DoctorDao;
import Medchek.Model.Department;
import Medchek.Model.Doctor;
import Medchek.Model.Hospital;

import java.util.List;

public class DaoDoctorImpl implements DoctorDao {
    private final Dao dao;

    public DaoDoctorImpl(Dao dao) {
        this.dao = dao;
    }


    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital hh : dao.getHospitals()) {
            for (Department dd : hh.getDepartments()) {
                if (dd.getInstanceId() == id) {
                    List<Doctor> doctors = dd.getDoctors();
                    for (Doctor doctor : doctors) {
                        if (doctor.getInstanceId() == id) {
                            return doctor;
                        }}}}}
        return null;
    }


    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital hospital : dao.getHospitals()) {
            if (hospital.getInstanceId() == id) {
                return hospital.getDoctors();
            }
        }
        return null;
    }


    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital hospital : dao.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getInstanceId() == id) {
                    return department.getDoctors();
                }}}
        return null;
    }


    @Override
    public String addDoctorToDepartment(Long id, List<Doctor> doctors) {
        for (Hospital hospital : dao.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getInstanceId() == id) {
                    List<Doctor> doctors1 = department.getDoctors();
                    if (!doctors1.equals(doctors)) {
                        doctors1.addAll(doctors);
                        hospital.getDoctors().addAll(doctors);
                        System.out.println(dao.getHospitals());
                        return "Added";
                    }}}}
        return "Already exist";
    }
}
