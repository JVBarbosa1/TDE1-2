package service;

import model.Pedido;
import java.util.*;

public class Service {

    private final Set<String> sabores = new HashSet<>();
    private final List<Pedido> pedidosAbertos = new ArrayList<>();
    private final Queue<Pedido> filaEntregas = new LinkedList<>();
    private final Stack<Pedido> historicoCancelados = new Stack<>();
    private final Map<String, Integer> vendasPorSabor = new HashMap<>();
    private int contadorPedidos = 1;

    public boolean adicionarSabor(String sabor) {
        if (sabor == null) return false;
        return sabores.add(sabor.trim());
    }

    public boolean removerSabor(String sabor) {
        if (sabor == null) return false;
        return sabores.remove(sabor.trim());
    }

    public boolean existeSabor(String sabor) {
        if (sabor == null) return false;
        return sabores.contains(sabor.trim());
    }

    public List<String> listarSabores() {
        List<String> lista = new ArrayList<>(sabores);
        Collections.sort(lista);
        return lista;
    }

    public Pedido criarPedido(String cliente, String sabor, char tamanho, double valor) {
        int numero = contadorPedidos++;
        Pedido p = new Pedido(numero, cliente, sabor, tamanho, valor);
        pedidosAbertos.add(p);
        filaEntregas.add(p);
        return p;
    }

    public List<Pedido> listarPedidosAbertos() {
        return new ArrayList<>(pedidosAbertos);
    }

    public Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido p : pedidosAbertos) {
            if (p.getNumero() == numero) return p;
        }
        return null;
    }

    public void ordenarPedidosPorValor() {
        pedidosAbertos.sort(Comparator.comparingDouble(Pedido::getValue));
    }

    public void ordenarPedidosPorCliente() {
        pedidosAbertos.sort(Comparator.comparing(Pedido::getCliente));
    }

    public Pedido entregarProximo() {
        Pedido p = filaEntregas.poll();
        if (p != null) registrarVendaAoEntregar(p);
        return p;
    }

    public Pedido verProximoSemRemover() {
        return filaEntregas.peek();
    }

    public boolean filaVazia() {
        return filaEntregas.isEmpty();
    }

    public void cancelarPedido(int numero) {
        Pedido p = buscarPedidoPorNumero(numero);
        if (p == null) return;
        pedidosAbertos.remove(p);
        filaEntregas.remove(p);
        historicoCancelados.push(p);
    }

    public Pedido recuperarUltimoCancelado() {
        if (historicoCancelados.isEmpty()) return null;
        return historicoCancelados.pop();
    }

    private void registrarVendaAoEntregar(Pedido p) {
        pedidosAbertos.remove(p);
        vendasPorSabor.put(p.getSabor(), vendasPorSabor.getOrDefault(p.getSabor(), 0) + 1);
    }

    public List<Map.Entry<String, Integer>> rankingSabores() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(vendasPorSabor.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return list;
    }
}
