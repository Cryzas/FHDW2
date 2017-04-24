
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Material extends view.objects.Component implements MaterialView{
    
    
    public Material(String name,common.Fraction price,common.Fraction overAllPrice,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)price,(common.Fraction)overAllPrice,id, classId);        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(ComponentVisitor visitor) throws ModelException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaterial(this);
    }
    public <E extends view.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends view.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaterial(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleMaterial(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleMaterial(this);
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getPriceIndex() throws ModelException {
        return 0 + 1;
    }
    public int getOverAllPriceIndex() throws ModelException {
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
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "price";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "overAllPrice";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getPrice();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getOverAllPrice();
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
            this.setPrice(common.Fraction.parse(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        rowIndex = rowIndex - 1;
    }
    public boolean hasTransientFields(){
        return true;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
