package iti.project.soap.Persistance.DTO;

import java.util.Date;

import iti.project.soap.Utils.RequestStatusEnum;
import lombok.Data;

@Data
public class RequestInfoDTO {

    private Integer employerId;

    private Integer requestId;

    private String details;

    private String title;

    private RequestStatusEnum status;

}
