package com.kariyer.elasticsearchjobadv.service;

import com.kariyer.elasticsearchjobadv.model.JobAdvertisement;

import java.time.LocalDateTime;
import java.util.List;

public interface JobAdvertisementService {
    JobAdvertisement addJobAdvRecord(JobAdvertisement jobAdvertisement);
    List<JobAdvertisement> searchByDate(String date);
    List<JobAdvertisement> getListByEmployerId(Long employerId);
}
