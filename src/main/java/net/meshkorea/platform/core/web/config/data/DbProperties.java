package net.meshkorea.platform.core.web.config.data;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DbProperties {

	private String driverClassName;
	private String url;

	private String user;
	private String password;

	private Integer minPoolSize;
	private Integer maxPoolSize;
	private Integer maxIdleTime;
	private Integer maintenanceInterval;
	private Integer borrowConnectionTimeout;

	private String testQuery;

	private String uniqueResourceName;

	public AtomikosNonXADataSourceBean toAtomikosNonXADataSourceBean() {
		System.out.println(this.toString());
		AtomikosNonXADataSourceBean dataSource = new AtomikosNonXADataSourceBean();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setMinPoolSize(minPoolSize);
		dataSource.setMaxPoolSize(maxPoolSize);
		dataSource.setMaxIdleTime(maxIdleTime);
		dataSource.setMaintenanceInterval(maintenanceInterval);
		dataSource.setBorrowConnectionTimeout(borrowConnectionTimeout);
		dataSource.setTestQuery(testQuery);
		dataSource.setUniqueResourceName(uniqueResourceName);

		return dataSource;
	}

	@Override
	public String toString() {
		return "Driver Class Name : " + driverClassName + "\n" +
				"URL : " + url + "\n" +
				"User : " + user + "\n" +
				"Password : " + password + "\n" +
				"MinPoolSize : " + minPoolSize + "\n" +
				"MaxPoolSize : " + maxPoolSize + "\n" +
				"MaxIdleTime : " + maxIdleTime + "\n" +
				"MaintenanceInterval : " + maintenanceInterval + "\n" +
				"BorrowConnectionTimeout : " + borrowConnectionTimeout + "\n" +
				"TestQuery : " + testQuery + "\n" +
				"UniqueResourceName : " + uniqueResourceName + "\n";
	}

}
