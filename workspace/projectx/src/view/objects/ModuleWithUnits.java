
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleWithUnits extends view.objects.ModuleAbstract implements ModuleWithUnitsView{
    
    protected java.util.Vector<UnitView> units;
    
    public ModuleWithUnits(String name,common.Fraction creditPoints,GradeSystemView gradeSystem,java.util.Vector<UnitView> units,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem,id, classId);
        this.units = units;        
    }
    
    static public long getTypeId() {
        return 154;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<UnitView> getUnits()throws ModelException{
        return this.units;
    }
    public void setUnits(java.util.Vector<UnitView> newValue) throws ModelException {
        this.units = newValue;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnits(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        GradeSystemView gradeSystem = this.getGradeSystem();
        if (gradeSystem != null) {
            ((ViewProxi)gradeSystem).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(gradeSystem.getClassId(), gradeSystem.getId())));
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
        if(index < this.getUnits().size()) return new UnitsModuleWithUnitsWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
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
        if(rowIndex == 0){
            this.setName(newValue);
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
