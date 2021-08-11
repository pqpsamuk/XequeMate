import java.util.ArrayList;
import java.util.List;

import xadrez.Xadrez;
import xadrez.Xadrez.Situacao;
import xadrez.pecas.Peca;

public class TestUtil {
    public static List<String> procurarMovimentosXequeMateEmUmLance(Xadrez xadrez) {
     List<Peca> PecasDisponiveis = xadrez.recuperarPecasDoTurno();
     ArrayList<String> MovimentosMate = new ArrayList();

     for(Peca a:PecasDisponiveis) {

      List<String> MovimentosDisponiveis = a.getMovimentosValidos(xadrez);

      for(String b:MovimentosDisponiveis) {

          Situacao resultadoMovimento = xadrez.simularJogada(b);
          boolean rodadaBranca = xadrez.isTurnoBrancas();

          if(resultadoMovimento == Situacao.Pretas_em_xeque_mate && rodadaBranca == true) {

           MovimentosMate.add(b);

          }else if(resultadoMovimento == Situacao.Brancas_em_xeque_mate && rodadaBranca == false){

           MovimentosMate.add(b);

          }

         }

     }

      return MovimentosMate;

    }

}
