package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NotBookedProxi extends TransferStateProxi implements NotBookedView{
    
    public NotBookedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NotBookedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        NotBookedView result$$ = new NotBooked( this.getId(), this.getClassId());
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
    
    
    public void accept(TransferStateVisitor visitor) throws ModelException {
        visitor.handleNotBooked(this);
    }
    public <R> R accept(TransferStateReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotBooked(this);
    }
    public <E extends view.UserException>  void accept(TransferStateExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotBooked(this);
    }
    public <R, E extends view.UserException> R accept(TransferStateReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotBooked(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNotBooked(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNotBooked(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNotBooked(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNotBooked(this);
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
