package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.EmployerRegisterDTO;
import iti.project.soap.Persistance.Entity.Employer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class RegisterEmployerMapperImpl implements RegisterEmployerMapper {

    @Override
    public Employer registerEmployerToEmployer(EmployerRegisterDTO employerRegisterDTO) {
        if ( employerRegisterDTO == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setFirstName( employerRegisterDTO.getFirstName() );
        employer.setLastName( employerRegisterDTO.getLastName() );
        employer.setEmail( employerRegisterDTO.getEmail() );
        employer.setAddress( employerRegisterDTO.getAddress() );
        employer.setPhoneNum( employerRegisterDTO.getPhoneNum() );
        employer.setPassword( employerRegisterDTO.getPassword() );

        return employer;
    }
}
