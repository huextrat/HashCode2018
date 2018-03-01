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
    private Location start, end;
    private int timeEarliest, timeLatest;
    
    public Ride(Location start, Location end, int timeEarliest, int timeLatest){
        this.start = start;
        this.end = end;
        this.timeEarliest = timeEarliest;
        this.timeLatest = timeLatest;
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
