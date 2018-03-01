/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2018;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huextrat <extrat.h@gmail.com> <www.hugoextrat.com>
 */
public class Vehicle {
    private Location location, dest;
    private boolean isUsed;
    
    private int id;
    public ArrayList<Ride> ridesDone = new ArrayList<>();
    //private int distance;
    
    public Vehicle(int id, Location location, Location dest, boolean isUsed){
        this.id = id;
        this.location = location;
        this.isUsed = isUsed;
        this.dest = dest;
    }
    
    public String getRidesDone(){
        String s = "";
        for(Ride r: ridesDone){
            s+=r.getTotalDistance();
        }
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Location getDest() {
        return dest;
    }

    public void setDest(Location dest) {
        this.dest = dest;
    }
    
    

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }    
}
