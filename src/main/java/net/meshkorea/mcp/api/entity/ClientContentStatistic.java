package net.meshkorea.mcp.api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@ToString(of = { "clientContentStatisticId", "updatedDateTime" })
@EqualsAndHashCode(of = "clientContentStatisticId")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_S_CLIENT_CONTENT_STAT")
@Entity
public class ClientContentStatistic {

	@lombok.experimental.Delegate
	@EmbeddedId
	private ClientContentStatisticId clientContentStatisticId = new ClientContentStatisticId();

	@Setter
	@Getter
	@Column(name = "updated_dt")
	private Timestamp updatedDateTime;
}
