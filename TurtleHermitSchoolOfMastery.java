import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.transform.Scale;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Glow;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.event.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;


public class TurtleHermitSchoolOfMastery extends Application{

  private double currentPL;
  private double nextTransformationPL;

  private ImageView currImgView;
  private ImageView nextImgView;

  private int expAddedFromDes;
  private int expAddedFromCode;
  private int expAddedFromWrite;
  private int expAddedFromLect;
  private int expAddedFromEdVid;
  private int expAddedFromRead;
  private int expAddedFromTeach;
  private int expAddedFromDisc;

  private long designTasksCompleted;
  private long codingTasksCompleted;
  private long writingTasksCompleted;
  private long lectureTasksCompleted;
  private long edVidTasksCompleted;
  private long readingTasksCompleted;
  private long teachingTasksCompleted;
  private long discussionTasksCompleted;

  private double kidGoku = 0.0;
  private double teenGoku = 500000.0;
  private double adultGoku = 1000000.0;
  private double SS1 = 20000000.0;
  private double SS2 = 50000000.0;
  private double SS3 = 100000000.0;
  private double SSGod = 1000000000.0;
  private double SSBlue = 2000000000.0;
  private double SSBlueEv = 4000000000.0;
  private double UltraInstinct = 8000000000.0;
  private double MasteredUI = 10000000000.0;

  private VBox rightVB;
  private VBox leftVB;

  Image KGImg = new Image("./KG2.png");
  ImageView KGImgView = new ImageView(KGImg);

  Image TGImg = new Image("./TG1.png");
  ImageView TGImgView = new ImageView(TGImg);

  Image AGImg = new Image("./AG4.png");
  ImageView AGImgView = new ImageView(AGImg);

  Image SS1Img = new Image("./SS1.png");
  ImageView SS1ImgView = new ImageView(SS1Img);

  Image SS2Img = new Image("./SS2.png");
  ImageView SS2ImgView = new ImageView(SS2Img);

  Image SS3Img = new Image("./SS34.png");
  ImageView SS3ImgView = new ImageView(SS3Img);

  Image SSGImg = new Image("./SSG9.png");
  ImageView SSGImgView = new ImageView(SSGImg);

  Image SSBImg = new Image("./SSB.png");
  ImageView SSBImgView = new ImageView(SSBImg);

  Image SSBKImg = new Image("./SSBK.png");
  ImageView SSBKImgView = new ImageView(SSBKImg);

  Image GUIImg = new Image("./GUI.png");
  ImageView GUIImgView = new ImageView(GUIImg);

  Image GMUIImg = new Image("./GMUI3.png");
  ImageView GMUIImgView = new ImageView(GMUIImg);

  Image ALLGImg = new Image("./ALLG.jpg");
  ImageView ALLGImgView = new ImageView(ALLGImg);

