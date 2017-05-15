package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferProxi extends AbstractTransferProxi implements TransferView{
    
    public TransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TransferView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String subject = (String)resultTable.get("subject");
        common.Fraction amount = common.Fraction.parse((String)resultTable.get("amount"));
        TransferView result$$ = new Transfer((String)subject,(common.Fraction)amount, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    public common.Fraction getAmount()throws ModelException{
        return ((Transfer)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setAmount(newValue);
    }
    
    public void accept(AbstractTransferVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AbstractTransferReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends view.UserException>  void accept(AbstractTransferExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends view.UserException> R accept(AbstractTransferReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
