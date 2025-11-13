package app;

import model.Pedido;
import service.Service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Service serv = new Service();
        Scanner sc = new Scanner(System.in, "UTF-8");

        serv.adicionarSabor("Calabresa");
        serv.adicionarSabor("Peperonni");
        serv.adicionarSabor("Frango com Catupiry");

        boolean rodando = true;
        while (rodando) {
            System.out.println("1) Listar sabores");
            System.out.println("2) Adicionar sabor");
            System.out.println("3) Remover sabor");
            System.out.println("4) Criar pedido");
            System.out.println("5) Listar pedidos abertos");
            System.out.println("6) Entregar próximo");
            System.out.println("7) Ver próximo (peek)");
            System.out.println("8) Cancelar pedido");
            System.out.println("9) Recuperar último cancelado");
            System.out.println("10) Ranking sabores");
            System.out.println("11) Sair");
            System.out.print("Escolha: ");

            String op = sc.nextLine().trim();
            try {
                switch (op) {
                    case "1":
                        for (String s : serv.listarSabores()) System.out.println(" - " + s);
                        break;
                    case "2":
                        System.out.print("Novo sabor: ");
                        if (!serv.adicionarSabor(sc.nextLine()))
                            System.out.println("Já existe.");
                        break;
                    case "3":
                        System.out.print("Remover sabor: ");
                        serv.removerSabor(sc.nextLine());
                        break;
                    case "4":
                        System.out.print("Cliente: ");
                        String cliente = sc.nextLine();
                        System.out.print("Sabor: ");
                        String sabor = sc.nextLine();
                        if (!serv.existeSabor(sabor)) {
                            System.out.println("Sabor não existe.");
                            break;
                        }
                        System.out.print("Tamanho (P/M/G): ");
                        char tam = sc.nextLine().toUpperCase().charAt(0);
                        System.out.print("Valor: R$");
                        double valor = Double.parseDouble(sc.nextLine().replace(',', '.'));
                        Pedido p = serv.criarPedido(cliente, sabor, tam, valor);
                        System.out.println("Criado: " + p);
                        break;
                    case "5":
                        for (Pedido pd : serv.listarPedidosAbertos()) System.out.println(pd);
                        break;
                    case "6":
                        Pedido ent = serv.entregarProximo();
                        System.out.println(ent == null ? "Nada a entregar." : "Entregue: " + ent);
                        break;
                    case "7":
                        Pedido prox = serv.verProximoSemRemover();
                        System.out.println(prox == null ? "Fila vazia." : prox);
                        break;
                    case "8":
                        System.out.print("Número do pedido: ");
                        serv.cancelarPedido(Integer.parseInt(sc.nextLine()));
                        break;
                    case "9":
                        Pedido rec = serv.recuperarUltimoCancelado();
                        System.out.println(rec == null ? "Nenhum cancelado." : "Recuperado: " + rec);
                        break;
                    case "10":
                        for (var e : serv.rankingSabores())
                            System.out.println(e.getKey() + ": " + e.getValue());
                        break;
                    case "11":
                        rodando = false;
                        break;
                    default:
                        System.out.println("Inválido.");
                }
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
        sc.close();
        System.out.println("Saindo...");
    }
}
