package iti.project.soap.Services.ServiceImpl;

import java.util.Date;
import java.util.LinkedList;

import java.util.List;

import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DAO.EventDAOImp;
import iti.project.soap.Persistance.DAO.ProjectDAOImp;
import iti.project.soap.Persistance.DTO.AddEmployerToEventDTO;
import iti.project.soap.Persistance.DTO.CreateEventDTO;
import iti.project.soap.Persistance.DTO.DeleteEventDTO;
import iti.project.soap.Persistance.DTO.EmployerGeneralInfoDTO;
import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.EventDataDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.ReqOfDeleteEmployerDTO;
import iti.project.soap.Persistance.DTO.ReqOfMembersPromotionDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEmployerDTO;
import iti.project.soap.Persistance.DTO.UpdateEventDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Events;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Mapper.CreateEventMapper;
import iti.project.soap.Persistance.Mapper.EmployerGeneralInfoMapper;
import iti.project.soap.Persistance.Mapper.EmployerInProjectMapper;
import iti.project.soap.Persistance.Mapper.EventDataDTOMapper;
import iti.project.soap.Persistance.Mapper.LoginEmployerMapper;
import iti.project.soap.Persistance.Mapper.ProjectRegisterMapper;
import iti.project.soap.Persistance.Mapper.RegisterEmployerMapper;
import iti.project.soap.Persistance.Mapper.RegisterManagerMapper;
import iti.project.soap.Persistance.Mapper.UncompletedAccMapper;
import iti.project.soap.Persistance.Mapper.UpdateEventMapper;
import iti.project.soap.Services.Service.EmployerServices;
import iti.project.soap.Services.Service.EventServices;
import iti.project.soap.Services.Service.RequestServices;
import iti.project.soap.Utils.EmployerStatusEnum;
import iti.project.soap.Utils.EventStatusEnum;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "iti.project.soap.Services.Service.EventServices")
public class EventServicesImpl implements EventServices {

    public final int PAGESIZE = 5;

    @Resource
    private WebServiceContext context;

    @Override
    public Boolean createEvent(CreateEventDTO createEventDTO) throws Exception {

        Project project = ProjectDAOImp.getByName(createEventDTO.getProjectName());
        if (project == null) {
            throw new Exception("No project Found");
        }
        Employer manager = project.getProjectManager();
        if (manager.getEmployerId() != createEventDTO.getEmployerId()) {
            throw new Exception("You dont have any Autherization");
        }
        Events event = CreateEventMapper.INSTANCE.createEventDtoToEvent(createEventDTO);
        event.setProject(project);
        event.setStatus(EventStatusEnum.PENDING);

        EventDAOImp.registerEvent(event);
        EventDAOImp.addEmployerToEventByName(event.getEventName(), manager);
        return true;

    }

    @Override
    public Boolean addEmployerToEvent(AddEmployerToEventDTO addEmployerToEventDTO) throws Exception {

        Employer manger = EmployerDAOImp.getById(addEmployerToEventDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        Employer employer = EmployerDAOImp.getByEmail(addEmployerToEventDTO.getEmployerEmail());
        if (manger.getEmployerProject().getProjectId() != employer.getEmployerProject().getProjectId())
            throw new Exception("Not Member Of Project");
        Events event = EventDAOImp.getByName(addEmployerToEventDTO.getEventName());
        if (event == null)
            throw new Exception("There is no event");

        EventDAOImp.addEmployerToEventByName(addEmployerToEventDTO.getEventName(), employer);

        return true;

    }

    @Override
    public EventDataDTO getEvent(String eventName) throws Exception {
        Events event = EventDAOImp.getByName(eventName);
        EventDataDTO eventDataDTO = EventDataDTOMapper.INSTANCE.EventToEventDataDTO(event);
        List<Employer> employersInEvent = EventDAOImp.getEmployersEvolved(eventName, 0);
        var employersNames = new LinkedList<String>();
        for (Employer e : employersInEvent)
            employersNames.add(e.getFirstName() + " " + e.getLastName());
        eventDataDTO.setEmployerEnvolved(employersNames);
        return eventDataDTO;
    }

    @Override
    public List<EmployerGeneralInfoDTO> getEmployerOfEvent(String eventName, int startPage) throws Exception {
        if (startPage < 1)
            startPage = 1;
        int start = (startPage - 1) * PAGESIZE;
        List<Employer> employersInEvent = EventDAOImp.getEmployersEvolved(eventName, start);
        List<EmployerGeneralInfoDTO> res = EmployerGeneralInfoMapper.INSTANCE.mapEntitiesToDTOs(employersInEvent);
        return res;
    }

    @Override
    public Boolean updateEvent(UpdateEventDTO updateEventDTO) throws Exception {

        Employer manger = EmployerDAOImp.getById(updateEventDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");
        Events original = EventDAOImp.getByName(updateEventDTO.getEventName());
        if (original == null)
            throw new Exception("Not Valid Event");
        if (original.getProject().getProjectId() != manger.getEmployerProject().getProjectId())
            throw new Exception("Acces Event Outside Project Boundaries");
        original.setAddress(updateEventDTO.getAddress());
        original.setEndDate(updateEventDTO.getEndDate());
        original.setStartDate(updateEventDTO.getEndDate());
        try {
            EventStatusEnum status = EventStatusEnum.valueOf(updateEventDTO.getNewStatus());
            original.setStatus(status);
            EventDAOImp.updateEvent(original);
            return true;
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid status for Event");
        }

    }

    @Override
    public Boolean deleteEvent(DeleteEventDTO deleteEventDTO) throws Exception {
        Employer manger = EmployerDAOImp.getById(deleteEventDTO.getEmployerId());
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");
        Events original = EventDAOImp.getByName(deleteEventDTO.getEventName());
        if (original == null)
            throw new Exception("Not Valid Event");
        return EventDAOImp.delByName(deleteEventDTO.getEventName());
    }

}
