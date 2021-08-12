package com.kariyer.elasticsearchjobadv.controller;

import com.kariyer.elasticsearchjobadv.model.JobAdvertisement;
import com.kariyer.elasticsearchjobadv.service.JobAdvertisementService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/elasticsearch")
public class JobAdvertisementElasticController {

    private final JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementElasticController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping(path = "/search-by-date")
    public ResponseEntity<List<JobAdvertisement>> searchJobAdvList(@RequestParam("date") String date){
        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementService.searchByDate(date);
        return ResponseEntity.ok(jobAdvertisementList);
    }

    @GetMapping(path = "/jobs-by-employer")
    public ResponseEntity<List<JobAdvertisement>> getAllJobAdvList(@RequestParam("employerId") Long employerId){
        List<JobAdvertisement> jobAdvertisementList = jobAdvertisementService.getListByEmployerId(employerId);
        return ResponseEntity.ok(jobAdvertisementList);
    }

    @PostMapping(path = "/save-job-advertisement")
    public ResponseEntity<JobAdvertisement> getAllJobAdvList(@RequestBody JobAdvertisement jobAdvertisement){
        JobAdvertisement savedJobAdvertisement = jobAdvertisementService.addJobAdvRecord(jobAdvertisement);
        return ResponseEntity.ok(savedJobAdvertisement);
    }

}
