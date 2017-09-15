package view.objects;


/* Additional import section end */

public class StudentsStudyGroupWrapper extends AssociationInTreeWrapper {

	public StudentsStudyGroupWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    public boolean isLeaf() {
		return true;
	}

    /*Start of protected part that is not overridden by persistence generator*/
	public javafx.scene.image.Image getImage() {
		this.getWrappedObject().setIconInfo(6);
    	return this.getWrappedObject().getImage();
    }
	
	
	public String toString(){
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
