package org.folio.rest.tenant.controller;

import static org.folio.rest.tenant.TenantConstants.TENANT_HEADER_NAME;

import java.sql.SQLException;

import org.folio.rest.tenant.model.request.TenantAttributes;
import org.folio.rest.tenant.service.HibernateSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/_/tenant")
public class TenantController {

  @Autowired
  private HibernateSchemaService hibernateSchemaService;

  @GetMapping
  public ResponseEntity<String> get(
      @RequestHeader(required = true, value = TENANT_HEADER_NAME) String tenant
    ) throws SQLException {
    return ResponseEntity.ok("Success");
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> create(
      @RequestHeader(required = true, value = TENANT_HEADER_NAME) String tenant,
      @RequestBody @Validated TenantAttributes attributes
    ) throws SQLException {
    hibernateSchemaService.initializeTenant(tenant);
    return ResponseEntity.ok("Success");
  }

  @DeleteMapping
  public ResponseEntity<String> delete(
      @RequestHeader(required = true, value = TENANT_HEADER_NAME) String tenant
    ) throws SQLException {
    hibernateSchemaService.deleteTenant(tenant);
    return ResponseEntity.ok("Success");
  }

}
