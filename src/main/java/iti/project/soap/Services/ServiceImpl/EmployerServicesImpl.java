package iti.project.soap.Services.ServiceImpl;

import java.util.Date;
import java.util.LinkedList;

import java.util.List;

import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DAO.ProjectDAOImp;
import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.EmployerLoginDTO;

import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.DTO.ReqOfDeleteEmployerDTO;
import iti.project.soap.Persistance.DTO.ReqOfMembersPromotionDTO;
import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.DTO.UpdateEmployerDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Mapper.EmployerInProjectMapper;
import iti.project.soap.Persistance.Mapper.LoginEmployerMapper;
import iti.project.soap.Persistance.Mapper.ProjectRegisterMapper;
import iti.project.soap.Persistance.Mapper.RegisterEmployerMapper;
import iti.project.soap.Persistance.Mapper.RegisterManagerMapper;
import iti.project.soap.Persistance.Mapper.UncompletedAccMapper;
import iti.project.soap.Services.Service.EmployerServices;
import iti.project.soap.Utils.EmployerStatusEnum;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "iti.project.soap.Services.Service.EmployerServices")
public class EmployerServicesImpl implements EmployerServices {

    public final int PAGESIZE = 5;

    @Resource
    private WebServiceContext context;

    @Override
    public EmployerLoginDTO getEmployerById(String userId) throws Exception {
        try {
            Integer idToInteger = Integer.parseInt(userId);
            Employer employer = EmployerDAOImp.getById(idToInteger);
            if (employer == null) {
                throw new Exception("User not found");
            }
            return LoginEmployerMapper.INSTANCE.employerToLoginDTO(employer);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid user ID format");
        }

    }

    @Override
    public String getEmployerStatus(String employerEmail) {
        EmployerStatusEnum status = EmployerDAOImp.getStatus(employerEmail);

        if (status == EmployerStatusEnum.EXISTING_EMPLOYER) {
            // Set the cookie in the response
            setCookie("passedFirstPhase", "true");
            // Return response
            return "EXISTING_EMPLOYER";
        } else {
            if (status == null)
                return EmployerStatusEnum.UNKNOWN_EMPLOYER.toString();
            return status.toString();
        }
    }

    @Override
    public EmployerLoginDTO loginPhaseTwo(String userEmail, String userPassword) throws Exception {

        Employer employer = EmployerDAOImp.getEmployer(userEmail);
        if (employer == null) {
            throw new Exception("Invalid user email");
        } else {
            if (!employer.getPassword().equals(userPassword)) {
                throw new Exception("Invalid user Password");
            }
            System.out.println("reached");
            EmployerLoginDTO currEmployer = LoginEmployerMapper.INSTANCE.employerToLoginDTO(employer);

            return currEmployer;
        }

    }

    private void setCookie(String name, String value) {
        // Retrieve response context
        MessageContext messageContext = context.getMessageContext();
        HttpServletResponse response = (HttpServletResponse) messageContext.get(MessageContext.SERVLET_RESPONSE);

        // Create and add cookie to the response
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(3600); // Set cookie expiration time
        cookie.setPath("/"); // Set cookie path
        response.addCookie(cookie);
    }

    @Override
    public Boolean register(EmployerRegisterDTO employerToRegister) throws Exception {
        EmployerStatusEnum status = EmployerDAOImp.getStatus(employerToRegister.getEmail());
        if (status == EmployerStatusEnum.EXISTING_EMPLOYER) {
            throw new Exception("This employer is in another project");
        } else if (status == EmployerStatusEnum.NEW_EMPLOYER) {
            Employer original = EmployerDAOImp.getByEmail(employerToRegister.getEmail());
            Employer newemployer = RegisterEmployerMapper.INSTANCE.registerEmployerToEmployer(employerToRegister);
            original.setFirstName(newemployer.getFirstName());
            original.setLastName(newemployer.getLastName());
            original.setPassword(newemployer.getPassword());
            original.setAddress(newemployer.getAddress());
            original.setPhoneNum(newemployer.getPhoneNum());
            return EmployerDAOImp.updateEmployer(original);
        } else {
            throw new Exception("This employer is unknown to the System");
        }

    }

    @Override
    public Boolean managerCreateAccount(UncompletedAccDTO uncompletedAccDTO) throws Exception {

        Project project = ProjectDAOImp.getById(uncompletedAccDTO.getProjectId());
        if (project == null) {
            throw new Exception("No project Found");
        }
        Employer manager = project.getProjectManager();
        if (manager.getEmployerId() != uncompletedAccDTO.getManagerId()) {
            throw new Exception("You dont have any Autherization");
        }
        Employer newAcc = UncompletedAccMapper.INSTANCE.UncompletedAccToEmployer(uncompletedAccDTO);
        newAcc.setEmployerProject(project);
        newAcc.setHumanResourceId(manager);
        return EmployerDAOImp.registerEmployer(newAcc);

    }

