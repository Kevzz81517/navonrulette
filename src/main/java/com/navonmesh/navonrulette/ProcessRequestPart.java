package com.navonmesh.navonrulette;

import com.navonmesh.navonrulette.configuration.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessRequestPart {

    private IdentificationType identificationType;

    private List<ProcessRequestPartData> data;

}
