package org.eclipse.scout.apps.contacts.server.sql;

import org.eclipse.scout.rt.platform.config.AbstractBooleanConfigProperty;
import org.eclipse.scout.rt.platform.config.AbstractStringConfigProperty;
import org.eclipse.scout.rt.platform.config.AbstractSubjectConfigProperty;

import javax.security.auth.Subject;

public class DatabaseProperties {

    public static class DatabaseAutoCreateProperty extends AbstractBooleanConfigProperty {

        @Override
        public Boolean getDefaultValue() {
            return Boolean.FALSE;
        }

        @Override
        public String getKey() {
            return "contacts.database.autocreate";
        }

        @Override
        public String description() {
            return "Specifies if the pim database should automatically be created if it does not exist yet. The default value is 'false'.";
        }
    }

    public static class DatabaseAutoPopulateProperty extends AbstractBooleanConfigProperty {

        @Override
        public Boolean getDefaultValue() {
            return Boolean.TRUE;
        }

        @Override
        public String getKey() {
            return "contacts.database.autopopulate";
        }

        @Override
        public String description() {
            return "Populating the Database with Testvalues at startup. The default value is 'true'.";
        }
    }

    public static class JdbcMappingNameProperty extends AbstractStringConfigProperty {

        @Override
        public String getDefaultValue() {
            if (System.getProperty("testing.base") != null) {
                return "jdbc:postgresql://" +
                        System.getProperty("testing.base") +
                        ":5432/contacts";
            }
            return "jdbc:postgresql://localhost:5432/contacts";
        }

        @Override
        public String getKey() {
            return "contacts.database.jdbc.mapping.name";
        }

        @Override
        public String description() {
            return "JDBC string for Database connection configuration.";
        }
    }

    public static class JdbcUsernameProperty extends AbstractStringConfigProperty {
        // defines default value and key
        // end::structure[]

        @Override
        public String getDefaultValue() {
            return "postgres";
        }

        @Override
        public String getKey() {
            return "contacts.database.jdbc.username";
        }
        // tag::structure[]

        @Override
        public String description() {
            return "Username for Database connection.";
        }
    }

    public static class JdbcPasswordProperty extends AbstractStringConfigProperty {
        // defines default value and key
        // end::structure[]

        //Maged Mohsen: Change the password to the one you used in Postgres
        @Override
        public String getDefaultValue() {
            return "password";
        }

        @Override
        public String getKey() {
            return "contacts.database.jdbc.password";
        }
        // tag::structure[]

        @Override
        public String description() {
            return "Password for Database connection.";
        }
    }

    public static class Jdbc2MappingNameProperty extends AbstractStringConfigProperty {

        @Override
        public String getDefaultValue() {
            return "jdbc:postgresql://pimdev02:5432/pim";
        }

        @Override
        public String getKey() {
            return "pim.database02.jdbc.mapping.name";
        }

        @Override
        public String description() {
            return "JDBC string for PimDatabase02 connection configuration.";
        }
    }

    public static class Jdbc2UsernameProperty extends AbstractStringConfigProperty {
        // defines default value and key
        // end::structure[]

        @Override
        public String getDefaultValue() {
            return "pim";
        }

        @Override
        public String getKey() {
            return "pim.database02.jdbc.username";
        }
        // tag::structure[]

        @Override
        public String description() {
            return "Username for PimDatabase02 connection.";
        }
    }

    public static class Jdbc2PasswordProperty extends AbstractStringConfigProperty {
        // defines default value and key
        // end::structure[]

        @Override
        public String getDefaultValue() {
            return "tn$m_]-g7X._Q.JV(.[G4@qp";
        }

        @Override
        public String getKey() {
            return "pim.database02.jdbc.password";
        }
        // tag::structure[]

        @Override
        public String description() {
            return "Password for PimDatabase02 connection.";
        }
    }

    public static class SuperUserSubjectProperty extends AbstractSubjectConfigProperty {

        @Override
        public Subject getDefaultValue() {
            return convertToSubject("pim");
        }

        @Override
        public String getKey() {
            return "pim.superuser";
        }

        @Override
        public String description() {
            return "User for initial Database operations.";
        }
    }
}
