package org.eclipse.scout.apps.contacts.server.organization;

import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class OrganizationService implements IOrganizationService {
    @Override
    public OrganizationTablePageData getOrganizationTableData(SearchFilter filter) {
        OrganizationTablePageData pageData = new OrganizationTablePageData();
// TODO [mega2] fill pageData.
        return pageData;
    }
}
