package Medchek.NodelServiceImpl;

import Medchek.DaoService.HospitalDao;
import Medchek.Model.Hospital;
import Medchek.Model.Patient;
import Medchek.ModelService.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    public HospitalDao hospitalDao;

    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDao.getAllHospitalByAddress(address);
    }
}
