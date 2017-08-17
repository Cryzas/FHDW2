package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentManagerProxi extends ViewProxi implements StudentManagerView{
    
    public StudentManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> students_string = (java.util.Vector<String>)resultTable.get("students");
        java.util.Vector<StudentView> students = ViewProxi.getProxiVector(students_string, connectionKey);
        StudentManagerView result$$ = new StudentManager(students, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public java.util.Vector<StudentView> getStudents()throws ModelException{
        return ((StudentManager)this.getTheObject()).getStudents();
    }
    public void setStudents(java.util.Vector<StudentView> newValue) throws ModelException {
        ((StudentManager)this.getTheObject()).setStudents(newValue);
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
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
