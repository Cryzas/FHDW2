package view;

import view.objects.*;

import view.visitor.*;

public interface ModuleAbstractView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public void setName(String newValue) throws ModelException ;
    public common.Fraction getCreditPoints()throws ModelException;
    public GradeSystemView getGradeSystem()throws ModelException;
    public void setGradeSystem(GradeSystemView newValue) throws ModelException ;
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

