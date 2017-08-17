package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudyGroupProxi extends ViewProxi implements StudyGroupView{
    
    public StudyGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudyGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        ViewProxi program = null;
        String program$String = (String)resultTable.get("program");
        if (program$String != null) {
            common.ProxiInformation program$Info = common.RPCConstantsAndServices.createProxiInformation(program$String);
            program = view.objects.ViewProxi.createProxi(program$Info,connectionKey);
            program.setToString(program$Info.getToString());
        }
        java.util.Vector<String> students_string = (java.util.Vector<String>)resultTable.get("students");
        java.util.Vector<StudentView> students = ViewProxi.getProxiVector(students_string, connectionKey);
        StudyGroupView result$$ = new StudyGroup((String)name,(ProgramSGroupView)program,students, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
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
        if (this.object == null) return this.getLeafInfo() == 0;
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
    
    public String getName()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setName(newValue);
    }
    public ProgramSGroupView getProgram()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getProgram();
    }
    public void setProgram(ProgramSGroupView newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setProgram(newValue);
    }
    public java.util.Vector<StudentView> getStudents()throws ModelException{
        return ((StudyGroup)this.getTheObject()).getStudents();
    }
    public void setStudents(java.util.Vector<StudentView> newValue) throws ModelException {
        ((StudyGroup)this.getTheObject()).setStudents(newValue);
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
