package ru.petclinic.patientqueueregistration.repository;

import ru.petclinic.patientqueueregistration.doctor.Doctor;
import ru.petclinic.patientqueueregistration.visitinfo.VisitInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class QueueInMemoryRepository implements QueueRepository {
    LinkedHashMap<LocalDate,
            LinkedHashMap<Doctor,
                    LinkedHashMap<LocalTime, VisitInfo>>> patientQueue = new LinkedHashMap<>();
    LinkedHashMap<LocalTime, VisitInfo> emergencyPatientQueue = new LinkedHashMap<>();

    public void addInPatientQueue(VisitInfo visit) {
        if (patientQueue.containsKey(LocalDate.now())) {
        }
    }

    @Override
    public int numberOfPatientsAtDoctorByDate(LocalDate date, Doctor doctor) {
        if (!patientQueue.containsKey(date)) {
            return 0;
        }
        return patientQueue.get(date).get(doctor).size();
    }

    @Override
    public void addInEmergencyPatientQueue(VisitInfo visit) {
        emergencyPatientQueue.put(LocalTime.now(), visit);
    }

    @Override
    public ArrayDeque<VisitInfo> queueSortedByPriority() {
        return null;
    }

    @Override
    public ArrayDeque<VisitInfo> queueByDate() {
        return null;
    }
}
