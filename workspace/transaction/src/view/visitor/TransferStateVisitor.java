
package view.visitor;
import view.*;

public interface TransferStateVisitor {
    
    public void handleBooked(BookedView booked) throws ModelException;
    public void handleNotBooked(NotBookedView notBooked) throws ModelException;
    
}
