/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huextrat <extrat.h@gmail.com> <www.hugoextrat.com>
 */
public class HashCode2018 {

    public static String in = "C:\\Users\\extra\\Documents\\2S_RGU\\HashCode2018\\HashCode2018_io\\a_example.in";
    public static String out = "C:\\Users\\extra\\Documents\\2S_RGU\\HashCode2018\\HashCode2018_io\\a_example.out";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
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
            lVehicle.add(new Vehicle(new Location(0, 0), false));
        }
        
        Collections.sort(lRide);
        
        for(int s=0; s<T; s++){
            for(int t=0; t<lRide.size(); t++){
                if(lRide.get(t).getTimeEarliest() == s){
                    int v = 0;
                    while(v<lVehicle.size()-1 && lVehicle.get(v).isIsUsed()){
                        v++;
                    }
                    int d = Math.abs(lVehicle.get(v).getLocation().getPosX() - Math.abs(lRide.get(t).getStart().getPosX())) + Math.abs(lVehicle.get(v).getLocation().getPosY() - Math.abs(lRide.get(t).getStart().getPosY()));
                    System.out.println(d);
                    lVehicle.get(v).setIsUsed(true);
                }
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
        return new Ride(new Location(sRow, sCol), new Location(fRow, fCol), earliestStart, latestFinish);
    }
    
}
