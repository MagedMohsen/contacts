package org.eclipse.scout.apps.contacts.client.organization;

import org.eclipse.scout.apps.contacts.client.organization.OrganizationTablePage.Table;
import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@Data(OrganizationTablePageData.class)
public class OrganizationTablePage extends AbstractPageWithTable<Table> {
    @Override
    protected boolean getConfiguredLeaf() {
        return true;
    }

    @Override
    protected void execLoadData(SearchFilter filter) {
        importPageData(BEANS.get(IOrganizationService.class).getOrganizationTableData(filter));
    }

    @Override
    protected String getConfiguredTitle() {
// TODO [mega2] verify translation
        return TEXTS.get("Organizations");
    }

    public class Table extends AbstractTable {
      public CityColumn getCityColumn() {
        return getColumnSet().getColumnByClass(CityColumn.class);
      }

      public CountryColumn getCountryColumn() {
        return getColumnSet().getColumnByClass(CountryColumn.class);
      }

      public HomePageColumn getHomePageColumn() {
        return getColumnSet().getColumnByClass(HomePageColumn.class);
      }

      public NameColumn getNameColumn() {
            return getColumnSet().getColumnByClass(NameColumn.class);
        }

        public OrganizationIdColumn getOrganizationIdColumn() {
            return getColumnSet().getColumnByClass(OrganizationIdColumn.class);
        }

        @Order(1000)
        public class OrganizationIdColumn extends AbstractStringColumn {
            @Override
            protected String getConfiguredHeaderText() {
                return TEXTS.get("OrganizationId");
            }

            @Override
            protected int getConfiguredWidth() {
                return 100;
            }

            @Override
            protected boolean getConfiguredVisible() {
                return false;
            }

        }

        @Order(2000)
        public class NameColumn extends AbstractStringColumn {
            @Override
            protected String getConfiguredHeaderText() {
                return TEXTS.get("Name");
            }

            @Override
            protected int getConfiguredWidth() {
                return 120;
            }
        }

      @Order(3000)
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

      @Order(4000)
      public class CountryColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Country");
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }

      @Order(5000)
      public class HomePageColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Homepage");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }
    }
}
