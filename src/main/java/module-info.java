module org.andrewkozinski.csc325mod5labcolorchooser {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.andrewkozinski.csc325mod5labcolorchooser to javafx.fxml;
    exports org.andrewkozinski.csc325mod5labcolorchooser;
}