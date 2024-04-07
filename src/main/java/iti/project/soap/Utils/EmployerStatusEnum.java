package iti.project.soap.Utils;

public enum EmployerStatusEnum {
    NEW_EMPLOYER("New Employer"),
    EXISTING_EMPLOYER("Existing Employer"),
    UNKNOWN_EMPLOYER("Unknown Employer");

    private final String employerStatus;

    EmployerStatusEnum(String employerStatus) {
        this.employerStatus = employerStatus;
    }

    public String getStatusString() {
        return employerStatus;
    }
}