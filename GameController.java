/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author footb
 */
public class GameController implements Initializable {

    @FXML
    private AnchorPane TitlePane;
    @FXML
    private Button PlayButton;
    @FXML
    private AnchorPane ChoosePane;
    @FXML
    private Button scissorsButton;
    @FXML
    private Button rockButton;
    @FXML
    private Button paperButton;
    @FXML
    private AnchorPane PlayPane;
    @FXML
    private Button playAgainButton;
    @FXML
    private Text WonText;
    @FXML
    private ImageView rockImg;
    @FXML
    private ImageView paperImg;
    @FXML
    private ImageView ScissorsImg;
    @FXML
    private ImageView rockImg1;
    @FXML
    private ImageView paperImg1;
    @FXML
    private ImageView ScissorsImg1;
    @FXML
    private Text GameText;
    @FXML
    private Text GameText1;
    @FXML
    private Text GameText11;
    @FXML
    private Text GameText111;
    @FXML
    private Text WinScore;
    @FXML
    private Text GameText121;
    @FXML
    private Text LooseScore;
    @FXML
    private Text GameText1211;

    String player, computer = null;
    String rock = "rock";
    String paper = "paper";
    String scissors = "scisors";
    int wins, loses, draw = 0;
    @FXML
    private Text GameText12111;
    @FXML
    private Text DrawScore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PlayButtonClicked(ActionEvent event) {
        TitlePane.setVisible(false);
        ChoosePane.setVisible(true);
    }

    @FXML
    private void scissorsButtonClicked(ActionEvent event) {
        player = scissors;
        ChoosePane.setVisible(false);
        try {
            play();
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void rockButtonClicked(ActionEvent event) {
        player = rock;
        ChoosePane.setVisible(false);
        try {
            play();
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void paperButtonClicked(ActionEvent event) {
        player = paper;
        ChoosePane.setVisible(false);
        try {
            play();
        } catch (InterruptedException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void playAgainButtonClicked(ActionEvent event) {
        playAgain();
    }

    public void play() throws InterruptedException {
        PlayPane.setVisible(true);
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        switch (randomNum) {
            case 1 ->
                computer = rock;
            case 2 ->
                computer = paper;
            case 3 ->
                computer = scissors;
            default -> {
            }
        }
        System.out.println("Player: " + player);
        System.out.println("Computer: " + computer);
        
        GameText.setVisible(false);
        
        /*GameText.setText("Rock");
        sleep(1000);
        GameText.setText("Paper");
        sleep(1000);
        GameText.setText("Scissors");
        sleep(1000);
        GameText.setText("Shoot!");
        GameText.setText("");*/
        if (player.equals(rock)) {
            rockImg.setVisible(true);
        } else if (player.equals(paper)) {
            paperImg.setVisible(true);
        } else if (player.equals(scissors)) {
            ScissorsImg.setVisible(true);
        }
        if (computer.equals(rock)) {
            rockImg1.setVisible(true);
        } else if (computer.equals(paper)) {
            paperImg1.setVisible(true);
        } else if (computer.equals(scissors)) {
            ScissorsImg1.setVisible(true);
        }
        //game logic
        if (player.equals(rock) && computer.equals(paper)) {
            loses++;
            WonText.setText("You lost :(");
            LooseScore.setText(Integer.toString(loses));
        } else if (player.equals(rock) && computer.equals(scissors)) {
            wins++;
            WonText.setText("You Won!!");
            WinScore.setText(Integer.toString(wins));
        } else if (player.equals(rock) && computer.equals(rock)) {
            draw++;
            DrawScore.setText(Integer.toString(draw));
            WonText.setText("No one won. Draw!!");
        }
        if (player.equals(paper) && computer.equals(scissors)) {
            loses++;
            LooseScore.setText(Integer.toString(loses));
            WonText.setText("You lost :(");

        } else if (player.equals(paper) && computer.equals(rock)) {
            wins++;
            WinScore.setText(Integer.toString(wins));
            WonText.setText("You Won!!");
        } else if (player.equals(paper) && computer.equals(paper)) {
            draw++;
            DrawScore.setText(Integer.toString(draw));
            WonText.setText("No one won. Draw!!");
        }
        if (player.equals(scissors) && computer.equals(rock)) {
            loses++;
            LooseScore.setText(Integer.toString(loses));
            WonText.setText("You lost :(");
        } else if (player.equals(scissors) && computer.equals(paper)) {
            wins++;
            WinScore.setText(Integer.toString(wins));
            WonText.setText("You Won!!");
        } else if (player.equals(scissors) && computer.equals(scissors)) {
            draw++;
            DrawScore.setText(Integer.toString(draw));
            WonText.setText("No one won. Draw!!");
        }
        WonText.setVisible(true);
        playAgainButton.setVisible(true);

    }

    public void playAgain() {
        PlayPane.setVisible(false);
        ChoosePane.setVisible(true);
        rockImg.setVisible(false);
        paperImg.setVisible(false);
        ScissorsImg.setVisible(false);
        rockImg1.setVisible(false);
        paperImg1.setVisible(false);
        ScissorsImg1.setVisible(false);

    }
}
