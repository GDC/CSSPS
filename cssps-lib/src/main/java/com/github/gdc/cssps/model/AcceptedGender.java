package com.github.gdc.cssps.model;

/**
 *Represents the different types of gender that are accepted into a particular school
 * @author Edem Morny
 */
public enum AcceptedGender {

    MALE("Male"), FEMALE("Female"), MIXED("Mixed");
    private String label;

    private AcceptedGender(String label) {
        this.label = label;
    }

    public AcceptedGender getFEMALE() {
        return FEMALE;
    }

    public String getLabel() {
        return label;
    }

    public AcceptedGender getMALE() {
        return MALE;
    }

    public AcceptedGender getMIXED() {
        return MIXED;
    }


    

}
