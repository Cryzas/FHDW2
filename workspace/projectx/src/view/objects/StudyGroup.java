
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudyGroup extends ViewObject implements StudyGroupView{
    
    protected String name;
    protected ProgramSGroupView program;
    protected java.util.Vector<StudentView> students;
    protected MyBooleanView finished;
    
    public StudyGroup(String name,ProgramSGroupView program,java.util.Vector<StudentView> students,MyBooleanView finished,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.program = program;
        this.students = students;
        this.finished = finished;        
    }
    
    static public long getTypeId() {
        return 180;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public ProgramSGroupView getProgram()throws ModelException{
        return this.program;
    }
    public void setProgram(ProgramSGroupView newValue) throws ModelException {
        this.program = newValue;
    }
    public java.util.Vector<StudentView> getStudents()throws ModelException{
        return this.students;
    }
    public void setStudents(java.util.Vector<StudentView> newValue) throws ModelException {
        this.students = newValue;
    }
    public MyBooleanView getFinished()throws ModelException{
        return this.finished;
    }
    public void setFinished(MyBooleanView newValue) throws ModelException {
        this.finished = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudyGroup(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        ProgramSGroupView program = this.getProgram();
        if (program != null) {
            ((ViewProxi)program).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(program.getClassId(), program.getId())));
        }
        java.util.Vector<?> students = this.getStudents();
        if (students != null) {
            ViewObject.resolveVectorProxies(students, resultTable);
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
        if(index == 0 && this.getProgram() != null) return new ProgramStudyGroupWrapper(this, originalIndex, (ViewRoot)this.getProgram());
        if(this.getProgram() != null) index = index - 1;
        if(index < this.getStudents().size()) return new StudentsStudyGroupWrapper(this, originalIndex, (ViewRoot)this.getStudents().get(index));
        index = index - this.getStudents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgram() == null ? 0 : 1)
            + (this.getStudents().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getProgram() == null ? true : false)
            && (this.getStudents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgram() != null && this.getProgram().equals(child)) return result;
        if(this.getProgram() != null) result = result + 1;
        java.util.Iterator<?> getStudentsIterator = this.getStudents().iterator();
        while(getStudentsIterator.hasNext()){
            if(getStudentsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getRowCount(){
        return 0 
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
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
