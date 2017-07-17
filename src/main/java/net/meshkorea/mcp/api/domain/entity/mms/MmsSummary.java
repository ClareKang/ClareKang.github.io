package net.meshkorea.mcp.api.domain.entity.mms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
@Setter
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
@Table(name = "mms_summary")
public class MmsSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mms_summary_no")
    private Long mmsSummaryNo;

    @Column(name = "mms_sender")
    private String mmsSender;

    @CreatedDate
    @Column(name = "mms_trans_date", updatable = false)
    private LocalDateTime mmsTransDate;

    @OneToMany(mappedBy = "mmsSummary")
    private List<MmsGroupLog> mmsGroupLogs;

}
