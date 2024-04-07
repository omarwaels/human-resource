package iti.project.soap.Services.Service;


import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

@WebService
public interface EmployerServices {
    
    @WebMethod(operationName = "getEmployerById")
    String getEmployerById (@WebParam(name = "employerId")String userId ) throws Exception;

    @WebMethod(operationName = "login")
    EmployerLoginDTO loginPhaseTwo (@WebParam(name = "employerEmail")String userEmail ,@WebParam(name = "employerPassword")String userPassword) throws Exception;
    
    @WebMethod(operationName = "getEmployerStatus")
    public String getEmployerStatus(@WebParam(name = "employerEmail")String employerEmail);
}
