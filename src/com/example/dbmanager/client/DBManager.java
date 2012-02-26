package com.example.dbmanager.client;

    import com.google.gwt.core.client.EntryPoint;
    import com.google.gwt.core.client.GWT;


    public class DBManager implements EntryPoint {
        private final DBManagerServiceAsync dbmanagerService = GWT.create(DBManagerService.class);


        public void onModuleLoad() {

        }
}

