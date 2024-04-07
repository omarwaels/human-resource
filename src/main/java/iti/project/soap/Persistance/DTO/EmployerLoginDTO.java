package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "employerLogin")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployerLoginDTO {
 
    @XmlElement(name = "employerId")
    private Integer employerId;
    
    @XmlElement(name = "firstName")
    private String firstName;
    
    @XmlElement(name = "lastName")
    private String lastName;
    
    @XmlElement(name = "email")
    private String email;
    
    @XmlElement(name = "managerName")
    private String managerName;
    
    @XmlElement(name = "projectName")
    private String projectName;
    
    @XmlElement(name = "address")
    private String address;
    
    @XmlElement(name = "phoneNum")
    private String phoneNum;

    // Getters and setters
}