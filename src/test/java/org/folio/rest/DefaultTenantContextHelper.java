package org.folio.rest;

import javax.annotation.PostConstruct;

import org.folio.rest.tenant.TenantConstants;

public abstract class DefaultTenantContextHelper extends TenantContextHelper {

    @PostConstruct
    public void addTenantToContext() {
        addTenantToContext(TenantConstants.DEFAULT_TENANT);
    }

}
