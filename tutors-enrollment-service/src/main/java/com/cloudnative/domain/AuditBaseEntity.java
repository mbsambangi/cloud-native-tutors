package com.cloudnative.domain;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by msambangi on 11/2/17.
 */

@Data
public class AuditBaseEntity {
    private DateTime createdAt, ModifiedAt;
}
