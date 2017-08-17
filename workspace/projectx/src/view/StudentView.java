package view;

import view.objects.*;

import view.visitor.*;

public interface StudentView extends Anything, AbstractViewRoot {
    
    public String getFirstName()throws ModelException;
    public void setFirstName(String newValue) throws ModelException ;
    public String getLastName()throws ModelException;
    public void setLastName(String newValue) throws ModelException ;
    public java.util.Date getBirthDate()throws ModelException;
    public void setBirthDate(java.util.Date newValue) throws ModelException ;
    public long getMatrNr()throws ModelException;
    public ProgramStudentView getProgram()throws ModelException;
    public void setProgram(ProgramStudentView newValue) throws ModelException ;
    public java.util.Vector<StudyGroupView> getParentGroup()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

