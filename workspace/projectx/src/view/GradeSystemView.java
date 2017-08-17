package view;

import view.objects.*;

import view.visitor.*;

public interface GradeSystemView extends Anything, AbstractViewRoot {
    
    
    public void accept(GradeSystemVisitor visitor) throws ModelException;
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

