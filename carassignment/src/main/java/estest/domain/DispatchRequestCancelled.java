package estest.domain;

import estest.domain.*;
import estest.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DispatchRequestCancelled extends AbstractEvent {

    private Long dispatchRequestId;
    private String cancellationReason;
    private Date cancelledAt;

    public DispatchRequestCancelled(DispatchRequest aggregate) {
        super(aggregate);
    }

    public DispatchRequestCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
