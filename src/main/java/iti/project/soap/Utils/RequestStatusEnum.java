package iti.project.soap.Utils;

public enum RequestStatusEnum {
    ACCEPTED("ACCEPTED"),
    REFUSED("REFUSED"),
    PENDING("PENDING");

    private final String employerStatus;

    RequestStatusEnum(String employerStatus) {
        this.employerStatus = employerStatus;
    }

    public String getStatusString() {
        return employerStatus;
    }
}