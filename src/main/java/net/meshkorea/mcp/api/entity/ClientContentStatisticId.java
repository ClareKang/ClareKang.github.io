package net.meshkorea.mcp.api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Embeddable
public class ClientContentStatisticId implements Serializable {

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "content_id")
	private Integer contentId;

}
