package com.fmi.demo.exposition.resources;

import com.fmi.demo.domain.model.Campaign;
import com.fmi.demo.exposition.ICommand.ICommand;
import com.fmi.demo.exposition.IQuerry.CampaignIQuerryImpl;


import com.fmi.demo.exposition.IQuerry.IQuerry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/campaign", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CampaignsResource{

    @Autowired
    private ICommand<Campaign> campaignICommand;

    @Autowired
    private IQuerry<Campaign> campaignIQuerry;

    @PostMapping("")
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) throws Exception{

        String id = campaignICommand.save(campaign);

        final var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + id).toUriString();

        return ResponseEntity.created(new URI(uri))
                .body(campaignIQuerry.getById(id));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("id") String id, @RequestBody Campaign campaign) {
        String objectId = campaignICommand.update(campaign, id);
        return ResponseEntity.ok()
                .body(campaignIQuerry.getById(objectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable("id") String id){
        return ResponseEntity.ok()
                .body(campaignIQuerry.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCampaign(@PathVariable("id") String id){
        campaignICommand.delete(id);
        return ResponseEntity.ok().build();
    }
}