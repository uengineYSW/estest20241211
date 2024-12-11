package estest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDispatchStatusCommand {

    private Long dispatchStatusId;
    private String progressStage;
    private Date approvalDate;
}
