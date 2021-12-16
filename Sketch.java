import processing.core.PApplet;

public class Sketch extends PApplet {

/**
  Global Variables
*/

// Inverse for X
float inverseX;

// Circle x and y starting values
public double circleX = 0;
public double circleY = 250;

// Circle size values
public float circleWidth = 50;
public float circleHeight = 50;

// Speed of the moving circle
public double speed = 5;

// Situation conditionals
public boolean sun = true;
public boolean moon = false;

// Background fade inital values
public float transparency = 1;
public int day = color(51, 198, 255);
public int night = color(15, 3, 36);
public float amt = 0;

  public void settings() {
    size(800, 300);
    smooth();
  }

  public void setup() {
    background(0);
  }

  public void draw() {

    if (sun == true) {

      // Backgound
      background(lerpColor(night, day, amt));
      amt += 0.03;

      // Parabola-arch circle movement
      fill(246, 255, 51);
      ellipse(inverseX, (float)circleY, circleWidth, circleHeight);
      circleX += speed;
      circleY = (0.0009 * (Math.pow(circleX - width/2, 2))) + 100;
      inverseX = width - (float) circleX;

      // Ground
      fill(85, 234, 19);
      rect(0, 250, width, height - 40);
      fill(116, 91, 14);
      rect(0, 260, width, height);

      // Reset values
      if (circleY >= 300) {
        moon = true;
        sun = false;
        circleX = 0;
        circleY = 250;
        amt = 0;
      }
    }

    else if (moon == true) {

      // Background
      background(lerpColor(day, night, amt));
      amt += 0.03;

      // Parabola-arch circle movement
      fill(255, 255, 255);
      ellipse(inverseX, (float)circleY, circleWidth, circleHeight);
      circleX += speed;
      circleY = (0.0009 * (Math.pow(circleX - width/2, 2))) + 100;
      inverseX = width - (float) circleX;

      // Ground
      fill(17, 99, 9);
      rect(0, 250, width, height - 40);
      fill(80, 63, 9);
      rect(0, 260, width, height);

      // Reset values
      if (circleY >= 300) {
        sun = true;
        moon = false;
        circleX = 0;
        circleY = 250;
        amt = 0;
      }
    }
  }
}