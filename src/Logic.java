public class Logic {

    static private GameInterface gi = null;
    static private Boolean move = true;

    public Logic(GameInterface gi){
        this.gi = gi;
        addNewNumbs();
    }

    static public void moveUp() throws InterruptedException {
        move = false;
        for (int n = 0; n < 3; n++) { //to make last number get to the age
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    //merge
                    if (gi.getAllJbNum()[(4 + i) + (4 * j)] == gi.getAllJbNum()[(0 + i) + (4 * j)]&
                            gi.getAllJbNum()[(4 + i) + (4 * j)]!=0) {
                        gi.setJb(gi.getAllJbNum()[(0 + i) + (4 * j)] * 2, (0 + i) + (4 * j));
                        gi.setJb(0, (4 + i) + (4 * j));
                        move=true;
                        //rebase
                    } else if (gi.getAllJbNum()[(4 + i) + (4 * j)] != 0 & gi.getAllJbNum()[0 + i + (4 * j)] == 0) {
                        gi.setJb(gi.getAllJbNum()[(4 + i) + (4 * j)], 0 + i + (4 * j));
                        gi.setJb(0, (4 + i) + (4 * j));
                        move=true;
                    }
                }
            }
        }
        addNewNumbs();
        checkVictory();
    }
    static public void moveDown() throws InterruptedException {
        move = false;
        for (int n = 0; n < 3; n++) { //to make last number get to the age
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    //merge numbers
                    if (gi.getAllJbNum()[(8 + i) - (4 * j)] == gi.getAllJbNum()[((8 + i) + 4) - (4 * j)]&
                            gi.getAllJbNum()[(8 + i) - (4 * j)]!=0) {
                        gi.setJb((gi.getAllJbNum()[((8 + i) + 4) - (4 * j)] * 2), ((8 + i) + 4) - (4 * j));
                        gi.setJb(0, (8 + i) - (4 * j));
                        move = true;
                        //rebase number
                    } else if (gi.getAllJbNum()[(8 + i) - (4 * j)] != 0 & gi.getAllJbNum()[((8 + i) + 4) - (4 * j)] == 0) {
                        gi.setJb(gi.getAllJbNum()[(8 + i) - (4 * j)], ((8 + i) + 4) - (4 * j));
                        gi.setJb(0, (8 + i) - (4 * j));
                        move = true;
                    }
                }
            }
        }
        addNewNumbs();
        checkVictory();
    }
    static public void moveRight() throws InterruptedException {
        move = false;
        for (int n = 0; n < 3; n++) { //to make last number get to the age
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    //merge numbers
                    if (gi.getAllJbNum()[(2 + 4*i) - j] == gi.getAllJbNum()[(3 + 4*i) - j] &
                            gi.getAllJbNum()[(2 + 4*i) - j]!=0) {
                        gi.setJb(gi.getAllJbNum()[(3 + 4*i) - j] * 2, (3 + 4*i) - j);
                        gi.setJb(0, (2 + 4*i) - j);
                        move = true;
                        //rebase number
                    } else if (gi.getAllJbNum()[(2 + 4*i) - j] != 0 & gi.getAllJbNum()[(3 + 4*i) - j] == 0) {
                        gi.setJb(gi.getAllJbNum()[(2 + 4*i) - j], (3 + 4*i) - j);
                        gi.setJb(0, (2 + 4*i) - j);
                        move = true;
                    }
                }
            }
        }
        addNewNumbs();
        checkVictory();
    }
    static public void moveLeft() throws InterruptedException {
        move = false;
        for (int n = 0; n < 3; n++) { //to make last number get to the age
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    //merge numbers
                    if (gi.getAllJbNum()[(1 + 4*i) + j] == gi.getAllJbNum()[(0 + 4*i) + j]&
                            gi.getAllJbNum()[(1 + 4*i) + j]!=0) {
                        gi.setJb(gi.getAllJbNum()[(0 + 4*i) + j] * 2, (0 + 4*i) + j);
                        gi.setJb(0, (1 + 4*i) + j);
                        move = true;
                        //rebase number
                    } else if (gi.getAllJbNum()[(1 + 4*i) + j] != 0 & gi.getAllJbNum()[(0 + 4*i) + j] == 0) {
                        gi.setJb(gi.getAllJbNum()[(1 + 4*i) + j], (0 + 4*i) + j);
                        gi.setJb(0, (1 + 4*i) + j);
                        move = true;
                    }
                }
            }
        }
        addNewNumbs();
        checkVictory();
    }

    private static void checkVictory() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            if (gi.getAllJbNum()[i]==2048){
                gi.victory();
            }
        }
    }

    public static void addNewNumbs(){
        int empty = 0;
        for (int i = 0; i < 16; i++) {
            if(gi.getAllJbNum()[i] == 0) {
                empty ++;
            }
        }
        if (move & empty > 0) {
            int n = 1;
            if (empty>1){
                n = (int) Math.round(Math.random() + 1);
            }
            for (int i = 0; i < n; i++) {
                int position = (int) (Math.random() * 15);
                if (gi.getAllJbNum()[position] == 0) {
                    gi.setJb(2, position);
                } else {
                    i--;
                }
            }
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    System.out.printf(gi.getAllJbNum()[i + 4*j] + ", ");
                }
                System.out.printf("\n");
            }
            System.out.println("------------");
        }
    }
}
