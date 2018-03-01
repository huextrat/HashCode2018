/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2018;

/**
 *
 * @author huextrat <extrat.h@gmail.com> <www.hugoextrat.com>
 */
public class Ride implements Comparable<Ride> {
    private int id, score, distance;
    private Location start, end;
    private int timeEarliest, timeLatest;
    private boolean isRunning;
    
    private int startedTime = 0;
    
    public Ride(int id, Location start, Location end, int timeEarliest, int timeLatest){
        this.id = id;
        this.score = 0;
        this.distance = 0;
        this.start = start;
        this.end = end;
        this.timeEarliest = timeEarliest;
        this.timeLatest = timeLatest;
        this.isRunning = false;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public int getTimeFinished(){
        return startedTime + getTotalDistance();
    }
    
    public int getLatestStarted(){
        return timeLatest - getTotalDistance();
    }
    
    public int getTotalDistance(){
        return start.getDistance(end);
    }

    @Override
    public int compareTo(Ride o) {
        return this.timeEarliest - o.timeEarliest;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public int getTimeEarliest() {
        return timeEarliest;
    }

    public void setTimeEarliest(int timeEarliest) {
        this.timeEarliest = timeEarliest;
    }

    public int getTimeLatest() {
        return timeLatest;
    }

    public void setTimeLatest(int timeLatest) {
        this.timeLatest = timeLatest;
    }
    
}
