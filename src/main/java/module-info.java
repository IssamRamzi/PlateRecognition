module com.kefelle.platerecognition {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.kefelle.platerecognition to javafx.fxml;
    exports com.kefelle.platerecognition;
}