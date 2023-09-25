package Medchek.DaoServiceImpl;

import Medchek.Dao;
import Medchek.DaoService.DepartmentDao;
import Medchek.Model.Department;
import Medchek.Model.Hospital;

import java.util.List;

public class DaoDepartmentImpl implements DepartmentDao {
    private final Dao dao;

    public DaoDepartmentImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for(Hospital hospital:dao.getHospitals()){
            if(hospital.getInstanceId()==id){
                return hospital.getDepartments();
            }
        }
        return null;
    }


    @Override
    public Department findDepartmentByName(String name) {
        for(Hospital hospital:dao.getHospitals()){
            for(Department department:hospital.getDepartments()){
                if(department.getDepartmentName().equals(name)){
                    return department;
                }
            }
        }
        return null;
    }



    @Override
    public String addDepartmentToHospital(Long id, Department... departments) {
        for (Hospital hospital : dao.getHospitals()) {
            if (hospital.getInstanceId() == id) {
                List<Department> hospitalDepartments = hospital.getDepartments();
                boolean allExist = true;

                for (Department department : departments) {
                    if (!hospitalDepartments.contains(department)) {
                        hospitalDepartments.add(department);
                        allExist = false;
                    }
                }
                if (!allExist) {
                    for (int i = 0; i < hospitalDepartments.size(); i++) {
                        hospitalDepartments.get(i).setInstanceId(i);
                    }
                    System.out.println(dao.getHospitals());
                    return "Added";
                }}}
        return "Already exist";
    }

}
