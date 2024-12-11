package estest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchRequestSummaryQuery {

    private Long dispatchRequestId;
    private Requester requester;
    private DispatchPurpose dispatchPurpose;
    private DispatchPeriod dispatchPeriod;
    private VehicleType vehicleType;
}
