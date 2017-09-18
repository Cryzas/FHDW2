
package view.visitor;

import view.*;

public abstract class TransferStateStandardVisitor implements TransferStateVisitor {
    
    public void handleNotBooked(NotBookedView notBooked) throws ModelException{
        this.standardHandling(notBooked);
    }
    public void handleBooked(BookedView booked) throws ModelException{
        this.standardHandling(booked);
    }
    protected abstract void standardHandling(TransferStateView transferState) throws ModelException;
}
