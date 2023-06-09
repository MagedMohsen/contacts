package org.eclipse.scout.apps.contacts.server.organization;

import org.eclipse.scout.apps.contacts.server.sql.SQLs;
import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationTablePageData;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class OrganizationService implements IOrganizationService {
    @Override
    public OrganizationTablePageData getOrganizationTableData(SearchFilter filter) {
        OrganizationTablePageData pageData = new OrganizationTablePageData();
      String sql = SQLs.ORGANIZATION_PAGE_SELECT + SQLs.ORGANIZATION_PAGE_DATA_SELECT_INTO;
      SQL.selectInto(sql, new NVPair("page", pageData));


// TODO [mega2] fill pageData.
        return pageData;
    }
}
