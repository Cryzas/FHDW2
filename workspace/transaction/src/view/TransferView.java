package view;

import view.objects.*;

import view.visitor.*;

public interface TransferView extends Anything, AbstractViewRoot {
    
    public String getDescription()throws ModelException;
    public void setDescription(String newValue) throws ModelException ;
    public common.Fraction getAmount()throws ModelException;
    public void setAmount(common.Fraction newValue) throws ModelException ;
    public AccountView getFromAcc()throws ModelException;
    public void setFromAcc(AccountView newValue) throws ModelException ;
    public AccountView getToAcc()throws ModelException;
    public void setToAcc(AccountView newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

