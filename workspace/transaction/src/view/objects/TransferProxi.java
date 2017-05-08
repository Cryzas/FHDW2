package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferProxi extends ViewProxi implements TransferView{
    
    public TransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TransferView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String description = (String)resultTable.get("description");
        common.Fraction amount = common.Fraction.parse((String)resultTable.get("amount"));
        ViewProxi fromAcc = null;
        String fromAcc$String = (String)resultTable.get("fromAcc");
        if (fromAcc$String != null) {
            common.ProxiInformation fromAcc$Info = common.RPCConstantsAndServices.createProxiInformation(fromAcc$String);
            fromAcc = view.objects.ViewProxi.createProxi(fromAcc$Info,connectionKey);
            fromAcc.setToString(fromAcc$Info.getToString());
        }
        ViewProxi toAcc = null;
        String toAcc$String = (String)resultTable.get("toAcc");
        if (toAcc$String != null) {
            common.ProxiInformation toAcc$Info = common.RPCConstantsAndServices.createProxiInformation(toAcc$String);
            toAcc = view.objects.ViewProxi.createProxi(toAcc$Info,connectionKey);
            toAcc.setToString(toAcc$Info.getToString());
        }
        TransferView result$$ = new Transfer((String)description,(common.Fraction)amount,(AccountView)fromAcc,(AccountView)toAcc, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getFromAcc() != null) return new FromAccTransferWrapper(this, originalIndex, (ViewRoot)this.getFromAcc());
        if(this.getFromAcc() != null) index = index - 1;
        if(index == 0 && this.getToAcc() != null) return new ToAccTransferWrapper(this, originalIndex, (ViewRoot)this.getToAcc());
        if(this.getToAcc() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getFromAcc() == null ? 0 : 1)
            + (this.getToAcc() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getFromAcc() == null ? true : false)
            && (this.getToAcc() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getFromAcc() != null && this.getFromAcc().equals(child)) return result;
        if(this.getFromAcc() != null) result = result + 1;
        if(this.getToAcc() != null && this.getToAcc().equals(child)) return result;
        if(this.getToAcc() != null) result = result + 1;
        return -1;
    }
    
    public String getDescription()throws ModelException{
        return ((Transfer)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getAmount()throws ModelException{
        return ((Transfer)this.getTheObject()).getAmount();
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setAmount(newValue);
    }
    public AccountView getFromAcc()throws ModelException{
        return ((Transfer)this.getTheObject()).getFromAcc();
    }
    public void setFromAcc(AccountView newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setFromAcc(newValue);
    }
    public AccountView getToAcc()throws ModelException{
        return ((Transfer)this.getTheObject()).getToAcc();
    }
    public void setToAcc(AccountView newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setToAcc(newValue);
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
