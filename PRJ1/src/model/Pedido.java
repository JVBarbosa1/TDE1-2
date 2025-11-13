package model;

public class Pedido {
 private int num;
 private String cliente;
 private String sabor;
 private char tam;
 private double val;

 public Pedido(int num, String cliente, String sabor, char tam, double val) {
	 this.num = num;
	 this.cliente = cliente;
	 this.sabor = sabor;
	 this.tam = Character.toUpperCase(tam);
	 this.val = val;
 }
 
 public int getNumero() {return num ;} 
 public String getCliente() {return cliente;}
 public String getSabor() {return sabor;}
 public char getTam() {return tam;}
 public double getValue() {return val;}
 
 @Override
 public String toString() {
	 return String.format("Pedido #%d - Client: %s - Sabor: %s - Tamanho:%c - Valor: R$%2.f", num, cliente, sabor, tam, val);
	 
 }
 
}
