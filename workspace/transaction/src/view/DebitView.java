package view;

import view.visitor.*;

public interface DebitView extends EntryView {
    
    
    public void accept(EntryVisitor visitor) throws ModelException;
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

