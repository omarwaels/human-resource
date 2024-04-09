package iti.project.soap.Persistance.DTO;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data

public class UpdateEventDTO {

    private Integer employerId;
    private String address;
    private String eventName;
    private String newStatus;
    private Date startDate;
    private Date endDate;

}
