module com.example.lp1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;

    opens com.example.lp1 to javafx.fxml;
    opens com.example.lp1.models to javafx.base;
    exports com.example.lp1;
}