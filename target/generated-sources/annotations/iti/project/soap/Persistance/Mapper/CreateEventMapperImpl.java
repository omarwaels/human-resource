package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.Entity.Events;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class CreateEventMapperImpl implements CreateEventMapper {

    @Override
    public Events createEventDtoToEvent(CreateEventDTO createEventDTO) {
        if ( createEventDTO == null ) {
            return null;
        }

        Events events = new Events();

        events.setEventName( createEventDTO.getEventName() );
        events.setAddress( createEventDTO.getAddress() );
        events.setStartDate( createEventDTO.getStartDate() );
        events.setEndDate( createEventDTO.getEndDate() );

        return events;
    }
}
