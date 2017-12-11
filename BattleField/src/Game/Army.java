
package Game;

import java.util.ArrayList;

public class Army {
    private int numOfUnits;

    public Army(int numOfUnits, ArrayList<Unit> units) {
        this.numOfUnits = numOfUnits;
        this.units = units;
    }
    private ArrayList<Unit> units;

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits) {
        this.numOfUnits = numOfUnits;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
    
    
    
    
}
