package Medchek.ModelService;

import Medchek.Model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    String addDepartmentToHospital(Long id, Department... departments);
}
