package view.objects;


/* Additional import section end */

public class ChangesUnitStudentWrapper extends AssociationInTreeWrapper {

	public ChangesUnitStudentWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		this.getWrappedObject().setIconInfo(16);
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}