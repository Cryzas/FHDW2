package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TenthGradeProxi extends GradeSystemProxi implements TenthGradeView{
    
    public TenthGradeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TenthGradeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        TenthGradeView result$$ = new TenthGrade( this.getId(), this.getClassId());
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
    
    
    public void accept(GradeSystemVisitor visitor) throws ModelException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends view.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends view.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTenthGrade(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTenthGrade(this);
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
