import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.security.auth.login.LoginException;
import org.omg.CORBA.Environment;

public class FXMLDocumentController {

    @FXML
    private AnchorPane anchorPaneRopotti;
    
    @FXML
    private Label lblRopottiStatus;
    
    @FXML
    private Label lblKuvatusStatus;

    @FXML
    private ToggleButton toggleBtnRopottiStatus;

    @FXML
    private TextField textFieldRopottiMsg;

    @FXML
    private Button btnRopottiSend;

    @FXML
    private TextField textFieldRopottiPrefix;

    @FXML
    private Button btnPrefix1;

    @FXML
    private Button btnRopotti;

    @FXML
    private Button btnKuvatus;
    
    @FXML
    private Button btnCloseProgram;

    @FXML
    private AnchorPane anchorPaneKuvatus;

    @FXML
    private ToggleButton toggleBtnKuvatusJoku;

    @FXML
    private TextField textFieldKuvatusMsg;

    @FXML
    private Button btnKuvatusSend;

    @FXML
    private TextField textFieldKuvatusPrefix;
    
    @FXML
    private TextArea textFieldRopottiQuotet;

    @FXML
    private Button btnPrefixKuvatus;
    
    @FXML
    private Button btnRopottiQuotet;
    
    
    @FXML //SAMMUTUSNAPPI
    void btnCloseClicked(ActionEvent event) {

        Platform.exit(); //sulkee ikkunat
        System.exit(0);  //sammuttaa koko ohjelman
    }
 
    @FXML
    void btnQuotetClicked(ActionEvent event) {
        for(int i = 0; i < RopottiSetup.quoteCounter; i++){
            if (i == 0)textFieldRopottiQuotet.setText(RopottiSetup.quotet[i]);
            else textFieldRopottiQuotet.setText(textFieldRopottiQuotet.getText() + "\n" + RopottiSetup.quotet[i]);
        }        
    }

    @FXML
    void btnPrefixClicked(ActionEvent event) {
        if(event.getSource() == btnPrefixKuvatus){
            KuvatusSetup.prefix = textFieldKuvatusPrefix.getText();
        }
        if (event.getSource() == btnPrefix1){
            RopottiSetup.prefix = textFieldRopottiPrefix.getText();
        }
    }

    @FXML
    void btnSendClicked(ActionEvent event) {
        if(event.getSource() == btnKuvatusSend){
            KuvatusSetup.msgKuvatus = textFieldKuvatusMsg.getText();
        }
        if(event.getSource() == btnRopottiSend){
            RopottiSetup.msgRopotti = textFieldRopottiMsg.getText();
        }
    }

    @FXML
    void changeBot(ActionEvent event) throws LoginException {
        if(event.getSource() == btnKuvatus){
            anchorPaneRopotti.setVisible(false);
            anchorPaneKuvatus.setVisible(true);
            //KuvatusSetup.botSetup();
        }
        else if(event.getSource() == btnRopotti){
            anchorPaneKuvatus.setVisible(false);
            anchorPaneRopotti.setVisible(true);   
            //RopottiSetup.botSetup();
        }
    }

    @FXML
    void toggleBtnClicked(ActionEvent event) {
        if(event.getSource() == toggleBtnKuvatusJoku){
            KuvatusSetup.botStatus();
            lblKuvatusStatus.setText(KuvatusSetup.kuvatusStatus);
            lblKuvatusStatus.setTextFill(KuvatusSetup.kuvatusStatusColor);
        }
        else if(event.getSource() == toggleBtnRopottiStatus){
            RopottiSetup.botStatus();
            lblRopottiStatus.setText(RopottiSetup.ropottiStatus);
            lblRopottiStatus.setTextFill(RopottiSetup.ropottiStatusColor);
        }
    }

}