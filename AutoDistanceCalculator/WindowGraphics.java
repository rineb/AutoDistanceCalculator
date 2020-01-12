import javax.swing.*;
import java.awt.*;

/**
* Class WindowGraphics is the view of the application
*/ 
public class WindowGraphics extends JPanel {
   private String initialVelocityMessage;
   private String accelerationMessage;
   private JFrame frame;
   private JTextArea textArea;

   /**
   * This is the constructor method for class WindowGraphics
   */
   public WindowGraphics() {
      initialVelocityMessage = "";
      accelerationMessage = "";
      frame = new JFrame();
      
      textArea = new JTextArea(40, 40);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      this.add(scrollPane);
      
      frame.getContentPane().add(this);
      frame.setSize(1000, 800);
      frame.setBackground(Color.WHITE);
      frame.setTitle("Distance Calculator");
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   /**
   * This is the constructor method for class Auto
   * @param g This parameter is the pen used to draw in the panel
   */
   public void paintComponent(Graphics g) {
      g.setColor(Color.RED);
      g.setFont(new Font("Serif", Font.BOLD, 20));
      g.drawString("Distance Calculator", 20, 30);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.drawString(initialVelocityMessage, 20, 60);
      g.drawString(accelerationMessage, 20, 80); 
   }
   

   /**
   * This is a private method for inputting doubles from the user
   * @param message This parameter is the question to ask the user
   * @return A double greater than or equal to 0
   */
   private double inputDouble(String message) {
      double result = -1;
      String error = "";
      boolean inputOk = false;
      while (!inputOk) {
         try {
            String input = JOptionPane.showInputDialog(error+message);
            result = Double.parseDouble(input);
            if (result >= 0) {
               inputOk = true;
            }
            else {
               error = "Error: Only numbers greater than or equal to 0 are allowed - ";
            }
        
         } catch (NumberFormatException ex) {error = "Error: You have typed text. Please type a number - ";}
      }
 
      return result;
   }
   
   /**
   * This is a private method for inputting integers from the user
   * @param message This parameter is the question to ask the user
   * @return An integer greater than or equal to 0
   */
   private int inputInteger(String message) {
      int result = -1;
      String error = "";
      boolean inputOk = false;
      while (!inputOk) {
         try {
            String input = JOptionPane.showInputDialog(error+message);
            if (input == null) {
               throw new NullPointerException();
            }
            result = Integer.parseInt(input);
            if (result >= 0) {
               inputOk = true;
            }
            else {
               error = "Error: Only numbers greater than or equal to 0 are allowed - ";
            }
        
         } catch (NumberFormatException ex) {error = "Error: You have typed text. Please type a number - ";}
      }
 
      return result;
   }

   /**
   * This is a method for inputting the initial velocity from the user in m/s
   * @return The given velocity in m/s
   */   
   public double getInitialVelocity() {
      double input = inputDouble("Type the car's initial velocity (in m/s)");
      return input;
   }
   
   /**
   * This is a method for inputting the acceleration from the user in m/s^2
   * @return The given velocity in m/s^2
   */   
   public double getAcceleration() {
      double input = inputDouble("Type the car's acceleration (in m/s^2)");
      return input;
   }
   
   /**
   * This is a method for inputting the initial time from the user in seconds
   * @return The initial time in seconds
   */   
   public int getTime() {
      int input = inputInteger("Type the initial time (in seconds)");
      return input;
   }
   
   /**
   * This is a method for writing the initial velocity in the panel
   * @param initialVelocity the velocity to write
   */   
   public void writeInitialVelocityInfo(double initialVelocity) {
      initialVelocityMessage = "The initial velocity is " + initialVelocity + "m/s";
      frame.repaint();
   }
   
   /**
   * This is a method for writing the acceleration in the panel
   * @param acceleration the acceleration to write
   */   
   public void writeAccelerationInfo(double acceleration) {
      accelerationMessage = "The acceleration is " + acceleration + "m/s^2"; 
      frame.repaint();
   }
   
   /**
   * This is a method for writing the distance passed in the panel
   * @param time the time that has passed
   * @param distance the distance that has been passed
   */   
   public void writeDistanceInfo(int time, double distance) {
      textArea.append("At time " + time + " seconds, the distance is " + distance + " meters\n");
      frame.repaint();
   }
   
   /**
   * This is a method for asking the user if time should be incremented
   * @return The answer if time should be incremented
   */   
   public boolean getWantsToIncrementTime() {
      int choice = JOptionPane.showConfirmDialog(null, "Do you wamt to increment time by one second?", "Confirmation", 
         JOptionPane.YES_NO_OPTION);
      return (choice == 0);
   } 
}