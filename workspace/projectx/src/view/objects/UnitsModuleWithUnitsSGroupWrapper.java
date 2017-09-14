package view.objects;


/* Additional import section end */

public class UnitsModuleWithUnitsSGroupWrapper extends AssociationInTreeWrapper {

	public UnitsModuleWithUnitsSGroupWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		this.getWrappedObject().setIconInfo(15);
    	 return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
