package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AccountProxi extends ViewProxi implements AccountView{
    
    public AccountProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public AccountView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        long number = new Long((String)resultTable.get("number")).longValue();
        String description = (String)resultTable.get("description");
        common.Fraction balance = common.Fraction.parse((String)resultTable.get("balance"));
        java.util.Vector<String> entries_string = (java.util.Vector<String>)resultTable.get("entries");
        java.util.Vector<EntryView> entries = ViewProxi.getProxiVector(entries_string, connectionKey);
        AccountView result$$ = new Account((long)number,(String)description,(common.Fraction)balance,entries, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getEntries().size()) return new EntriesAccountWrapper(this, originalIndex, (ViewRoot)this.getEntries().get(index));
        index = index - this.getEntries().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getEntries().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getEntries().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getEntriesIterator = this.getEntries().iterator();
        while(getEntriesIterator.hasNext()){
            if(getEntriesIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public long getNumber()throws ModelException{
        return ((Account)this.getTheObject()).getNumber();
    }
    public String getDescription()throws ModelException{
        return ((Account)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws ModelException {
        ((Account)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getBalance()throws ModelException{
        return ((Account)this.getTheObject()).getBalance();
    }
    public void setBalance(common.Fraction newValue) throws ModelException {
        ((Account)this.getTheObject()).setBalance(newValue);
    }
    public java.util.Vector<EntryView> getEntries()throws ModelException{
        return ((Account)this.getTheObject()).getEntries();
    }
    public void setEntries(java.util.Vector<EntryView> newValue) throws ModelException {
        ((Account)this.getTheObject()).setEntries(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAccount(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAccount(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
