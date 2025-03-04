package com.mycompany.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import com.mycompany.GameRPG.GamePanel;

public class MouseMListener implements MouseMotionListener{

  public double x,y;
  GamePanel gp;
  public MouseMListener(GamePanel gp){
    this.gp = gp;
  }

  @Override
  public void mouseDragged(MouseEvent e){
    x = e.getX();
    y = e.getY();
  }
  @Override
  public void mouseMoved(MouseEvent e){
    x = e.getX();
    y = e.getY();
    //Check if its hovering over a button
    for (int i = 0; i < gp.buttonH.buttonCount; i++){
      if(x > gp.buttonH.buttons[i].x && x < gp.buttonH.buttons[i].x + gp.buttonH.buttons[i].width &&
        y > gp.buttonH.buttons[i].y && y < gp.buttonH.buttons[i].y + gp.buttonH.buttons[i].height &&
        gp.buttonH.buttons[i].isAlive){
          if (!gp.buttonH.buttons[i].hover){
            gp.buttonH.startHover(i);
          }
      }else if (gp.buttonH.buttons[i].hover){
        gp.buttonH.endHover(i);
      }
    }
  }
}

