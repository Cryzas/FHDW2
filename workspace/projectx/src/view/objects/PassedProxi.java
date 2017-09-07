package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class PassedProxi extends GradesInSimpleProxi implements PassedView{
    
    public PassedProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public PassedView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        PassedView result$$ = new Passed( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(GradesInSimpleVisitor visitor) throws ModelException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePassed(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePassed(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePassed(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePassed(this);
    }
    public void accept(GradeVisitor visitor) throws ModelException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePassed(this);
    }
    public <E extends view.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends view.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePassed(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handlePassed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handlePassed(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handlePassed(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
