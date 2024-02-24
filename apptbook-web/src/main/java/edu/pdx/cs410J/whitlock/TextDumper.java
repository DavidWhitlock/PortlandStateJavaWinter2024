package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

public class TextDumper implements AppointmentBookDumper<AppointmentBook> {
  private final Writer writer;

  public TextDumper(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void dump(AppointmentBook book) {
    try (
      PrintWriter pw = new PrintWriter(this.writer)
    ){
      for (Appointment appointment : book.getAppointments()) {
        pw.println(book.getOwnerName() + " : " + appointment.getDescription());
      }

      pw.flush();
    }
  }
}
