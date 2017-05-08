
package view.objects;

import view.*;


/* Additional import section end */

public abstract class Entry extends ViewObject implements EntryView{
    
    protected String description;
    protected common.Fraction amount;
    protected AccountView otherAcc;
    
    public Entry(String description,common.Fraction amount,AccountView otherAcc,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.description = description;
        this.amount = amount;
        this.otherAcc = otherAcc;        
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
    public AccountView getOtherAcc()throws ModelException{
        return this.otherAcc;
    }
    public void setOtherAcc(AccountView newValue) throws ModelException {
        this.otherAcc = newValue;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
