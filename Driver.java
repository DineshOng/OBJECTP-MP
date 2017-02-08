import java.awt.EventQueue;
import javafx.scene.media.*;
import java.nio.file.*;

public class Driver{
  public static void main(String[] args)throws Exception{
    EventQueue.invokeLater(new Runnable(){
      public void run(){
        try{
          MainFrame mainframe = new MainFrame();
          UserControls controls = new UserControls(mainframe);
          mainframe.getFrame().setVisible(true);
          try{
            AudioClip sound = new AudioClip(Paths.get("O.wav").toUri().toString());
	    sound.setCycleCount(AudioClip.INDEFINITE);
            sound.play();
          }catch (Exception er){
            System.out.println(er);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}