package org.eclipse.scout.apps.contacts.server.sql;

import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.server.jdbc.postgresql.AbstractPostgreSqlService;

@Order(1950)
public class PostgresSqlService extends AbstractPostgreSqlService {

	@Override
	protected String getConfiguredJdbcMappingName() {
		return "jdbc:postgresql://localhost:5432/contacts";
	}

	@Override
	protected String getConfiguredUsername() {
		return "postgres";
	}

	@Override
	protected String getConfiguredPassword() {
		return "password";
	}
}


