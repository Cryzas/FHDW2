package view;

import view.visitor.*;

public interface ModuleAtomarView extends ModuleAbstractView {
    
    public GradeSystemView getGradeSystem()throws ModelException;
    public void setGradeSystem(GradeSystemView newValue) throws ModelException ;
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

