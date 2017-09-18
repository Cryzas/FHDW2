
package view.visitor;
import view.*;

public interface TransferStateReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleBooked(BookedView booked) throws ModelException, E;
    public R handleNotBooked(NotBookedView notBooked) throws ModelException, E;
    
}
