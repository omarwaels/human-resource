package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.EmployerInProjectDTO;
import iti.project.soap.Persistance.Entity.Employer;
import iti.project.soap.Persistance.Entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class EmployerInProjectMapperImpl implements EmployerInProjectMapper {

    @Override
    public EmployerInProjectDTO employerToEmployerInProjectDTO(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerInProjectDTO employerInProjectDTO = new EmployerInProjectDTO();

        employerInProjectDTO.setFirstName( employer.getFirstName() );
        employerInProjectDTO.setLastName( employer.getLastName() );
        employerInProjectDTO.setEmail( employer.getEmail() );
        employerInProjectDTO.setAddress( employer.getAddress() );
        employerInProjectDTO.setPhoneNum( employer.getPhoneNum() );
        employerInProjectDTO.setProjectName( employerEmployerProjectProjectName( employer ) );

        return employerInProjectDTO;
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
}
