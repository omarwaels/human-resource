package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.UpdateEventDTO;
import iti.project.soap.Persistance.Entity.Events;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UpdateEventMapperImpl implements UpdateEventMapper {

    @Override
    public Events createEventDtoToEvent(UpdateEventDTO updateEventMapper) {
        if ( updateEventMapper == null ) {
            return null;
        }

        Events events = new Events();

        events.setAddress( updateEventMapper.getAddress() );
        events.setStartDate( updateEventMapper.getStartDate() );
        events.setEndDate( updateEventMapper.getEndDate() );
        events.setEventName( updateEventMapper.getEventName() );

        return events;
    }
}
