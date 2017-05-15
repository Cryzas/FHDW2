package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountWrpprProxi extends AccountHandleProxi implements AccountWrpprView{
    
    public AccountWrpprProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public AccountWrpprView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        AccountWrpprView result$$ = new AccountWrppr( this.getId(), this.getClassId());
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
    
    
    public void accept(AccountHandleVisitor visitor) throws ModelException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends view.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends view.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountWrppr(this);
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
