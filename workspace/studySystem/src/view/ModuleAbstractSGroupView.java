package view;

import view.objects.*;

import view.visitor.*;

public interface ModuleAbstractSGroupView extends Anything, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public common.Fraction getCreditPoints()throws ModelException;
    public ModuleAbstractView getModuleCopy()throws ModelException;
    public void setModuleCopy(ModuleAbstractView newValue) throws ModelException ;
    public MyBooleanView getFinished()throws ModelException;
    public void setFinished(MyBooleanView newValue) throws ModelException ;
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

