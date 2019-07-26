package Secao_12_Trabalhando_com_Arquivos;

public class Aula163_Entities_ExercicioFixacao {

	private String product;
	private double price;
	private int quantity;

	public Aula163_Entities_ExercicioFixacao() {

	}

	public Aula163_Entities_ExercicioFixacao(String product, double price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;

	}

	public String getProdut() {
		return product;
	}

	public void setProdut(String produt) {
		this.product = produt;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double total() {
		return price * quantity;

	}
	
	public String toString() {
		return "Name: "
				+getProdut()
				+" Valor: "
				+getPrice()
				+" Qde: "
				+getQuantity();
		
	}
}