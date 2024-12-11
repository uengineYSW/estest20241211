package estest.domain;

import estest.domain.*;
import estest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DispatchRequestUpdated extends AbstractEvent {

    private Long dispatchRequestId;
    private DispatchPurpose dispatchPurpose;
    private DispatchPeriod dispatchPeriod;
    private VehicleType vehicleType;
    private Integer numberOfPassengers;
    private Boolean driverIncluded;
    private String remarks;
    private String contactNumber;
    private File attachment;

    public DispatchRequestUpdated(DispatchRequest aggregate) {
        super(aggregate);
    }

    public DispatchRequestUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
