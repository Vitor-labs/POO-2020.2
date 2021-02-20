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

    void quebraLampada(Lampada lampada) {
        Random meninofei = new Random();// chance de menino fei quebrar a lampada.
        int foiQuebrada = meninofei.nextInt(10);
        if (foiQuebrada > 8) {
            inteira = false;
            System.out.println("Um menino fei quebrou a lampada, presisamos troca-lá !\n");}
        toString(lampada);}

    void durasaoLampada(Lampada lampada){
        lampada.durabilidade--;
        if (lampada.durabilidade == 0) {
            System.out.println("\nIh, a lampada ficou muito velha, queimou...\nChama lá o estágiario pra trocar");
            toString(lampada);}
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

    public String toString(Lampada lampada) {
        return "Status: inteira = "+lampada.inteira+" | potência = "+lampada.potencia;}
}
public class Poste{
    int potencia;
    boolean emPe = true;

    Poste(int potencia){
        this.potencia = potencia;}

    void posteCaiu(Poste poste, Lampada lampada){
        Random ventania = new Random();
        int forsaVento = ventania.nextInt(10);
        if (forsaVento > 9) {
            poste.emPe = false;
            lampada.setInteira(false);
            System.out.println("\nVish, que vento forte, o poste caiu, precisamo trocar tudo agora.");
        }else{
            System.out.println("\nHum, bom, o poste continua de pé.");}
        }
    void posteVsLampada(Poste poste, Lampada lampada){
        if (poste.potencia > lampada.potencia) {//aqui compara as potências
            System.out.println("\nEita, a lampada Explodiu, use uma de mesma potência.");       
            lampada.inteira = false;
            lampada.toString(lampada);
        } if(poste.potencia < lampada.potencia){
            System.out.println("\nEssa lampada tá meio apagada, use uma de menor potência.");
            lampada.durabilidade--;
            lampada.toString(lampada);
        } else {
            System.out.println("\nLinda e Brilhante, do jeito que o povo gosta");
            lampada.durabilidade--;
            lampada.toString(lampada);}
        }
    void trocaLampada(Lampada lampada, Lampada lampada2) {
        if (lampada.inteira == true && lampada.durabilidade > 0) {
            System.out.println("Não precisa, ela ainda está funcionando.");
        } else {
            System.out.println("\nLampada trocada com sucesso !");
            lampada = lampada2;}
        }
    void diaAdia(Poste poste, Lampada lampada){
        System.out.println("\nAlguns dias se passaram, o que será q aconteceu ?\n");
        for (int i = 0; i < 10; i++) {
            System.out.println("Dia "+i+": ");
            posteCaiu(poste, lampada);
            lampada.durasaoLampada(lampada);
            lampada.quebraLampada(lampada);
            lampada.toString(lampada);}
    }
    public static void main(String[] args) {
        Lampada lampada = new Lampada(2, 2, 0);
        lampada.durasaoLampada(lampada);

        System.out.println("Deu problema no poste da rua 7, veja o que aconteceu !\ne compre uma lampada nova no caminho !");

        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o tamanho da lampada ? 1) para Pequena | 2) para Grande: ");
        int tamanho = leitor.nextInt();
        System.out.println("Qual a potência da lampada ? 1) para Fraca | 2) para Forte: ");
        int potencia = leitor.nextInt();

        System.out.println("Qual era a potência do poste mesmo ? ");
        int altura = leitor.nextInt();
        leitor.close();

        Lampada lampada2 = new Lampada(tamanho, potencia, 10);
        Poste poste = new Poste(altura);

        poste.posteVsLampada(poste, lampada2);

        System.out.println("\nCerto, vamos trocar essa bagaça");
    
        poste.diaAdia(poste, lampada2);}
}