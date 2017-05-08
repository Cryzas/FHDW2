
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Transfer extends ViewObject implements TransferView{
    
    protected String description;
    protected common.Fraction amount;
    protected AccountView fromAcc;
    protected AccountView toAcc;
    
    public Transfer(String description,common.Fraction amount,AccountView fromAcc,AccountView toAcc,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.description = description;
        this.amount = amount;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;        
    }
    
    static public long getTypeId() {
        return 134;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getDescription()throws ModelException{
        return this.description;
    }
    public void setDescription(String newValue) throws ModelException {
        this.description = newValue;
    }
    public common.Fraction getAmount()throws ModelException{
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws ModelException {
        this.amount = newValue;
    }
    public AccountView getFromAcc()throws ModelException{
        return this.fromAcc;
    }
    public void setFromAcc(AccountView newValue) throws ModelException {
        this.fromAcc = newValue;
    }
    public AccountView getToAcc()throws ModelException{
        return this.toAcc;
    }
    public void setToAcc(AccountView newValue) throws ModelException {
        this.toAcc = newValue;
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
        AccountView fromAcc = this.getFromAcc();
        if (fromAcc != null) {
            ((ViewProxi)fromAcc).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(fromAcc.getClassId(), fromAcc.getId())));
        }
        AccountView toAcc = this.getToAcc();
        if (toAcc != null) {
            ((ViewProxi)toAcc).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(toAcc.getClassId(), toAcc.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
