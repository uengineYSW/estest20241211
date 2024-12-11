package estest.domain;

import estest.domain.*;
import estest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DispatchRequestCreated extends AbstractEvent {

    private Long dispatchRequestId;
    private Requester requester;
    private ApprovalInfo approvalInfo;
    private DispatchPeriod dispatchPeriod;
    private DispatchPurpose dispatchPurpose;
    private VehicleType vehicleType;
    private Integer numberOfPassengers;
    private Boolean driverIncluded;
    private String remarks;
    private String contactNumber;
    private File attachment;
    private DispatchStatus status;

    public DispatchRequestCreated(DispatchRequest aggregate) {
        super(aggregate);
    }

    public DispatchRequestCreated() {
        super();
    }
}
//>>> DDD / Domain Event
