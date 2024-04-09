package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;

@Mapper
public interface UncompletedAccMapper {

    UncompletedAccMapper INSTANCE = Mappers.getMapper(UncompletedAccMapper.class);

    @Mapping(source = "uncompletedAccDTO.email", target = "email")
    Employer UncompletedAccToEmployer(UncompletedAccDTO uncompletedAccDTO);

}
