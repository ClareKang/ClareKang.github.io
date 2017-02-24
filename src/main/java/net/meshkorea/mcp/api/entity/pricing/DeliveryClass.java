package net.meshkorea.mcp.api.entity.pricing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by mincheoloh on 2016. 7. 18..
 */
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table( name = "DeliveryClass" )
public class DeliveryClass {

    private static Logger logger = LoggerFactory.getLogger(DeliveryClass.class);

    @Id
    @Column( name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "classCode", unique = true)
    private String classCode;

    @Column( name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String className) {
        this.name = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classId) {
        this.classCode = classId;
    }
}
