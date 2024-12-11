package estest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum VehicleType {
    승용차,
    승합차,
    화물차,
}
