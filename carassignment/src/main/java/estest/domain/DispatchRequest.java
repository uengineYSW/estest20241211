package estest.domain;

import estest.CarassignmentApplication;
import estest.domain.DispatchRequestCreated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DispatchRequest_table")
@Data
//<<< DDD / Aggregate Root
public class DispatchRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dispatchRequestId;

    @Embedded
    private Requester requester;

    @Embedded
    private ApprovalInfo approvalInfo;

    @Embedded
    private DispatchPeriod dispatchPeriod;

    @Embedded
    private DispatchPurpose dispatchPurpose;

    @Embedded
    private DispatchStatus status;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Integer numberOfPassengers;

    private Boolean driverIncluded;

    private String remarks;

    private String contactNumber;

    @Embedded
    private File attachment;

    @PostPersist
    public void onPostPersist() {
        DispatchRequestCreated dispatchRequestCreated = new DispatchRequestCreated(
            this
        );
        dispatchRequestCreated.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DispatchRequestRepository repository() {
        DispatchRequestRepository dispatchRequestRepository = CarassignmentApplication.applicationContext.getBean(
            DispatchRequestRepository.class
        );
        return dispatchRequestRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateDispatchRequest(
        UpdateDispatchRequestCommand updateDispatchRequestCommand
    ) {
        //implement business logic here:

        DispatchRequestUpdated dispatchRequestUpdated = new DispatchRequestUpdated(
            this
        );
        dispatchRequestUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelDispatchRequest(
        CancelDispatchRequestCommand cancelDispatchRequestCommand
    ) {
        //implement business logic here:

        DispatchRequestCancelled dispatchRequestCancelled = new DispatchRequestCancelled(
            this
        );
        dispatchRequestCancelled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
