package org.eclipse.scout.apps.contacts.server.person;

import org.eclipse.scout.apps.contacts.shared.person.IPersonService;
import org.eclipse.scout.apps.contacts.shared.person.PersonTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class PersonService implements IPersonService {
    @Override
    public PersonTablePageData getPersonTableData(SearchFilter filter) {
        PersonTablePageData pageData = new PersonTablePageData();
// TODO [mega2] fill pageData.
        return pageData;
    }
}
