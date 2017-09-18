
package model.visitor;
import persistence.*;

public interface TransferStateVisitor {
    
    public void handleBooked(Booked4Public booked) throws PersistenceException;
    public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException;
    
}
