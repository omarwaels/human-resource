package iti.project.soap.Persistance.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class CreateEventDTO {

    private Integer employerId;
    private String projectName;
    private String eventName;
    private String address;
    private Date startDate;
    private Date endDate;

}
