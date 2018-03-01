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
    private Location location;
    private boolean isUsed;
    
    private ArrayList<Ride> ridesDone = new ArrayList<>();
    //private int distance;
    
    public Vehicle(Location location, boolean isUsed){
        this.location = location;
        this.isUsed = isUsed;
    }
    
    public boolean canDrive(Ride nextRide){
        Location loc, nextLoc;
        int lastTime, distance, latestStart;
        
        if(ridesDone.isEmpty()){
            loc = new Location(0, 0);
            lastTime = 0;
        }
        else {
            loc = ridesDone.get(ridesDone.size()).getEnd();
            lastTime = ridesDone.get(ridesDone.size()).getTimeFinished();
        }
        nextLoc = nextRide.getStart();
        distance = loc.getDistance(nextLoc);
        latestStart = nextRide.getLatestStarted();
        
        return lastTime + distance;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
}
