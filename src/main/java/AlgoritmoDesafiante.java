
import java.util.List;

import xadrez.Xadrez;
import xadrez.alg.AlgoritmoXadrez;
import xadrez.pecas.Peca;

public class AlgoritmoDesafiante implements AlgoritmoXadrez {

    @Override
    public String procurarMelhorMovimento(Xadrez xadrez) {
        List<Peca> pecasDoTurno = xadrez.recuperarPecasDoTurno();

        String movimentoValido = null;
        while (movimentoValido == null) {
            int numeroAleatorio = (int) (Math.random() * pecasDoTurno.size());
            Peca peca = pecasDoTurno.get(numeroAleatorio);
            List<String> movimentosValidos = peca.getMovimentosValidos(xadrez);
            if (movimentosValidos.size() > 0) {
                numeroAleatorio = (int) (Math.random() * movimentosValidos.size());
                movimentoValido = movimentosValidos.get(numeroAleatorio);
            }
        }

        return movimentoValido;
    }

}
