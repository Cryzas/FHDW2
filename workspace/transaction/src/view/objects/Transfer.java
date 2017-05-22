
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Transfer extends view.objects.Bookable implements TransferView{
    
    protected common.Fraction amount;
    
    public Transfer(String subject,common.Fraction amount,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)subject,id, classId);
        this.amount = amount;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public common.Fraction getAmount()throws ModelException{
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        this.amount = newValue;
    }
    
    public void accept(BookableVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends view.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends view.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getSubjectIndex() throws ModelException {
        return 0;
    }
    public int getAmountIndex() throws ModelException {
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
                if(rowIndex == 0) return "subject";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "amount";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getSubject();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getAmount();
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
        if(rowIndex == 0){
            this.setAmount(common.Fraction.parse(newValue));
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
