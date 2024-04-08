package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;


@Data
@XmlRootElement(name = "employerLogin")
@XmlAccessorType(XmlAccessType.FIELD)
public class UncompletedAccDTO {

 

    @XmlElement(name = "email")
    private String email;
    

    @XmlElement(name = "projectId")
    private int projectId;


    @XmlElement(name = "managerId")
    private int managerId;

    
}
