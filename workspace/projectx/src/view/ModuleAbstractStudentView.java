package view;

import view.objects.*;

import view.visitor.*;

public interface ModuleAbstractStudentView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public common.Fraction getCreditPoints()throws ModelException;
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

