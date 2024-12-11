package estest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispatchRequestReference {

    private Requester Requester;

    private DispatchPeriod DispatchPeriod;

    private DispatchPurpose DispatchPurpose;

    private VehicleType VehicleType;

    private Integer NumberOfPassengers;

    private Boolean DriverIncluded;
}
//>>> DDD / Value Object
