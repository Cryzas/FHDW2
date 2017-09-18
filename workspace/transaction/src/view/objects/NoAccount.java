
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class NoAccount extends view.objects.Account implements NoAccountView{
    
    
    public NoAccount(String name,common.Fraction balance,java.util.Vector<EntryView> entries,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)balance,entries,id, classId);        
    }
    
    static public long getTypeId() {
        return 140;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(AccountVisitor visitor) throws ModelException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoAccount(this);
    }
    public <E extends view.UserException>  void accept(AccountExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends view.UserException> R accept(AccountReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AccountHandleVisitor visitor) throws ModelException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoAccount(this);
    }
    public <E extends view.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends view.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoAccount(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoAccount(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> entries = this.getEntries();
        if (entries != null) {
            ViewObject.resolveVectorProxies(entries, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getBalanceIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "balance";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getBalance();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setBalance(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
