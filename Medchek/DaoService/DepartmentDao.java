package Medchek.DaoService;

import Medchek.Model.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    String addDepartmentToHospital(Long id, Department... departments);
}
