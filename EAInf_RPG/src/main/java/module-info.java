module com.mycompany.eainf_rpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.eainf_rpg to javafx.fxml;
    exports com.mycompany.eainf_rpg;
}
