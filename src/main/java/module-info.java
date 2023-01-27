module com.example.testpractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testpractice to javafx.fxml;
    exports com.example.testpractice;
}