package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.EventDataDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;

@Mapper
public interface EventDataDTOMapper {

    EventDataDTOMapper INSTANCE = Mappers.getMapper(EventDataDTOMapper.class);

    @Mapping(source = "event.eventName", target = "eventName")
    @Mapping(source = "event.project.projectName", target = "projectName")
    @Mapping(source = "event.address", target = "address")
    @Mapping(source = "event.startDate", target = "startDate")
    @Mapping(source = "event.endDate", target = "endDate")
    EventDataDTO EventToEventDataDTO(Events event);

}
