/**
* Class AutoApplication is the controller of the application.
* It uses the model: Auto and the view: WindowGraphics
*/ 
public class AutoApplication {

   /**
   * The main method of the application
   */
   public static void main(String[] args) {
      WindowGraphics graphicalInterface = new WindowGraphics();
      
      double initialVelocity = graphicalInterface.getInitialVelocity();
      graphicalInterface.writeInitialVelocityInfo(initialVelocity);
      
      double acceleration = graphicalInterface.getAcceleration();
      graphicalInterface.writeAccelerationInfo(acceleration);
      
      Auto car = new Auto(initialVelocity, acceleration);
      int time = graphicalInterface.getTime();

      double distance = car.calculateDistance(time);
      graphicalInterface.writeDistanceInfo(time, distance);
      
      boolean wantsToIncrementTime = graphicalInterface.getWantsToIncrementTime();
      while (wantsToIncrementTime) {
         time++;
         distance = car.calculateDistance(time);
         graphicalInterface.writeDistanceInfo(time, distance);
         wantsToIncrementTime = graphicalInterface.getWantsToIncrementTime();  
      }
   }
}