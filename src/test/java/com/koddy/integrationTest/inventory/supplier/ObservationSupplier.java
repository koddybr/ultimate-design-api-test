package com.koddy.integrationTest.inventory.supplier;

import com.koddy.integrationTest.inventory.dto.ObservationDto;
import com.koddy.util.RequestUtil;

public class ObservationSupplier {

    public static ObservationDto get() {
        ObservationDto observationDto = new ObservationDto();
        observationDto.setName("Observation demo: "+ RequestUtil.generateCode());
        observationDto.setDescription("Traslado Ultimate");
        return observationDto;
    }

    public static ObservationDto getFirstRow() {
        ObservationDto observationDto = new ObservationDto();
        observationDto.setName("(A)-Traslado Ultimate");
        observationDto.setDescription("Traslado Ultimate");
        return observationDto;
    }
}
