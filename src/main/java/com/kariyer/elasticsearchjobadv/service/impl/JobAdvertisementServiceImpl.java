package com.kariyer.elasticsearchjobadv.service.impl;

import com.kariyer.elasticsearchjobadv.model.JobAdvertisement;
import com.kariyer.elasticsearchjobadv.repository.JobAdvertisementRepository;
import com.kariyer.elasticsearchjobadv.service.JobAdvertisementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final JobAdvertisementRepository jobAdvertisementRepository;

    public JobAdvertisementServiceImpl(JobAdvertisementRepository jobAdvertisementRepository) {
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }

    @Override
    public JobAdvertisement addJobAdvRecord(JobAdvertisement jobAdvertisement) {
        return jobAdvertisementRepository.save(jobAdvertisement);
    }

    @Override
    public List<JobAdvertisement> searchByDate(String date) {
        LocalDateTime dateTime = LocalDate.parse(date).atTime(0,0,0);
        return jobAdvertisementRepository.findJobAdvertisementsByAirtimeIsBefore(dateTime);
   }

    @Override
    public List<JobAdvertisement> getListByEmployerId(Long employerId) {
        return jobAdvertisementRepository.findJobAdvertisementsByEmployerId(employerId);
    }
}
