package net.meshkorea.mcp.api.domain.repository;

import com.querydsl.jpa.JPQLQuery;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import net.meshkorea.mcp.api.domain.entity.mms.QMmsGroupLog;
import net.meshkorea.mcp.api.domain.entity.mms.QMmsSummary;
import net.meshkorea.mcp.api.domain.entity.mms.QMmsTransferLog;
import net.meshkorea.mcp.api.domain.model.mms.MmsListRequest;
import net.meshkorea.mcp.api.domain.model.mms.ResultOptionEnum;
import org.apache.commons.lang3.StringUtils;
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
        QMmsGroupLog mmsGroupLog = QMmsGroupLog.mmsGroupLog;
        QMmsSummary mmsSummary = QMmsSummary.mmsSummary;

        JPQLQuery<MmsTransferLog> query = from(mmsTransferLog);
        query.innerJoin(mmsTransferLog.mmsGroupLog, mmsGroupLog)
            .fetchJoin()
            .innerJoin(mmsGroupLog.mmsSummary, mmsSummary)
            .fetchJoin();

        if (mmsListRequest != null) {
            if (mmsListRequest.getStartDate() != null && mmsListRequest.getEndDate() != null) {
                query.where(
                    mmsTransferLog.sendRequestDate.between(
                        mmsListRequest.getStartDate(), mmsListRequest.getEndDate()
                    )
                );
            }
            if (mmsListRequest.getSearchOption() != null && mmsListRequest.getKeyword() != null) {
                String keyword = mmsListRequest.getKeyword();
                switch (mmsListRequest.getSearchOption()) {
                    case SENDING_ORDER:
                        if (StringUtils.isNumeric(keyword)) {
                            query.where(mmsSummary.mmsSummaryNo.eq(Long.valueOf(keyword)));
                        }
                        break;
                    case RECEIVER_PHONE:
                        query.where(mmsTransferLog.receiverPhone.like("%" + keyword + "%"));
                        break;
                    case RECEIVER_NAME:
                        query.where(mmsTransferLog.receiver.like("%" + keyword + "%"));
                        break;
                    case SENDER:
                        query.where(mmsSummary.mmsSender.eq(keyword));
                        break;
                }
            }
            if (mmsListRequest.getResultOption() != null) {
                switch (mmsListRequest.getResultOption()) {
                    case SUCCESS:
                        query.where(mmsTransferLog.resultCode.eq(ResultOptionEnum.SUCCESS.toString()));
                        break;
                    default:
                        query.where(mmsTransferLog.resultCode.ne(ResultOptionEnum.SUCCESS.toString()));
                        break;
                }
            }
            if (mmsListRequest.getOrderOption() != null) {
                switch (mmsListRequest.getOrderOption()) {
                    case NEWEST:
                        query.orderBy(mmsTransferLog.sendRequestDate.desc());
                        break;
                    case SENDING_ORDER:
                        query.orderBy(mmsSummary.mmsSummaryNo.desc(), mmsTransferLog.sendRequestDate.desc());
                        break;
                    case RECEIVER_NAME:
                        query.orderBy(mmsTransferLog.receiver.asc());
                        break;
                    case RECEIVER_PHONE:
                        query.orderBy(mmsTransferLog.receiverPhone.asc());
                        break;
                }
            }
        }

        List<MmsTransferLog> mmsTransferLogs = getQuerydsl().applyPagination(pageable, query).fetch();
        long totalCount = query.fetchCount();

        return new PageImpl<>(mmsTransferLogs, pageable, totalCount);
    }
}
