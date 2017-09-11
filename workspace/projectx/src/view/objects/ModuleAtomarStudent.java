
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ModuleAtomarStudent extends view.objects.ModuleAbstractStudent implements ModuleAtomarStudentView{
    
    protected GradesInSimpleOrThirdView ownGrade;
    protected java.util.Vector<GradeChangeView> changes;
    
    public ModuleAtomarStudent(ModuleAbstractSGroupView moduleCopy,String name,common.Fraction creditPoints,GradeView grade,common.Fraction CPmulGrade,common.Fraction CPwithGrade,GradesInSimpleOrThirdView ownGrade,java.util.Vector<GradeChangeView> changes,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((ModuleAbstractSGroupView)moduleCopy,(String)name,(common.Fraction)creditPoints,(GradeView)grade,(common.Fraction)CPmulGrade,(common.Fraction)CPwithGrade,id, classId);
        this.ownGrade = ownGrade;
        this.changes = changes;        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public GradesInSimpleOrThirdView getOwnGrade()throws ModelException{
        return this.ownGrade;
    }
    public void setOwnGrade(GradesInSimpleOrThirdView newValue) throws ModelException {
        this.ownGrade = newValue;
    }
    public java.util.Vector<GradeChangeView> getChanges()throws ModelException{
        return this.changes;
    }
    public void setChanges(java.util.Vector<GradeChangeView> newValue) throws ModelException {
        this.changes = newValue;
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws ModelException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ModuleAbstractSGroupView moduleCopy = this.getModuleCopy();
        if (moduleCopy != null) {
            ((ViewProxi)moduleCopy).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(moduleCopy.getClassId(), moduleCopy.getId())));
        }
        GradeView grade = this.getGrade();
        if (grade != null) {
            ((ViewProxi)grade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(grade.getClassId(), grade.getId())));
        }
        GradesInSimpleOrThirdView ownGrade = this.getOwnGrade();
        if (ownGrade != null) {
            ((ViewProxi)ownGrade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(ownGrade.getClassId(), ownGrade.getId())));
        }
        java.util.Vector<?> changes = this.getChanges();
        if (changes != null) {
            ViewObject.resolveVectorProxies(changes, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getChanges().size()) return new ChangesModuleAtomarStudentWrapper(this, originalIndex, (ViewRoot)this.getChanges().get(index));
        index = index - this.getChanges().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getChanges().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getChanges().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getChangesIterator = this.getChanges().iterator();
        while(getChangesIterator.hasNext()){
            if(getChangesIterator.next().equals(child)) return result;
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
