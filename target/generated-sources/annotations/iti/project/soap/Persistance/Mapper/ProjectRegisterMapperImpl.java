package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.Entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ProjectRegisterMapperImpl implements ProjectRegisterMapper {

    @Override
    public Project registerManagerToProject(ManagerRegisterDTO managerRegisterDTO) {
        if ( managerRegisterDTO == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectName( managerRegisterDTO.getProjectName() );
        project.setAddress( managerRegisterDTO.getProjectAddress() );

        return project;
    }
}
