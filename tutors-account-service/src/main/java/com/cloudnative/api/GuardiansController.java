package com.cloudnative.api;

import com.cloudnative.domain.guardian.Guardian;
import com.cloudnative.domain.guardian.GuardianRepository;
import com.cloudnative.domain.guardian.GuardianService;
import com.cloudnative.error.GuardianNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * Created by msambangi on 10/26/17.
 */

@RestController
@RequestMapping("v1/guardians")
public class GuardiansController {

    @Autowired
    private GuardianService guardianService;

    @Autowired
    private GuardianRepository guardianRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.HEAD, HttpMethod.OPTIONS, HttpMethod.PUT, HttpMethod.DELETE).build();
    }

    @GetMapping
    ResponseEntity<Collection<Guardian>> getGuardians() {
        return ResponseEntity.ok(this.guardianRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Guardian> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.guardianRepository.findById(id).get());
    }

    @PostMapping
    ResponseEntity<Guardian> post(@RequestBody Guardian guardian) {
        Guardian guardian1 = guardianService.createGuardian(guardian).get();

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(guardian1.getId()).toUri();
        return ResponseEntity.created(uri).body(guardian1);

    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) throws GuardianNotFoundException {
        return this.guardianRepository.findById(id).map(g -> {
            guardianRepository.delete(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new GuardianNotFoundException(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    ResponseEntity<?> head(@PathVariable Long id) throws GuardianNotFoundException {
        return this.guardianRepository.findById(id).map(exists -> ResponseEntity.noContent().build()).orElseThrow(() -> new GuardianNotFoundException(id));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Guardian> put(@PathVariable Long id, @RequestBody Guardian guardian) throws GuardianNotFoundException {
        return this.guardianRepository.findById(id).map(existing -> {
            guardian.setId(existing.getId());
            guardian.setAccount(existing.getAccount());
            guardian.setCreatedAt(existing.getCreatedAt());
            Guardian guardian1 = this.guardianRepository.save(guardian);
            URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
            return ResponseEntity.created(selfLink).body(guardian1);
        }).orElseThrow(() -> new GuardianNotFoundException(id));
    }

}
