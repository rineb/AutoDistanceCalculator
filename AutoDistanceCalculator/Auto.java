/**
* Class Auto is the model of the application. It remembers the car's initial velocity
* and acceleration. It has a method for calculating distance
*/ 
public class Auto {
   double initialVelocity;
   double acceleration;
   
   /**
   * This is the constructor method for class Auto
   * @param initialVelocity This parameter is the initial velocity of the car in m/s
   * @param acceleration This parameter is the acceleration of the car in m/s^2
   */
   public Auto(double initialVelocity, double acceleration) {
      this.initialVelocity = initialVelocity;
      this.acceleration = acceleration;
   }
   
   /**
   * This method calculates the car's distance for the time given
   * @param time This parameter is the time for which the car has travelled
   * @return This returns the double value of the distance the car has travelled
   */
   public double calculateDistance(double time) {
      double distance = initialVelocity*time + (1.0/2.0)*acceleration*Math.pow(time, 2);
      return distance;
   }
}