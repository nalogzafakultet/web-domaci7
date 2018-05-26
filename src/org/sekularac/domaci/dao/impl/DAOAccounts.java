package org.sekularac.domaci.dao.impl;

import org.sekularac.domaci.dao.IDAOAccounts;
import org.sekularac.domaci.entities.Accounts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOAccounts extends DAOAbstractDatabase<Accounts> implements IDAOAccounts {

    public DAOAccounts() {
        super(Accounts.class);
    }

    @Override
    public boolean login(String username, String password) {
        connection = makeConnection();

        if (connection == null) {
            return false;
        }

        String queryPassword = null;
        String query = "SELECT password FROM accounts WHERE username=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                queryPassword = resultSet.getString(1);
            }

            // Closing cloasable objects
            closeResultSet(resultSet);
            closeStatement(preparedStatement);

            if (queryPassword != null && queryPassword.equals(password)) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return false;
    }
}
