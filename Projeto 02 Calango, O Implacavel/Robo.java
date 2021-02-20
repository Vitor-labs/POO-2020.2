import java.util.Random;
import java.util.Scanner;
public class Robo{
    
    int Maxbateria;
    int bateria;
    int erros;
    int armadura;
    int Maxarmadura;
    boolean bug;

    Robo(int maxBateria, int maxArmadura){
        this.Maxbateria = maxBateria;
        this.bateria = maxBateria;
        this.erros = 0;
        this.Maxarmadura = maxArmadura;
        this.armadura = maxArmadura;
        this.bug = false;}
    
    /*public String status() {
        return "Bateria: " + bateria + "/" + Maxbateria + "\nArmadura: " + armadura + "/" + Maxarmadura
                + "\nBugs: " + bug + ": " + erros;}*/

    void andar(){
        if (bateria > 2){
            System.out.println("4NDAND0, QU4L A PR0X1M4 0RD3M ?");
            bateria--;}}

    void carregar(){
        if(bateria <= Maxbateria - 2){
            System.out.println("P0ND0 M415 UM4 P1LH4...\nPR0NT0, QU4L A PR0X1M4 0RD3M ?");
            bateria += 2;
            if(bateria == Maxbateria){
                System.out.println("C4RG4 T0T4L !!!");}
        } else {
            System.out.println("41ND4 T3NH0 B45T4NT3 3N3RG14, V4M0S F4Z3R M415 C01S4S");}}

    void concerto(){
        if (armadura < Maxarmadura) {
            System.out.println("4P3RT4ND0 0S P4R4FUS0S...");
            armadura++;
        } else {
            System.out.println("41ND4 T0 N0V1NH0 3M F0LH4 !");}}

    void escrever(){
        if (bateria < 3){
            System.out.println("N40 T3NH0 3N3RG14 5UF1C13NT3 !!!");
        }else{
            System.out.println("\"Rosas são vermelhas violetas são azuis, a luz de seus olhos é o que me seduz.\"");
            System.out.println("35P3R4, V10L3T45 D3V3R14M 53R V10L3T45, 3SS3S HUM4N05...");
        bateria -= 3;}}

    void bugs(){
            System.out.println("S1ST3M4 F4LH4ND0 !!.\n??? P3R - D4 DE C0N...\n\t~TR0...\n\t\t~L3 !!.");
            System.out.println("~ADMIN: Não deixe a bateria ou a armadura baixar muito !!!");
            erros++;}

    void desligar(){
        System.out.println("~ADMIN: Até a Próxima");}

    void lutas(Robo other){
        if (this.bateria > 2 && this.armadura > 3) {
            System.out.println("V4M0 C41R N0 P4U !!");
            Random sorte = new Random(10);
            if (sorte.nextInt() > 5) {
                this.bateria --;
                this.armadura -= 2;
                other.bateria -= 2;
                other.armadura -= 3;
                System.out.println("T0M3 1550 S3U F3RRUG3M !!!");
            } else {
                this.bateria -= 2;
                this.armadura -= 3;
                other.bateria--;
                other.armadura -= 2;
                System.out.println("0H N0, V0C3 V41 V3R 50 L4T4 V3LH4");}
        } else {
            System.out.println("N40 T3NH0 F0RÇ4 PR4 LUT4R =_=");}}
    public static void main(String[] args) {

        Robo roboto = new Robo(10, 12);
        Robo robert = new Robo(12, 15);

        System.out.println(roboto);

        System.out.println("0L4, 3U S0U O R0B0T0, ME DIGA MEU PROPOSITO.\n\nADMIN: ~Roboto tem 5 funções:" +
                             "(1) andar, (2) escrever, (3) carregar, (4) lutar ,(5) desliga \n"
                             +"ADMIN: ~Eu sei, ele não faz muita coisa.\n" +
                             "ADMIN: ~Tente dar uma ordem a ele\n");
        
        Scanner leitor = new Scanner(System.in);
        while (true) {

            //Opções de Energia
            if (roboto.bateria < 6) {
                System.out.println("M3LH0R P0R M41S UM4S P1LH4S");}
            if (roboto.bateria < 4) {
                System.out.println("35T0U F1C4ND0 53M 3N3RG14 !!!");
                roboto.bugs();}
            if (roboto.bateria == 0) {
                System.out.println("4C4B0U A 3N3R...");
                roboto.desligar();}

            //Opções de Armadura
            if (roboto.armadura < 6) {
                System.out.println("M3LH0R  1R PR0 C0NC3RT0");}
            if (roboto.armadura < 4) {
                System.out.println("35T0U MU1T0 D4N1F1C4D0 !!!");
                roboto.bugs();}
            if (roboto.armadura == 0) {
                System.out.println("~ADMIN: Roboto foi destruido");
                roboto.desligar();}

            String entrada = leitor.nextLine();
            if (entrada.equals("1")) {
                roboto.andar();
            }if (entrada.equals("2")) {
                roboto.escrever();
            }if (entrada.equals("3")) {
                roboto.carregar();
            }if (entrada.equals("4")) {
                roboto.lutas(robert);
            }if (entrada.equals("5")) {
                roboto.desligar();
                break;}
            //roboto.status();
        }

            System.out.println(robert);
        leitor.close();}
}