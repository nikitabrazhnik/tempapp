/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloader;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

/**
 *
 * @author macb
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button button_LOADFILE;
    @FXML
    private TextField edit_FILENAME;
    @FXML
    private ListView<String> list_FILES;
    @FXML
    private MenuItem menu_ACTION;
    @FXML
    private StackPane paneMain;
    private ProgressBar progress_1;
    
    private void handleButtonAction(ActionEvent event) {
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        Logic.button_LOADFILE = button_LOADFILE;
        Logic.edit_FILENAME   = edit_FILENAME;
        Logic.list_FILES      = list_FILES;
        Logic.menu_ACTION     = menu_ACTION;
        Logic.paneMain = paneMain;
    }    

   

    @FXML
    private void button_ACTION(ActionEvent event) {
        Logic.DoAction(event);
    
    }

    @FXML
    private void menu_ACTION(ActionEvent event) {
    Logic.DoActionMenu(event);
    }
    
}
