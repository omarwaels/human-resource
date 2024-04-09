package iti.project.soap.Persistance.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEventDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;

@Mapper
public interface UpdateEventMapper {

    UpdateEventMapper INSTANCE = Mappers.getMapper(UpdateEventMapper.class);

    @Mapping(source = "updateEventMapper.address", target = "address")
    @Mapping(source = "updateEventMapper.startDate", target = "startDate")
    @Mapping(source = "updateEventMapper.endDate", target = "endDate")
    Events createEventDtoToEvent(UpdateEventDTO updateEventMapper);

}
