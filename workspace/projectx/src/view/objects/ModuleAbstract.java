
package view.objects;

import view.*;


/* Additional import section end */

public abstract class ModuleAbstract extends ViewObject implements ModuleAbstractView{
    
    protected String name;
    protected common.Fraction creditPoints;
    protected GradeSystemView gradeSystem;
    
    public ModuleAbstract(String name,common.Fraction creditPoints,GradeSystemView gradeSystem,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.name = name;
        this.creditPoints = creditPoints;
        this.gradeSystem = gradeSystem;        
    }
    
    public String getName()throws ModelException{
        return this.name;
    }
    public void setName(String newValue) throws ModelException {
        this.name = newValue;
    }
    public common.Fraction getCreditPoints()throws ModelException{
        return this.creditPoints;
    }
    public GradeSystemView getGradeSystem()throws ModelException{
        return this.gradeSystem;
    }
    public void setGradeSystem(GradeSystemView newValue) throws ModelException {
        this.gradeSystem = newValue;
    }
    
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        GradeSystemView gradeSystem = this.getGradeSystem();
        if (gradeSystem != null) {
            ((ViewProxi)gradeSystem).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(gradeSystem.getClassId(), gradeSystem.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getNameIndex() throws ModelException {
        return 0;
    }
    public int getCreditPointsIndex() throws ModelException {
        return 0 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "name";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "creditPoints";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getName();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getCreditPoints();
                rowIndex = rowIndex - 1;
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        if(rowIndex == 0){
            this.setName(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        rowIndex = rowIndex - 1;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public javafx.scene.image.Image getImage() {
        return super.getImage();
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}
