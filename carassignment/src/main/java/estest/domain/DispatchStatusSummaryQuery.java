package estest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchStatusSummaryQuery {

    private Long dispatchStatusId;
    private Requester requester;
    private String progressStage;
    private Date approvalDate;
    private Date lastUpdatedDate;
}
