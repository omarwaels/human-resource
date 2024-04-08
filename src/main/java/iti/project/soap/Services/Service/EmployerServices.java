package iti.project.soap.Services.Service;


import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

@WebService
public interface EmployerServices {
    
    @WebMethod(operationName = "getEmployerById")
    EmployerLoginDTO getEmployerById (@WebParam(name = "employerId")String userId ) throws Exception;

    @WebMethod(operationName = "login")
    EmployerLoginDTO loginPhaseTwo (@WebParam(name = "employerEmail")String userEmail ,@WebParam(name = "employerPassword")String userPassword) throws Exception;
    
    @WebMethod(operationName = "getEmployerStatus")
    public String getEmployerStatus(@WebParam(name = "employerEmail")String employerEmail);

    @WebMethod(operationName = "register")
    public boolean register(@WebParam(name = "employerToRegister")EmployerRegisterDTO employerToRegister) throws Exception;
    
    @WebMethod(operationName = "registerManager")
    boolean registerManager(ManagerRegisterDTO managerToRegister) throws Exception;

    @WebMethod(operationName = "managerCreateAccount")
    boolean managerCreateAccount(UncompletedAccDTO uncompletedAccDTO ) throws Exception;
}
