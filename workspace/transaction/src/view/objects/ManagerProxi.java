package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ManagerProxi extends ViewProxi implements ManagerView{
    
    public ManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> currentAccounts_string = (java.util.Vector<String>)resultTable.get("currentAccounts");
        java.util.Vector<AccountView> currentAccounts = ViewProxi.getProxiVector(currentAccounts_string, connectionKey);
        java.util.Vector<String> openTransfers_string = (java.util.Vector<String>)resultTable.get("openTransfers");
        java.util.Vector<TransferView> openTransfers = ViewProxi.getProxiVector(openTransfers_string, connectionKey);
        ManagerView result$$ = new Manager(currentAccounts,openTransfers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCurrentAccounts().size()) return new CurrentAccountsManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrentAccounts().get(index));
        index = index - this.getCurrentAccounts().size();
        if(index < this.getOpenTransfers().size()) return new OpenTransfersManagerWrapper(this, originalIndex, (ViewRoot)this.getOpenTransfers().get(index));
        index = index - this.getOpenTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrentAccounts().size())
            + (this.getOpenTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getCurrentAccounts().size() == 0)
            && (this.getOpenTransfers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCurrentAccountsIterator = this.getCurrentAccounts().iterator();
        while(getCurrentAccountsIterator.hasNext()){
            if(getCurrentAccountsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        java.util.Iterator<?> getOpenTransfersIterator = this.getOpenTransfers().iterator();
        while(getOpenTransfersIterator.hasNext()){
            if(getOpenTransfersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<AccountView> getCurrentAccounts()throws ModelException{
        return ((Manager)this.getTheObject()).getCurrentAccounts();
    }
    public void setCurrentAccounts(java.util.Vector<AccountView> newValue) throws ModelException {
        ((Manager)this.getTheObject()).setCurrentAccounts(newValue);
    }
    public java.util.Vector<TransferView> getOpenTransfers()throws ModelException{
        return ((Manager)this.getTheObject()).getOpenTransfers();
    }
    public void setOpenTransfers(java.util.Vector<TransferView> newValue) throws ModelException {
        ((Manager)this.getTheObject()).setOpenTransfers(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleManager(this);
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
