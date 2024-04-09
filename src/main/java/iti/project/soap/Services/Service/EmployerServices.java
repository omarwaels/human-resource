package iti.project.soap.Services.Service;

import java.util.List;

import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.ReqOfDeleteEmployerDTO;
import iti.project.soap.Persistance.DTO.ReqOfMembersPromotionDTO;
import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEmployerDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

@WebService
public interface EmployerServices {

    @WebMethod(operationName = "getEmployerById")
    EmployerLoginDTO getEmployerById(@WebParam(name = "employerId") String userId) throws Exception;

    @WebMethod(operationName = "login")
    EmployerLoginDTO loginPhaseTwo(@WebParam(name = "employerEmail") String userEmail,
            @WebParam(name = "employerPassword") String userPassword) throws Exception;

    @WebMethod(operationName = "getEmployerStatus")
    String getEmployerStatus(@WebParam(name = "employerEmail") String employerEmail);

    @WebMethod(operationName = "employerRegister")
    Boolean register(@WebParam(name = "employerToRegister") EmployerRegisterDTO employerToRegister) throws Exception;

    @WebMethod(operationName = "registerManager")
    Boolean registerManager(@WebParam(name = "ManagerRegisterDTO") ManagerRegisterDTO managerToRegister)
            throws Exception;

    @WebMethod(operationName = "managerCreateAccount")
    Boolean managerCreateAccount(@WebParam(name = "UncompletedAccDTO") UncompletedAccDTO uncompletedAccDTO)
            throws Exception;

    @WebMethod(operationName = "promoteEmployer")
    Boolean promoteEmployer(
            @WebParam(name = "ReqOfMembersPromotionDTO") ReqOfMembersPromotionDTO ReqOfMembersPromotionDTO)
            throws Exception;

    @WebMethod(operationName = "deleteEmployer")
    public Boolean deleteEmployer(
            @WebParam(name = "ReqOfDeleteEmployerDTO") ReqOfDeleteEmployerDTO reqOfDeleteEmployerDTO) throws Exception;

    @WebMethod(operationName = "updateEmployer")
    public Boolean updateEmployer(@WebParam(name = "UpdateEmployerDTO") UpdateEmployerDTO updateEmployerDTO)
            throws Exception;
}
