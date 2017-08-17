package view;

import view.objects.*;

import view.visitor.*;

public interface StudyGroupView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public ProgramSGroupView getProgram()throws ModelException;
    public void setProgram(ProgramSGroupView newValue) throws ModelException ;
    public java.util.Vector<StudentView> getStudents()throws ModelException;
    public void setStudents(java.util.Vector<StudentView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

