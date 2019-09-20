/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

/**
 *
 * @author flunghi
 */
public class Car {
    static int carNumber = 0;
    public String plate;
    
    // random plate constructor
    public Car() {
        plate = "AB" + carNumber + "CD";
        carNumber++;               
    }
    @Override
    public String toString() {
        return plate;
    }
    
}
