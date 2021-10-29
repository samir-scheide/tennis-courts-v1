package com.tenniscourts.config.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.tenniscourts.audit.CustomAuditEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Base class that should be used by all entity related classes. It keeps all common fields centralized, magin it easier to maintain and the audit scheme work.
 * @author Samir Scheide
 * @param <ID> can be any type, it will the {@link #id}, or unique identifier, type.
 */
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@EntityListeners(CustomAuditEntityListener.class)
public class BaseEntity<ID> implements Serializable {

  private static final long serialVersionUID = 6679822722077518593L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private ID id;
  
  @Column
  private String ipNumberUpdate;
  
  @Column
  private Long userCreate;
  
  @Column
  private Long userUpdate;
  
  @Column
  @LastModifiedDate
  private LocalDateTime dateUpdate;
  
  @Column
  private String ipNumberCreate;
  
  @Column
  @CreatedDate
  private LocalDateTime dateCreate;
  
}
