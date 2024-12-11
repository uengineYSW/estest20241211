package estest.infra;

import estest.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/dispatchRequests")
@Transactional
public class DispatchRequestController {

    @Autowired
    DispatchRequestRepository dispatchRequestRepository;

    @RequestMapping(
        value = "/dispatchRequests/{id}/updatedispatchrequest",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DispatchRequest updateDispatchRequest(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateDispatchRequestCommand updateDispatchRequestCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /dispatchRequest/updateDispatchRequest  called #####"
        );
        Optional<DispatchRequest> optionalDispatchRequest = dispatchRequestRepository.findById(
            id
        );

        optionalDispatchRequest.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DispatchRequest dispatchRequest = optionalDispatchRequest.get();
        dispatchRequest.updateDispatchRequest(updateDispatchRequestCommand);

        dispatchRequestRepository.save(dispatchRequest);
        return dispatchRequest;
    }

    @RequestMapping(
        value = "/dispatchRequests/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DispatchRequest cancelDispatchRequest(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelDispatchRequestCommand cancelDispatchRequestCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /dispatchRequest/cancelDispatchRequest  called #####"
        );
        Optional<DispatchRequest> optionalDispatchRequest = dispatchRequestRepository.findById(
            id
        );

        optionalDispatchRequest.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DispatchRequest dispatchRequest = optionalDispatchRequest.get();
        dispatchRequest.cancelDispatchRequest(cancelDispatchRequestCommand);

        dispatchRequestRepository.save(dispatchRequest);
        return dispatchRequest;
    }
}
//>>> Clean Arch / Inbound Adaptor
