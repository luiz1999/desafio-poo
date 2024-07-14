package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();


    public void inscreverBootcamp(Bootcamp bootcamp) {

    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.out.println("Você não esta matriculado em nenhum conteúdo");
        }
    }

    public void calcularTotalXp(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIncritos() {
        return conteudosInscritos;
    }

    public void setConteudosIncritos(Set<Conteudo> conteudosIncritos) {
        this.conteudosInscritos = conteudosIncritos;
    }

    public Set<Conteudo> getConteudoConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
        this.conteudosConcluidos = conteudoConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    public String getConteudosInscritos() {
    }

    public String getConteudosConcluidos() {
    }

    public void InscreverBootcamp(Bootcamp bootcamp) {
    }
}
