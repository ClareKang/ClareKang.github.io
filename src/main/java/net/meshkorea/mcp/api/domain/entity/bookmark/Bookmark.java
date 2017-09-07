package net.meshkorea.mcp.api.domain.entity.bookmark;

import lombok.Data;
import net.meshkorea.mcp.api.domain.model.bookmark.BookmarkType;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bookmark")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bmk_no")
    private Long bmkNo;

    // firebase auth 의 사용자 식별자 (1~128자인 문자열)
    @Column(name = "uid")
    private String uid;

    // 배송오더 이외에 추가 예정
    @Column(name = "bmk_type")
    @Enumerated(EnumType.STRING)
    private BookmarkType bmkType;

    @Column(name = "bmk_id")
    private String bmkId;

    @Column(name = "title")
    private String title;

    @Column(name = "memo")
    private String memo;

    @Column(name = "create_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDt;

    @Column(name = "issue_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDt;

    @Column(name = "del_yn")
    private Character delYn;

}
