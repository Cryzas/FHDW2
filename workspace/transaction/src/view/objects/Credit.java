
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Credit extends view.objects.Entry implements CreditView{
    
    
    public Credit(String description,common.Fraction amount,AccountView otherAcc,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)description,(common.Fraction)amount,(AccountView)otherAcc,id, classId);        
    }
    
    static public long getTypeId() {
        return 133;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(EntryVisitor visitor) throws ModelException {
        visitor.handleCredit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCredit(this);
    }
    public <E extends view.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends view.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCredit(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleCredit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleCredit(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleCredit(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AccountView otherAcc = this.getOtherAcc();
        if (otherAcc != null) {
            ((ViewProxi)otherAcc).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(otherAcc.getClassId(), otherAcc.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        return true 
            && (this.getOtherAcc() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getOtherAcc() != null && this.getOtherAcc().equals(child)) return result;
        if(this.getOtherAcc() != null) result = result + 1;
        return -1;
    }
    public int getDescriptionIndex() throws ModelException {
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
                if(rowIndex == 0) return "description";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "amount";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getDescription();
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
            this.setDescription(newValue);
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
