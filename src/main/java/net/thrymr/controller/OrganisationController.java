package net.thrymr.controller;


import net.thrymr.dto.OrganisationDto;
import net.thrymr.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationController {

    @Autowired
    public OrganisationService service;

    @GetMapping("/organisation/all")
    public List<OrganisationDto> getAll(){
    return service.findAll();
    }

    @GetMapping("/organisation/id/{id}")
    public  OrganisationDto getById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    @PostMapping("/organisation/save")
    public OrganisationDto getSave(@RequestBody OrganisationDto dto){
        return service.saveOrg(dto);
    }

    @PutMapping("/organisation/update{id}")
    public OrganisationDto getUpdate(@RequestBody OrganisationDto dto,@PathVariable("id") Long id){
        return service.updateOrg(dto,id);
    }

    @DeleteMapping("/organisation/delete{id}")
    public void getDelete(@PathVariable("id") Long id){
        service.deleteOrg(id);
    }


}
