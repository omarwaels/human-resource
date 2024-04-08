package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.Entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T02:28:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
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
