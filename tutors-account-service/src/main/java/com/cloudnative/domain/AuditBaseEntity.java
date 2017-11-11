package com.cloudnative.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Created by msambangi on 10/26/17.
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditBaseEntity {

    @CreatedDate
    private Long createdAt;

    @LastModifiedDate
    private Long modifiedAt;
}
