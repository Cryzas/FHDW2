package view;

import view.objects.*;

import view.visitor.*;

public interface EntryView extends Anything, AbstractViewRoot {
    
    
    public void accept(EntryVisitor visitor) throws ModelException;
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

