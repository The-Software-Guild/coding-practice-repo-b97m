/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.statecapitals;


public class Capital {
    private String name;
    private int population;
    private double sqMiles;
    
    public Capital(String name, int population, double sqMiles) {
        this.name = name;
        this.population = population;
        this.sqMiles = sqMiles;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getSqMiles() {
        return sqMiles;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Capital) {
            Capital othCap = (Capital) obj;
            boolean allMatch = this.name.equals(othCap.name);
            allMatch = allMatch && (this.population == othCap.population);
            allMatch = allMatch && (this.sqMiles == othCap.sqMiles);
            
            return allMatch;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int nameComp = this.name.hashCode();
        int popComp = Integer.hashCode(this.population);
        int sqComp = Double.hashCode(this.sqMiles);
        
        return nameComp * popComp * sqComp;
    }
    
    
}
