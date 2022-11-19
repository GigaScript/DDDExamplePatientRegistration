package ru.petclinic.patientqueueregistration;

import ru.petclinic.patientqueueregistration.client.Client;
import ru.petclinic.patientqueueregistration.doctor.Doctor;
import ru.petclinic.patientqueueregistration.repository.QueueInMemoryRepository;
import ru.petclinic.patientqueueregistration.repository.QueueRepository;
import ru.petclinic.patientqueueregistration.visitinfo.VisitInfo;
import ru.petclinic.patientqueueregistration.visitinfo.VisitPriority;
import ru.petclinic.patientqueueregistration.visitinfo.VisitPurpose;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;

public class PatientQueueRegistration {
    private final QueueRepository queueRepository = new QueueInMemoryRepository();
    private final LocalTime firstWorkingHour = LocalTime.parse("09:00");
    private final LocalTime lastWorkingHour = LocalTime.parse("18:00");
    private final LinkedList<Doctor> doctorInWork = new LinkedList<>();
    private Client client;
    private String problemDescription;
    private VisitPriority visitPriority;
    private LocalDate desiredDate;
    private LocalTime desiredTime;


    private void addRecordInNearTime(Client client, String problemDescription) throws CustomException {
        LocalDate localDate = LocalDate.now();
        Doctor doctor;
        int numberOfPatients;
        int maxNumberOfPatients;
        for (int i = 0; i < doctorInWork.size(); i++) {
            numberOfPatients = queueRepository.numberOfPatientsAtDoctorByDate(localDate,doctorInWork.get(i));
        }
        VisitInfo visitInfo = new VisitInfo(
                VisitPriority.emergency,
                VisitPurpose.operation,
                problemDescription,
                LocalDateTime.now()
        );

    }

    public void addEmergencePatientInQueue(Client client, String problemDescription, VisitPurpose visitPurpose) throws CustomException {
        VisitInfo visitInfo = new VisitInfo(
                VisitPriority.emergency,
                visitPurpose,
                problemDescription,
                LocalDateTime.now()
        );
        queueRepository.addInEmergencyPatientQueue(visitInfo);
    }

    public void addDoctorToWork(Doctor doctor) throws CustomException {
            checkDoctorInWorkBeforeAdd(doctor);
        doctorInWork.add(doctor);
    }

    public static boolean isWorkingTime(LocalTime checkingTime, LocalTime firstWorkingHour, LocalTime lastWorkingHour) throws CustomException {
        if (!checkingTime.isBefore(firstWorkingHour) && !checkingTime.isAfter(lastWorkingHour) != true) {
            throw new CustomException("Выбрана запись в не рабочее время");
        }
        return true;
    }

    private void checkDoctorInWorkBeforeAdd(Doctor doctor) throws CustomException {
        for (int i = 0; i < doctorInWork.size(); i++) {
            if (doctorInWork.get(i).equals(doctor)) {
                throw new CustomException("Попытка добавить уже добавленого доктора с ID=" + doctor.getId());
            }

        }
    }
}
