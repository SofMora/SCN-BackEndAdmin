package com.admin.scnadmin.service;

import com.admin.scnadmin.model.ConsultAppointment;
import com.admin.scnadmin.model.Course;
import com.admin.scnadmin.repository.appointment.ConsultAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultAppointmentService {

    @Autowired
    private ConsultAppointmentRepository consultAppointmentRepository;

    public List<ConsultAppointment> getAllConsultAppointment() throws SQLException {
        return consultAppointmentRepository.findAll();
    }

    public ConsultAppointment getConsultAppointment(long id) throws SQLException {
        Optional<ConsultAppointment> optionalconsultAppointment = consultAppointmentRepository.findById(id);
        if (optionalconsultAppointment.isPresent()) {
            return optionalconsultAppointment.get(); // Devuelve el estudiante si lo encuentra
        } else {
            throw new SQLException("Consult Appointment not found"); // Lanza excepción si no se encuentra el estudiante
        }
    }
}
