
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Product extends view.objects.Component implements ProductView{
    
    protected ComponentLstView components;
    protected ComponentLstView materials;
    
    public Product(String name,common.Fraction price,common.Fraction overAllPrice,ComponentLstView components,ComponentLstView materials,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)price,(common.Fraction)overAllPrice,id, classId);
        this.components = components;
        this.materials = materials;        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ComponentLstView getComponents()throws ModelException{
        return this.components;
    }
    public void setComponents(ComponentLstView newValue) throws ModelException {
        this.components = newValue;
    }
    public ComponentLstView getMaterials()throws ModelException{
        return this.materials;
    }
    
    public void accept(ComponentVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends view.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends view.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleProduct(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleProduct(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ComponentLstView components = this.getComponents();
        if (components != null) {
            ((ViewProxi)components).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(components.getClassId(), components.getId())));
        }
        ComponentLstView materials = this.getMaterials();
        if (materials != null) {
            ((ViewProxi)materials).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(materials.getClassId(), materials.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getComponents() != null) return new ComponentsProductWrapper(this, originalIndex, (ViewRoot)this.getComponents());
        if(this.getComponents() != null) index = index - 1;
        if(index == 0 && this.getMaterials() != null) return new MaterialsProductWrapper(this, originalIndex, (ViewRoot)this.getMaterials());
        if(this.getMaterials() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponents() == null ? 0 : 1)
            + (this.getMaterials() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getComponents() == null ? true : false)
            && (this.getMaterials() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getComponents() != null && this.getComponents().equals(child)) return result;
        if(this.getComponents() != null) result = result + 1;
        if(this.getMaterials() != null && this.getMaterials().equals(child)) return result;
        if(this.getMaterials() != null) result = result + 1;
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
