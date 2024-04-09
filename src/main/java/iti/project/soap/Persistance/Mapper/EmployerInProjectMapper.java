package iti.project.soap.Persistance.Mapper;

import java.util.LinkedList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;

@Mapper
public interface EmployerInProjectMapper {

    EmployerInProjectMapper INSTANCE = Mappers.getMapper(EmployerInProjectMapper.class);

    @Mapping(source = "employer.firstName", target = "firstName")
    @Mapping(source = "employer.lastName", target = "lastName")
    @Mapping(source = "employer.email", target = "email")
    @Mapping(source = "employer.address", target = "address")
    @Mapping(source = "employer.phoneNum", target = "phoneNum")
    @Mapping(source = "employer.employerProject.projectName", target = "projectName")
    EmployerInProjectDTO employerToEmployerInProjectDTO(Employer employer);

    default List<EmployerInProjectDTO> mapEntitiesToDTOs(List<Employer> entities) {
        List<EmployerInProjectDTO> res = new LinkedList<>();
        for (Employer employer : entities) {
            res.add(employerToEmployerInProjectDTO(employer));
        }
        return res;
    }

}
