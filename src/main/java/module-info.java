module com.example.hackopgave3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.microsoft.sqlserver.jdbc;
    requires java.sql;


    opens com.example.hackopgave3 to javafx.fxml;
    exports com.example.hackopgave3;
}