package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class NoGradeThirdProxi extends GradesInThirdProxi implements NoGradeThirdView{
    
    public NoGradeThirdProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public NoGradeThirdView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        NoGradeThirdView result$$ = new NoGradeThird( this.getId(), this.getClassId());
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
    
    
    public void accept(GradesInThirdVisitor visitor) throws ModelException {
        visitor.handleNoGradeThird(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoGradeThird(this);
    }
    public <E extends view.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoGradeThird(this);
    }
    public <R, E extends view.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoGradeThird(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException {
        visitor.handleNoGradeThird(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoGradeThird(this);
    }
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoGradeThird(this);
    }
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoGradeThird(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleNoGradeThird(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleNoGradeThird(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleNoGradeThird(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleNoGradeThird(this);
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
