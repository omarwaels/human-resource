package iti.project.soap.Persistance.Mapper;

import java.util.LinkedList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerGeneralInfoDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface EmployerGeneralInfoMapper {

    EmployerGeneralInfoMapper INSTANCE = Mappers.getMapper(EmployerGeneralInfoMapper.class);

    @Mapping(source = "employer.firstName", target = "firstName")
    @Mapping(source = "employer.lastName", target = "lastName")
    @Mapping(source = "employer.email", target = "email")
    @Mapping(source = "employer.address", target = "address")
    @Mapping(source = "employer.phoneNum", target = "phoneNum")

    EmployerGeneralInfoDTO employerToGeneralDTO(Employer employer);

    default List<EmployerGeneralInfoDTO> mapEntitiesToDTOs(List<Employer> entities) {
        List<EmployerGeneralInfoDTO> res = new LinkedList<>();
        for (Employer employer : entities) {
            res.add(employerToGeneralDTO(employer));
        }
        return res;
    }

}
