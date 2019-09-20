/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.Random;

/**
 *
 * @author flunghi
 */
public class GateInThread extends Thread{
    private int gateNumber;
    private Garage garage;
    Random r = new Random();
    private boolean running = true;
    
    public GateInThread(int gateNumber, Garage garage) {
        this.garage = garage;
        this.gateNumber = gateNumber;
    }
    
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(r.nextInt(1000) + 1000);
                Car c = new Car();
                //System.out.println(c + " entering the garage from gate " + gateNumber);
                if (!garage.addCar(c)) {
                    closeGate();
                }
            } catch (InterruptedException e) {} 
        }
    }
    public void closeGate() {
        System.out.println("closing gate " + gateNumber);
        running = false;
    }
    
}
