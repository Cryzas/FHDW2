package view;

import view.visitor.*;

public interface TransactionView extends BookableView {
    
    public java.util.Vector<TransferView> getTransfers()throws ModelException;
    public void setTransfers(java.util.Vector<TransferView> newValue) throws ModelException ;
    
    public void accept(BookableVisitor visitor) throws ModelException;
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

