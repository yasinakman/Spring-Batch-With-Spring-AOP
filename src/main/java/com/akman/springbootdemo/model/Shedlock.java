package com.akman.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "SCHEDULER_LOCK")
public class Shedlock {

    @Id
    @Column(name = "name", length = 64)
    String name;

    @Column(name = "lock_until")
    LocalDateTime lockUntil;

    @Column(name = "locked_at")
    LocalDateTime lockedAt;

    @Column(name = "locked_by")
    String lockedBy;
}
