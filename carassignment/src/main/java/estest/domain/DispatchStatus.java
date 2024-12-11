package estest.domain;

import estest.CarassignmentApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DispatchStatus_table")
@Data
//<<< DDD / Aggregate Root
public class DispatchStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dispatchStatusId;

    @Embedded
    private DispatchRequestReference dispatchRequestReference;

    @Embedded
    private ApprovalDate approvalDate;

    @Embedded
    private ProgressStage progressStage;

    @PrePersist
    public void onPrePersist() {}

    public static DispatchStatusRepository repository() {
        DispatchStatusRepository dispatchStatusRepository = CarassignmentApplication.applicationContext.getBean(
            DispatchStatusRepository.class
        );
        return dispatchStatusRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateDispatchStatus(
        UpdateDispatchStatusCommand updateDispatchStatusCommand
    ) {
        //implement business logic here:

        DispatchStatusUpdated dispatchStatusUpdated = new DispatchStatusUpdated(
            this
        );
        dispatchStatusUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
