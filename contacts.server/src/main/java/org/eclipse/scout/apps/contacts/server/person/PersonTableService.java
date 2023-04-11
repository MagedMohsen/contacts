package org.eclipse.scout.apps.contacts.server.person;

import org.eclipse.scout.apps.contacts.shared.person.IPersonTableService;
import org.eclipse.scout.apps.contacts.shared.person.PersonTableTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class PersonTableService implements IPersonTableService {
    @Override
    public PersonTableTablePageData getPersonTableTableData(SearchFilter filter) {

        PersonTableTablePageData pageData = new PersonTableTablePageData();
// TODO [mega2] fill pageData.
        return pageData;
    }
}
