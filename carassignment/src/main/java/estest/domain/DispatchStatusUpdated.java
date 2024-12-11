package estest.domain;

import estest.domain.*;
import estest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DispatchStatusUpdated extends AbstractEvent {

    private Long dispatchStatusId;
    private String progressStage;
    private Date approvalDate;
    private Date lastUpdatedDate;

    public DispatchStatusUpdated(DispatchStatus aggregate) {
        super(aggregate);
    }

    public DispatchStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
