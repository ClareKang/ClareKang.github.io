package net.meshkorea.mcp.api.domain.entity.bookmark;

import lombok.Data;
import net.meshkorea.mcp.api.domain.model.bookmark.ShareMemoType;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "share_memo")
public class ShareMemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "share_memo_no")
    private Long shareMemoNo;

    // 배송오더 이외에 추가 예정
    @Column(name = "share_memo_type")
    @Enumerated(EnumType.STRING)
    private ShareMemoType shareMemoType;

    @Column(name = "share_memo_id")
    private String shareMemoId;

    @Column(name = "share_memo")
    private String shareMemo;

    @Column(name = "issuor")
    private String issuor;

    @Column(name = "issue_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDt;

}
