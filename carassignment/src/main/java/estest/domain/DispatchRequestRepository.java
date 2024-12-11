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
    collectionResourceRel = "dispatchRequests",
    path = "dispatchRequests"
)
public interface DispatchRequestRepository
    extends PagingAndSortingRepository<DispatchRequest, Long> {
    @Query(
        value = "select dispatchRequest " +
        "from DispatchRequest dispatchRequest " +
        "where(:dispatchRequestId is null or dispatchRequest.dispatchRequestId = :dispatchRequestId) and (:requester is null or dispatchRequest.requester = :requester) and (:dispatchPurpose is null or dispatchRequest.dispatchPurpose = :dispatchPurpose) and (:dispatchPeriod is null or dispatchRequest.dispatchPeriod = :dispatchPeriod) and (:vehicleType is null or dispatchRequest.vehicleType = :vehicleType)"
    )
    List<DispatchRequest> dispatchRequestSummary(
        Long dispatchRequestId,
        Requester requester,
        DispatchPurpose dispatchPurpose,
        DispatchPeriod dispatchPeriod,
        VehicleType vehicleType,
        Pageable pageable
    );

    @Query(
        value = "select dispatchRequest " +
        "from DispatchRequest dispatchRequest " +
        "where(:dispatchRequestId is null or dispatchRequest.dispatchRequestId = :dispatchRequestId) and (:requester is null or dispatchRequest.requester = :requester) and (:approvalInfo is null or dispatchRequest.approvalInfo = :approvalInfo) and (:dispatchPurpose is null or dispatchRequest.dispatchPurpose = :dispatchPurpose) and (:dispatchPeriod is null or dispatchRequest.dispatchPeriod = :dispatchPeriod) and (:vehicleType is null or dispatchRequest.vehicleType = :vehicleType) and (:numberOfPassengers is null or dispatchRequest.numberOfPassengers = :numberOfPassengers) and (dispatchRequest.driverIncluded = :driverIncluded) and (:remarks is null or dispatchRequest.remarks like %:remarks%) and (:contactNumber is null or dispatchRequest.contactNumber like %:contactNumber%) and (:attachment is null or dispatchRequest.attachment = :attachment) and (:status is null or dispatchRequest.status = :status)"
    )
    DispatchRequest dispatchRequestDetails(
        Long dispatchRequestId,
        Requester requester,
        ApprovalInfo approvalInfo,
        DispatchPurpose dispatchPurpose,
        DispatchPeriod dispatchPeriod,
        VehicleType vehicleType,
        Integer numberOfPassengers,
        Boolean driverIncluded,
        String remarks,
        String contactNumber,
        File attachment,
        DispatchStatus status
    );
}
