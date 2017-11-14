package net.meshkorea.platform.core.web.config.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "datasource.master")
public class MasterDbProperties extends DbProperties {
}
