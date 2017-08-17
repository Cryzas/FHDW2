package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class StudentProxi extends ViewProxi implements StudentView{
    
    public StudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public StudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String firstName = (String)resultTable.get("firstName");
        String lastName = (String)resultTable.get("lastName");
        java.util.Date birthDate = (java.util.Date)resultTable.get("birthDate");
        long matrNr = new Long((String)resultTable.get("matrNr")).longValue();
        ViewProxi program = null;
        String program$String = (String)resultTable.get("program");
        if (program$String != null) {
            common.ProxiInformation program$Info = common.RPCConstantsAndServices.createProxiInformation(program$String);
            program = view.objects.ViewProxi.createProxi(program$Info,connectionKey);
            program.setToString(program$Info.getToString());
        }
        java.util.Vector<String> parentGroup_string = (java.util.Vector<String>)resultTable.get("parentGroup");
        java.util.Vector<StudyGroupView> parentGroup = ViewProxi.getProxiVector(parentGroup_string, connectionKey);
        StudentView result$$ = new Student((String)firstName,(String)lastName,(java.util.Date)birthDate,(long)matrNr,(ProgramStudentView)program,parentGroup, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getProgram() != null) return new ProgramStudentWrapper(this, originalIndex, (ViewRoot)this.getProgram());
        if(this.getProgram() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getProgram() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getProgram() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getProgram() != null && this.getProgram().equals(child)) return result;
        if(this.getProgram() != null) result = result + 1;
        return -1;
    }
    
    public String getFirstName()throws ModelException{
        return ((Student)this.getTheObject()).getFirstName();
    }
    public void setFirstName(String newValue) throws ModelException {
        ((Student)this.getTheObject()).setFirstName(newValue);
    }
    public String getLastName()throws ModelException{
        return ((Student)this.getTheObject()).getLastName();
    }
    public void setLastName(String newValue) throws ModelException {
        ((Student)this.getTheObject()).setLastName(newValue);
    }
    public java.util.Date getBirthDate()throws ModelException{
        return ((Student)this.getTheObject()).getBirthDate();
    }
    public void setBirthDate(java.util.Date newValue) throws ModelException {
        ((Student)this.getTheObject()).setBirthDate(newValue);
    }
    public long getMatrNr()throws ModelException{
        return ((Student)this.getTheObject()).getMatrNr();
    }
    public ProgramStudentView getProgram()throws ModelException{
        return ((Student)this.getTheObject()).getProgram();
    }
    public void setProgram(ProgramStudentView newValue) throws ModelException {
        ((Student)this.getTheObject()).setProgram(newValue);
    }
    public java.util.Vector<StudyGroupView> getParentGroup()throws ModelException{
        return ((Student)this.getTheObject()).getParentGroup();
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleStudent(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
