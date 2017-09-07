package view;

import view.objects.*;

import view.visitor.*;

public interface ModuleAbstractStudentView extends Anything, AbstractViewRoot {
    
    public ModuleAbstractSGroupView getModuleCopy()throws ModelException;
    public void setModuleCopy(ModuleAbstractSGroupView newValue) throws ModelException ;
    public String getName()throws ModelException;
    public common.Fraction getCreditPoints()throws ModelException;
    public GradeView getGrade()throws ModelException;
    public common.Fraction getCPmulGrade()throws ModelException;
    public common.Fraction getCPwithGrade()throws ModelException;
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

