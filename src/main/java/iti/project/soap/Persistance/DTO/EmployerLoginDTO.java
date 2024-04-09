package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data

public class EmployerLoginDTO {

    private Integer employerId;

    private String firstName;

    private String lastName;

    private String email;

    private String managerName;

    private String projectName;

    private int projectId;

    private String address;

    private String phoneNum;

    // Getters and setters
}