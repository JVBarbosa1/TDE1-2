package tde.controle;

import tde.dominio.VendaProduto;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ControleVendaTDE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.00");

        // Array para armazenar 5 vendas
        VendaProduto[] vendas = new VendaProduto[5];

        // Entrada dos dados das vendas
        for (int count = 0; count < vendas.length; count++) {
            System.out.println("\n--- Cadastro da venda " + (count + 1) + " ---");

            System.out.print("Digite o número da venda: ");
            int num = scanner.nextInt();

            System.out.print("Digite a quantidade de produtos: ");
            int qtd = scanner.nextInt();

            System.out.print("Digite o valor unitário do produto: ");
            double vlUnit = scanner.nextDouble();

            // Cria a venda e armazena no array
            vendas[count] = new VendaProduto(num, qtd, vlUnit);
        }

        // Listagem das vendas cadastradas
        System.out.println("\n===== LISTA DE VENDAS =====");
        for (int count = 0; count < vendas.length; count++) {
            VendaProduto venda = vendas[count];
            System.out.println("Venda " + (count + 1) + ":");
            System.out.println("Número da venda : " + venda.getNumero());
            System.out.println("Quantidade : " + venda.getQuantidade());
            System.out.println("Valor unitário : R$ " + formato.format(venda.getValorUnitario()));
            System.out.println("Valor total : R$ " + formato.format(venda.valorPagar()));
            System.out.println("------------------------------");
        }

        scanner.close();
    }
}
