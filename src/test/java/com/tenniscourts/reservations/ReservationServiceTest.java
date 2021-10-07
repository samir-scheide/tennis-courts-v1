package com.tenniscourts.reservations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.tenniscourts.schedules.Schedule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ReservationService.class)
public class ReservationServiceTest {

    @InjectMocks
    ReservationService reservationService;

    @Test
    public void getRefundValueFullRefund() {
      LocalDateTime startDateTime = LocalDateTime.now().plusDays(2);
      
        Schedule schedule = new Schedule();
        schedule.setStartDateTime(startDateTime);
        
        Reservation reservation = new Reservation();
        reservation.setValue(new BigDecimal(10L));

        reservation.setSchedule(schedule);
        Assert.assertEquals(reservationService.getRefundValue(reservation), new BigDecimal(10));
    }
}