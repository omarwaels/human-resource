package iti.project.soap.Services.ServiceImpl;

import java.util.Date;
import java.util.List;
import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DAO.RequestDAOImp;
import iti.project.soap.Persistance.DTO.CreateRequestDTO;
import iti.project.soap.Persistance.DTO.DeleteRequestDTO;
import iti.project.soap.Persistance.DTO.RequestInfoDTO;
import iti.project.soap.Persistance.DTO.RequestsOfProjectDTO;
import iti.project.soap.Persistance.DTO.ReplyRequestDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Entity.Request;
import iti.project.soap.Persistance.Mapper.RequestInfoMapper;
import iti.project.soap.Services.Service.RequestServices;
import iti.project.soap.Utils.RequestStatusEnum;
import jakarta.jws.WebService;

@WebService(endpointInterface = "iti.project.soap.Services.Service.RequestServices")
public class RequestServicesImpl implements RequestServices {

    public final int PAGESIZE = 5;

    @Override
    public Boolean createRequest(CreateRequestDTO createRequestDTO) throws Exception {
        Employer employer = EmployerDAOImp.getById(createRequestDTO.getEmployerId());
        Project project = employer.getEmployerProject();
        if (employer == null)
            throw new Exception("Not Valid Employer");

        Request reqToCreate = new Request();
        reqToCreate.setDetails(createRequestDTO.getDetails());
        reqToCreate.setEmployer(employer);
        reqToCreate.setProject(project);
        reqToCreate.setStatus(RequestStatusEnum.PENDING);
        reqToCreate.setSubmitDate(new Date());
        reqToCreate.setTitle(createRequestDTO.getTitle());

        return RequestDAOImp.registerRequest(reqToCreate);

    }

    @Override
    public RequestInfoDTO getRequest(int requestId) throws Exception {
        Request request = RequestDAOImp.getById(requestId);
        if (request == null)
            throw new Exception("Not Valid Request");
        return RequestInfoMapper.INSTANCE.createEventDtoToEvent(request);
    }

    @Override
    public Boolean replyToRequest(ReplyRequestDTO replyRequestDTO) throws Exception {
        Request requestToUpdate = RequestDAOImp.getById(replyRequestDTO.getRequestId());
        if (requestToUpdate == null)
            throw new Exception("Not Valid Request");
        Employer manger = EmployerDAOImp.getById(replyRequestDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");

        if (requestToUpdate.getProject().getProjectId() != manger.getEmployerProject().getProjectId())
            throw new Exception("Acces Event Outside Project Boundaries");

        requestToUpdate.setResponse(replyRequestDTO.getResponse());
        requestToUpdate.setStatus(replyRequestDTO.getStatus());

        return RequestDAOImp.updateRequest(requestToUpdate);

    }

    @Override
    public Boolean deleteRequest(DeleteRequestDTO deleteEventDTO) throws Exception {
        Request requestToUpdate = RequestDAOImp.getById(deleteEventDTO.getRequestId());
        if (requestToUpdate == null)
            throw new Exception("Not Valid Request");
        Employer manger = EmployerDAOImp.getById(deleteEventDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");
        if (requestToUpdate.getProject().getProjectId() != manger.getEmployerProject().getProjectId())
            throw new Exception("Acces Event Outside Project Boundaries");
        return RequestDAOImp.delById(deleteEventDTO.getRequestId());
    }

    @Override
    public List<RequestInfoDTO> getRequestsOfProject(RequestsOfProjectDTO requestsOfProjectDTO) throws Exception {

        Employer manger = EmployerDAOImp.getById(requestsOfProjectDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");
        int startPage = requestsOfProjectDTO.getPageNum();
        if (startPage < 1)
            startPage = 1;
        int start = (startPage - 1) * PAGESIZE;
        List<Request> employersInEvent = RequestDAOImp.getRequestsEvolved(manger.getEmployerProject().getProjectId(),
                start);
        List<RequestInfoDTO> res = RequestInfoMapper.INSTANCE.mapEntitiesToDTOs(employersInEvent);
        return res;

    }

}
