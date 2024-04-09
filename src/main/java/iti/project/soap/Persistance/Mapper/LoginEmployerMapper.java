package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface LoginEmployerMapper {

    LoginEmployerMapper INSTANCE = Mappers.getMapper(LoginEmployerMapper.class);

    @Mapping(source = "employer.employerId", target = "employerId")
    @Mapping(source = "employer.firstName", target = "firstName")
    @Mapping(source = "employer.lastName", target = "lastName")
    @Mapping(source = "employer.email", target = "email")
    @Mapping(source = "employer.address", target = "address")
    @Mapping(source = "employer.phoneNum", target = "phoneNum")
    @Mapping(source = "employer.humanResourceId.firstName", target = "managerName")
    @Mapping(source = "employer.employerProject.projectName", target = "projectName")
    @Mapping(source = "employer.employerProject.projectId", target = "projectId")
    EmployerLoginDTO employerToLoginDTO(Employer employer);

}
