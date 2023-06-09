package org.eclipse.scout.apps.contacts.client.person;

import org.eclipse.scout.apps.contacts.client.common.CountryLookupCall;
import org.eclipse.scout.apps.contacts.client.person.PersonTablePage.Table;
import org.eclipse.scout.apps.contacts.shared.person.IPersonService;
import org.eclipse.scout.apps.contacts.shared.person.PersonTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;

@Data(PersonTablePageData.class)
public class PersonTablePage extends AbstractPageWithTable<Table> {
    @Override
    protected boolean getConfiguredLeaf() {
        return true;
    }

    @Override
    protected void execLoadData(SearchFilter filter) {
        importPageData(BEANS.get(IPersonService.class).getPersonTableData(filter));
    }

    @Override
    protected String getConfiguredTitle() {
// TODO [mega2] verify translation
        return TEXTS.get("PersonTablePage");
    }

    public class Table extends AbstractTable {
      public CountryColumn getCountryColumn() {
        return getColumnSet().getColumnByClass(CountryColumn.class);
      }

      public EmailColumn getEmailColumn() {
        return getColumnSet().getColumnByClass(EmailColumn.class);
      }

      public FirstNameColumn getFirstNameColumn() {
        return getColumnSet().getColumnByClass(FirstNameColumn.class);
      }

      public LastNameColumn getLastNameColumn() {
        return getColumnSet().getColumnByClass(LastNameColumn.class);
      }

      public MobileColumn getMobileColumn() {
        return getColumnSet().getColumnByClass(MobileColumn.class);
      }

      public PersonIdColumn getPersonIdColumn() {
        return getColumnSet().getColumnByClass(PersonIdColumn.class);
      }

      public CityColumn getPhoneColumn() {
        return getColumnSet().getColumnByClass(CityColumn.class);
      }

      @Order(1000)
      public class PersonIdColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("PersonIdColumn");
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }

        @Override
        protected boolean getConfiguredDisplayable() {
          return false;
        }

        @Override
        protected boolean getConfiguredPrimaryKey() {
          return true;
        }
      }

      @Order(2000)
      public class FirstNameColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("FirstName");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }

      @Order(3000)
      public class LastNameColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("LastName");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }

      @Order(4000)
      public class CityColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("City");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }

      @Order(5000)
      public class CountryColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Country");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }

//        @Override
        protected Class<? extends ILookupCall<String>> getConfiguredLookupCall() {
          return CountryLookupCall.class;
        }
      }

      @Order(6000)
      public class PhoneColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Phone");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }
      }

      @Order(7000)
      public class MobileColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Mobile");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }
      }

      @Order(8000)
      public class EmailColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Email");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }

        
      }
    }
}
