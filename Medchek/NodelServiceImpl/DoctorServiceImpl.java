package Medchek.NodelServiceImpl;

import Medchek.Dao;
import Medchek.DaoService.DoctorDao;
import Medchek.Model.Department;
import Medchek.Model.Doctor;
import Medchek.Model.Hospital;
import Medchek.ModelService.DoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoctorServiceImpl implements DoctorService {
    public DoctorDao doctorDao;
    private final Dao dao;

    public DoctorServiceImpl(DoctorDao doctorDao, Dao dao) {
        this.doctorDao = doctorDao;
        this.dao = dao;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hospital : dao.getHospitals()) {
            List<Department> departments = hospital.getDepartments();
            for (Department dd : departments) {
                if (dd.getInstanceId() == departmentId) {
                    List<Doctor> doctors = dd.getDoctors();
                    List<Doctor> doctorsToAdd = new ArrayList<>();

                    for (Long doctorId : doctorsId) {
                        boolean doctorFound = false;
                        for (Doctor doctor : doctors) {
                            if (doctor.getInstanceId() == doctorId) {
                                doctorsToAdd.add(doctor);
                                doctorFound = true;
                                break;
                            }
                        }
                        if (!doctorFound) {
                            throw new NoSuchElementException("Not found");
                        }
                    }
                    dd.getDoctors().addAll(doctorsToAdd);
                    return "Doctors assigned to department successfully";
                }
            }
        }

        return "Department not found";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }

    @Override
    public String addDoctorToDepartment(Long id, List<Doctor> doctors) {
        return doctorDao.addDoctorToDepartment(id, doctors);
    }
}
