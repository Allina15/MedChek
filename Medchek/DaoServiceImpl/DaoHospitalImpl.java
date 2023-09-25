package Medchek.DaoServiceImpl;

import Medchek.Dao;
import Medchek.DaoService.HospitalDao;
import Medchek.Model.Hospital;
import Medchek.Model.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class DaoHospitalImpl implements HospitalDao {
    private final Dao dao;

    public DaoHospitalImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        List<Hospital> newHospital=dao.getHospitals();
        for(Hospital hospital1:newHospital) {
            if (hospital1.equals(hospital)) {
                return "Already exist";
            }
        }
        newHospital.add(hospital);
        dao.setHospitals(newHospital);
        System.out.println(newHospital);
        return "Added";

    }

    @Override
    public Hospital findHospitalById(Long id) {
        for(Hospital hospital:dao.getHospitals()) {
            if (hospital.getInstanceId() == id) {
                return hospital;
            }
        }
        throw new NoSuchElementException("Hospital not found by this id: "+id);

    }


    @Override
    public List<Hospital> getAllHospital() {
        return dao.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return dao.getHospitals().stream()
                .filter(hospital -> hospital.getInstanceId() == id)
                .findFirst()
                .map(Hospital::getPatients)
                .orElse(null);
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> hospitals = dao.getHospitals();
        for (int i = 0; i < hospitals.size(); i++) {
            if (hospitals.get(i).getInstanceId() == id) {
                hospitals.remove(i);
                return "Deleted the hospital by ID: "+id;
            }
        }
        throw new NoSuchElementException("Hospital with ID " + id + " not found");
    }


    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> map=new HashMap<>();
        for(Hospital hospital:dao.getHospitals()){
            String add=hospital.getAddress();
            if(add.contains(address)){
                map.put(address,hospital);
            }
        }
        return map;
    }
}
