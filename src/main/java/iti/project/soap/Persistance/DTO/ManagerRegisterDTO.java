package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Data
@XmlRootElement(name = "employerLogin")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerRegisterDTO {

 
    @XmlElement(name = "firstName")
    private String firstName;
    
    @XmlElement(name = "lastName")
    private String lastName;
    
    @XmlElement(name = "email")
    private String email;
    
    @XmlElement(name = "address")
    private String address;
    
    @XmlElement(name = "phoneNum")
    private String phoneNum;
    
    @XmlElement(name = "password")
    private String password;

    @XmlElement(name = "projectName")
    private String projectName;

    @XmlElement(name = "projectAddress")
    private String projectAddress;
    
}
