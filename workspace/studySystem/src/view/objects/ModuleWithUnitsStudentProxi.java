package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ModuleWithUnitsStudentProxi extends ModuleAbstractStudentProxi implements ModuleWithUnitsStudentView{
    
    public ModuleWithUnitsStudentProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ModuleWithUnitsStudentView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi moduleCopy = null;
        String moduleCopy$String = (String)resultTable.get("moduleCopy");
        if (moduleCopy$String != null) {
            common.ProxiInformation moduleCopy$Info = common.RPCConstantsAndServices.createProxiInformation(moduleCopy$String);
            moduleCopy = view.objects.ViewProxi.createProxi(moduleCopy$Info,connectionKey);
            moduleCopy.setToString(moduleCopy$Info.getToString());
        }
        String name = (String)resultTable.get("name");
        common.Fraction creditPoints = common.Fraction.parse((String)resultTable.get("creditPoints"));
        ViewProxi grade = null;
        String grade$String = (String)resultTable.get("grade");
        if (grade$String != null) {
            common.ProxiInformation grade$Info = common.RPCConstantsAndServices.createProxiInformation(grade$String);
            grade = view.objects.ViewProxi.createProxi(grade$Info,connectionKey);
            grade.setToString(grade$Info.getToString());
        }
        common.Fraction CPmulGrade = common.Fraction.parse((String)resultTable.get("CPmulGrade"));
        common.Fraction CPwithGrade = common.Fraction.parse((String)resultTable.get("CPwithGrade"));
        common.Fraction passedCP = common.Fraction.parse((String)resultTable.get("passedCP"));
        ViewProxi finished = null;
        String finished$String = (String)resultTable.get("finished");
        if (finished$String != null) {
            common.ProxiInformation finished$Info = common.RPCConstantsAndServices.createProxiInformation(finished$String);
            finished = view.objects.ViewProxi.createProxi(finished$Info,connectionKey);
            finished.setToString(finished$Info.getToString());
        }
        java.util.Vector<String> units_string = (java.util.Vector<String>)resultTable.get("units");
        java.util.Vector<UnitStudentView> units = ViewProxi.getProxiVector(units_string, connectionKey);
        ModuleWithUnitsStudentView result$$ = new ModuleWithUnitsStudent((ModuleAbstractSGroupView)moduleCopy,(String)name,(common.Fraction)creditPoints,(GradeView)grade,(common.Fraction)CPmulGrade,(common.Fraction)CPwithGrade,(common.Fraction)passedCP,(MyBooleanView)finished,units, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getUnits().size()) return new UnitsModuleWithUnitsStudentWrapper(this, originalIndex, (ViewRoot)this.getUnits().get(index));
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
    
    public java.util.Vector<UnitStudentView> getUnits()throws ModelException{
        return ((ModuleWithUnitsStudent)this.getTheObject()).getUnits();
    }
    public void setUnits(java.util.Vector<UnitStudentView> newValue) throws ModelException {
        ((ModuleWithUnitsStudent)this.getTheObject()).setUnits(newValue);
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleModuleWithUnitsStudent(this);
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
