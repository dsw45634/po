package pl.dsw45634.po.ex_10.observer;

// refactoring guru

import java.io.File;

class EmailNotificationListener implements EventListener {

  private String email;

  public EmailNotificationListener(String email) {
    this.email = email;
  }

  @Override
  public void update(String eventType, File file) {
    System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
  }

}
