package pacto;

public class BolsaDeTrocas {
    private int precoGrao = 2;
    public int getPrecoGrao() { return precoGrao; }
    public boolean comprarGraos(Assentamento a, int quantidade) {
        if (a == null || quantidade <= 0 || quantidade > Integer.MAX_VALUE / precoGrao) return false;
        int custo = quantidade * precoGrao;
        if (!a.pagar(custo)) return false;
        a.guardarGraos(quantidade); return true;
    }
    public boolean venderGraos(Assentamento a, int quantidade) {
        if (a == null || quantidade <= 0 || !a.gastarGraos(quantidade)) return false;
        a.receber(quantidade * Math.max(1, precoGrao - 1)); return true;
    }
    public void atualizarMercado(int variacao) { precoGrao = Math.max(1, Math.min(8, precoGrao + variacao)); }
}
