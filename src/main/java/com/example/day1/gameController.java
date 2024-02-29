package com.example.day1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class gameController {
  @FXML
  public Button btn1;
  public Button btn2;
  @FXML
  private Label label1;
  public Label label3;

  @FXML
  private TextField tbox;
  @FXML
  public ImageView img;
  @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    public int score=0;
    public int random_number;
    public int left=7;
    Alert info=new Alert(Alert.AlertType.INFORMATION);

    public gameController(){
      rand();
    }
//    random number genetator
    public void rand(){
      random_number = new Random().nextInt(0, 100);
    }
//    submit button
    public void clickme(MouseEvent mouseEvent) {
      String str=tbox.getText();
      int number=Integer.parseInt(str);
      if(left>0){
        if (number == random_number) {
          label1.setText("Hurrah!!!Your guess is Right...");
          info.setTitle("Congratulation!!!!!");
          info.setHeaderText("You won....");
          info.show();
          btn2.setDisable(false);
          btn1.setDisable(true);
          myScore();
          img.setVisible(false);
        }
        else if (number > random_number) {
          left--;
          label1.setText("You have "+left+" chances left!");
          info.setTitle("OOPS!!!");
          info.setHeaderText("Think lower....");
          tbox.setText("");
          img.setVisible(true);
          info.show();

        }
        else {
          left--;
          label1.setText("You have "+left+" chances left!");
          info.setTitle("OOPS!!!");
          info.setHeaderText("Think higher....");
          tbox.setText("");
          img.setVisible(true);
          info.show();
        }
      }
//      termination
      if (left==0){
        btn1.setDisable(true);
        btn2.setDisable(false);
        info.setTitle("Game Over!!!!");
//        info.setContentText("Better luck next time...");
        info.setHeaderText("Your score is "+score);
        reset();
      }

    }
//    restart game
    public void startAgain(){
      rand();
      btn1.setDisable(false);
      btn2.setDisable(true);
      img.setVisible(false);
      left=7;
      label1.setText("You have "+left+" chances left!");
      tbox.setText("");

    }
//    score
    public void myScore(){
      if(left>=5){
        score+=10;
        label3.setText("Your Score: "+score);
      }
      else if(left==3||left==4){
        score+=5;
        label3.setText("Your Score: "+score);
      }
      else{
        score+=3;
        label3.setText("Your Score: "+score);
      }
    }
//    reset game
    public  void reset(){
      score=0;
      label3.setText("Your Score : "+score);
    }
}