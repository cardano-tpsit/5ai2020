/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

import java.util.ArrayList;

/**
 *
 * @author flunghi
 */
public class Garage {

    public static int maxCars = 5;
    private ArrayList<Car> garage = new ArrayList<>();
    
    public synchronized int count() {
        return garage.size();
    }
    
    public synchronized boolean addCar(Car c) {
        if (count() < maxCars) {
            garage.add(c);
            System.out.println(c + " enters");
            return true;
        } else {
            System.out.println(c + " cannot enter");
            return false;
        }
    }
    public synchronized boolean removeACar() {
        if (!garage.isEmpty()) {
            garage.remove(count() -1);
            System.out.println("a car is leaving");
            System.out.println(garage);
            return true;
        } else {
            System.out.println("garage: empty!");
            return false;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------\n");
        for (Car c : garage) {
            sb.append(c + "\n");
        }
        sb.append("------------\n");
        return sb.toString();
    } 
    
    
    public static void main(String[] args) throws InterruptedException {
        Garage g = new Garage();
        GateInThread t1 = new GateInThread(1, g);
        GateInThread t2 = new GateInThread(2, g);
        GateOutThread t3 = new GateOutThread(g);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("garage closed!");
        
    }
    
}
