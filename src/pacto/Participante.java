package pacto;

public class Participante {
    private final String nome;
    private String patente = "Regente";
    private int pontosDeInfluencia;

    public Participante(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Informe um nome.");
        this.nome = nome.trim();
    }
    public String getNome() { return nome; }
    public String getPatente() { return patente; }
    public int getPontosDeInfluencia() { return pontosDeInfluencia; }
    public void somarInfluencia(int pontos) { if (pontos > 0) pontosDeInfluencia += pontos; }
    public boolean promover() {
        String[] niveis = {"Regente", "Conselheiro", "Lorde", "Duque", "Soberano"};
        for (int i = 0; i < niveis.length - 1; i++) {
            if (patente.equals(niveis[i]) && pontosDeInfluencia >= (i + 1) * 250) {
                patente = niveis[i + 1]; return true;
            }
        }
        return false;
    }
    public int getNivel() {
        return switch (patente) { case "Conselheiro" -> 1; case "Lorde" -> 2; case "Duque" -> 3; case "Soberano" -> 4; default -> 0; };
    }
}
