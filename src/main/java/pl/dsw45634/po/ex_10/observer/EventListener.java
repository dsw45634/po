package pl.dsw45634.po.ex_10.observer;

// refactoring guru

import java.io.File;

interface EventListener {

  void update(String eventType, File file);

}
