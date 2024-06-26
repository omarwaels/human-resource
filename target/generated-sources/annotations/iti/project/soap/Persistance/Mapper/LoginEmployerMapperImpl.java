package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.EmployerLoginDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class LoginEmployerMapperImpl implements LoginEmployerMapper {

    @Override
    public EmployerLoginDTO employerToLoginDTO(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerLoginDTO employerLoginDTO = new EmployerLoginDTO();

        employerLoginDTO.setEmployerId( employer.getEmployerId() );
        employerLoginDTO.setFirstName( employer.getFirstName() );
        employerLoginDTO.setLastName( employer.getLastName() );
        employerLoginDTO.setEmail( employer.getEmail() );
        employerLoginDTO.setAddress( employer.getAddress() );
        employerLoginDTO.setPhoneNum( employer.getPhoneNum() );
        employerLoginDTO.setManagerName( employerHumanResourceIdFirstName( employer ) );
        employerLoginDTO.setProjectName( employerEmployerProjectProjectName( employer ) );
        employerLoginDTO.setProjectId( employerEmployerProjectProjectId( employer ) );

        return employerLoginDTO;
    }

    private String employerHumanResourceIdFirstName(Employer employer) {
        if ( employer == null ) {
            return null;
        }
        Employer humanResourceId = employer.getHumanResourceId();
        if ( humanResourceId == null ) {
            return null;
        }
        String firstName = humanResourceId.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String employerEmployerProjectProjectName(Employer employer) {
        if ( employer == null ) {
            return null;
        }
        Project employerProject = employer.getEmployerProject();
        if ( employerProject == null ) {
            return null;
        }
        String projectName = employerProject.getProjectName();
        if ( projectName == null ) {
            return null;
        }
        return projectName;
    }

    private int employerEmployerProjectProjectId(Employer employer) {
        if ( employer == null ) {
            return 0;
        }
        Project employerProject = employer.getEmployerProject();
        if ( employerProject == null ) {
            return 0;
        }
        int projectId = employerProject.getProjectId();
        return projectId;
    }
}
