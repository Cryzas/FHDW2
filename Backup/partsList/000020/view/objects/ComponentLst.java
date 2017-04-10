
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ComponentLst extends ViewObject implements ComponentLstView{
    
    protected java.util.Vector<QuantifiedComponentView> parts;
    
    public ComponentLst(java.util.Vector<QuantifiedComponentView> parts,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.parts = parts;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<QuantifiedComponentView> getParts()throws ModelException{
        return this.parts;
    }
    public void setParts(java.util.Vector<QuantifiedComponentView> newValue) throws ModelException {
        this.parts = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleComponentLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleComponentLst(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleComponentLst(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleComponentLst(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> parts = this.getParts();
        if (parts != null) {
            ViewObject.resolveVectorProxies(parts, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getParts().size()) return new PartsComponentLstWrapper(this, originalIndex, (ViewRoot)this.getParts().get(index));
        index = index - this.getParts().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getParts().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getParts().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getPartsIterator = this.getParts().iterator();
        while(getPartsIterator.hasNext()){
            if(getPartsIterator.next().equals(child)) return result;
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
