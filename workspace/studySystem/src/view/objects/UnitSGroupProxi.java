package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class UnitSGroupProxi extends ViewProxi implements UnitSGroupView{
    
    public UnitSGroupProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public UnitSGroupView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi finished = null;
        String finished$String = (String)resultTable.get("finished");
        if (finished$String != null) {
            common.ProxiInformation finished$Info = common.RPCConstantsAndServices.createProxiInformation(finished$String);
            finished = view.objects.ViewProxi.createProxi(finished$Info,connectionKey);
            finished.setToString(finished$Info.getToString());
        }
        UnitSGroupView result$$ = new UnitSGroup((String)name,(common.Fraction)creditPoints,(MyBooleanView)finished, this.getId(), this.getClassId());
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
        return ((UnitSGroup)this.getTheObject()).getName();
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return ((UnitSGroup)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws ModelException {
        ((UnitSGroup)this.getTheObject()).setCreditPoints(newValue);
    }
    public MyBooleanView getFinished()throws ModelException{
        return ((UnitSGroup)this.getTheObject()).getFinished();
    }
    public void setFinished(MyBooleanView newValue) throws ModelException {
        ((UnitSGroup)this.getTheObject()).setFinished(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleUnitSGroup(this);
    }
    
    public boolean hasTransientFields(){
        return true;
    }
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
