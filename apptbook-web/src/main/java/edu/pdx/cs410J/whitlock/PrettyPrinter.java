package edu.pdx.cs410J.whitlock;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.PrintWriter;
import java.io.Writer;

public class PrettyPrinter implements AppointmentBookDumper<AppointmentBook> {
  private final Writer writer;

  @VisibleForTesting
  static String formatAppointmentDescription(String word, String definition )
  {
    return String.format("  %s -> %s", word, definition);
  }


  public PrettyPrinter(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void dump(AppointmentBook book) {
    try (
      PrintWriter pw = new PrintWriter(this.writer)
    ) {

      for (Appointment appointment : book.getAppointments()) {
        String owner = book.getOwnerName();
        String description = appointment.getDescription();
        pw.println(formatAppointmentDescription(owner, description));
      }

      pw.flush();
    }

  }
}
