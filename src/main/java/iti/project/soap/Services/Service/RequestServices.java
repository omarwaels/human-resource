package iti.project.soap.Services.Service;

import java.util.List;

import iti.project.soap.Persistance.DTO.AddEmployerToEventDTO;
import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.CreateRequestDTO;
import iti.project.soap.Persistance.DTO.DeleteEventDTO;
import iti.project.soap.Persistance.DTO.DeleteRequestDTO;
import iti.project.soap.Persistance.DTO.EmployerGeneralInfoDTO;
import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.EventDataDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.ReplyRequestDTO;
import iti.project.soap.Persistance.DTO.ReqOfDeleteEmployerDTO;
import iti.project.soap.Persistance.DTO.ReqOfMembersPromotionDTO;
import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.DTO.RequestInfoDTO;
import iti.project.soap.Persistance.DTO.RequestsOfProjectDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEmployerDTO;
import iti.project.soap.Persistance.DTO.UpdateEventDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

@WebService
public interface RequestServices {

    @WebMethod(operationName = "createRequest")
    Boolean createRequest(@WebParam(name = "createRequestDTO") CreateRequestDTO createRequestDTO) throws Exception;

    @WebMethod(operationName = "getRequest")
    RequestInfoDTO getRequest(@WebParam(name = "requestId") int requestId) throws Exception;

    @WebMethod(operationName = "replyToRequest")
    Boolean replyToRequest(@WebParam(name = "ReplyRequestDTO") ReplyRequestDTO replyRequestDTO) throws Exception;

    @WebMethod(operationName = "deleteRequest")
    Boolean deleteRequest(@WebParam(name = "DeleteRequestDTO") DeleteRequestDTO deleteEventDTO) throws Exception;

    @WebMethod(operationName = "getRequestsOfProject")
    List<RequestInfoDTO> getRequestsOfProject(
            @WebParam(name = "RequestsOfProjectDTO") RequestsOfProjectDTO deleteEventDTO) throws Exception;
}
