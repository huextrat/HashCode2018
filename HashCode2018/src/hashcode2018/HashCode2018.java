/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javafx.application.Platform;

/**
 *
 * @author huextrat <extrat.h@gmail.com> <www.hugoextrat.com>
 */
public class HashCode2018 {

    public static String in = "C:\\Users\\extra\\Documents\\2S_RGU\\HashCode2018\\HashCode2018_io\\c_no_hurry.in";
    public static String out = "C:\\Users\\extra\\Documents\\2S_RGU\\HashCode2018\\HashCode2018_io\\c_no_hurry.out";
    
    public static int i = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        int ridesAlready = 0;
        int score = 0;
        
        File file = new File(in);
        Scanner scanner = new Scanner(file);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int F = scanner.nextInt();
        int N = scanner.nextInt();
        int B = scanner.nextInt();
        int T = scanner.nextInt();
            
        scanner.nextLine();
        
        List<Ride> lRide = new ArrayList<>();
        List<Vehicle> lVehicle = new ArrayList<>();
                
        for(int i=0; i<N; i++){
            lRide.add(readRide(scanner));
        }
        for(int i=0; i<F; i++){
            lVehicle.add(new Vehicle(i+1, new Location(0, 0), new Location(0, 0), false));
        }
        
        Collections.sort(lRide);
        

        for(int s=0; s<T; s++){
            for(int t=0; t<lRide.size(); t++){
                if(!lRide.get(t).isIsRunning() && lRide.get(t).getTimeEarliest() <= s){
                    int v = 0;
                    int dist = -1; 
                    for(int vehic = 0; vehic<lVehicle.size();vehic++){
                        if(!lVehicle.get(vehic).isIsUsed() && !lRide.get(t).isIsRunning()){
                            lRide.get(t).setIsRunning(true);

                            lVehicle.get(vehic).ridesDone.add(lRide.get(t));
                            Location loc = lVehicle.get(vehic).getLocation();
                            if(dist <= 0 || (Math.abs(loc.getPosX()-lRide.get(t).getStart().getPosX()) + (Math.abs(loc.getPosY()-lRide.get(t).getStart().getPosY()))) < dist){
                                v = vehic;
                                dist = Math.abs(loc.getPosX()-lRide.get(t).getStart().getPosX()) + (Math.abs(loc.getPosY()-lRide.get(t).getStart().getPosY()));
                            }
                        }
                        //int d = Math.abs(lVehicle.get(v).getLocation().getPosX() - Math.abs(lRide.get(t).getStart().getPosX())) + Math.abs(lVehicle.get(v).getLocation().getPosY() - Math.abs(lRide.get(t).getStart().getPosY()));
                        //System.out.println(d);
                        lRide.get(t).setDistance(dist);
                        lVehicle.get(v).setIsUsed(true);
                        lVehicle.get(vehic).setDest(lRide.get(t).getStart());
                    }
                    
                }
            }
            for(Vehicle v: lVehicle){
                if(v.isIsUsed()){
                    if(v.getLocation().getPosX() > v.getDest().getPosX()){
                        v.getLocation().setPosX(v.getLocation().getPosX()-1);
                    }
                    if(v.getLocation().getPosX() < v.getDest().getPosX()){
                        v.getLocation().setPosX(v.getLocation().getPosX()+1);
                    }
                    if(v.getLocation().getPosY() > v.getDest().getPosY()){
                        v.getLocation().setPosY(v.getLocation().getPosY()-1);
                    }
                    if(v.getLocation().getPosY() < v.getDest().getPosY()){
                        v.getLocation().setPosY(v.getLocation().getPosY()+1);
                    }
                    if(v.getLocation().equals(v.getDest())) {
                        
                        v.setDest(v.ridesDone.get(v.ridesDone.size()-1).getEnd());
                        
                    }
                    

                    if(v.getLocation().equals(v.ridesDone.get(v.ridesDone.size()-1).getStart()) && v.ridesDone.get(v.ridesDone.size()-1).getTimeEarliest()== s){
                        score += B;
                        //v.ridesDone.get(v.ridesDone.size()-1).setScore(v.ridesDone.get(v.ridesDone.size()-1).getScore()+B);
                    }
                    
                    if(v.getLocation().equals(v.ridesDone.get(v.ridesDone.size()-1).getEnd())){
                        ridesAlready += 1;
                        v.setIsUsed(false);
                        
                        //if(v.ridesDone.get(v.ridesDone.size()-1).getTimeFinished() <= s){
                            score += Math.abs(v.ridesDone.get(v.ridesDone.size()-1).getEnd().getPosX() - v.ridesDone.get(v.ridesDone.size()-1).getStart().getPosX()) + Math.abs(v.ridesDone.get(v.ridesDone.size()-1).getEnd().getPosY() - v.ridesDone.get(v.ridesDone.size()-1).getStart().getPosY());
                            
                            //System.out.println("distance: "+v.ridesDone.get(v.ridesDone.size()-1).getDistance());
                            //score += v.ridesDone.get(v.ridesDone.size()-1).getDistance();
                            //v.ridesDone.get(v.ridesDone.size()-1).setScore(v.ridesDone.get(v.ridesDone.size()-1).getScore()+v.ridesDone.get(v.ridesDone.size()-1).getDistance());
                            //System.out.println(v.ridesDone.get(v.ridesDone.size()-1).getScore());
                        //}
                    }
                    else {
                        //System.out.println("d");
                    }
                }
            }
            
            if(ridesAlready == lRide.size()){
                System.out.println("Score:" +score);
                
                PrintWriter writer = new PrintWriter(out, "UTF-8");
                for(Vehicle v: lVehicle){
                    
                    writer.print(v.ridesDone.size()+ " ");
                    for(Ride r: v.ridesDone){
                        writer.print(r.getId()+ " ");
                    }
                    writer.println("");
                }
                
                writer.close();
                System.out.println("terminé");
                System.exit(0);
            }
        }
        
        
        
        /**
        for(Ride r: lRide){
            System.out.println(r.getTimeEarliest());
        }**/
        
    }
    
    // Add each ride
    private static Ride readRide(Scanner in) {
        int sRow = in.nextInt();
        int sCol = in.nextInt();
        int fRow = in.nextInt();
        int fCol = in.nextInt();
        int earliestStart = in.nextInt();
        int latestFinish = in.nextInt();
        Ride r = new Ride(i, new Location(sRow, sCol), new Location(fRow, fCol), earliestStart, latestFinish);
        i++;
        return r;
    }
    
}
