package estest.domain;

import estest.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "dispatchStatuses",
    path = "dispatchStatuses"
)
public interface DispatchStatusRepository
    extends PagingAndSortingRepository<DispatchStatus, Long> {
    @Query(
        value = "select dispatchStatus " +
        "from DispatchStatus dispatchStatus " +
        "where(:dispatchStatusId is null or dispatchStatus.dispatchStatusId = :dispatchStatusId) and (:requester is null or dispatchStatus.requester = :requester) and (:progressStage is null or dispatchStatus.progressStage like %:progressStage%) and (:approvalDate is null or dispatchStatus.approvalDate = :approvalDate) and (:lastUpdatedDate is null or dispatchStatus.lastUpdatedDate = :lastUpdatedDate)"
    )
    List<DispatchStatus> dispatchStatusSummary(
        Long dispatchStatusId,
        Requester requester,
        String progressStage,
        Date approvalDate,
        Date lastUpdatedDate,
        Pageable pageable
    );

    @Query(
        value = "select dispatchStatus " +
        "from DispatchStatus dispatchStatus " +
        "where(:dispatchStatusId is null or dispatchStatus.dispatchStatusId = :dispatchStatusId) and (:dispatchRequestReference is null or dispatchStatus.dispatchRequestReference = :dispatchRequestReference) and (:progressStage is null or dispatchStatus.progressStage like %:progressStage%) and (:approvalDate is null or dispatchStatus.approvalDate = :approvalDate) and (:lastUpdatedDate is null or dispatchStatus.lastUpdatedDate = :lastUpdatedDate)"
    )
    DispatchStatus dispatchStatusDetails(
        Long dispatchStatusId,
        DispatchRequestReference dispatchRequestReference,
        String progressStage,
        Date approvalDate,
        Date lastUpdatedDate
    );
}
