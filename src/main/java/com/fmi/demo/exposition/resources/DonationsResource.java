package com.fmi.demo.exposition.resources;

import com.fmi.demo.domain.model.Donation;
import com.fmi.demo.exposition.ICommand.ICommand;
import com.fmi.demo.exposition.IQuerry.IQuerry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/donation", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DonationsResource {

    @Autowired
    private ICommand<Donation> donationICommand;

    @Autowired
    private IQuerry<Donation> donationIQuerry;

    @PostMapping("")
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) throws Exception {

        String id = donationICommand.save(donation);

        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();

        return ResponseEntity.created(new URI(uri))
                .body(donationIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Donation> updateDonation(@PathVariable("id") String id, @RequestBody Donation donation) {
        String objectId = donationICommand.update(donation, id);
        return ResponseEntity.ok()
                .body(donationIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(donationIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonation(@PathVariable("id") String id){
        donationICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}
