package org.sekularac.domaci.entities;

import org.sekularac.domaci.utils.Utils;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tweets extends BasicEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Properties
    private String username;
    private String messageBody;
    private Timestamp createdOn;

    // Column names
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_MESSAGE_BODY = "message_body";
    private static final String COLUMN_CREATED_ON = "created_on";


    public Tweets() {
        super();
        this.columnNames.add(COLUMN_USERNAME);
        this.columnNames.add(COLUMN_MESSAGE_BODY);
        this.columnNames.add(COLUMN_CREATED_ON);
    }

    @Override
    public void setValueForColumnName(String columnName, Object value) {
        if (COLUMN_USERNAME.equals(columnName)) {
            this.username = Utils.safeConvertToStr(value);
        } else if (COLUMN_MESSAGE_BODY.equals(columnName)) {
            this.messageBody = Utils.safeConvertToStr(value);
        } else if (COLUMN_CREATED_ON.equals(columnName)) {
            this.createdOn = new Timestamp((long)value);
        } else {
            super.setValueForColumnName(columnName, value);
        }
    }

    @Override
    public Object getValueForColumnName(String columnName) {
        if (COLUMN_USERNAME.equals(columnName)) {
            return this.username;
        } else if (COLUMN_MESSAGE_BODY.equals(columnName)) {
            return this.messageBody;
        } else if (COLUMN_CREATED_ON.equals(columnName)) {
            return this.createdOn;
        }
        return super.getValueForColumnName(columnName);
    }
}
