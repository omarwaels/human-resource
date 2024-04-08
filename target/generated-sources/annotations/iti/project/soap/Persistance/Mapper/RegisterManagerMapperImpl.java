package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.ManagerRegisterDTO;
import iti.project.soap.Persistance.Entity.Employer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-08T02:28:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RegisterManagerMapperImpl implements RegisterManagerMapper {

    @Override
    public Employer registerManagerToEmployer(ManagerRegisterDTO managerRegisterDTO) {
        if ( managerRegisterDTO == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setFirstName( managerRegisterDTO.getFirstName() );
        employer.setLastName( managerRegisterDTO.getLastName() );
        employer.setEmail( managerRegisterDTO.getEmail() );
        employer.setAddress( managerRegisterDTO.getAddress() );
        employer.setPhoneNum( managerRegisterDTO.getPhoneNum() );
        employer.setPassword( managerRegisterDTO.getPassword() );

        return employer;
    }
}
