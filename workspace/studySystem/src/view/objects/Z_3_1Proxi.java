package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class Z_3_1Proxi extends GradesInTenthProxi implements Z_3_1View{
    
    public Z_3_1Proxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public Z_3_1View getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        Z_3_1View result$$ = new Z_3_1( this.getId(), this.getClassId());
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
    
    
    public void accept(GradesInTenthVisitor visitor) throws ModelException {
        visitor.handleZ_3_1(this);
    }
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleZ_3_1(this);
    }
    public <E extends view.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleZ_3_1(this);
    }
    public <R, E extends view.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleZ_3_1(this);
    }
    public void accept(GradeVisitor visitor) throws ModelException {
        visitor.handleZ_3_1(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleZ_3_1(this);
    }
    public <E extends view.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleZ_3_1(this);
    }
    public <R, E extends view.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleZ_3_1(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleZ_3_1(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleZ_3_1(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleZ_3_1(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleZ_3_1(this);
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
