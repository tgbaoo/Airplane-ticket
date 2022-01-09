// package ThiHK1;
public abstract class Person {
    protected String IdentyCard;
    protected String Name;
    public Person() {
    	
    }
    public abstract void input();
	public abstract void output();
	public abstract void ShowInfo();
	public Person(String identyCard , String Name) {
		this.IdentyCard = identyCard;
		this.Name = Name;
	}

	public String getIdentyCard() {
		return IdentyCard;
	}

	public void setIdentyCard(String identyCard) {
		this.IdentyCard = identyCard;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
  
}
