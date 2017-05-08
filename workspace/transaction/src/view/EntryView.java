package view;

import view.objects.*;

import view.visitor.*;

public interface EntryView extends Anything, AbstractViewRoot {
    
    public String getDescription()throws ModelException;
    public void setDescription(String newValue) throws ModelException ;
    public common.Fraction getAmount()throws ModelException;
    public void setAmount(common.Fraction newValue) throws ModelException ;
    public AccountView getOtherAcc()throws ModelException;
    public void setOtherAcc(AccountView newValue) throws ModelException ;
    
    public void accept(EntryVisitor visitor) throws ModelException;
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

