package downloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author macb
 */
public class Logic {

    public static Button button_LOADFILE;
    public static MenuItem menu_ACTION;
    public static Stage mainStage;
    public static TextField edit_FILENAME;
    public static ListView<String> list_FILES;
    public static ObservableList<String> data = FXCollections.observableArrayList();
    public static StackPane paneMain;
    public static ProgressIndicator[] pB;

    public static void DoAction(ActionEvent event) {
        if (event.getSource() == button_LOADFILE) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(mainStage);

            if (file != null) {
                edit_FILENAME.setText(file.getPath());

                try {

                    BufferedReader br = new BufferedReader(new FileReader(edit_FILENAME.getText()));
                    while (true) {
                        String str = br.readLine();
                        if (str == null) {
                            break;
                        }

                        if (!str.isEmpty()) {
                            data.add(str);
                        }
                    }
                    br.close();

                    if (data.size() != 0) {
                        list_FILES.setItems(data);
                        pB = new ProgressIndicator[list_FILES.getItems().size()];
                    
                    }

                } catch (IOException e) {

                }

            }

        }

    }

    public static void DoActionMenu(ActionEvent event) {
        
        VBox vB = new VBox();
        vB.setMinHeight(paneMain.getHeight());
        vB.setMinWidth(paneMain.getWidth());

        vB.setSpacing(10);
        vB.setAlignment(Pos.CENTER);

        for (int i = 0; i < list_FILES.getItems().size(); i++) {

            pB[i] = new ProgressIndicator();
            pB[i].setMinWidth(paneMain.getWidth());
           
            //pB[i].setProgress(0);
            vB.getChildren().add(pB[i]);

            
        //creating tasks
            
           TaskDowload tD = new TaskDowload(list_FILES.getItems().get(i),i); 
           Thread tDownload = new Thread(tD);
           tDownload.setPriority(i+1);
           tDownload.start();

            
//creating threads
            
//            ThreadDowload tD = new ThreadDowload(list_FILES.getItems().get(i), i); 
//            Thread tDownload = new Thread(tD);
//            tDownload.start();
        
        
        }
        paneMain.getChildren().add(vB);
        
        
         

    }


   public static synchronized void EndDownload(String url, int pos) {
       System.out.println(pos);
      
       pB[0].setVisible(false);
//       er
   }
    
}
