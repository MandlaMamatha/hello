package net.thrymr.service;

import net.thrymr.dto.EmployeeDto;


import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);


    //    @Override
    //    public EmployeeDto saveEmp(EmployeeRequest dto) {
    //        Optional<Organisation> organisation= organisationRepository.findById(dto.getOrgId());
    //        if(organisation.isPresent()){
    //
    //            Employee employee= new Employee();
    //            employee.setSNo(dto.getSNo());
    //            employee.setEmpId(dto.getEmpId());
    //            employee.setEmpName(dto.getEmpName());
    //            employee.setEmpEmail(dto.getEmpEmail());
    //            employee.setDateOfJoining(dto.getDateOfJoining());
    //            employee.setDateOfBirth(dto.getDateOfBirth());
    //            employee.setOrganisation(organisation.get());
    //            repository.save(employee);
    //            return entityToDto(employee);
    //
    //        }else return null;
    //
    //    }
    //    @Override
    //    public List<EmployeeDto> saveAllEmp(List<EmployeeRequest> dtos) {
    //        List<Employee> employeeList= new ArrayList<>();
    //        Employee employee;
    //
    //        for (EmployeeRequest employeeDto:dtos){
    //            Optional<Organisation> organisation= organisationRepository.findById(employeeDto.getOrgId());
    //            if(organisation.isPresent()){
    //
    //                employee= new Employee();
    //                employee.setSNo(employee.getSNo());
    //                employee.setEmpId(employeeDto.getEmpId());
    //                employee.setEmpName(employeeDto.getEmpName());
    //                employee.setEmpEmail(employeeDto.getEmpEmail());
    //                employee.setDateOfJoining(employeeDto.getDateOfJoining());
    //                employee.setDateOfBirth(employeeDto.getDateOfBirth());
    //                employee.setOrganisation(organisation.get());
    //
    //                employeeList.add(employee);
    //
    //            }else return null;
    //        }
    //        List<Employee> emp=repository.saveAll(employeeList);
    //        return entityToDto(emp);
    //    }
    EmployeeDto saveEmp(EmployeeDto dto, Long orgId);

    List<EmployeeDto> saveAllEmp(List<EmployeeDto> dtos,Long id);

    EmployeeDto updateEmp(EmployeeDto employeeDTO, Long id);

    void deleteEmp(Long id);

    String deleteAllEmp(List<EmployeeDto> employeeDTOList);
}
//    EmployeeDto saveEmp(EmployeeRequest dto);
//    List<EmployeeDto> saveAllEmp(List<EmployeeRequest> dtos);
//}
