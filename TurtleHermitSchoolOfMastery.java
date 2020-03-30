import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
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


public class TurtleHermitSchoolOfMastery extends Application{

  private double currentPL;
  private double nextTransformationPL;

  private int expAddedFromDes;
  private int expAddedFromCode;
  private int expAddedFromWrite;
  private int expAddedFromLect;
  private int expAddedFromEdVid;
  private int expAddedFromRead;

  private long designTasksCompleted;
  private long codingTasksCompleted;
  private long writingTasksCompleted;
  private long lectureTasksCompleted;
  private long edVidTasksCompleted;
  private long readingTasksCompleted;

  private double kidGoku = 0.0;
  private double teenGoku = 500000.0;
  private double adultGoku = 1000000.0;
  private double SS1 = 20000000.0;
  private double SS2 = 50000000.0;
  private double SS3 = 100000000.0;
  private double SSGod = 1000000000.0;
  private double SSBlue = 2000000000.0;
  private double SSBlueEv = 4000000000.0;
  private double SSFullPower = 5000000000.0;
  private double UltraInstinct = 8000000000.0;
  private double MasteredUI = 10000000000.0;

  @Override
  public void start(Stage primaryStage){
    setInstanceVarsFromFileOrDefault();
    setNextTransformation(currentPL);

    primaryStage.setTitle("Turtle Hermit School Of Mastery");

    Text currPowerLvl = new Text("Current\nPower Level");
    Text nextTransformation = new Text("Next\nTransformation");

    Text expTxt = new Text("Experience Bar");
    Text trainingRegimen = new Text("Training Regimen");

    Text Designing = new Text("Designing - 600 exp");
    Text Coding = new Text("Coding - 500 exp");
    Text Writing = new Text("Writing - 400 exp");
    Text Lectures = new Text("Lectures - 300 exp");
    Text edVids = new Text("Educational Videos - 200 exp");
    Text Reading = new Text("Reading - 100 exp");

    Text effD = new Text("Effort: ");
    Text effC = new Text("Effort: ");
    Text effW = new Text("Effort: ");
    Text effL = new Text("Effort: ");
    Text effE = new Text("Effort: ");
    Text effR = new Text("Effort: ");

    Text history = new Text("History");

    Text designTasksCompletedTxt = new Text("Designing Tasks Completed: ");
    String desTasCompletedStr = Long.toString(designTasksCompleted);
    Text designTasksCompletedNumTxt = new Text(desTasCompletedStr);

    Text codingTasksCompletedTxt = new Text("Coding Tasks Completed: ");
    String codTasCompletedStr = Long.toString(codingTasksCompleted);
    Text codingTasksCompletedNumTxt = new Text(codTasCompletedStr);

    Text writingTasksCompletedTxt = new Text("Writing Tasks Completed: ");
    String wriTasCompletedStr = Long.toString(writingTasksCompleted);
    Text writingTasksCompletedNumTxt = new Text(wriTasCompletedStr);

    Text lectureTasksCompletedTxt = new Text("Lecture Tasks Completed: ");
    String lecTasCompletedStr = Long.toString(lectureTasksCompleted);
    Text lectureTasksCompletedNumTxt = new Text(lecTasCompletedStr);

    Text edVidTasksCompletedTxt = new Text("Educational Videos Watched: ");
    String edVidTasCompletedStr = Long.toString(edVidTasksCompleted);
    Text edVidTasksCompletedNumTxt = new Text(edVidTasCompletedStr);

    Text readingTasksCompletedTxt = new Text("Reading Tasks Completed: ");
    String readTasCompletedStr = Long.toString(readingTasksCompleted);
    Text readingTasksCompletedNumTxt = new Text(readTasCompletedStr);

    String currPLStr = Double.toString(currentPL);
    Text currPLnum = new Text(currPLStr);
    String nextTransformationStr = Double.toString(nextTransformationPL);
    Text nextTransformationTxt = new Text(nextTransformationStr);

    ProgressBar expBar = new ProgressBar();
    expBar.setPrefWidth(700.0);
    double expProgress = (currentPL / nextTransformationPL);
    expBar.setProgress(expProgress);

    VBox expVB = new VBox(12);
    expVB.getChildren().add(expTxt);
    expVB.getChildren().add(expBar);


    VBox leftVB = new VBox();
    leftVB.getChildren().add(currPowerLvl);
    leftVB.getChildren().add(currPLnum);

    VBox rightVB = new VBox();
    rightVB.getChildren().add(nextTransformation);
    rightVB.getChildren().add(nextTransformationTxt);

    VBox bottomVB = new VBox(10);
    bottomVB.getChildren().add(history);

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

    VBox vbox = new VBox(30);
    vbox.getChildren().add(expVB);
    vbox.getChildren().add(trainingRegimen);


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
      currentPL += expAddedFromDes;
      if(expAddedFromDes != 0){
        designTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(designArr[i].isSelected()){
          designArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
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
      currentPL += expAddedFromCode;
      if(expAddedFromCode != 0){
        codingTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(codeArr[i].isSelected()){
          codeArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
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
      currentPL += expAddedFromWrite;
      if(expAddedFromWrite != 0){
        writingTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(writeArr[i].isSelected()){
          writeArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
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
      currentPL += expAddedFromLect;
      if(expAddedFromLect != 0){
        lectureTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(lectArr[i].isSelected()){
          lectArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
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
      currentPL += expAddedFromEdVid;
      if(expAddedFromEdVid != 0){
        edVidTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(edVidArr[i].isSelected()){
          edVidArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
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
      currentPL += expAddedFromRead;
      if(expAddedFromRead != 0){
        readingTasksCompleted += 1;
      }
      updateFile();
      System.out.println(currentPL);
      for(int i = 0; i < 10; i++){
        if(readArr[i].isSelected()){
          readArr[i].setSelected(false);
        }
      }
      String plStr = Double.toString(currentPL);
      currPLnum.setText(plStr);
      expAddedFromRead = 0;
      expBar.setProgress(currentPL / nextTransformationPL);
      String readingTasksCompletedStr = Long.toString(readingTasksCompleted);
      readingTasksCompletedNumTxt.setText(readingTasksCompletedStr);
    });


    BorderPane pane = new BorderPane();

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
    effortD.setAlignment(Pos.CENTER);
    effortC.setAlignment(Pos.CENTER);
    effortW.setAlignment(Pos.CENTER);
    effortL.setAlignment(Pos.CENTER);
    effortE.setAlignment(Pos.CENTER);
    effortR.setAlignment(Pos.CENTER);


    Scene scene = new Scene(pane, 1000, 10000);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void setNextTransformation(double powerLevel){
    if(powerLevel < teenGoku){
      nextTransformationPL = teenGoku;
    }
    else if(powerLevel > teenGoku && powerLevel < adultGoku){
      nextTransformationPL = adultGoku;
    }
    else if(powerLevel > adultGoku && powerLevel < SS1){
      nextTransformationPL = SS1;
    }
    else if(powerLevel > SS1 && powerLevel < SS2){
      nextTransformationPL = SS2;
    }
    else if(powerLevel > SS2 && powerLevel < SS3){
      nextTransformationPL = SS3;
    }
    else if(powerLevel > SS3 && powerLevel < SSGod){
      nextTransformationPL = SSGod;
    }
    else if(powerLevel > SSGod && powerLevel < SSBlue){
      nextTransformationPL = SSBlue;
    }
    else if(powerLevel > SSBlue && powerLevel < SSBlueEv){
      nextTransformationPL = SSBlueEv;
    }
    else if(powerLevel > SSBlueEv && powerLevel < SSFullPower){
      nextTransformationPL = SSFullPower;
    }
    else if(powerLevel > SSFullPower && powerLevel < UltraInstinct){
      nextTransformationPL = UltraInstinct;
    }
    else if(powerLevel > UltraInstinct && powerLevel < MasteredUI){
      nextTransformationPL = MasteredUI;
    }
  }

  private void updateFile(){
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
      System.out.println(currentPL);

      JSONArray tasksArr = (JSONArray) mainObj.get("Tasks");
      tasksArr.forEach( task -> parseTaskDetails( (JSONObject) task ) );


    } catch (FileNotFoundException e) {
        e.printStackTrace();
        setDefaultValsForVars();
    } catch (IOException e) {
        e.printStackTrace();
        setDefaultValsForVars();
    } catch (ParseException e) {
        e.printStackTrace();
        setDefaultValsForVars();
    }
  }

  private void parseTaskDetails(JSONObject taskDetails){
    String taskName = (String) taskDetails.get("Task");
    System.out.println(taskName);
    switch(taskName){
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
    this.designTasksCompleted = 0;
    this.codingTasksCompleted = 0;
    this.writingTasksCompleted = 0;
    this.lectureTasksCompleted = 0;
    this.edVidTasksCompleted = 0;
    this.readingTasksCompleted = 0;
    this.currentPL = 0;
  }
}
