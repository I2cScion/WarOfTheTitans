/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefield;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Thamer
 */
public class BattleField extends Application {
    
    HashMap<String, KeyCode> map = new HashMap();
    
    ArrayList<Machine> machines = new ArrayList();
    ArrayList<Machine> enemies = new ArrayList();
    
    Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 700);
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setFullScreen(false);
        
        
        buildMap();
        
        
        
        int xM = 20;
        int xE = 20;
        
        Shooter sh = new Shooter();
        
       // root.setOnKeyPressed(sh);
        
        for(String s: map.keySet())
        {
            Machine m = new Machine(xM, scene.getHeight() - 100, 60, 40);
            m.setFill(Color.PURPLE);
            xM += 120;
            m.setCode(map.get(s));
            m.setFocusTraversable(true);
            m.setOnKeyPressed(sh);
            machines.add(m);
            root.getChildren().add(m);
            
            Machine e = new Machine(xE, 100, 60, 40);
            e.setFill(Color.DARKRED);
            xE += 120;
            enemies.add(e);
            root.getChildren().add(e);
        }
        
        
        
        
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
    private void buildMap()
    {
        map.put("A", KeyCode.A);
        map.put("S", KeyCode.S);
        map.put("D", KeyCode.D);
        map.put("F", KeyCode.F);
        map.put("G", KeyCode.G);
        map.put("H", KeyCode.H);
        map.put("J", KeyCode.J);
        map.put("K", KeyCode.K);
        map.put("L", KeyCode.L);
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
    class Shooter implements EventHandler<KeyEvent>
    { 
        @Override
        public void handle(KeyEvent event)
        {
            Iterator it = root.getChildren().iterator();
            KeyCode code = event.getCode();
            while(it.hasNext())
            {
                Object obj = it.next();
                if(obj instanceof Machine)
                {
                    Machine m = (Machine)obj; 
                    if(m.getCode() == code)
                    {
                        Circle bullet =  m.fire();
                        
                        Task<Void> sleeper = new Task<Void>() {
                        @Override
                            protected Void call() throws Exception {
                                try {
                                    Thread.sleep(3000);
                                }   catch (InterruptedException e) {
                                }
                                return null;
                                }
                        };
                        
                        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                        @Override
                        public void handle(WorkerStateEvent event) {
                            checkIntersection(bullet);
                        }
                        });
                        new Thread(sleeper).start();
                        
                        break;
                    }
                }
            }
        }
        
        private void checkIntersection(Shape bullet)
        {
            boolean collisionDetected = false;
            Machine enemy = null;
            
            for(Machine e: enemies)
            {
                Shape intersect = Shape.intersect(bullet, e);
                if (intersect.getBoundsInLocal().getWidth() != -1)
                {
                    collisionDetected = true;
                    enemy = e;
                }
            }
     
            if(collisionDetected && enemy != null)
            {
                enemy.setVisible(false);
            }
            
         }
        
    }
    
    
    
    
class Machine extends Rectangle
{
    
    
    
    //private String label;
    private Circle bullet;
    private TranslateTransition tr;
    
    private KeyCode code;
    
    public Machine(double x, double y, double width, double height)
    {
        super(x, y, width, height);
        bullet = new Circle(this.getX(), this.getY(), 10, Color.GOLD);
        bullet.setVisible(true); // you can set it to false and invert it later in event handle
        
        tr = new TranslateTransition(Duration.millis(3000), bullet);
        
        root.getChildren().add(bullet);
        
    }
    
    public Circle fire()
    {
        //bullet.setVisible(true);
        tr.setByY(-500);              // modify this to control range of the bullet 
        tr.play();
        return bullet;
    }
    
    /*
    public void setLabel(String label) {
        this.label = label;
    }
    */
    
    public void setCode(KeyCode code) {
        this.code = code;
    }

    public KeyCode getCode() {
        return code;
    }
    
    
    
    
}    
    
    
    
       
    
    
    
}








