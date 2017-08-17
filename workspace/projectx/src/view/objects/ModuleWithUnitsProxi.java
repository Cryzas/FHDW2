package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleWithUnitsProxi extends ModuleAbstractProxi implements ModuleWithUnitsView{
    
    public ModuleWithUnitsProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleWithUnitsView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi gradeSystem = null;
        String gradeSystem$String = (String)resultTable.get("gradeSystem");
        if (gradeSystem$String != null) {
            common.ProxiInformation gradeSystem$Info = common.RPCConstantsAndServices.createProxiInformation(gradeSystem$String);
            gradeSystem = view.objects.ViewProxi.createProxi(gradeSystem$Info,connectionKey);
            gradeSystem.setToString(gradeSystem$Info.getToString());
        }
        java.util.Vector<String> units_string = (java.util.Vector<String>)resultTable.get("units");
        java.util.Vector<UnitView> units = ViewProxi.getProxiVector(units_string, connectionKey);
        ModuleWithUnitsView result$$ = new ModuleWithUnits((String)name,(common.Fraction)creditPoints,(GradeSystemView)gradeSystem,units, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getUnits().size()) return new UnitsModuleWithUnitsWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
        index = index - this.getUnits().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getUnits().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getUnits().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getUnitsIterator = this.getUnits().iterator();
        while(getUnitsIterator.hasNext()){
            if(getUnitsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<UnitView> getUnits()throws ModelException{
        return ((ModuleWithUnits)this.getTheObject()).getUnits();
    }
    public void setUnits(java.util.Vector<UnitView> newValue) throws ModelException {
        ((ModuleWithUnits)this.getTheObject()).setUnits(newValue);
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnits(this);
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
