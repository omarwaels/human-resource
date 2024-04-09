package iti.project.soap.Utils;

public enum EventStatusEnum {
    ACTIVE("ACTIVE"),
    FINISHED("FINISHED"),
    PENDING("PENDING");

    private final String employerStatus;

    EventStatusEnum(String employerStatus) {
        this.employerStatus = employerStatus;
    }

    public String getStatusString() {
        return employerStatus;
    }
}