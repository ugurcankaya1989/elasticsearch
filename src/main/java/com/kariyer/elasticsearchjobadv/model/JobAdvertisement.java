package com.kariyer.elasticsearchjobadv.model;

import com.kariyer.elasticsearchjobadv.constant.WorkingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "job_advertisement")
public class JobAdvertisement {
    @Id
    @Field(type = FieldType.Long)
    private long id;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime airtime;
    @Field(type = FieldType.Short)
    private short advQuality;
    @Field(type = FieldType.Text)
    private String fringeBenefits;
    @Field(type = FieldType.Keyword)
    private WorkingType workingType;
    @Field(type = FieldType.Text)
    private String salaryInfo;
    @Field(type = FieldType.Long)
    private long employerId;
}
