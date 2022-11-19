package ru.petclinic.patientqueueregistration.repository;

import ru.petclinic.patientqueueregistration.doctor.Doctor;
import ru.petclinic.patientqueueregistration.visitinfo.VisitInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayDeque;

public interface QueueRepository {
    public void addInEmergencyPatientQueue(VisitInfo visit);

    public ArrayDeque<VisitInfo> queueSortedByPriority();

    public ArrayDeque<VisitInfo> queueByDate();

    int numberOfPatientsAtDoctorByDate(LocalDate localDate, Doctor doctor);
}
