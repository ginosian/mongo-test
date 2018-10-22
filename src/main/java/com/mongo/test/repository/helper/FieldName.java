package com.mongo.test.repository.helper;

public class FieldName {

    private static final String DELIMITER = ".";

    private static final String ID_FIELD_NAME = "_id";
    private static final String API_ID_FIELD_NAME = "api_id";
    private static final String COUNTRIES_FIELD_NAME = "countries";
    private static final String POSITIONS_FIELD_NAME = "positions";
    private static final String POSITIONS_POSITION_FIELD_NAME = "position";
    private static final String POSITIONS_DATE_FIELD_NAME = "date";


    public static String getCountriesFieldName() {
        return String.join(
                DELIMITER,
                COUNTRIES_FIELD_NAME
        );
    }

    public static String getPositionsFieldName() {
        return String.join(
                DELIMITER,
                POSITIONS_FIELD_NAME
        );
    }

    public static String getPositionFieldName(){
        return String.join(
                DELIMITER,
                getPositionsFieldName(),
                POSITIONS_POSITION_FIELD_NAME
        );
    }

    public static String getPositionDateFieldName(){
        return String.join(
                DELIMITER,
                getPositionsFieldName(),
                POSITIONS_DATE_FIELD_NAME
        );
    }

}