    @Override
    public Boolean promoteEmployer(ReqOfMembersPromotionDTO ReqOfMembersPromotionDTO) throws Exception {

        Employer oldManager = EmployerDAOImp.getById(ReqOfMembersPromotionDTO.getEmployerId());
        if (oldManager == null)
            throw new Exception("Not Valid Employer");
        if (oldManager.getEmployerProject().getProjectId() != ReqOfMembersPromotionDTO.getProjectId())
            throw new Exception("Not Member Of Project");
        if (oldManager.getEmployerId() != oldManager.getHumanResourceId().getEmployerId())
            throw new Exception("You dont have Authorization");
        Employer employerToPromote = EmployerDAOImp.getByEmail(ReqOfMembersPromotionDTO.getEmployerEmailToPromote());
        if (employerToPromote == null)
            throw new Exception("Not Valid User To Promote");
        if (employerToPromote.getEmployerProject().getProjectId() != ReqOfMembersPromotionDTO.getProjectId())
            throw new Exception("User not inside this Project");
        Project project = ProjectDAOImp.getById(ReqOfMembersPromotionDTO.getProjectId());
        if (project == null)
            throw new Exception("Not Valid Project");
        return EmployerDAOImp.promote(oldManager, employerToPromote, project);

    }

    @Override
    public Boolean deleteEmployer(ReqOfDeleteEmployerDTO reqOfDeleteEmployerDTO) throws Exception {

        Employer manager = EmployerDAOImp.getById(reqOfDeleteEmployerDTO.getEmployerId());
        if (manager == null)
            throw new Exception("Not Valid Employer");
        if (manager.getEmployerId() != manager.getHumanResourceId().getEmployerId())
            throw new Exception("You dont have Authorization");
        Employer employerToDelete = EmployerDAOImp.getByEmail(reqOfDeleteEmployerDTO.getEmployerEmailToDelete());
        if (employerToDelete == null)
            throw new Exception("Not Valid User To Promote");
        if (employerToDelete.getEmployerProject().getProjectId() != manager.getEmployerProject().getProjectId())
            throw new Exception("They arent in same Project");
        if (manager.getEmployerId() == employerToDelete.getEmployerId())
            throw new Exception("Manager Cant Be Deleted");

        return EmployerDAOImp.removeEmployer(employerToDelete);

    }

    @Override
    public Boolean registerManager(ManagerRegisterDTO managerToRegister) throws Exception {
        EmployerStatusEnum status = EmployerDAOImp.getStatus(managerToRegister.getEmail());
        if (status == EmployerStatusEnum.NEW_EMPLOYER || status == EmployerStatusEnum.EXISTING_EMPLOYER) {
            throw new Exception("This employer already in the System");
        } else {
            Employer employer = RegisterManagerMapper.INSTANCE.registerManagerToEmployer(managerToRegister);
            Project project = ProjectRegisterMapper.INSTANCE.registerManagerToProject(managerToRegister);
            boolean addedSuccessFulyFlag = false;
            if (EmployerDAOImp.registerEmployer(employer)) {
                if (ProjectDAOImp.registerProject(project)) {
                    addedSuccessFulyFlag = true;
                }
            }
            if (!addedSuccessFulyFlag) {
                throw new Exception("There is Project with same Name ");
            }
            employer.setEmployerProject(project);
            employer.setHumanResourceId(employer);
            project.setProjectManager(employer);
            project.setStartDate(new Date());
            if (EmployerDAOImp.updateEmployer(employer)) {
                if (ProjectDAOImp.updateProject(project)) {
                    return true;
                }
            }
            return false;

        }

    }

    @Override
    public Boolean updateEmployer(UpdateEmployerDTO updateEmployerDTO) throws Exception {
        Employer employerToUpdate = EmployerDAOImp.getById(updateEmployerDTO.getEmployerId());
        if (employerToUpdate == null)
            throw new Exception("Not Valid Employer");
        employerToUpdate.setAddress(updateEmployerDTO.getAddress());
        employerToUpdate.setPassword(updateEmployerDTO.getPassword());
        employerToUpdate.setFirstName(updateEmployerDTO.getFirstName());
        employerToUpdate.setLastName(updateEmployerDTO.getLastName());
        employerToUpdate.setPhoneNum(updateEmployerDTO.getPhoneNum());

        EmployerDAOImp.updateEmployer(employerToUpdate);
        return true;

    }

}
