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
public class Location {
    private int posX;
    private int posY;
    
    public Location(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.posX != other.posX) {
            return false;
        }
        if (this.posY != other.posY) {
            return false;
        }
        return true;
    }
    
    
    
    public int getDistance(Location loc){
        return Math.abs(posY - loc.posY) + Math.abs(posX - loc.posX);
    }
}
