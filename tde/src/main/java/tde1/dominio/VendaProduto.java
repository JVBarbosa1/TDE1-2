package tde.dominio;

public class VendaProduto{ 
   private int num;
   private int qtd;
   private double vlUnit;

   // Construtor para inicializar os atributos
   public VendaProduto(int num, int qtd, double vlUnit) { 
       this.num = num;
       this.qtd = qtd;
       this.vlUnit = vlUnit;
   }

   // Getters e setters
   public int getNumero() {
       return num;
   }

   public void setNumero(int num) {
       this.num = num;
   }

   public int getQuantidade() {
       return qtd;
   }

   public void setQuantidade(int qtd) {
       this.qtd = qtd;
   }

   public double getValorUnitario() {
       return vlUnit;
   }

   public void setValorUnitario(double vlUnit) {
       this.vlUnit = vlUnit;
   }

   // Método para calcular o valor total a pagar
   public double valorPagar() {
       return qtd * vlUnit;
   }
}
