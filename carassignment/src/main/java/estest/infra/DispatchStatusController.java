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
// @RequestMapping(value="/dispatchStatuses")
@Transactional
public class DispatchStatusController {

    @Autowired
    DispatchStatusRepository dispatchStatusRepository;

    @RequestMapping(
        value = "/dispatchStatuses/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DispatchStatus updateDispatchStatus(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateDispatchStatusCommand updateDispatchStatusCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /dispatchStatus/updateDispatchStatus  called #####"
        );
        Optional<DispatchStatus> optionalDispatchStatus = dispatchStatusRepository.findById(
            id
        );

        optionalDispatchStatus.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DispatchStatus dispatchStatus = optionalDispatchStatus.get();
        dispatchStatus.updateDispatchStatus(updateDispatchStatusCommand);

        dispatchStatusRepository.save(dispatchStatus);
        return dispatchStatus;
    }
}
//>>> Clean Arch / Inbound Adaptor
