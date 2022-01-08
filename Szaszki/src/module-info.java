module Szaszki {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
    opens controllers to javafx.fxml, javafx.graphics;
}