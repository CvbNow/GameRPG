package com.mycompany.GameRPG;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import com.mycompany.Listeners.MouseCListener;
import com.mycompany.Listeners.MouseMListener;


public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; //Might not need? not sure.
    
    int screenWidth = 60 * 16;
    int screenHeight = 60 * 9;
    
    

    Thread gameThread;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

        MouseCListener MouseCListener = new MouseCListener();
        MouseMListener MouseMListener = new MouseMListener();

        this.addMouseListener(MouseCListener);
        this.addMouseMotionListener(MouseMListener);
    }

    int fps = 60;
    double lastTime = System.nanoTime();
    double currentTime;
    @Override //Delta Time
    public void run() {
        currentTime = System.nanoTime();
        if ((currentTime - lastTime)/1e9/fps >= 1){
            lastTime = currentTime;

            this.update();

            this.repaint();
            //TODO
            //Add in the update and repaint functions
            //Add in the key listener
        
         }
    }
    public void update(){
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.black);

    }
}
