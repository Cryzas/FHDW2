
package view.visitor;
import view.*;

public interface TransferStateReturnVisitor<R> {
    
    public R handleBooked(BookedView booked) throws ModelException;
    public R handleNotBooked(NotBookedView notBooked) throws ModelException;
    
}
