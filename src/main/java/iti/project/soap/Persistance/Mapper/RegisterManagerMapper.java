package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface RegisterManagerMapper {

    RegisterManagerMapper INSTANCE = Mappers.getMapper(RegisterManagerMapper.class);

    @Mapping(source = "managerRegisterDTO.firstName", target = "firstName")
    @Mapping(source = "managerRegisterDTO.lastName", target = "lastName")
    @Mapping(source = "managerRegisterDTO.email", target = "email")
    @Mapping(source = "managerRegisterDTO.address", target = "address")
    @Mapping(source = "managerRegisterDTO.phoneNum", target = "phoneNum")
    @Mapping(source = "managerRegisterDTO.password", target = "password")

    Employer registerManagerToEmployer(ManagerRegisterDTO managerRegisterDTO);

}
