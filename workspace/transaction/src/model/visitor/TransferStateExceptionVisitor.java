
package model.visitor;
import persistence.*;

public interface TransferStateExceptionVisitor<E extends model.UserException> {
    
    public void handleBooked(Booked4Public booked) throws PersistenceException, E;
    public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException, E;
    
}
