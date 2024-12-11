package estest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestDetailsQuery {

    private Long dispatchRequestId;
    private Requester requester;
    private ApprovalInfo approvalInfo;
    private DispatchPurpose dispatchPurpose;
    private DispatchPeriod dispatchPeriod;
    private VehicleType vehicleType;
    private Integer numberOfPassengers;
    private Boolean driverIncluded;
    private String remarks;
    private String contactNumber;
    private File attachment;
    private DispatchStatus status;
}
