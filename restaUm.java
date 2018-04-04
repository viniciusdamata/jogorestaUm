/*******************************************************************************************************************
data de alteração: 16/03 11hr nome: Vinicius
*http://dontpad.com/magdiel_macedo_progII
*Alteração no metodo imprimeTabuleiro(Otimização)
*1)resta n; a, b, c, d  possibilidades de jogadas.Se uma não der certo, tentar as outras possibilidades;
*Se escolher n == 1, posso escolher se a peça que vai sobrar sera no meio.
****************************************************************************************************************/

public class restaUm{


    public static void inicializaMatriz(char m[][]){
          /*Espacos vazios sem uso da matriz são iniciados com '\u0000'
          *Espaco deixado por jogadas e representado por 'x'
          *Peças sao representadas por 'o'*/
             for(int i = 0 ; i < 7; i++){
				        for(int j = 0; j < 7; j++){
					         if(i < 2 || i > 4){
                     if(j < 2){
                       m[i][j] = '\u0000';
                     }
                     if(j > 4) {
                       m[i][j] = '\u0000';
                     }
                     else {
                      m[i][j] = 'o';
                      }

                   }
                   else if(i == 3 && j == 3) {
                     m[i][j] = 'x';
                   }
                   else{
                     m[i][j] = 'o';
                   }

                   }
                }
            }
    public static void imprimeTabuleiro(char m[][]){
			int i, j = 2, n = 5;
      /*Alteração 16/03 por Vinicius (Otimização)
      *A coluna é alterada conforme a linha, nas duas primeiras linhas
      *e nas duas ultimas j recebe 2 e o n recebe 5 para imprimir apenas
      *3 colunas nas outras linhas a impressão é normal.
      */

			for(i = 0; i < 7; i++){
        if(i < 2 || i > 4){
          j = 2;
          n = 5;
          System.out.print("    ");
        }
        else {
          j = 0;
          n = 7;
        }
          while(j < n) {
              System.out.print(" "+m[i][j]);
              j++;
          }
          System.out.println(" ");
        }
      }
    public static void jogo(char m[][], int n){
    }
    public  static void desfazjogadas(char m[][]){

    }
    public static void realizaJogadas(char m[][], int o[], int d[]) {
      int aux = 0;
      boolean continuar = true;
        while (continuar) {
          continuar = procuraJogadas(m, o, d);
          m[o[0]][o[1]] = m[d[0]][d[1]];
          m[o[0]][o[1]] = 'x';


        }
    }
    public static void metodoAux(int op, int o[], int d[]) {

    }
    public static boolean procuraJogadas(char m[][], int o[], int d[]){
        for (int i = 0; i < 7; i++) {
          for (int j = 0; j < 7; j++) {
              /*Tive a ideia de talvez colocar essas comparações em um metodo Auxiliar
              *para usa-las conforme necessario*/
              // Comparação a direita
                if(m[i][j] == 'o') {
                  if(m[i][j+1] == 'o' && m[i][j+2] == 'x'){
                  o[0] = i;
                  o[1] = j;
                  d[0] = i;
                  d[1] = (j+1);
                  m[i][j+1] = 'x';
                  return true;
                  }
              // Comparação a esquerda
                if(m[i][j-1] == 'o' && m[i][j-2] == 'x'){
                  o[0] = i;
                  o[1] = j;
                  d[0] = i;
                  d[1] = (j-1);
                  m[i][j-1] = 'x';
                  return true;
                }
              // Comparação abaixo
                if(m[i+1][j] == 'o' && m[i+2][j] == 'x'){
                  o[0] = i;
                  o[1] = j;
                  d[0] = (i+2);
                  d[1] = j;
                  m[i+1][j] = 'x';
                  return true;
                }
              // Comparação acima
                if(m[i-1][j] == 'o' && m[i-2][j] == 'x'){
                  o[0] = i;
                  o[1] = j;
                  d[0] = (i-2);
                  d[1] = j;
                  m[i-1][j] = 'x';
                  return true;
                }
              }
            }
          }
          return false;
      }

    public static void main(String args[]){

    	char m[][] = new char [7][7];
    	int n, origem[] = new int[2], destino[] = new int[2];

    		inicializaMatriz(m);
    		imprimeTabuleiro(m);
        n = Input.readInt("\nquantas pecas devem sobrar no tabuleiro: ");
        jogo(m, n);
        realizaJogadas(m, origem, destino);



	}
} teste
