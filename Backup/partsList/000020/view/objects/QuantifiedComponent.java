
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class QuantifiedComponent extends ViewObject implements QuantifiedComponentView{
    
    protected long quantity;
    protected ComponentView component;
    
    public QuantifiedComponent(long quantity,ComponentView component,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.quantity = quantity;
        this.component = component;        
    }
    
    static public long getTypeId() {
        return 114;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getQuantity()throws ModelException{
        return this.quantity;
    }
    public void setQuantity(long newValue) throws ModelException {
        this.quantity = newValue;
    }
    public ComponentView getComponent()throws ModelException{
        return this.component;
    }
    public void setComponent(ComponentView newValue) throws ModelException {
        this.component = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleQuantifiedComponent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleQuantifiedComponent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleQuantifiedComponent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleQuantifiedComponent(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ComponentView component = this.getComponent();
        if (component != null) {
            ((ViewProxi)component).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(component.getClassId(), component.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getComponent() != null) return new ComponentQuantifiedComponentWrapper(this, originalIndex, (ViewRoot)this.getComponent());
        if(this.getComponent() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getComponent() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getComponent() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getComponent() != null && this.getComponent().equals(child)) return result;
        if(this.getComponent() != null) result = result + 1;
        return -1;
    }
    public int getQuantityIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "quantity";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getQuantity());
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
            this.setQuantity(Long.parseLong(newValue));
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
