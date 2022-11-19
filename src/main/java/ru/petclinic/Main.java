package ru.petclinic;

import ru.petclinic.patientqueueregistration.CustomException;
import ru.petclinic.patientqueueregistration.PatientQueueRegistration;
import ru.petclinic.patientqueueregistration.doctor.Doctor;
import ru.petclinic.patientqueueregistration.doctor.DoctorSurgeon;
import ru.petclinic.patientqueueregistration.doctor.DoctorTherapist;
import ru.petclinic.patientqueueregistration.visitinfo.VisitInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;

public class Main {
    public static PatientQueueRegistration patientQueueRegistration = new PatientQueueRegistration();
    public static void main(String[] args) throws CustomException {
        Doctor doctor = new DoctorSurgeon("1","Петр Иванович");
        patientQueueRegistration.addDoctorToWork(new DoctorSurgeon("1","Петр Иванович"));
        patientQueueRegistration.addDoctorToWork(new DoctorTherapist("2","Иван Петрович"));
    }





}