package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        // analizarCandidato(1900.0);
        // analizarCandidato(2500.0);
        // analizarCandidato(2000.0);

        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto" };

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

        // selecaoCandidatos();
        // imprimirSelecionados();

    }

    static void entrandoEmContato(String candidato) {
        int tentativaRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando) {
                tentativaRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }

        } while (continuaTentando && tentativaRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativaRealizadas + " tentativa");
        } else {
            System.out.println(
                    "Nao conseguimos contato com " + candidato + "numero maximo de tentativas " + tentativaRealizadas);
        }

    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto" };
        System.out.println("Imprimindo a lista de aprovados com indice");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de numero: " + (indice + 1) + " é " + candidatos[indice]);
        }

    }

    static void selecaoCandidatos() {
        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela",
                "Jorge" };
        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        double salarioPretendido = valorPrentendido();

        while (candidatoSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];

            System.out.println("O candidato " + candidato + " solicitou este valor de salario: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + "foi selecionado para a vaga");
                candidatoSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPrentendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candito com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }

    }

}
