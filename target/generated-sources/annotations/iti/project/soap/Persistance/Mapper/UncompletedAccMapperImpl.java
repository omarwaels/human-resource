package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.UncompletedAccDTO;
import iti.project.soap.Persistance.Entity.Employer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T02:28:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UncompletedAccMapperImpl implements UncompletedAccMapper {

    @Override
    public Employer UncompletedAccToEmployer(UncompletedAccDTO uncompletedAccDTO) {
        if ( uncompletedAccDTO == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setEmail( uncompletedAccDTO.getEmail() );

        return employer;
    }
}
