package app.service;

import util.view.menu.IterativeMenu;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.collection.Iterator;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;

public class ServiceMenu extends IterativeMenu<LinkedMap<Date, Interval<Time>>> {

  public ServiceMenu(LinkedMap<Date, Interval<Time>> target) {
    super("Menú de Servicio", target);
    this.add(new ServiceOption("Listar", target) {

      public void interact() {
        LinkedSet<Date> set = this.getTarget().keySet();
        Iterator<Date> iterator = set.iterator();
        while (iterator.hasNext()) {
          Date date = iterator.next();
          new ServiceDialog().writeln(new Service(date, this.getTarget().get(date)));
        }
      }
  
    });
    this.add(new ServiceOption("Añadir", target) {
  
      public void interact() {
        ServiceDialog serviceDialog = new ServiceDialog("Servicio");
        Service service = (Service) serviceDialog.read();
        this.getTarget().put(service.getKey(), service.getValue());
      }
  
    });
    this.add(new RemovingServiceMenu(this.getTarget()));
  }

 

 

}
