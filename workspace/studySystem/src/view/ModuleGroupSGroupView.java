package view;

import view.visitor.*;

public interface ModuleGroupSGroupView extends ModuleAbstractSGroupView {
    
    public java.util.Vector<ModuleAbstractSGroupView> getModules()throws ModelException;
    public void setModules(java.util.Vector<ModuleAbstractSGroupView> newValue) throws ModelException ;
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

