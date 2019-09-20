/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.Random;

public class GateOutThread extends Thread{
    private Garage garage;
    Random r = new Random();
    private boolean running = true;
    
    public GateOutThread( Garage garage) {
        this.garage = garage;
    }
    
    @Override
    public void run() {
            try {
                Thread.sleep(5000);
                 while (running) {
                Thread.sleep(r.nextInt(2000) + 1000);
                if (!garage.removeACar()) {
                    running = false;
                    
                }
                 }
            } catch (InterruptedException e) {} 
        
    }
    
}