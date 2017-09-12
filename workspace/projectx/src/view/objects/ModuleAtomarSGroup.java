
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleAtomarSGroup extends view.objects.ModuleAbstractSGroup implements ModuleAtomarSGroupView{
    
    protected GradeSystemView gradeSystem;
    
    public ModuleAtomarSGroup(String name,common.Fraction creditPoints,ModuleAbstractView moduleCopy,MyBooleanView finished,GradeSystemView gradeSystem,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((String)name,(common.Fraction)creditPoints,(ModuleAbstractView)moduleCopy,(MyBooleanView)finished,id, classId);
        this.gradeSystem = gradeSystem;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public GradeSystemView getGradeSystem()throws ModelException{
        return this.gradeSystem;
    }
    public void setGradeSystem(GradeSystemView newValue) throws ModelException {
        this.gradeSystem = newValue;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarSGroup(this);
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
        GradeSystemView gradeSystem = this.getGradeSystem();
        if (gradeSystem != null) {
            ((ViewProxi)gradeSystem).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(gradeSystem.getClassId(), gradeSystem.getId())));
        }
        
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
