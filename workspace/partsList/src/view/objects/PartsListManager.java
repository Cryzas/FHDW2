
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class PartsListManager extends ViewObject implements PartsListManagerView{
    
    protected java.util.Vector<ComponentView> currentComponents;
    
    public PartsListManager(java.util.Vector<ComponentView> currentComponents,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.currentComponents = currentComponents;        
    }
    
    static public long getTypeId() {
        return 124;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ComponentView> getCurrentComponents()throws ModelException{
        return this.currentComponents;
    }
    public void setCurrentComponents(java.util.Vector<ComponentView> newValue) throws ModelException {
        this.currentComponents = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePartsListManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> currentComponents = this.getCurrentComponents();
        if (currentComponents != null) {
            ViewObject.resolveVectorProxies(currentComponents, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getCurrentComponents().size()) return new CurrentComponentsPartsListManagerWrapper(this, originalIndex, (ViewRoot)this.getCurrentComponents().get(index));
        index = index - this.getCurrentComponents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getCurrentComponents().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getCurrentComponents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getCurrentComponentsIterator = this.getCurrentComponents().iterator();
        while(getCurrentComponentsIterator.hasNext()){
            if(getCurrentComponentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
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
