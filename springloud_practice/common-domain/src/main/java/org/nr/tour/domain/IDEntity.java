package org.nr.tour.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Wujun
 */
@MappedSuperclass
public class IDEntity implements Serializable {

    @Id
    @Column(name = "id", length = 64)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
