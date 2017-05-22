
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Transaction extends view.objects.Bookable implements TransactionView{
    
    protected java.util.Vector<TransferView> transfers;
    
    public Transaction(String subject,java.util.Vector<TransferView> transfers,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)subject,id, classId);
        this.transfers = transfers;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<TransferView> getTransfers()throws ModelException{
        return this.transfers;
    }
    public void setTransfers(java.util.Vector<TransferView> newValue) throws ModelException {
        this.transfers = newValue;
    }
    
    public void accept(BookableVisitor visitor) throws ModelException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransaction(this);
    }
    public <E extends view.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends view.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransaction(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransaction(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> transfers = this.getTransfers();
        if (transfers != null) {
            ViewObject.resolveVectorProxies(transfers, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTransfers().size()) return new TransfersTransactionWrapper(this, originalIndex, (ViewRoot)this.getTransfers().get(index));
        index = index - this.getTransfers().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransfers().size());
    }
    public boolean isLeaf() throws ModelException {
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
    public int getSubjectIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "subject";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getSubject();
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
            this.setSubject(newValue);
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
