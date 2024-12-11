package estest.infra;

import estest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DispatchRequestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DispatchRequest>> {

    @Override
    public EntityModel<DispatchRequest> process(
        EntityModel<DispatchRequest> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/updatedispatchrequest"
                )
                .withRel("updatedispatchrequest")
        );
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
