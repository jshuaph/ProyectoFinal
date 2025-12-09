module com.tap.gestiontorneo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens com.tap.gestiontorneo to javafx.fxml;
    exports com.tap.gestiontorneo;
    exports com.tap.gestiontorneo.View;
}