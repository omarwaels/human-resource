package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;

@Mapper
public interface CreateEventMapper {

    CreateEventMapper INSTANCE = Mappers.getMapper(CreateEventMapper.class);

    @Mapping(source = "createEventDTO.eventName", target = "eventName")
    @Mapping(source = "createEventDTO.address", target = "address")
    @Mapping(source = "createEventDTO.startDate", target = "startDate")
    @Mapping(source = "createEventDTO.endDate", target = "endDate")
    Events createEventDtoToEvent(CreateEventDTO createEventDTO);

}
