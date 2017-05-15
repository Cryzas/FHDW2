package view;

import view.objects.*;

import view.visitor.*;

public interface AbstractTransferView extends Anything, AbstractViewRoot {
    
    public String getSubject()throws ModelException;
    public void setSubject(String newValue) throws ModelException ;
    
    public void accept(AbstractTransferVisitor visitor) throws ModelException;
    public <R> R accept(AbstractTransferReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AbstractTransferExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AbstractTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

