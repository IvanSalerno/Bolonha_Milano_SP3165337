package pacto;

import java.util.*;

public class Temporada {
    private final List<Assentamento> participantes = new ArrayList<>();
    private int vez;
    public boolean inscrever(Assentamento a) { if (a == null || participantes.size() == 4) return false; participantes.add(a); return true; }
    public List<Assentamento> getParticipantes() { return Collections.unmodifiableList(participantes); }
    public Assentamento getAssentamentoDaVez() { return participantes.isEmpty() ? null : participantes.get(vez); }
    public boolean avancarVez() { if (participantes.isEmpty()) return false; vez++; if (vez == participantes.size()) { vez = 0; return true; } return false; }
    public void fecharAno() { for (Assentamento a : participantes) { a.iniciarNovoAno(); a.getResponsavel().promover(); } }
    public Assentamento apontarVencedor() {
        return participantes.stream().max(Comparator.comparingInt((Assentamento a) -> a.getResponsavel().getNivel())
                .thenComparingInt(a -> a.getResponsavel().getPontosDeInfluencia() + a.getEdificios() * 20 + a.getGuardas() * 2)).orElse(null);
    }
    public boolean encerrada() { return participantes.stream().anyMatch(a -> a.getResponsavel().getNivel() == 4) || (!participantes.isEmpty() && participantes.get(0).getAno() > 1420); }
}
