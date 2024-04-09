package iti.project.soap.Services.Service;

import java.util.List;

import iti.project.soap.Persistance.DTO.AddEmployerToEventDTO;
import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.DeleteEventDTO;
import iti.project.soap.Persistance.DTO.EmployerGeneralInfoDTO;
import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.EventDataDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.ReqOfDeleteEmployerDTO;
import iti.project.soap.Persistance.DTO.ReqOfMembersPromotionDTO;
import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEmployerDTO;
import iti.project.soap.Persistance.DTO.UpdateEventDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

@WebService
public interface EventServices {

    @WebMethod(operationName = "addEmployerToEvent")
    Boolean addEmployerToEvent(@WebParam(name = "addEmployerToEventDTO") AddEmployerToEventDTO addEmployerToEventDTO)
            throws Exception;

    @WebMethod(operationName = "createEvent")
    Boolean createEvent(@WebParam(name = "createEventDTO") CreateEventDTO createEventDTO) throws Exception;

    @WebMethod(operationName = "getEvent")
    EventDataDTO getEvent(@WebParam(name = "eventName") String eventName) throws Exception;

    @WebMethod(operationName = "getEmployerOfEvent")
    List<EmployerGeneralInfoDTO> getEmployerOfEvent(@WebParam(name = "eventName") String eventName,
            @WebParam(name = "startPage") int startPage) throws Exception;

    @WebMethod(operationName = "updateEvent")
    Boolean updateEvent(@WebParam(name = "UpdateEventDTO") UpdateEventDTO updateEventDTO) throws Exception;

    @WebMethod(operationName = "deletEvent")
    Boolean deleteEvent(@WebParam(name = "DeleteEventDTO") DeleteEventDTO deleteEventDTO) throws Exception;
}
