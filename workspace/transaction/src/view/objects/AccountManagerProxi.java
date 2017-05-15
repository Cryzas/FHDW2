package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountManagerProxi extends ViewProxi implements AccountManagerView{
    
    public AccountManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> currentAccounts_string = (java.util.Vector<String>)resultTable.get("currentAccounts");
        java.util.Vector<AccountHandleView> currentAccounts = ViewProxi.getProxiVector(currentAccounts_string, connectionKey);
        AccountManagerView result$$ = new AccountManager(currentAccounts, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsAccountManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrentAccounts().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCurrentAccounts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCurrentAccountsIterator = this.getCurrentAccounts().iterator();
        while(getCurrentAccountsIterator.hasNext()){
            if(getCurrentAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AccountHandleView> getCurrentAccounts()throws ModelException{
        return ((AccountManager)this.getTheObject()).getCurrentAccounts();
    }
    public void setCurrentAccounts(java.util.Vector<AccountHandleView> newValue) throws ModelException {
        ((AccountManager)this.getTheObject()).setCurrentAccounts(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccountManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccountManager(this);
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
