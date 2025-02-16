package com.admin.scnadmin.repository.appointment;

import com.admin.scnadmin.model.ConsultAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultAppointmentRepository extends JpaRepository<ConsultAppointment, Long> {
}
