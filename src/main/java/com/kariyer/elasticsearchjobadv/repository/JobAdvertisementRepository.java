package com.kariyer.elasticsearchjobadv.repository;

import com.kariyer.elasticsearchjobadv.model.JobAdvertisement;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JobAdvertisementRepository extends ElasticsearchRepository<JobAdvertisement,Long> {
    List<JobAdvertisement> findJobAdvertisementsByEmployerId(Long employerId);
    List<JobAdvertisement> findJobAdvertisementsByAirtimeIsBefore(LocalDateTime dateTime);
}
