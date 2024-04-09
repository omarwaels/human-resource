package iti.project.soap.Persistance.DTO;

import java.util.Date;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data

public class EventDataDTO {

    private String eventName;

    private String projectName;

    private List<String> employerEnvolved;

    private String address;

    private Date startDate;

    private Date endDate;

}
