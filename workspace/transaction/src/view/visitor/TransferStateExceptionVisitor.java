
package view.visitor;
import view.*;

public interface TransferStateExceptionVisitor<E extends view.UserException> {
    
    public void handleBooked(BookedView booked) throws ModelException, E;
    public void handleNotBooked(NotBookedView notBooked) throws ModelException, E;
    
}
