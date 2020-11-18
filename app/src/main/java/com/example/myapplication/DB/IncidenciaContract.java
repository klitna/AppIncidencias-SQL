package com.example.myapplication.DB;

import android.provider.BaseColumns;

public class IncidenciaContract {
    private IncidenciaContract(){}
    public static class IncidenciaEntry implements BaseColumns {
        public static final String TABLE_NAME ="Incidencia";
        public static final String ID = "Id";
        public static final String COLUMN_NAME_TITLE = "Title";
        public static final String COLUMN2_NAME_TITLE = "Urgence";
    }
}
