package com.github.gdc.cssps.model.school;

/**
 *Represents the different types of gender that are accepted into a particular school
 * @author Edem Morny
 */
public enum AcceptedGender {

    MALE("Male",'M'), FEMALE("Female",'F'), MIXED("Mixed",'A');
    private String label;
    private Character symbol;

    private AcceptedGender(String label,Character symbol) {
        this.label = label;
        this.symbol = symbol;
    }

    public AcceptedGender getFEMALE() {
        return FEMALE;
    }

    public String getLabel() {
        return label;
    }

    public Character getSymbol() {
        return symbol;
    }
    

    public AcceptedGender getMALE() {
        return MALE;
    }

    public AcceptedGender getMIXED() {
        return MIXED;
    }


    

}
