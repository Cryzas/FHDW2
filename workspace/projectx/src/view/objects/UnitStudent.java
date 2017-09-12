
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class UnitStudent extends ViewObject implements UnitStudentView{
    
    protected String name;
    protected common.Fraction creditPoints;
    protected GradesInThirdView grade;
    protected common.Fraction CPmulGrade;
    protected common.Fraction CPwithGrade;
    protected java.util.Vector<GradeChangeView> changes;
    protected MyBooleanView finished;
    
    public UnitStudent(String name,common.Fraction creditPoints,GradesInThirdView grade,common.Fraction CPmulGrade,common.Fraction CPwithGrade,java.util.Vector<GradeChangeView> changes,MyBooleanView finished,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.creditPoints = creditPoints;
        this.grade = grade;
        this.CPmulGrade = CPmulGrade;
        this.CPwithGrade = CPwithGrade;
        this.changes = changes;
        this.finished = finished;        
    }
    
    static public long getTypeId() {
        return 197;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return this.creditPoints;
    }
    public GradesInThirdView getGrade()throws ModelException{
        return this.grade;
    }
    public void setGrade(GradesInThirdView newValue) throws ModelException {
        this.grade = newValue;
    }
    public common.Fraction getCPmulGrade()throws ModelException{
        return this.CPmulGrade;
    }
    public common.Fraction getCPwithGrade()throws ModelException{
        return this.CPwithGrade;
    }
    public java.util.Vector<GradeChangeView> getChanges()throws ModelException{
        return this.changes;
    }
    public void setChanges(java.util.Vector<GradeChangeView> newValue) throws ModelException {
        this.changes = newValue;
    }
    public MyBooleanView getFinished()throws ModelException{
        return this.finished;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws ModelException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitStudent(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        GradesInThirdView grade = this.getGrade();
        if (grade != null) {
            ((ViewProxi)grade).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(grade.getClassId(), grade.getId())));
        }
        java.util.Vector<?> changes = this.getChanges();
        if (changes != null) {
            ViewObject.resolveVectorProxies(changes, resultTable);
        }
        MyBooleanView finished = this.getFinished();
        if (finished != null) {
            ((ViewProxi)finished).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(finished.getClassId(), finished.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getChanges().size()) return new ChangesUnitStudentWrapper(this, originalIndex, (ViewRoot)this.getChanges().get(index));
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
