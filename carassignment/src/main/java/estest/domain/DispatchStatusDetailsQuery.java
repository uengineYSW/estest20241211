package estest.domain;

import java.util.Date;
import lombok.Data;

@Data
public class DispatchStatusDetailsQuery {

    private Long dispatchStatusId;
    private DispatchRequestReference dispatchRequestReference;
    private String progressStage;
    private Date approvalDate;
    private Date lastUpdatedDate;
}
