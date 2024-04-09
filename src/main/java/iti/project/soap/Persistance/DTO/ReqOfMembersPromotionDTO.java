package iti.project.soap.Persistance.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data

public class ReqOfMembersPromotionDTO {

    private int projectId;

    private int employerId;

    private String employerEmailToPromote;

}
