package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.RequestInfoDTO;
import iti.project.soap.Persistance.Entity.Request;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RequestInfoMapperImpl implements RequestInfoMapper {

    @Override
    public RequestInfoDTO createEventDtoToEvent(Request request) {
        if ( request == null ) {
            return null;
        }

        RequestInfoDTO requestInfoDTO = new RequestInfoDTO();

        requestInfoDTO.setDetails( request.getDetails() );
        requestInfoDTO.setTitle( request.getTitle() );
        requestInfoDTO.setStatus( request.getStatus() );
        requestInfoDTO.setRequestId( request.getRequestId() );

        return requestInfoDTO;
    }
}
