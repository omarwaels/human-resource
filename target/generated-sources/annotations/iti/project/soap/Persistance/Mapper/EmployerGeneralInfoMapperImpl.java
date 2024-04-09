package iti.project.soap.Persistance.Mapper;

import iti.project.soap.Persistance.DTO.EmployerGeneralInfoDTO;
import iti.project.soap.Persistance.Entity.Employer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-09T23:11:31+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.9 (Oracle Corporation)"
)
public class EmployerGeneralInfoMapperImpl implements EmployerGeneralInfoMapper {

    @Override
    public EmployerGeneralInfoDTO employerToGeneralDTO(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerGeneralInfoDTO employerGeneralInfoDTO = new EmployerGeneralInfoDTO();

        employerGeneralInfoDTO.setFirstName( employer.getFirstName() );
        employerGeneralInfoDTO.setLastName( employer.getLastName() );
        employerGeneralInfoDTO.setEmail( employer.getEmail() );
        employerGeneralInfoDTO.setAddress( employer.getAddress() );
        employerGeneralInfoDTO.setPhoneNum( employer.getPhoneNum() );

        return employerGeneralInfoDTO;
    }
}
