
package model.visitor;

import persistence.*;

public abstract class TransferStateStandardVisitor implements TransferStateVisitor {
    
    public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException{
        this.standardHandling(notBooked);
    }
    public void handleBooked(Booked4Public booked) throws PersistenceException{
        this.standardHandling(booked);
    }
    protected abstract void standardHandling(TransferState4Public transferState) throws PersistenceException;
}
