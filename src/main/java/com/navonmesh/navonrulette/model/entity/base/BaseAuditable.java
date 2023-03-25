package com.navonmesh.navonrulette.model.entity.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.navonmesh.navonrulette.configuration.constant.DataFormatConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseAuditable implements Serializable {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = DataFormatConstant.TIMESTAMP_OUTPUT_FORMAT)
    @Column(updatable = false)
    private Calendar createdOn;

    @LastModifiedBy
    private String modifiedBy;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = DataFormatConstant.TIMESTAMP_OUTPUT_FORMAT)
    private Calendar updatedOn;
}
