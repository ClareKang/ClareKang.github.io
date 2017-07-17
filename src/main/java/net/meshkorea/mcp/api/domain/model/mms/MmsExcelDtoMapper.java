package net.meshkorea.mcp.api.domain.model.mms;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 18..
 */
public class MmsExcelDtoMapper {

    public static List<List<String>> convert(List<MmsTransferLogDto> mmsTransferLogDtos) {
        List<List<String>> result = new ArrayList<>();
        mmsTransferLogDtos.forEach(item -> {
            List<String> row = new ArrayList<>();
            row.add(getSendingNumber(item.getMmsGroupLog().getMmsSummary().getMmsSummaryNo()));
            row.add(getTransferStartDate(item.getTransferStartDate()));
            row.add(getOrEmpty(item.getReceiver()));
            row.add(getOrEmpty(item.getReceiverPhone()));
            row.add(getOrEmpty(item.getMmsGroupLog().getMmsSummary().getMmsSender()));
            row.add(getResult(item.getResultCode()));
            result.add(row);
        });
        return result;
    }

    private static String getSendingNumber(Long mmsSummaryNo) {
        if (mmsSummaryNo == null) {
            return StringUtils.EMPTY;
        }
        return String.valueOf(mmsSummaryNo);
    }

    private static String getTransferStartDate(LocalDateTime transferStartDate) {
        if (transferStartDate == null) {
            return StringUtils.EMPTY;
        }
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(transferStartDate);
    }

    private static String getResult(String result) {
        if (result == null) {
            return StringUtils.EMPTY;
        }
        if (StringUtils.equals("1000", result)) {
            return "성공";
        } else {
            return "실패";
        }
    }

    private static String getOrEmpty(String value) {
        if (value == null) {
            return StringUtils.EMPTY;
        }
        return value;
    }

}
