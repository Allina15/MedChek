package Medchek.NodelServiceImpl;

import Medchek.Dao;
import Medchek.DaoService.PatientDao;
import Medchek.Model.Hospital;
import Medchek.Model.Patient;
import Medchek.ModelService.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    public PatientDao patientDao;

    private final Dao dao;

    public PatientServiceImpl(PatientDao patientDao, Dao dao) {
        this.patientDao = patientDao;
        this.dao=dao;

    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : dao.getHospitals()) {
            patients.addAll(hospital.getPatients());
            patients.sort((o1, o2) -> ascOrDesc.equals("1") ? o1.getAge() - o2.getAge() : o2.getAge() - o1.getAge());

        }
        return patients;
    }
}
