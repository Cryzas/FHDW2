
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class StudentManager extends ViewObject implements StudentManagerView{
    
    protected java.util.Vector<StudentView> students;
    
    public StudentManager(java.util.Vector<StudentView> students,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.students = students;        
    }
    
    static public long getTypeId() {
        return 201;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<StudentView> getStudents()throws ModelException{
        return this.students;
    }
    public void setStudents(java.util.Vector<StudentView> newValue) throws ModelException {
        this.students = newValue;
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudentManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudentManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudentManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudentManager(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> students = this.getStudents();
        if (students != null) {
            ViewObject.resolveVectorProxies(students, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getStudents().size()) return new StudentsStudentManagerWrapper(this, originalIndex, (ViewRoot)this.getStudents().get(index));
        index = index - this.getStudents().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getStudents().size());
    }
    public boolean isLeaf() throws ModelException {
        return true 
            && (this.getStudents().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getStudentsIterator = this.getStudents().iterator();
        while(getStudentsIterator.hasNext()){
            if(getStudentsIterator.next().equals(child)) return result;
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
