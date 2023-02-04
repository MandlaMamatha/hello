package net.thrymr.service.impl;

import net.thrymr.dto.EmployeeDto;
import net.thrymr.entity.Employee;
import net.thrymr.entity.Organisation;
import net.thrymr.repository.EmployeeRepository;
import net.thrymr.repository.OrganisationRepository;
import net.thrymr.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository repository;
    public OrganisationRepository organisationRepository;
    public ModelMapper modelMapper;
    @Override
    public List<EmployeeDto> findAll() {
       List<Employee> employees= repository.findAll();
       return employees.stream().map(e->modelMapper.map(e, EmployeeDto.class))
               .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long id) {
        Optional<Employee> emp= repository.findById(id);
        return emp.map(this::entityToDto).orElse(null);
    }

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
    @Override
    public EmployeeDto saveEmp(EmployeeDto dto, Long orgId) {
        Optional<Organisation> organisation= organisationRepository.findById(orgId);
        if(organisation.isPresent()){

            Employee employee= new Employee();
            employee.setSNo(dto.getSNo());
            employee.setEmpId(dto.getEmpId());
            employee.setEmpName(dto.getEmpName());
            employee.setEmpEmail(dto.getEmpEmail());
            employee.setDateOfJoining(dto.getDateOfJoining());
            employee.setDateOfBirth(dto.getDateOfBirth());
            employee.setOrgId(orgId);
            repository.save(employee);
            return entityToDto(employee);

        }else return null;

    }
    @Override
    public List<EmployeeDto> saveAllEmp(List<EmployeeDto> dtos,Long orgId) {
        List<Employee> employeeList= new ArrayList<>();
        Employee employee;

        for (EmployeeDto employeeDto:dtos){
            Optional<Organisation> organisation= organisationRepository.findById(orgId);
            if(organisation.isPresent()){

                employee= new Employee();
                employee.setSNo(employeeDto.getSNo());
                employee.setEmpId(employeeDto.getEmpId());
                employee.setEmpName(employeeDto.getEmpName());
                employee.setEmpEmail(employeeDto.getEmpEmail());
                employee.setDateOfJoining(employeeDto.getDateOfJoining());
                employee.setDateOfBirth(employeeDto.getDateOfBirth());
                employee.setOrgId(orgId);

               employeeList.add(employee);

            }else return null;
        }
        List<Employee> emp=repository.saveAll(employeeList);
        return entityToDto(emp);
    }

    @Override
    public EmployeeDto updateEmp(EmployeeDto employeeDTO, Long id) {
        Employee empData = dtoToEntity(employeeDTO);
        repository.save(empData);
        return  entityToDto(empData);
    }

    @Override
    public void deleteEmp(Long id) {
        repository.deleteById(id);
    }



    @Override
    public String deleteAllEmp(List<EmployeeDto> employeeDTOList) {
        List<Employee> empData = dtoToEntity(employeeDTOList);
        repository.deleteAll(empData);
        entityToDto(empData);
        return "Successfully deleted all entities  which has been passed as request data";
    }




    public EmployeeDto entityToDto(Employee empData){
        return modelMapper.map(empData, EmployeeDto.class);
    }
    public List<EmployeeDto> entityToDto(List<Employee> empData){
        return empData.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    public Employee dtoToEntity(EmployeeDto dto){
        return modelMapper.map(dto, Employee.class);
    }
    public List<Employee> dtoToEntity(List<EmployeeDto> dto){

        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
