package net.thrymr.service.impl;

import net.thrymr.dto.OrganisationDto;
import net.thrymr.entity.Organisation;
import net.thrymr.repository.OrganisationRepository;
import net.thrymr.service.OrganisationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganisationSeriveImpl implements OrganisationService {
    @Autowired
    public OrganisationRepository repository;

    @Autowired
    public ModelMapper modelMapper;


    @Override
    public List<OrganisationDto> findAll() {
        return repository.findAll().stream().
                map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public OrganisationDto findById(Long id) {
        Optional<Organisation> organisation=repository.findById(id);
        return organisation.map(this::entityToDto).orElse(null);

    }

    @Override
    public OrganisationDto saveOrg(OrganisationDto dto) {
        Organisation organisation=dtoToEntity(dto);
        repository.save(organisation);
        return entityToDto(organisation);
    }

    @Override
    public OrganisationDto updateOrg(OrganisationDto dto, Long id) {
        Organisation organisation=dtoToEntity(dto);
        repository.save(organisation);
        return entityToDto(organisation);
    }

    @Override
    public void deleteOrg(Long id) {
       repository.deleteById(id);
    }





    public OrganisationDto entityToDto(Organisation organisation){
        return modelMapper.map(organisation, OrganisationDto.class);
    }
    public List<OrganisationDto> entityToDto(List<Organisation> organisations){
        return organisations.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    public Organisation dtoToEntity(OrganisationDto dto){
        return modelMapper.map(dto, Organisation.class);
    }
    public List<Organisation> dtoToEntity(List<OrganisationDto> dto){

        return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
