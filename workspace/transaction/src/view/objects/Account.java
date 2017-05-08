
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Account extends ViewObject implements AccountView{
    
    protected long number;
    protected String description;
    protected common.Fraction balance;
    protected java.util.Vector<EntryView> entries;
    
    public Account(long number,String description,common.Fraction balance,java.util.Vector<EntryView> entries,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.number = number;
        this.description = description;
        this.balance = balance;
        this.entries = entries;        
    }
    
    static public long getTypeId() {
        return 130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getNumber()throws ModelException{
        return this.number;
    }
    public void setNumber(long newValue) throws ModelException {
        this.number = newValue;
    }
    public String getDescription()throws ModelException{
        return this.description;
    }
    public void setDescription(String newValue) throws ModelException {
        this.description = newValue;
    }
    public common.Fraction getBalance()throws ModelException{
        return this.balance;
    }
    public void setBalance(common.Fraction newValue) throws ModelException {
        this.balance = newValue;
    }
    public java.util.Vector<EntryView> getEntries()throws ModelException{
        return this.entries;
    }
    public void setEntries(java.util.Vector<EntryView> newValue) throws ModelException {
        this.entries = newValue;
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
    public int getNumberIndex() throws ModelException {
        return 0;
    }
    public int getDescriptionIndex() throws ModelException {
        return 0 + 1;
    }
    public int getBalanceIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "number";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "description";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "balance";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getNumber());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getDescription();
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
            this.setNumber(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setDescription(newValue);
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
