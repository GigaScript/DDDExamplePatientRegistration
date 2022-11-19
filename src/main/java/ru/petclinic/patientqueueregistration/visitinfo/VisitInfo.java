package ru.petclinic.patientqueueregistration.visitinfo;

import ru.petclinic.patientqueueregistration.CustomException;

import java.time.LocalDateTime;
import java.util.Date;

public class VisitInfo {
    final LocalDateTime visitCreate = LocalDateTime.now();
    private final String reasonForVisit;
    private final VisitPurpose visitPurpose;

    private LocalDateTime visitOnDateTime;
    private VisitPriority visitPriority;
    private VisitStatus visitStatus;
    private String doctorId;

    private String visitResult;

    public VisitInfo(VisitPriority visitPriority, VisitPurpose visitPurpose, String reasonForVisit, LocalDateTime visitOnDateTime) throws CustomException {
        this.visitPriority = visitPriority;
        this.visitPurpose = visitPurpose;
        this.visitStatus = VisitStatus.bookedToDoctor;
        this.reasonForVisit = reasonForVisit;
        this.visitOnDateTime = visitOnDateTime;
    }

    public void changeDateForNexVisit(LocalDateTime newDate) {
        this.visitOnDateTime = newDate;
    }

    public void changeVisitStatus(VisitStatus newStatus) {
        this.visitStatus = newStatus;
    }

    public void changeDoctor(String newId) {
        this.doctorId = newId;
    }

    public void changeVisitPriority(VisitPriority newPriority) {
        this.visitPriority = newPriority;
    }

    public LocalDateTime getVisitCreateDate() {
        return visitCreate;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public LocalDateTime getVisitOnDateTime() {
        return visitOnDateTime;
    }


    public VisitPriority getVisitPriority() {
        return visitPriority;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }


    public String getDoctorId() {
        return doctorId;
    }


    public String getVisitResult() {
        return visitResult;
    }


    @Override
    public String toString() {
        return "Visit{" +
                "visitCreate=" + visitCreate +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                ", visitOnDateTime=" + visitOnDateTime +
                ", visitPriority=" + visitPriority +
                ", visitStatus=" + visitStatus +
                ", doctorId='" + doctorId + '\'' +
                ", visitResult='" + visitResult + '\'' +
                '}';
    }
}
