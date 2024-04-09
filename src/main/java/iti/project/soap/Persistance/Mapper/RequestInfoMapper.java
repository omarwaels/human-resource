package iti.project.soap.Persistance.Mapper;

import java.util.LinkedList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.RequestInfoDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Entity.Request;

@Mapper
public interface RequestInfoMapper {

    RequestInfoMapper INSTANCE = Mappers.getMapper(RequestInfoMapper.class);

    @Mapping(source = "request.details", target = "details")
    @Mapping(source = "request.title", target = "title")
    @Mapping(source = "request.status", target = "status")
    @Mapping(source = "request.requestId", target = "requestId")

    RequestInfoDTO createEventDtoToEvent(Request request);

    default List<RequestInfoDTO> mapEntitiesToDTOs(List<Request> entities) {
        List<RequestInfoDTO> res = new LinkedList<>();
        for (Request request : entities) {
            res.add(createEventDtoToEvent(request));
        }
        return res;
    }

}
