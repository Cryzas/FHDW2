package view;

import view.objects.*;

import view.visitor.*;

public interface ProgramStudentView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<ModuleAbstractStudentView> getModules()throws ModelException;
    public void setModules(java.util.Vector<ModuleAbstractStudentView> newValue) throws ModelException ;
    public String getName()throws ModelException;
    public common.Fraction getCreditPoints()throws ModelException;
    public ProgramSGroupView getProgramCopy()throws ModelException;
    public void setProgramCopy(ProgramSGroupView newValue) throws ModelException ;
    public GradeView getGrade()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

