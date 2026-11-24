package pacto;

public class Conselho {
    public int recolherTributo(Assentamento a) {
        if (a == null || a.isTributoRecolhido()) return -1;
        int receita = a.getHabitantes() * a.getImposto() / 10;
        a.receber(receita); a.marcarTributo();
        a.getResponsavel().somarInfluencia(receita / 10);
        return receita;
    }
    public boolean alterarTaxa(Assentamento a, int taxa) {
        if (a == null || taxa < 0 || taxa > 30) return false;
        a.definirImposto(taxa); return a.getImposto() == taxa;
    }
}
