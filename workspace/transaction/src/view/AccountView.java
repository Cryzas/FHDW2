package view;

import view.objects.*;

import view.visitor.*;

public interface AccountView extends Anything, AbstractViewRoot {
    
    public long getNumber()throws ModelException;
    public String getDescription()throws ModelException;
    public void setDescription(String newValue) throws ModelException ;
    public common.Fraction getBalance()throws ModelException;
    public void setBalance(common.Fraction newValue) throws ModelException ;
    public java.util.Vector<EntryView> getEntries()throws ModelException;
    public void setEntries(java.util.Vector<EntryView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

