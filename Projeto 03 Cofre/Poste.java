import java.util.Random;
import java.util.Scanner;

class Lampada{
    int tamanho;// 1) para Pequena | 2) para Grande
    int potencia;// 1) para Fraca | 2) para Forte
    int durabilidade;// tempo de vida (0 - 10)
    boolean inteira = true;

    Lampada(int tamanho, int potencia, int durabilidade){
        this.tamanho = tamanho;
        this.potencia = potencia;
        this.durabilidade = durabilidade;}

    public String toString() {
        return "Status: inteira = "+this.inteira+" | potência = "+this.potencia+" | durabilidade = "+this.durabilidade;}

    void quebraLampada(Lampada lampada) {
        Random meninofei = new Random();// chance de menino fei quebrar a lampada.
        int foiQuebrada = meninofei.nextInt(10);
        if (foiQuebrada > 8) {
            lampada.inteira = false;
            lampada.durabilidade = 0;
            System.out.println("Um menino fei quebrou a lampada, presisamos troca-lá !\n");
            return;}
        }
    void durasaoLampada(Lampada lampada){
        lampada.durabilidade--;
        if (lampada.durabilidade == 0) {
            System.out.println("\nIh, a lampada ficou muito velha, queimou...\nChama lá o estágiario pra trocar");
            return;}
    }
    int getPotencia(){
        return this.potencia;}
    int getDurabilidade(){
        return this.durabilidade;}
    boolean getInteira(){
        return this.inteira;}
    
    public void setPotencia(int p){
        this.potencia = p;}
    public void setDurabilidade(int d){
        this.durabilidade = d;}
    public void setInteira(boolean i){
        this.inteira = i;}
}
public class Poste{
    int potencia;// 1) para Fraca | 2) para Forte
    int tamanho;// 1) para Pequeno | 2) para Grande
    boolean emPe = true;

    Poste(int potencia, int tamanho){
        this.potencia = potencia;
        this.tamanho = tamanho;}

    void posteCaiu(Poste poste, Lampada lampada){
        Random ventania = new Random();
        int forsaVento = ventania.nextInt(10);
        if (forsaVento > 9) {
            poste.emPe = false;
            lampada.setInteira(false);
            System.out.println("Vish, bateu um vento forte, o poste caiu, precisamos trocar tudo agora.");
            return;
        }else{
            System.out.println("\nHum, bom, o poste continua de pé.");}
        }
    void posteVsLampada(Poste poste, Lampada lampada){
        if (poste.potencia > lampada.potencia) {//aqui compara as potências
            lampada.inteira = false;
            System.out.println("Eita, a lampada Explodiu, use uma de mesma potência.\n");     
            return; 
        } if(poste.potencia < lampada.potencia){
            lampada.durabilidade--;
            System.out.println("Essa lampada tá meio apagada, use uma de menor potência.\n");
            return;
        } if (poste.tamanho > lampada.tamanho) {// aqui compara os tamanhos
            System.out.println("Essa lampada é meio pequena para esse poste !\n");
            return; 
        } else {
            lampada.durabilidade--;
            System.out.println("Linda e Brilhante, do jeito que o povo gosta\n");}
        }
    void diaAdia(Poste poste, Lampada lampada){//agregador das funções
        System.out.println("um dia se passou, o que será q aconteceu ?\n");
            poste.posteCaiu(poste, lampada);
            lampada.durasaoLampada(lampada);
            lampada.quebraLampada(lampada);
            System.out.println(lampada.toString());}

    public static void main(String[] args) {
        Lampada lampada = new Lampada(2, 2, 0);
        lampada.durasaoLampada(lampada);

        System.out.println("Deu problema no poste da rua 7, veja o que aconteceu !\ne compre uma lampada nova no caminho !");

        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o tamanho da lampada ? 1) para Pequena | 2) para Grande: ");
        int tamanho = leitor.nextInt();
        System.out.println("Qual a potência da lampada ? 1) para Fraca | 2) para Forte: ");
        int potencia = leitor.nextInt();
        System.out.println("Ela dura quanto tempo ? (numero de dias): ");

        System.out.println("Qual era a potência do poste mesmo ? 1) para Fraca | 2) para Forte: ");
        int potenp = leitor.nextInt();
        System.out.println("Qual a altura dele ? 1) para Pequeno | 2) para Grande:");
        int altura = leitor.nextInt();

        System.out.println("Certo, vamos trocar essa bagaça !\n");

        Lampada lampada2 = new Lampada(tamanho, potencia, 10);
        Poste poste = new Poste(potenp, altura);
        poste.posteVsLampada(poste, lampada2);
    
        boolean y;
        do {//aqui faz-se um ciclo das funções
            int x;
            System.out.println("\nDeseja ver o próximo dia ? 1) para sim | 2) para não" );
            x = leitor.nextInt();
            if (x == 1) {
                y = true;
                poste.diaAdia(poste, lampada2);
            } else {
                y = false;
                return;}
        } while (y == true);
        
        leitor.close();}
}