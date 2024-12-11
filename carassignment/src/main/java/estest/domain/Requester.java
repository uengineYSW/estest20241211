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
public class Requester {

    private String Name;

    private String Department;

    private String EmployeeNumber;

    private String PhoneNumber;

    private String MobileNumber;

    private Date RequestDate;
}
//>>> DDD / Value Object
