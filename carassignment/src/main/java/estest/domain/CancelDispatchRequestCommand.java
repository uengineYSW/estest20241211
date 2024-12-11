package estest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelDispatchRequestCommand {

    private Long dispatchRequestId;
    private String cancellationReason;
}
