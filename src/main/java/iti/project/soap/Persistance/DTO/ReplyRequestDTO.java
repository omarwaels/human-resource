package iti.project.soap.Persistance.DTO;

import java.util.Date;

import iti.project.soap.Utils.RequestStatusEnum;
import lombok.Data;

@Data
public class ReplyRequestDTO {

    private Integer employerId;

    private int requestId;

    private String response;

    private RequestStatusEnum status;

}
