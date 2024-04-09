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
public interface ProjectServices {

    @WebMethod(operationName = "getEmployerOfProject")
    List<EmployerInProjectDTO> getEmplyersOfProject(
            @WebParam(name = "ReqOfProjectMembersDTO") ReqOfProjectMembersDTO membersOfProjectDTO) throws Exception;

    @WebMethod(operationName = "removeProject")
    Boolean removeProject(@WebParam(name = "employerId") int employerId) throws Exception;

}
