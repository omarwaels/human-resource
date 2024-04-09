package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.EventDataDTO;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class EventDataDTOMapperImpl implements EventDataDTOMapper {

    @Override
    public EventDataDTO EventToEventDataDTO(Events event) {
        if ( event == null ) {
            return null;
        }

        EventDataDTO eventDataDTO = new EventDataDTO();

        eventDataDTO.setEventName( event.getEventName() );
        eventDataDTO.setProjectName( eventProjectProjectName( event ) );
        eventDataDTO.setAddress( event.getAddress() );
        eventDataDTO.setStartDate( event.getStartDate() );
        eventDataDTO.setEndDate( event.getEndDate() );

        return eventDataDTO;
    }

    private String eventProjectProjectName(Events events) {
        if ( events == null ) {
            return null;
        }
        Project project = events.getProject();
        if ( project == null ) {
            return null;
        }
        String projectName = project.getProjectName();
        if ( projectName == null ) {
            return null;
        }
        return projectName;
    }
}
