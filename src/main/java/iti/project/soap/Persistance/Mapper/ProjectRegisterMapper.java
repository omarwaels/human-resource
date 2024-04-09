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
public interface ProjectRegisterMapper {

    ProjectRegisterMapper INSTANCE = Mappers.getMapper(ProjectRegisterMapper.class);

    @Mapping(source = "managerRegisterDTO.projectName", target = "projectName")
    @Mapping(source = "managerRegisterDTO.projectAddress", target = "address")
    Project registerManagerToProject(ManagerRegisterDTO managerRegisterDTO);

}
