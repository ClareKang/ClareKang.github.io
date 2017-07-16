package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import net.meshkorea.mcp.api.domain.entity.mms.QMmsTransferLog;
import net.meshkorea.mcp.api.domain.model.mms.MmsListRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by reverof on 2017-07-17.
 */
public class MmsTransferLogRepositoryImpl extends MmsRepositoryQueryDslSupport implements MmsTransferLogRepositoryCustom {

    public MmsTransferLogRepositoryImpl() {
        super(MmsTransferLog.class);
    }

    public Page<MmsTransferLog> search(MmsListRequest mmsListRequest, Pageable pageable) {
        QMmsTransferLog mmsTransferLog = QMmsTransferLog.mmsTransferLog;

        JPQLQuery<MmsTransferLog> query = from(mmsTransferLog);

        List<MmsTransferLog> mmsTransferLogs = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();


        return new PageImpl<>(mmsTransferLogs, pageable, totalCount);
    }
}
