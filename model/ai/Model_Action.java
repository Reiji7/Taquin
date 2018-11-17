package model.ai;

public class Model_Action {
	private String name;
	
	/*
	 * constructor of Model_Action
	 */
	public void Action(String action) {
		this.name = action;
	}
	
	/*
	 * getters and setters of Model_Action
	 */
	public String getAction() {
		return this.name;
	}
	public void setAction(String action) {
		this.name = action;
	}
	
	/*
	 * methods for Model_Action
	 */
    public void print(){
	System.out.println(name);
    }
}
