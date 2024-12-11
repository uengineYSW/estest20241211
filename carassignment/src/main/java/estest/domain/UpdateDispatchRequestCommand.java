package estest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDispatchRequestCommand {

    private Long dispatchRequestId;
    private DispatchPurpose dispatchPurpose;
    private DispatchPeriod dispatchPeriod;
    private VehicleType vehicleType;
    private Integer numberOfPassengers;
    private Boolean driverIncluded;
    private String remarks;
    private String contactNumber;
    private File attachment;
}
