package com.navonmesh.navonrulette;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessRequest {

    private String tenantId;

    private List<ProcessRequestPart> dataEntities;
}
