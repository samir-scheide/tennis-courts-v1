package com.tenniscourts.reservations;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tenniscourts.config.persistence.BaseEntity;
import com.tenniscourts.guests.Guest;
import com.tenniscourts.schedules.Schedule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Reservation extends BaseEntity<Long> {

  private static final long serialVersionUID = 6202270463230922983L;

  @OneToOne
  private Guest guest;

  @ManyToOne
  @NotNull
  private Schedule schedule;

  @NotNull
  private BigDecimal value;

  @NotNull
  private ReservationStatus reservationStatus = ReservationStatus.READY_TO_PLAY;

  private BigDecimal refundValue;
}
