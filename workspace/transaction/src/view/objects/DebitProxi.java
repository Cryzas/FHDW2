package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitProxi extends EntryProxi implements DebitView{
    
    public DebitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        DebitView result$$ = new Debit( this.getId(), this.getClassId());
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
    
    
    public void accept(EntryVisitor visitor) throws ModelException {
        visitor.handleDebit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebit(this);
    }
    public <E extends view.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends view.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleDebit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleDebit(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleDebit(this);
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
