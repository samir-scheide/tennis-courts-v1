package com.tenniscourts.audit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.tenniscourts.config.persistence.BaseEntity;

/**
 * Whenever an entity is updated os persisted, the application need to run some extra code to set the updated and created dates; <br>
 * It will set the user and host adrress if they aren`t defined in the entity.
 * @author Samir Scheide
 *
 */
public final class CustomAuditEntityListener {

  /**
   * The user ID defined for the system, since all operations must have a user.
   */
  public final static Long USER_SYSTEM_ID = 1L;
  
  /**
   * Set the entity updated time and, if the user or the IP number aren't defined, it will set the {@value #USER_SYSTEM_ID} as the user updating it and the local host address, respectively.
   * @param baseEntity {@link BaseEntity}
   * @throws UnknownHostException Thrown to indicate that the IP address of a host could not be determined.
   */
  @PreUpdate
  public void preUpdate(BaseEntity<?> baseEntity) throws UnknownHostException {
    baseEntity.setDateUpdate(LocalDateTime.now());
    if (Objects.isNull(baseEntity.getUserUpdate())) {
        baseEntity.setUserUpdate(USER_SYSTEM_ID);
    }
    if (Objects.isNull(baseEntity.getIpNumberUpdate())) {
        baseEntity.setIpNumberUpdate(InetAddress.getLocalHost().getHostAddress());
    }
  }
  
  /**
   * Set the entity created and updated time and, if the user isn't defined, it will set the {@value #USER_SYSTEM_ID} as the user creating and updating it. Also, if no IP address ifs found, it will set the local host address.
   * @param baseEntity {@link BaseEntity}
   * @throws UnknownHostException Thrown to indicate that the IP address of a host could not be determined.
   */
  @PrePersist
  public void prePersist(BaseEntity<?> baseEntity) throws UnknownHostException {
    baseEntity.setDateCreate(LocalDateTime.now());
    if (Objects.isNull(baseEntity.getUserCreate())) {
      baseEntity.setUserCreate(USER_SYSTEM_ID);
    }
    baseEntity.setDateUpdate(LocalDateTime.now());
    if (Objects.isNull(baseEntity.getUserUpdate())) {
        baseEntity.setUserUpdate(USER_SYSTEM_ID);
    }
    if (Objects.isNull(baseEntity.getIpNumberCreate())) {
      baseEntity.setIpNumberUpdate(InetAddress.getLocalHost().getHostAddress());
    }
  }
}