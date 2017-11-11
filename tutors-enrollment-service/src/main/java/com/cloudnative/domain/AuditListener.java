package com.cloudnative.domain;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

@Component
public class AuditListener extends AbstractMongoEventListener<AuditBaseEntity> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<AuditBaseEntity> event) {
        DateTime datetime = new DateTime();

        if (event.getSource().getCreatedAt() == null) {
            event.getSource().setCreatedAt(datetime);
        }

        event.getSource().setModifiedAt(datetime);

        super.onBeforeSave(event);
    }
}
