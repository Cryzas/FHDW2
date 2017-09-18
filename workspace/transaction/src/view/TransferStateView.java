package view;

import view.objects.*;

import view.visitor.*;

public interface TransferStateView extends Anything, AbstractViewRoot {
    
    
    public void accept(TransferStateVisitor visitor) throws ModelException;
    public <R> R accept(TransferStateReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(TransferStateExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(TransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

