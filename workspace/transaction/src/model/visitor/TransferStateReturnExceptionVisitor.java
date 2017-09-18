
package model.visitor;
import persistence.*;

public interface TransferStateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleBooked(Booked4Public booked) throws PersistenceException, E;
    public R handleNotBooked(NotBooked4Public notBooked) throws PersistenceException, E;
    
}
