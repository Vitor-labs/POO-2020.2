import java.util.Scanner;

public class Tamagochi {
    private int hungry, clean, energy, maxHungry, maxClean, maxEnergy, age, diamonds;
    private boolean alive;

    Tamagochi(int hungry, int clean, int energy){
        this.maxHungry = hungry;
        this.maxClean = clean;
        this.maxEnergy = energy;

        this.hungry = hungry;
        this.clean = clean;
        this.energy = energy;

        this.age = 0;
        this.diamonds = 0;
        this.alive = true;}

    public String toString(){
        return "Status: Energia = "+this.energy+"/"+this.maxEnergy+" | Fome = "+this.hungry+"/"+
        this.maxHungry+" | Sujeira = "+this.clean+"/"+this.maxClean+" | Vivo = "+this.alive+
        " | Idade = "+this.age+" | Diamantes = "+this.diamonds;}

    private void setHungry(int h) {
        this.hungry = h;}
    private void setClean(int c) {
        this.clean = c;}
    private void setEnergy(int e) {
        this.energy = e;}

    public int getMaxHungry() {
        return this.maxHungry;}
    public int getMaxEnergy() {
        return this.maxEnergy;}
    public int getMaxClean() {
        return this.maxClean;}
    public int getHungry() {
        return this.hungry;}
    public int getEnergy() {
        return this.energy;}
    public int getClean() {
        return this.clean;}

    void play(){
        if(this.alive){
            this.setHungry(this.getHungry() - 1);
            this.setEnergy(this.getEnergy() - 2);
            this.setClean(this.getClean() - 3);
            this.diamonds++;
            this.age++;
        } else {
            System.out.println("O pet está morto");
            return;} 
    }
    void shower (){
        if (this.alive) {
            this.setHungry(this.getHungry() - 1);
            this.setEnergy(this.getEnergy() - 3);
            this.setClean(this.getMaxClean());
            this.age += 2;
        } if (this.getClean() < 6) {
            System.out.println("O bixim ainda tá limpo");
            return;
        } else {
            System.out.println("O pet está morto");
            return;}
    }
    void eat(){
        if (this.alive) {
            this.setHungry(this.getHungry() + 4);
            this.setEnergy(this.getEnergy() - 1);
            this.setClean(this.getClean() - 2);
            this.age++;
        } else {
            System.out.println("O pet está morto");
            return;
        }
    }
    void sleep(){
        if (this.alive) {
            this.age += this.getMaxEnergy() - this.getEnergy();
            this.setEnergy(this.getMaxEnergy());
        } if (this.energy < 5) {
            System.out.println("O pet tá sem sono");
            return;
        } else {
            System.out.println("O pet está morto");
            return;
        }
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Legal esse novo pet, quais as caracteristicas dele: ");

        /*
         * System.out.println("Qual o tamanho do bucho dele ? "); 
         * int hungry = leitor.nextInt(); System.out.println("Qual a tanto de energia dele ? ");
         * int clean = leitor.nextInt();
         * System.out.println("Ele aguenta até onde de sujeira ? "); 
         * int energy = leitor.nextInt();
         * 
         * tontogochi tonto = new tontogochi(hungry, clean, energy);
         */
		Tamagochi tonto = null;

        while (true){
            String[] line = leitor.nextLine().split(" ");

            if (line[0].equals("init"))
                tonto = new Tamagochi (Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
            else if (line[0].equals("show"))
                System.out.println(tonto);
            else if (line[0].equals("play"))
                tonto.play();
            else if (line[0].equals("eat"))
                tonto.eat();
            else if (line[0].equals("clean"))
                tonto.shower();
            else if (line[0].equals("sleep"))
                tonto.sleep();
            else if (line[0].equals("end"))
                break;
            else
                System.out.println("ERROR, Comando inválido!\nDigite um comando valido ou verifique ortografia.");}
        leitor.close();}
    }