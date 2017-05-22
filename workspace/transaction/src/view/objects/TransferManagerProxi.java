package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferManagerProxi extends ViewProxi implements TransferManagerView{
    
    public TransferManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TransferManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> transfers_string = (java.util.Vector<String>)resultTable.get("transfers");
        java.util.Vector<BookableView> transfers = ViewProxi.getProxiVector(transfers_string, connectionKey);
        TransferManagerView result$$ = new TransferManager(transfers, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTransfers().size()) return new TransfersTransferManagerWrapper(this, originalIndex, (ViewRoot)this.getTransfers().get(index));
        index = index - this.getTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTransfers().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTransfersIterator = this.getTransfers().iterator();
        while(getTransfersIterator.hasNext()){
            if(getTransfersIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<BookableView> getTransfers()throws ModelException{
        return ((TransferManager)this.getTheObject()).getTransfers();
    }
    public void setTransfers(java.util.Vector<BookableView> newValue) throws ModelException {
        ((TransferManager)this.getTheObject()).setTransfers(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransferManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransferManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransferManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransferManager(this);
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