  @Override
  public void start(Stage primaryStage){
    setInstanceVarsFromFileOrDefault();
    setNextTransformation(currentPL);
    setImages(currentPL);
    adjustImageSize(currImgView, nextImgView);

    primaryStage.setTitle("Turtle Hermit School Of Mastery");

    Text currPowerLvl = new Text("Current\nPower Level");
    currPowerLvl.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
    Text nextTransformation = new Text("Next\nTransformation");
    nextTransformation.setFont(Font.font("Verdana", FontWeight.BOLD, 17));

    Text expTxt = new Text("Experience Bar");
    expTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
    Text trainingRegimen = new Text("Training Regimen");
    Font font = Font.font("Verdana", FontWeight.BOLD, 18);
    trainingRegimen.setFont(font);

    Text Designing = new Text("Designing - 600 exp");
    Designing.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Coding = new Text("Coding - 500 exp");
    Coding.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Writing = new Text("Writing - 400 exp");
    Writing.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Lectures = new Text("Lectures - 300 exp");
    Lectures.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text edVids = new Text("Educational Videos - 200 exp");
    edVids.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Reading = new Text("Reading - 100 exp");
    Reading.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Teaching = new Text("Teaching - 700 exp");
    Teaching.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text Discussion = new Text("Software Discussion - 650 exp");
    Discussion.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text effD = new Text("Effort: ");
    effD.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effC = new Text("Effort: ");
    effC.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effW = new Text("Effort: ");
    effW.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effL = new Text("Effort: ");
    effL.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effE = new Text("Effort: ");
    effE.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effR = new Text("Effort: ");
    effR.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effT = new Text("Effort: ");
    effT.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    Text effCD = new Text("Effort: ");
    effCD.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text history = new Text("History");
    history.setFont(Font.font("Verdana", FontWeight.BOLD, 11));


    Text designTasksCompletedTxt = new Text("Designing Tasks Completed: ");
    designTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String desTasCompletedStr = Long.toString(designTasksCompleted);
    Text designTasksCompletedNumTxt = new Text(desTasCompletedStr);
    designTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text codingTasksCompletedTxt = new Text("Coding Tasks Completed: ");
    codingTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String codTasCompletedStr = Long.toString(codingTasksCompleted);
    Text codingTasksCompletedNumTxt = new Text(codTasCompletedStr);
    codingTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text writingTasksCompletedTxt = new Text("Writing Tasks Completed: ");
    writingTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String wriTasCompletedStr = Long.toString(writingTasksCompleted);
    Text writingTasksCompletedNumTxt = new Text(wriTasCompletedStr);
    writingTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text lectureTasksCompletedTxt = new Text("Lecture Tasks Completed: ");
    lectureTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String lecTasCompletedStr = Long.toString(lectureTasksCompleted);
    Text lectureTasksCompletedNumTxt = new Text(lecTasCompletedStr);
    lectureTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text edVidTasksCompletedTxt = new Text("Educational Videos Watched: ");
    edVidTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String edVidTasCompletedStr = Long.toString(edVidTasksCompleted);
    Text edVidTasksCompletedNumTxt = new Text(edVidTasCompletedStr);
    edVidTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text readingTasksCompletedTxt = new Text("Reading Tasks Completed: ");
    readingTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String readTasCompletedStr = Long.toString(readingTasksCompleted);
    Text readingTasksCompletedNumTxt = new Text(readTasCompletedStr);
    readingTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text teachingTasksCompletedTxt = new Text("Teaching Tasks Completed: ");
    teachingTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String teachTasCompletedStr = Long.toString(teachingTasksCompleted);
    Text teachingTasksCompletedNumTxt = new Text(teachTasCompletedStr);
    teachingTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    Text discussionTasksCompletedTxt = new Text("Software Discussion Tasks Completed: ");
    discussionTasksCompletedTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
    String discussionTasCompletedStr = Long.toString(discussionTasksCompleted);
    Text discussionTasksCompletedNumTxt = new Text(discussionTasCompletedStr);
    discussionTasksCompletedNumTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

    String currPLStr = Double.toString(currentPL);
    Text currPLnum = new Text(currPLStr);
    currPLnum.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
    String nextTransformationStr = Double.toString(nextTransformationPL);
    Text nextTransformationTxt = new Text(nextTransformationStr);
    nextTransformationTxt.setFont(Font.font("Verdana", FontWeight.BOLD, 13));

    ProgressBar expBar = new ProgressBar();
    expBar.setPrefWidth(700.0);
    double expProgress = (currentPL / nextTransformationPL);
    expBar.setProgress(expProgress);

    VBox expVB = new VBox();
    expVB.getChildren().add(expTxt);
    expVB.getChildren().add(expBar);


    leftVB = new VBox();
    leftVB.getChildren().add(currPowerLvl);
    leftVB.getChildren().add(currPLnum);
    leftVB.getChildren().add(currImgView);

    rightVB = new VBox();
    rightVB.getChildren().add(nextTransformation);
    rightVB.getChildren().add(nextTransformationTxt);
    rightVB.getChildren().add(nextImgView);

    VBox bottomVB = new VBox(8);
    bottomVB.getChildren().add(history);

    HBox teachHisHB = new HBox();
    teachHisHB.getChildren().add(teachingTasksCompletedTxt);
    teachHisHB.getChildren().add(teachingTasksCompletedNumTxt);
    bottomVB.getChildren().add(teachHisHB);
    HBox discHisHB = new HBox();
    discHisHB.getChildren().add(discussionTasksCompletedTxt);
    discHisHB.getChildren().add(discussionTasksCompletedNumTxt);
    bottomVB.getChildren().add(discHisHB);
    HBox desHisHB = new HBox();
    desHisHB.getChildren().add(designTasksCompletedTxt);
    desHisHB.getChildren().add(designTasksCompletedNumTxt);
    bottomVB.getChildren().add(desHisHB);
    HBox codHisHB = new HBox();
    codHisHB.getChildren().add(codingTasksCompletedTxt);
    codHisHB.getChildren().add(codingTasksCompletedNumTxt);
    bottomVB.getChildren().add(codHisHB);
    HBox wriHisHB = new HBox();
    wriHisHB.getChildren().add(writingTasksCompletedTxt);
    wriHisHB.getChildren().add(writingTasksCompletedNumTxt);
    bottomVB.getChildren().add(wriHisHB);
    HBox lecHisHB = new HBox();
    lecHisHB.getChildren().add(lectureTasksCompletedTxt);
    lecHisHB.getChildren().add(lectureTasksCompletedNumTxt);
    bottomVB.getChildren().add(lecHisHB);
    HBox edVidHisHB = new HBox();
    edVidHisHB.getChildren().add(edVidTasksCompletedTxt);
    edVidHisHB.getChildren().add(edVidTasksCompletedNumTxt);
    bottomVB.getChildren().add(edVidHisHB);
    HBox readHisHB = new HBox();
    readHisHB.getChildren().add(readingTasksCompletedTxt);
    readHisHB.getChildren().add(readingTasksCompletedNumTxt);
    bottomVB.getChildren().add(readHisHB);
    
    VBox vbox = new VBox(20);
    vbox.getChildren().add(expVB);
    vbox.getChildren().add(trainingRegimen);


    RadioButton[] teachingArr = new RadioButton[10];
    ToggleGroup teachingGroup = new ToggleGroup();
    HBox effortT = new HBox(10);
    effortT.getChildren().add(effT);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbTeach = new RadioButton(s);
      teachingArr[j] = rbTeach;
      rbTeach.setToggleGroup(teachingGroup);
      effortT.getChildren().add(rbTeach);
    }
    vbox.getChildren().add(Teaching);
    vbox.getChildren().add(effortT);
    Button bt7 = new Button("Complete");
    effortT.getChildren().add(bt7);

