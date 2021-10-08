package com.tenniscourts.guests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tenniscourts.config.persistence.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Guest extends BaseEntity<Long> {

  private static final long serialVersionUID = 325562220286578553L;

  @Column
  @NotNull
  private String name;

}
