package net.thrymr.controller;

import net.thrymr.dto.EmployeeDto;

import net.thrymr.entity.EmployeeRequest;
import net.thrymr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

@Autowired
    public EmployeeService service;



    @GetMapping("/organisation/emp/all")
  public List<EmployeeDto> getEmpAll(){
        return service.findAll();
    }
    @GetMapping("/organisation/emp-id/{id}")
    public EmployeeDto getById(@PathVariable("id") Long id){
        return service.findById(id);
    }


//    @PostMapping("/organisation/emp/save")
//    public EmployeeDto getSave(@RequestBody EmployeeRequest dto){
//        return  service.saveEmp(dto);
//    }
//
//    @PostMapping("/organisation/emp/save-all")
//    public List<EmployeeDto> getSave(@RequestBody List<EmployeeRequest> dtos){
//        return  service.saveAllEmp(dtos);
//    }
    @PostMapping("/organisation/emp/save/{id}")
    public EmployeeDto getSave(@RequestBody EmployeeDto dto,@PathVariable Long id){
        return  service.saveEmp(dto,id);
    }

    @PostMapping("/organisation/emp/save-all/{id}")
    public List<EmployeeDto> getSave(@RequestBody List<EmployeeDto> dtos,@PathVariable Long id){
        return  service.saveAllEmp(dtos,id);
    }

    @PutMapping("/organisation/emp/update/{id}")
    public EmployeeDto getUpdate(@RequestBody EmployeeDto dto,@PathVariable("id") Long id){
        return service.updateEmp(dto,id);
    }

    @DeleteMapping("/organisation/emp/delete/{id}")
    public void getDelete(@PathVariable("id") Long id){
        service.deleteEmp(id);
    }
    @DeleteMapping("/organisation/emp/delete/all")
    public String getDeleteAll(@RequestBody List<EmployeeDto> dtoList){
        return service.deleteAllEmp(dtoList);
    }


}
