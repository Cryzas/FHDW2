package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitProxi extends ViewProxi implements UnitView{
    
    public UnitProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public UnitView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi gradeSystem = null;
        String gradeSystem$String = (String)resultTable.get("gradeSystem");
        if (gradeSystem$String != null) {
            common.ProxiInformation gradeSystem$Info = common.RPCConstantsAndServices.createProxiInformation(gradeSystem$String);
            gradeSystem = view.objects.ViewProxi.createProxi(gradeSystem$Info,connectionKey);
            gradeSystem.setToString(gradeSystem$Info.getToString());
        }
        UnitView result$$ = new Unit((String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem, this.getId(), this.getClassId());
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
    
    public String getName()throws ModelException{
        return ((Unit)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws ModelException {
        ((Unit)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((Unit)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws ModelException {
        ((Unit)this.getTheObject()).setCreditPoints(newValue);
    }
    public GradeSystemView getGradeSystem()throws ModelException{
        return ((Unit)this.getTheObject()).getGradeSystem();
    }
    public void setGradeSystem(GradeSystemView newValue) throws ModelException {
        ((Unit)this.getTheObject()).setGradeSystem(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnit(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnit(this);
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
