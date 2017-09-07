package view;

import view.objects.*;

import view.visitor.*;

public interface GradeView extends Anything, AbstractViewRoot {
    
    
    public void accept(GradeVisitor visitor) throws ModelException;
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

