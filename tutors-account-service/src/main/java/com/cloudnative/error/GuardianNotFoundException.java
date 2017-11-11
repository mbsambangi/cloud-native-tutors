package com.cloudnative.error;

/**
 * Created by msambangi on 10/26/17.
 */


public class GuardianNotFoundException extends Exception {

    private Long guardianId;
    public GuardianNotFoundException(Long id) {
        super(id + "");
        this.guardianId = id;
    }

    public Long getGuardianId() {
        return this.guardianId;
    }

}
