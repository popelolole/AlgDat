module se.kth.pellebe.f12fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens se.kth.pellebe.f12 to javafx.fxml;
    exports se.kth.pellebe.f12.NB38;
    opens se.kth.pellebe.f12.NB38 to javafx.fxml;
}