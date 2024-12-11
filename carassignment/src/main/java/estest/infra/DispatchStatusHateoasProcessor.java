package estest.infra;

import estest.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DispatchStatusHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DispatchStatus>> {

    @Override
    public EntityModel<DispatchStatus> process(
        EntityModel<DispatchStatus> model
    ) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
