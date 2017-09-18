
package model.visitor;
import persistence.*;

public interface TransferStateReturnVisitor<R> {
    
    public R handleBooked(Booked4Public booked) throws PersistenceException;
    public R handleNotBooked(NotBooked4Public notBooked) throws PersistenceException;
    
}
