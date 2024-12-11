package estest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum Department {
    서울(포스코센터),
    포항제철소,
    광양제철소,
}
