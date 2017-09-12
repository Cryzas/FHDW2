
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsSGroup extends view.objects.ModuleAbstractSGroup implements ModuleWithUnitsSGroupView{
    
    protected java.util.Vector<UnitSGroupView> units;
    
    public ModuleWithUnitsSGroup(String name,common.Fraction creditPoints,ModuleAbstractView moduleCopy,MyBooleanView finished,java.util.Vector<UnitSGroupView> units,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)creditPoints,(ModuleAbstractView)moduleCopy,(MyBooleanView)finished,id, classId);
        this.units = units;        
    }
    
    static public long getTypeId() {
        return 182;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<UnitSGroupView> getUnits()throws ModelException{
        return this.units;
    }
    public void setUnits(java.util.Vector<UnitSGroupView> newValue) throws ModelException {
        this.units = newValue;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ModuleAbstractView moduleCopy = this.getModuleCopy();
        if (moduleCopy != null) {
            ((ViewProxi)moduleCopy).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleCopy.getClassId(), moduleCopy.getId())));
        }
        MyBooleanView finished = this.getFinished();
        if (finished != null) {
            ((ViewProxi)finished).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(finished.getClassId(), finished.getId())));
        }
        java.util.Vector<?> units = this.getUnits();
        if (units != null) {
            ViewObject.resolveVectorProxies(units, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getUnits().size()) return new UnitsModuleWithUnitsSGroupWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
        index = index - this.getUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitsIterator = this.getUnits().iterator();
        while(getUnitsIterator.hasNext()){
            if(getUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getCreditPointsIndex() throws ModelException {
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
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "creditPoints";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getCreditPoints();
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
