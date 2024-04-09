package iti.project.soap.Persistance.DTO;

import java.util.Date;

import lombok.Data;
import lombok.Value;

@Data
public class CreateRequestDTO {

    private Integer employerId;
    private String details;
    private String title;

}
