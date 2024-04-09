package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
public class EmployerInProjectDTO {

    private String email;

    private String firstName;

    private String lastName;

    private String projectName;

    private String phoneNum;

    private String address;

}