    EventHandler<ActionEvent> teachHandler = e -> {
      if(teachingArr[0].isSelected()){
        expAddedFromTeach = 700;
      }
      else if(teachingArr[1].isSelected()){
        expAddedFromTeach = 1400;
      }
      else if(teachingArr[2].isSelected()){
        expAddedFromTeach = 2100;
      }
      else if(teachingArr[3].isSelected()){
        expAddedFromTeach = 2800;
      }
      else if(teachingArr[4].isSelected()){
        expAddedFromTeach = 3500;
      }
      else if(teachingArr[5].isSelected()){
        expAddedFromTeach = 4200;
      }
      else if(teachingArr[6].isSelected()){
        expAddedFromTeach = 4900;
      }
      else if(teachingArr[7].isSelected()){
        expAddedFromTeach = 5600;
      }
      else if(teachingArr[8].isSelected()){
        expAddedFromTeach = 6300;
      }
      else if(teachingArr[9].isSelected()){
        expAddedFromTeach = 7000;
      }
    };
    for(int i = 0; i < teachingArr.length; i++){
      teachingArr[i].setOnAction(teachHandler);
    }
    bt7.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromTeach;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromTeach != 0){
        teachingTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(teachingArr[i].isSelected()){
          teachingArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromTeach = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String teachTasksCompletedStr = Long.toString(teachingTasksCompleted);
      teachingTasksCompletedNumTxt.setText(teachTasksCompletedStr);
    });


    RadioButton[] discussionArr = new RadioButton[10];
    ToggleGroup discussionGroup = new ToggleGroup();
    HBox effortCD = new HBox(10);
    effortCD.getChildren().add(effCD);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbDisc = new RadioButton(s);
      discussionArr[j] = rbDisc;
      rbDisc.setToggleGroup(discussionGroup);
      effortCD.getChildren().add(rbDisc);
    }
    vbox.getChildren().add(Discussion);
    vbox.getChildren().add(effortCD);
    Button bt8 = new Button("Complete");
    effortCD.getChildren().add(bt8);

    EventHandler<ActionEvent> discHandler = e -> {
      if(discussionArr[0].isSelected()){
        expAddedFromDisc = 650;
      }
      else if(discussionArr[1].isSelected()){
        expAddedFromDisc = 1300;
      }
      else if(discussionArr[2].isSelected()){
        expAddedFromDisc = 1950;
      }
      else if(discussionArr[3].isSelected()){
        expAddedFromDisc = 2600;
      }
      else if(discussionArr[4].isSelected()){
        expAddedFromDisc = 3250;
      }
      else if(discussionArr[5].isSelected()){
        expAddedFromDisc = 3900;
      }
      else if(discussionArr[6].isSelected()){
        expAddedFromDisc = 4550;
      }
      else if(discussionArr[7].isSelected()){
        expAddedFromDisc = 5200;
      }
      else if(discussionArr[8].isSelected()){
        expAddedFromDisc = 5850;
      }
      else if(discussionArr[9].isSelected()){
        expAddedFromDisc = 6500;
      }
    };
    for(int i = 0; i < discussionArr.length; i++){
      discussionArr[i].setOnAction(discHandler);
    }
    bt8.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromDisc;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromDisc != 0){
        discussionTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(discussionArr[i].isSelected()){
          discussionArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromDisc = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String discTasksCompletedStr = Long.toString(discussionTasksCompleted);
      discussionTasksCompletedNumTxt.setText(discTasksCompletedStr);
    });


    RadioButton[] designArr = new RadioButton[10];
    ToggleGroup designGroup = new ToggleGroup();
    HBox effortD = new HBox(10);
    effortD.getChildren().add(effD);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbDes = new RadioButton(s);
      designArr[j] = rbDes;
      rbDes.setToggleGroup(designGroup);
      effortD.getChildren().add(rbDes);
    }
    vbox.getChildren().add(Designing);
    vbox.getChildren().add(effortD);
    Button bt1 = new Button("Complete");
    effortD.getChildren().add(bt1);

    EventHandler<ActionEvent> desHandler = e -> {
      if(designArr[0].isSelected()){
        expAddedFromDes = 600;
      }
      else if(designArr[1].isSelected()){
        expAddedFromDes = 1200;
      }
      else if(designArr[2].isSelected()){
        expAddedFromDes = 1800;
      }
      else if(designArr[3].isSelected()){
        expAddedFromDes = 2400;
      }
      else if(designArr[4].isSelected()){
        expAddedFromDes = 3000;
      }
      else if(designArr[5].isSelected()){
        expAddedFromDes = 3600;
      }
      else if(designArr[6].isSelected()){
        expAddedFromDes = 4200;
      }
      else if(designArr[7].isSelected()){
        expAddedFromDes = 4800;
      }
      else if(designArr[8].isSelected()){
        expAddedFromDes = 5400;
      }
      else if(designArr[9].isSelected()){
        expAddedFromDes = 6000;
      }
    };
    for(int i = 0; i < designArr.length; i++){
      designArr[i].setOnAction(desHandler);
    }
    bt1.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromDes;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromDes != 0){
        designTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(designArr[i].isSelected()){
          designArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromDes = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String desTasksCompletedStr = Long.toString(designTasksCompleted);
      designTasksCompletedNumTxt.setText(desTasksCompletedStr);
    });


    RadioButton[] codeArr = new RadioButton[10];
    ToggleGroup codeGroup = new ToggleGroup();
    HBox effortC = new HBox(10);
    effortC.getChildren().add(effC);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbCod = new RadioButton(s);
      codeArr[j] = rbCod;
      rbCod.setToggleGroup(codeGroup);
      effortC.getChildren().add(rbCod);
    }
    vbox.getChildren().add(Coding);
    vbox.getChildren().add(effortC);
    Button bt2 = new Button("Complete");
    effortC.getChildren().add(bt2);

    EventHandler<ActionEvent> codeHandler = e -> {
      if(codeArr[0].isSelected()){
        expAddedFromCode = 500;
      }
      else if(codeArr[1].isSelected()){
        expAddedFromCode = 1000;
      }
      else if(codeArr[2].isSelected()){
        expAddedFromCode = 1500;
      }
      else if(codeArr[3].isSelected()){
        expAddedFromCode = 2000;
      }
      else if(codeArr[4].isSelected()){
        expAddedFromCode = 2500;
      }
      else if(codeArr[5].isSelected()){
        expAddedFromCode = 3000;
      }
      else if(codeArr[6].isSelected()){
        expAddedFromCode = 3500;
      }
      else if(codeArr[7].isSelected()){
        expAddedFromCode = 4000;
      }
      else if(codeArr[8].isSelected()){
        expAddedFromCode = 4500;
      }
      else if(codeArr[9].isSelected()){
        expAddedFromCode = 5000;
      }
    };
    for(int i = 0; i < codeArr.length; i++){
      codeArr[i].setOnAction(codeHandler);
    }
    bt2.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromCode;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromCode != 0){
        codingTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(codeArr[i].isSelected()){
          codeArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromCode = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String codeTasksCompletedStr = Long.toString(codingTasksCompleted);
      codingTasksCompletedNumTxt.setText(codeTasksCompletedStr);
    });


    RadioButton[] writeArr = new RadioButton[10];
    ToggleGroup writeGroup = new ToggleGroup();
    HBox effortW = new HBox(10);
    effortW.getChildren().add(effW);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbWrite = new RadioButton(s);
      writeArr[j] = rbWrite;
      rbWrite.setToggleGroup(writeGroup);
      effortW.getChildren().add(rbWrite);
    }
    vbox.getChildren().add(Writing);
    vbox.getChildren().add(effortW);
    Button bt3 = new Button("Complete");
    effortW.getChildren().add(bt3);

    EventHandler<ActionEvent> writeHandler = e -> {
      if(writeArr[0].isSelected()){
        expAddedFromWrite = 400;
      }
      else if(writeArr[1].isSelected()){
        expAddedFromWrite = 800;
      }
      else if(writeArr[2].isSelected()){
        expAddedFromWrite = 1200;
      }
      else if(writeArr[3].isSelected()){
        expAddedFromWrite = 1600;
      }
      else if(writeArr[4].isSelected()){
        expAddedFromWrite = 2000;
      }
      else if(writeArr[5].isSelected()){
        expAddedFromWrite = 2400;
      }
      else if(writeArr[6].isSelected()){
        expAddedFromWrite = 2800;
      }
      else if(writeArr[7].isSelected()){
        expAddedFromWrite = 3200;
      }
      else if(writeArr[8].isSelected()){
        expAddedFromWrite = 3600;
      }
      else if(writeArr[9].isSelected()){
        expAddedFromWrite = 4000;
      }
    };
    for(int i = 0; i < writeArr.length; i++){
      writeArr[i].setOnAction(writeHandler);
    }
    bt3.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromWrite;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromWrite != 0){
        writingTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(writeArr[i].isSelected()){
          writeArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromWrite = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String writingTasksCompletedStr = Long.toString(writingTasksCompleted);
      writingTasksCompletedNumTxt.setText(writingTasksCompletedStr);
    });


    RadioButton[] lectArr = new RadioButton[10];
    ToggleGroup lectGroup = new ToggleGroup();
    HBox effortL = new HBox(10);
    effortL.getChildren().add(effL);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbLect = new RadioButton(s);
      lectArr[j] = rbLect;
      rbLect.setToggleGroup(lectGroup);
      effortL.getChildren().add(rbLect);
    }
    vbox.getChildren().add(Lectures);
    vbox.getChildren().add(effortL);
    Button bt4 = new Button("Complete");
    effortL.getChildren().add(bt4);

    EventHandler<ActionEvent> lectHandler = e -> {
      if(lectArr[0].isSelected()){
        expAddedFromLect = 300;
      }
      else if(lectArr[1].isSelected()){
        expAddedFromLect = 600;
      }
      else if(lectArr[2].isSelected()){
        expAddedFromLect = 900;
      }
      else if(lectArr[3].isSelected()){
        expAddedFromLect = 1200;
      }
      else if(lectArr[4].isSelected()){
        expAddedFromLect = 1500;
      }
      else if(lectArr[5].isSelected()){
        expAddedFromLect = 1800;
      }
      else if(lectArr[6].isSelected()){
        expAddedFromLect = 2100;
      }
      else if(lectArr[7].isSelected()){
        expAddedFromLect = 2400;
      }
      else if(lectArr[8].isSelected()){
        expAddedFromLect = 2700;
      }
      else if(lectArr[9].isSelected()){
        expAddedFromLect = 3000;
      }
    };
    for(int i = 0; i < lectArr.length; i++){
      lectArr[i].setOnAction(lectHandler);
    }
    bt4.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromLect;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromLect != 0){
        lectureTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(lectArr[i].isSelected()){
          lectArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromLect = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String lectureTasksCompletedStr = Long.toString(lectureTasksCompleted);
      lectureTasksCompletedNumTxt.setText(lectureTasksCompletedStr);
    });


    RadioButton[] edVidArr = new RadioButton[10];
    ToggleGroup edVidGroup = new ToggleGroup();
    HBox effortE = new HBox(10);
    effortE.getChildren().add(effE);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbEV = new RadioButton(s);
      edVidArr[j] = rbEV;
      rbEV.setToggleGroup(edVidGroup);
      effortE.getChildren().add(rbEV);
    }
    vbox.getChildren().add(edVids);
    vbox.getChildren().add(effortE);
    Button bt5 = new Button("Complete");
    effortE.getChildren().add(bt5);

    EventHandler<ActionEvent> edVidHandler = e -> {
      if(edVidArr[0].isSelected()){
        expAddedFromEdVid = 200;
      }
      else if(edVidArr[1].isSelected()){
        expAddedFromEdVid = 400;
      }
      else if(edVidArr[2].isSelected()){
        expAddedFromEdVid = 600;
      }
      else if(edVidArr[3].isSelected()){
        expAddedFromEdVid = 800;
      }
      else if(edVidArr[4].isSelected()){
        expAddedFromEdVid = 1000;
      }
      else if(edVidArr[5].isSelected()){
        expAddedFromEdVid = 1200;
      }
      else if(edVidArr[6].isSelected()){
        expAddedFromEdVid = 1400;
      }
      else if(edVidArr[7].isSelected()){
        expAddedFromEdVid = 1600;
      }
      else if(edVidArr[8].isSelected()){
        expAddedFromEdVid = 1800;
      }
      else if(edVidArr[9].isSelected()){
        expAddedFromEdVid = 2000;
      }
    };
    for(int i = 0; i < edVidArr.length; i++){
      edVidArr[i].setOnAction(edVidHandler);
    }
    bt5.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromEdVid;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromEdVid != 0){
        edVidTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(edVidArr[i].isSelected()){
          edVidArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromEdVid = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String edVidTasksCompletedStr = Long.toString(edVidTasksCompleted);
      edVidTasksCompletedNumTxt.setText(edVidTasksCompletedStr);
    });


    RadioButton[] readArr = new RadioButton[10];
    ToggleGroup readGroup = new ToggleGroup();
    HBox effortR = new HBox(10);
    effortR.getChildren().add(effR);
    for(int j = 0; j < 10; j++){
      int i = j + 1;
      String s = Integer.toString(i);
      RadioButton rbRead = new RadioButton(s);
      readArr[j] = rbRead;
      rbRead.setToggleGroup(readGroup);
      effortR.getChildren().add(rbRead);
    }
    vbox.getChildren().add(Reading);
    vbox.getChildren().add(effortR);
    Button bt6 = new Button("Complete");
    effortR.getChildren().add(bt6);

    EventHandler<ActionEvent> readHandler = e -> {
      if(readArr[0].isSelected()){
        expAddedFromRead = 100;
      }
      else if(readArr[1].isSelected()){
        expAddedFromRead = 200;
      }
      else if(readArr[2].isSelected()){
        expAddedFromRead = 300;
      }
      else if(readArr[3].isSelected()){
        expAddedFromRead = 400;
      }
      else if(readArr[4].isSelected()){
        expAddedFromRead = 500;
      }
      else if(readArr[5].isSelected()){
        expAddedFromRead = 600;
      }
      else if(readArr[6].isSelected()){
        expAddedFromRead = 700;
      }
      else if(readArr[7].isSelected()){
        expAddedFromRead = 800;
      }
      else if(readArr[8].isSelected()){
        expAddedFromRead = 900;
      }
      else if(readArr[9].isSelected()){
        expAddedFromRead = 1000;
      }
    };
    for(int i = 0; i < readArr.length; i++){
      readArr[i].setOnAction(readHandler);
    }
    bt6.setOnAction(e -> {
      setCompletedEffects(currImgView, currPLnum, expBar);
      currentPL += expAddedFromRead;
      setNextTransformation(currentPL);
      setImages(currentPL);
      setImagesInUI(leftVB, rightVB);
      adjustImageSize(currImgView, nextImgView);
      if(expAddedFromRead != 0){
        readingTasksCompleted += 1;
      }
      updateFile();
      for(int i = 0; i < 10; i++){
        if(readArr[i].isSelected()){
          readArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      String nextTranStr = Double.toString(nextTransformationPL);
      nextTransformationTxt.setText(nextTranStr);
      expAddedFromRead = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String readingTasksCompletedStr = Long.toString(readingTasksCompleted);
      readingTasksCompletedNumTxt.setText(readingTasksCompletedStr);
    });


    BackgroundImage myBI= new BackgroundImage(new Image("./BG9.jpg"),
      BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
      new BackgroundSize(BackgroundSize.AUTO,
      BackgroundSize.AUTO,
        false,
        false,
        true,
        true));

    BorderPane pane = new BorderPane();

    pane.setBackground(new Background(myBI));

    pane.setCenter(vbox);
    pane.setLeft(leftVB);
    pane.setRight(rightVB);
    pane.setBottom(bottomVB);


    leftVB.setAlignment(Pos.CENTER_LEFT);
    rightVB.setAlignment(Pos.CENTER_RIGHT);
    expVB.setAlignment(Pos.CENTER);
    vbox.setAlignment(Pos.CENTER);
    bottomVB.setAlignment(Pos.CENTER);
    desHisHB.setAlignment(Pos.CENTER);
    codHisHB.setAlignment(Pos.CENTER);
    wriHisHB.setAlignment(Pos.CENTER);
    lecHisHB.setAlignment(Pos.CENTER);
    edVidHisHB.setAlignment(Pos.CENTER);
    readHisHB.setAlignment(Pos.CENTER);
    teachHisHB.setAlignment(Pos.CENTER);
    discHisHB.setAlignment(Pos.CENTER);
    effortD.setAlignment(Pos.CENTER);
    effortC.setAlignment(Pos.CENTER);
    effortW.setAlignment(Pos.CENTER);
    effortL.setAlignment(Pos.CENTER);
    effortE.setAlignment(Pos.CENTER);
    effortR.setAlignment(Pos.CENTER);
    effortT.setAlignment(Pos.CENTER);
    effortCD.setAlignment(Pos.CENTER);


    Scene scene = new Scene(pane, 1300, 1000);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void setNextTransformation(double powerLevel){
    if(powerLevel < teenGoku){
      nextTransformationPL = teenGoku;
    }
    else if(powerLevel >= teenGoku && powerLevel < adultGoku){
      nextTransformationPL = adultGoku;
    }
    else if(powerLevel >= adultGoku && powerLevel < SS1){
      nextTransformationPL = SS1;
    }
    else if(powerLevel >= SS1 && powerLevel < SS2){
      nextTransformationPL = SS2;
    }
    else if(powerLevel >= SS2 && powerLevel < SS3){
      nextTransformationPL = SS3;
    }
    else if(powerLevel >= SS3 && powerLevel < SSGod){
      nextTransformationPL = SSGod;
    }
    else if(powerLevel >= SSGod && powerLevel < SSBlue){
      nextTransformationPL = SSBlue;
    }
    else if(powerLevel >= SSBlue && powerLevel < SSBlueEv){
      nextTransformationPL = SSBlueEv;
    }
    else if(powerLevel >= SSBlueEv && powerLevel < UltraInstinct){
      nextTransformationPL = UltraInstinct;
    }
    else if(powerLevel >= UltraInstinct && powerLevel < MasteredUI){
      nextTransformationPL = MasteredUI;
    }
  }

  private void updateFile(){
    JSONObject teachingTaskDetails = new JSONObject();
    teachingTaskDetails.put("Task", "Teaching");
    teachingTaskDetails.put("Count", teachingTasksCompleted);
    JSONObject discussionTaskDetails = new JSONObject();
    discussionTaskDetails.put("Task", "Discussion");
    discussionTaskDetails.put("Count", discussionTasksCompleted);
    JSONObject designTaskDetails = new JSONObject();
    designTaskDetails.put("Task", "Designing");
    designTaskDetails.put("Count", designTasksCompleted);
    JSONObject codingTaskDetails = new JSONObject();
    codingTaskDetails.put("Task", "Coding");
    codingTaskDetails.put("Count", codingTasksCompleted);
    JSONObject writingTaskDetails = new JSONObject();
    writingTaskDetails.put("Task", "Writing");
    writingTaskDetails.put("Count", writingTasksCompleted);
    JSONObject lectureTaskDetails = new JSONObject();
    lectureTaskDetails.put("Task", "Lecture");
    lectureTaskDetails.put("Count", lectureTasksCompleted);
    JSONObject edVidTaskDetails = new JSONObject();
    edVidTaskDetails.put("Task", "EdVids");
    edVidTaskDetails.put("Count", edVidTasksCompleted);
    JSONObject readingTaskDetails = new JSONObject();
    readingTaskDetails.put("Task", "Reading");
    readingTaskDetails.put("Count", readingTasksCompleted);


    JSONObject user = new JSONObject();
    user.put("Current Power Level", currentPL);

    JSONArray tasksArr = new JSONArray();
    tasksArr.add(teachingTaskDetails);
    tasksArr.add(discussionTaskDetails);
    tasksArr.add(designTaskDetails);
    tasksArr.add(codingTaskDetails);
    tasksArr.add(writingTaskDetails);
    tasksArr.add(lectureTaskDetails);
    tasksArr.add(edVidTaskDetails);
    tasksArr.add(readingTaskDetails);

    JSONObject mainObj = new JSONObject();
    mainObj.put("Tasks", tasksArr);
    mainObj.put("User", user);


    try (FileWriter file = new FileWriter("TurtleSchoolProgress.json")) {
      file.write(mainObj.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private void setInstanceVarsFromFileOrDefault(){
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader("TurtleSchoolProgress.json")){
      Object obj = jsonParser.parse(reader);

      JSONObject mainObj = (JSONObject) obj;

      JSONObject user = (JSONObject) mainObj.get("User");
      double currPwrLvl = (double) user.get("Current Power Level");
      this.currentPL = currPwrLvl;

      JSONArray tasksArr = (JSONArray) mainObj.get("Tasks");
      tasksArr.forEach( task -> parseTaskDetails( (JSONObject) task ) );


    } catch (FileNotFoundException e) {
        System.out.println("No Saved Progress");
        setDefaultValsForVars();
    } catch (IOException e) {
        System.out.println("No Saved Progress");
        setDefaultValsForVars();
    } catch (ParseException e) {
        System.out.println("No Saved Progress");
        setDefaultValsForVars();
    }
  }

  private void parseTaskDetails(JSONObject taskDetails){
    String taskName = (String) taskDetails.get("Task");
    switch(taskName){
      case "Teaching":
          this.teachingTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Discussion":
          this.discussionTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Designing":
          this.designTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Coding":
          this.codingTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Writing":
          this.writingTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Lecture":
          this.lectureTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "EdVids":
          this.edVidTasksCompleted = (long) taskDetails.get("Count");
          break;
      case "Reading":
          this.readingTasksCompleted = (long) taskDetails.get("Count");
          break;
    }
  }

  private void setDefaultValsForVars(){
    this.teachingTasksCompleted = 0;
    this.discussionTasksCompleted = 0;
    this.designTasksCompleted = 0;
    this.codingTasksCompleted = 0;
    this.writingTasksCompleted = 0;
    this.lectureTasksCompleted = 0;
    this.edVidTasksCompleted = 0;
    this.readingTasksCompleted = 0;
    this.currentPL = 0;
  }

  private void setImages(double powerLevel){
    if(powerLevel < teenGoku){
      this.currImgView = KGImgView;
      this.nextImgView = TGImgView;
    }
    else if(powerLevel >= teenGoku && powerLevel < adultGoku){
      this.currImgView = TGImgView;
      this.nextImgView = AGImgView;
    }
    else if(powerLevel >= adultGoku && powerLevel < SS1){
      this.currImgView = AGImgView;
      this.nextImgView = SS1ImgView;
    }
    else if(powerLevel >= SS1 && powerLevel < SS2){
      this.currImgView = SS1ImgView;
      this.nextImgView = SS2ImgView;
    }
    else if(powerLevel >= SS2 && powerLevel < SS3){
      this.currImgView = SS2ImgView;
      this.nextImgView = SS3ImgView;
    }
    else if(powerLevel >= SS3 && powerLevel < SSGod){
      this.currImgView = SS3ImgView;
      this.nextImgView = SSGImgView;
    }
    else if(powerLevel >= SSGod && powerLevel < SSBlue){
      this.currImgView = SSGImgView;
      this.nextImgView = SSBImgView;
    }
    else if(powerLevel >= SSBlue && powerLevel < SSBlueEv){
      this.currImgView = SSBImgView;
      this.nextImgView = SSBKImgView;
    }
    else if(powerLevel >= SSBlueEv && powerLevel < UltraInstinct){
      this.currImgView = SSBKImgView;
      this.nextImgView = GUIImgView;
    }
    else if(powerLevel >= UltraInstinct && powerLevel < MasteredUI){
      this.currImgView = GUIImgView;
      this.nextImgView = GMUIImgView;
    }
    else if(powerLevel >= MasteredUI){
      this.currImgView = GMUIImgView;
      this.nextImgView = ALLGImgView;
    }
  }

  private void adjustImageSize(ImageView currImage, ImageView nextImage){
    currImage.setFitHeight(350);
    currImage.setPreserveRatio(true);

    nextImage.setFitHeight(350);
    nextImage.setPreserveRatio(true);
  }

  private void setImagesInUI(VBox currentTransformationVB, VBox nextTransformationVB){
    currentTransformationVB.getChildren().remove(currentTransformationVB.getChildren().size()-1);
    currentTransformationVB.getChildren().add(this.currImgView);

    nextTransformationVB.getChildren().remove(nextTransformationVB.getChildren().size()-1);
    nextTransformationVB.getChildren().add(this.nextImgView);
  }

  private void setCompletedEffects(ImageView currImgView, Text currPLText, ProgressBar expPB){
    Glow glow0 = new Glow();
    glow0.setLevel(0.0);
    Glow glow1 = new Glow();
    glow1.setLevel(1.0);

    Timeline currimgeffect = new Timeline(
        new KeyFrame(Duration.seconds(3.0),         event -> currImgView.setEffect(glow0)),
        new KeyFrame(Duration.ZERO, event -> currImgView.setEffect(glow1))
    );
    currimgeffect.setAutoReverse(true);
    currimgeffect.setCycleCount(1);
    currimgeffect.play();

    Timeline txtColorEffect = new Timeline(
        new KeyFrame(Duration.seconds(3.0),         event -> currPLText.setFill(Color.BLACK)),
        new KeyFrame(Duration.ZERO, event -> currPLText.setFill(Color.ORANGERED))
    );
    txtColorEffect.setAutoReverse(true);
    txtColorEffect.setCycleCount(1);
    txtColorEffect.play();

    Timeline texteffect = new Timeline(
        new KeyFrame(Duration.seconds(3.0),         event -> currPLText.setEffect(glow0)),
        new KeyFrame(Duration.ZERO, event -> currPLText.setEffect(glow1))
    );
    texteffect.setAutoReverse(true);
    texteffect.setCycleCount(1);
    texteffect.play();

    Timeline expPBeffect = new Timeline(
        new KeyFrame(Duration.seconds(3.0),         event -> expPB.setEffect(glow0)),
        new KeyFrame(Duration.ZERO, event -> expPB.setEffect(glow1))
    );
    expPBeffect.setAutoReverse(true);
    expPBeffect.setCycleCount(1);
    expPBeffect.play();
  }
}