
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleManager extends ViewObject implements ModuleManagerView{
    
    protected java.util.Vector<ModuleAbstractView> modules;
    
    public ModuleManager(java.util.Vector<ModuleAbstractView> modules,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.modules = modules;        
    }
    
    static public long getTypeId() {
        return 145;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<ModuleAbstractView> getModules()throws ModelException{
        return this.modules;
    }
    public void setModules(java.util.Vector<ModuleAbstractView> newValue) throws ModelException {
        this.modules = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> modules = this.getModules();
        if (modules != null) {
            ViewObject.resolveVectorProxies(modules, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getModules().size()) return new ModulesModuleManagerWrapper(this, originalIndex, (ViewRoot)this.getModules().get(index));
        index = index - this.getModules().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getModules().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getModules().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getModulesIterator = this.getModules().iterator();
        while(getModulesIterator.hasNext()){
            if(getModulesIterator.next().equals(child)) return result;
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
