package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface RegisterEmployerMapper {

    RegisterEmployerMapper INSTANCE = Mappers.getMapper(RegisterEmployerMapper.class);

    @Mapping(source = "employerRegisterDTO.firstName", target = "firstName")
    @Mapping(source = "employerRegisterDTO.lastName", target = "lastName")
    @Mapping(source = "employerRegisterDTO.email", target = "email")
    @Mapping(source = "employerRegisterDTO.address", target = "address")
    @Mapping(source = "employerRegisterDTO.phoneNum", target = "phoneNum")
    @Mapping(source = "employerRegisterDTO.password", target = "password")

    Employer registerEmployerToEmployer(EmployerRegisterDTO employerRegisterDTO);

}
