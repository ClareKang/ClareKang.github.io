package net.meshkorea.mcp.api.domain.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by reverof on 2017. 6. 16..
 */
@Data
@Entity
@Table(name = "resource")
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_no")
    private Long resourceNo;

    @ManyToOne
    @JoinColumn(name = "authority_no")
    private Authority authority;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "resource_uri")
    private String resourceUri;

    public void setAuthority(Authority authority) {
        if (this.authority != null)
            this.authority.getResources().remove(this);

        this.authority = authority;
        this.authority.getResources().add(this);
    }

}
