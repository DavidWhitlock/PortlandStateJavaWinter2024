package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractAppointment;

public class Appointment extends AbstractAppointment {
    private final String description;

    public Appointment(String description) {
        this.description = description;
    }

    @Override
    public String getBeginTimeString() {
        return "Begin";
    }

    @Override
    public String getEndTimeString() {
        return "End";
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
