package iti.project.soap.Services.ServiceImpl;

import java.util.Date;
import java.util.List;
import iti.project.soap.Persistance.DAO.EmployerDAOImp;
import iti.project.soap.Persistance.DAO.ProjectDAOImp;
import iti.project.soap.Persistance.DAO.RequestDAOImp;
import iti.project.soap.Persistance.DTO.CreateRequestDTO;
import iti.project.soap.Persistance.DTO.DeleteRequestDTO;
import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.DTO.RequestInfoDTO;
import iti.project.soap.Persistance.DTO.RequestsOfProjectDTO;
import iti.project.soap.Persistance.DTO.ReplyRequestDTO;
import iti.project.soap.Persistance.DTO.ReqOfProjectMembersDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import iti.project.soap.Persistance.Entity.Request;
import iti.project.soap.Persistance.Mapper.EmployerInProjectMapper;
import iti.project.soap.Persistance.Mapper.RequestInfoMapper;
import iti.project.soap.Services.Service.ProjectServices;
import iti.project.soap.Services.Service.RequestServices;
import iti.project.soap.Utils.RequestStatusEnum;
import jakarta.jws.WebService;

@WebService(endpointInterface = "iti.project.soap.Services.Service.ProjectServices")
public class ProjectServicesImpl implements ProjectServices {

    public final int PAGESIZE = 5;

    @Override
    public List<EmployerInProjectDTO> getEmplyersOfProject(ReqOfProjectMembersDTO membersOfProjectDTO)
            throws Exception {

        Employer employer = EmployerDAOImp.getById(membersOfProjectDTO.getEmployerId());
        if (employer == null)
            throw new Exception("Not Valid Employer");
        if (employer.getEmployerProject().getProjectId() != membersOfProjectDTO.getProjectId())
            throw new Exception("Not Member Of Project");
        int page = membersOfProjectDTO.getPage() < 1 ? 1 : membersOfProjectDTO.getPage();
        int start = (page - 1) * PAGESIZE;
        List<Employer> emplyersOfProject = ProjectDAOImp.getEmpOfProjectById(membersOfProjectDTO.getProjectId(), start);
        List<EmployerInProjectDTO> res = EmployerInProjectMapper.INSTANCE.mapEntitiesToDTOs(emplyersOfProject);
        return res;

    }

    @Override
    public Boolean removeProject(int employerId) throws Exception {
        Employer manger = EmployerDAOImp.getById(employerId);
        if (manger == null)
            throw new Exception("Not Valid Employer");
        if (manger.getEmployerId() != manger.getHumanResourceId().getEmployerId())
            throw new Exception("Dont have Authorization");
        return ProjectDAOImp.delByName(manger.getEmployerProject().getProjectName());
    }

}
