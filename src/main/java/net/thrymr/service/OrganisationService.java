package net.thrymr.service;

import net.thrymr.dto.OrganisationDto;

import java.util.List;

public interface OrganisationService {
    List<OrganisationDto> findAll();
    OrganisationDto findById(Long id);


    OrganisationDto saveOrg(OrganisationDto dto);

    OrganisationDto updateOrg(OrganisationDto dto,Long id);

    void  deleteOrg(Long id);

}
