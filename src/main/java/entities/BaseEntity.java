package entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
@MappedSuperclass
@Data
@ToString


public class BaseEntity implements Serializable {
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updateBy;
}
