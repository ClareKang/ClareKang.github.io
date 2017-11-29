package net.meshkorea.mcp.api.config.interceptor;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class AuditLogProperties {

    @Value("${interceptor.audit.exclude-methods}")
    private String excludeMethods;

    @Value("${interceptor.audit.include-patterns}")
    private String includePatterns;

    @Value("${interceptor.audit.exclude-patterns}")
    private String excludePatterns;

    public String[] getExcludeMethodArray() {
        return getSplitArray(excludeMethods);
    }

    public String[] getIncludePatternArray() {
        return getSplitArray(includePatterns);
    }

    public String[] getExcludePatternArray() {
        return getSplitArray(excludePatterns);
    }

    private String[] getSplitArray(String csv) {
        List<String> results = new ArrayList<>();
        if (StringUtils.isNotEmpty(csv)) {
            if (StringUtils.containsIgnoreCase(csv, ",")) {
                return StringUtils.split(csv, ",");
            } else {
                results.add(csv);
            }
        }
        return results.toArray(new String[results.size()]);
    }

}
