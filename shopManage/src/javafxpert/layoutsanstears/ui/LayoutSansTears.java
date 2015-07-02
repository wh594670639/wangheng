/*
 * LayoutSansTears.java - JavaFX layout example
 * Author - Jim Weaver jim.weaver@javafxpert.com
 */
package javafxpert.layoutsanstears.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutSansTears extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    Region headerLeftSpring = new Region();
    
    // TO DO: Declare a variable of type Region, assigning a 
    // new Region object to it for use as a "spring" in the 
    // header between the title of the app and the search box
    
    // TO DO: Declare a variable of type Region, assigning a 
    // new Region object to it for use as a "spring" in the 
    // footer between the left and right labels 
    
    ImageView logo = new ImageView(
      new Image(getClass().getResourceAsStream("images/javafx-logo.png"))
    );
    
    HBox searchBox = HBoxBuilder.create()
      .spacing(5)
      .children(
        TextAreaBuilder.create()
          .prefWidth(120)
          .prefHeight(40)
            
          // TO DO: Use a method of the TextAreaBuilder to set the maximum
          // height of the TextArea to its preferred size
          
          .build(),
        ButtonBuilder.create()
          .text("Go")
          .build()
      )
      .build();
    
    Scene scene = SceneBuilder.create()
      .stylesheets("javafxpert/layoutsanstears/ui/myStyles.css")
      .width(800)
      .height(500)
      .root(
        BorderPaneBuilder.create()
          .top(
            HBoxBuilder.create()
              .children(
                logo,
                headerLeftSpring,
                LabelBuilder.create()
                  .id("app-title")
                  .text("App Title")
                  .build(),
                
                // TO DO: Insert the Region object created to act as a "spring"                
                
                searchBox
              )
              .build()
          )
          .center(
            TabPaneBuilder.create()
              .tabs(
                TabBuilder.create()
                  .text("Tab A")
                  .build(),
                TabBuilder.create()
                  .text("Tab B")
                  .build(),
                TabBuilder.create()
                  .text("Tab C")
                  .build()
              )
              .build()
          )
          .bottom(
            HBoxBuilder.create()
              .id("footer")
              .children(
                new Label("Footer Left"),
                
                // TO DO: Insert the Region object created to act as a "spring" 
                
                new Label("Footer Right")
              )
              .build()
          )
          .build()
      )
      .build();
    
    HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);
    
    // TO DO: Use a static method of HBox to allow the headerRightSpring
    // to compete for any extra horizontal space
        
    // TO DO: Use a static method of HBox to allow the footerCenterSpring
    // to compete for  any extra horizontal space
    
    // TO DO: Use a static method of HBox to give the searchBox
    // a margin of 20 pixels on the top and 10 pixels on the right
    
    primaryStage.setTitle("Layout Sans Tears: Exercise");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
