package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class DebitProxi extends EntryProxi implements DebitView{
    
    public DebitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public DebitView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String description = (String)resultTable.get("description");
        common.Fraction amount = common.Fraction.parse((String)resultTable.get("amount"));
        ViewProxi otherAcc = null;
        String otherAcc$String = (String)resultTable.get("otherAcc");
        if (otherAcc$String != null) {
            common.ProxiInformation otherAcc$Info = common.RPCConstantsAndServices.createProxiInformation(otherAcc$String);
            otherAcc = view.objects.ViewProxi.createProxi(otherAcc$Info,connectionKey);
            otherAcc.setToString(otherAcc$Info.getToString());
        }
        DebitView result$$ = new Debit((String)description,(common.Fraction)amount,(AccountView)otherAcc, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getOtherAcc() != null) return new OtherAccEntryWrapper(this, originalIndex, (ViewRoot)this.getOtherAcc());
        if(this.getOtherAcc() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getOtherAcc() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getOtherAcc() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOtherAcc() != null && this.getOtherAcc().equals(child)) return result;
        if(this.getOtherAcc() != null) result = result + 1;
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
