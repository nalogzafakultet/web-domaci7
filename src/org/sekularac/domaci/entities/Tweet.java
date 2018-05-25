package org.sekularac.domaci.entities;

import java.sql.Timestamp;

public class Tweet extends BasicEntity {

    // Properties
    private String username;
    private String messageBody;
    private Timestamp createdOn;

    // Column names
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_MESSAGE_BODY = "message_body";
    private static final String COLUMN_CREATED_ON = "created_on";


    public Tweet() {
        super();
        this.columnNames.add(COLUMN_USERNAME);
    }
}
