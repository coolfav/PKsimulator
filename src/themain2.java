import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;

public class themain2 {

    static int x = 20;
    static int y = 210;
    static boolean choiced;
    static int maxhp1;
    static int maxhp2;
    static float proportion1;
    static float proportion2;


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame frame = new JFrame("Battle!");
        MyPanel panel = new MyPanel();
        panel.setFocusable(true);
        Random rand = new Random();
        URL file = new URL(new File("./rubybattle.wav").toURI().toString());
        switch (rand.nextInt(5)) {
            case 0:
                file = new URL(new File("./rubybattle.wav").toURI().toString());
                break;
            case 1:
                file = new URL(new File("./rival1.wav").toURI().toString());
                break;
            case 2:
                file = new URL(new File("./rival2.wav").toURI().toString());
                break;
            case 3:
                file = new URL(new File("./cynthia.wav").toURI().toString());
                break;
            case 4:
                file = new URL(new File("./cheren.wav").toURI().toString());
                break;
            default:
                file = new URL(new File("./rubybattle.wav").toURI().toString());
                break;
        }
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(ais);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        sleep(2000);
        //IVE UNLOCKED INFINITE POWER
//        panel.left1String = "not based";
//        panel.left2String = "base";
//        panel.right1String = "base";
//        panel.right2String = "base";
        panel.y_cursor = 210;
        //!!!!!!!
        ArrayList<move> moves1 = rollMoves();
        ArrayList<move> moves2 = rollMoves();
        pokemon pok1 = new pokemon("Geoph", generateTypes(), 100, (int) Math.floor(Math.random() * (300 - 240 + 1) + 240), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), moves1.get(0), moves1.get(1), moves1.get(2), moves1.get(3));
        maxhp1 = pok1.getHp();
        pokemon pok2 = new pokemon("Gary's mon", generateTypes(), 100, (int) Math.floor(Math.random() * (300 - 240 + 1) + 240), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), (int) Math.floor(Math.random() * (80 - 55 + 1) + 55), moves2.get(0), moves2.get(1), moves2.get(2), moves2.get(3));
        maxhp2 = pok2.getHp();
        panel.pok1String = pok1.getTypes()[0] + "/" + pok1.getTypes()[1];
        panel.pok2String1 = pok2.getTypes()[0] + "/";
        panel.pok2String2 = pok2.getTypes()[1];
        panel.addKeyListener(new AL());
        printMoves(panel, pok1);
        System.out.println("Gary challenged you to a Pokemon battle! \nYou sent out " + pok1.getName() + "! \nGary sent out " + pok2.getName() + "!");
        System.out.println(pok1.getName() + "'s stats: \nTypes: " + pok1.getTypes()[0] + "/" + pok1.getTypes()[1] + "\nHP: " + pok1.getHp() + "\nAtk: " + pok1.getAtk() + "\nDef: " + pok1.getDef() + "\nSpatk: " + pok1.getSpatk() + "\nSpdef: " + pok1.getSpdef() + "\nSpd: " + pok1.getSpd());
        System.out.println(pok2.getName() + "'s stats: \nTypes: " + pok2.getTypes()[0] + "/" + pok2.getTypes()[1] + "\nHP: " + pok2.getHp() + "\nAtk: " + pok2.getAtk() + "\nDef: " + pok2.getDef() + "\nSpatk: " + pok2.getSpatk() + "\nSpdef: " + pok2.getSpdef() + "\nSpd: " + pok2.getSpd());
        while (pok1.getHp() > 0 && pok2.getHp() > 0) {
            //picks which is higher speed
//            Scanner scan = new Scanner(System.in);
            menu(pok1);
            printMoves(panel, pok1);
//            System.out.println("Choose a move (type its name exactly): ");
//            String choice = scan.nextLine();
            while (choiced == false) {
                panel.x_cursor = x;
                panel.y_cursor = y;
                if (x == 20 && y == 210) {
                    panel.typeString = pok1.getMove1().getType().substring(0, 1).toUpperCase() + pok1.getMove1().getType().substring(1);
                } else if (x == 20 && y == 240) {
                    panel.typeString = pok1.getMove2().getType().substring(0, 1).toUpperCase() + pok1.getMove2().getType().substring(1);
                } else if (x == 180 && y == 210) {
                    panel.typeString = pok1.getMove3().getType().substring(0, 1).toUpperCase() + pok1.getMove3().getType().substring(1);
                } else if (x == 180 && y == 240) {
                    panel.typeString = pok1.getMove4().getType().substring(0, 1).toUpperCase() + pok1.getMove4().getType().substring(1);
                }
            }
            move themove = pok1.getMove1();
            if (x == 20 && y == 210) {
                themove = pok1.getMove1();
            } else if (x == 20 && y == 240) {
                themove = pok1.getMove2();
            } else if (x == 180 && y == 210) {
                themove = pok1.getMove3();
            } else if (x == 180 && y == 240) {
                themove = pok1.getMove4();
            }
            battle(pok1, pok2, themove, panel);
            panel.y_cursor = 210;
            panel.x_cursor = 20;
            choiced = false;
        }
        panel.x_cursor = 2000;
        clip.stop();
        clip.close();
        if (pok1.getHp() <= 0) {
            System.out.println(pok1.getName() + " fainted! You have no more usable pokemon! \nYou whited out and paid the opponent your life savings!");
            panel.left1String = pok2.getName() + " fainted!";
            panel.left2String = "You whited out and paid Gary your life savings!";
        } else {
            file = new URL(new File("./victory.wav").toURI().toString());
            ais = AudioSystem.getAudioInputStream(file);
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println(pok2.getName() + " fainted! Your opponent has no more usable pokemon! \nYou win and recieved your opponent's life savings!");
            panel.left1String = pok2.getName() + " fainted!";
            panel.left2String = "You win and recieved Gary's life savings!";
        }
    }

    public static String[] generateTypes() {
        Random rand = new Random();
        String[] thetypes = {"", ""};
        int num = rand.nextInt(4);
        switch (num) {
            case 0:
                thetypes[0] = "fire";
                break;
            case 1:
                thetypes[0] = "water";
                break;
            case 2:
                thetypes[0] = "grass";
                break;
            case 3:
                thetypes[0] = "rock";
            default:
                break;
        }
        do {
            num = rand.nextInt(4);
            switch (num) {
                case 0:
                    thetypes[1] = "fire";
                    break;
                case 1:
                    thetypes[1] = "water";
                    break;
                case 2:
                    thetypes[1] = "grass";
                    break;
                case 3:
                    thetypes[1] = "rock";
                    break;
                default:
                    break;
            }
        } while (thetypes[0].equals(thetypes[1]));
        return thetypes;
    }

    public static ArrayList<move> rollMoves() {
        Random rand = new Random();
        ArrayList<move> moves = new ArrayList<move>();
        ArrayList<move> moves1 = new ArrayList<move>();
        moves.add(new move("Flamethrower", 80, 95, "fire", "special"));
        moves.add(new move("Hydro pump", 80, 95, "water", "special"));
        moves.add(new move("Leaf blade", 80, 95, "grass", "physical"));
        moves.add(new move("Fire punch", 80, 95, "fire", "physical"));
        moves.add(new move("Aqua tail", 80, 95, "water", "physical"));
        moves.add(new move("Solar Beam", 80, 95, "grass", "special"));
        moves.add(new move("Stone edge", 80, 95, "rock", "physical"));
        moves.add(new move("Ancient power", 80, 95, "rock", "special"));
        moves.add(new move("Headbutt", 80, 95, "normal", "physical"));
        moves.add(new move("Boomburst", 80, 95, "normal", "physical"));
        int bound = 10;
        for (int x = 0; x < 4; x++) {
            int choice = rand.nextInt(bound);
            switch (choice) {
                case 0:
                    moves1.add(moves.get(0));
                    moves.remove(0);
                    break;
                case 1:
                    moves1.add(moves.get(1));
                    moves.remove(1);
                    break;
                case 2:
                    moves1.add(moves.get(2));
                    moves.remove(2);
                    break;
                case 3:
                    moves1.add(moves.get(3));
                    moves.remove(3);
                    break;
                case 4:
                    moves1.add(moves.get(4));
                    moves.remove(4);
                    break;
                case 5:
                    moves1.add(moves.get(5));
                    moves.remove(5);
                    break;
                case 6:
                    moves1.add(moves.get(6));
                    moves.remove(6);
                    break;
                case 7:
                    moves1.add(moves.get(7));
                    moves.remove(7);
                    break;
                case 8:
                    moves1.add(moves.get(8));
                    moves.remove(8);
                    break;
                case 9:
                    moves1.add(moves.get(9));
                    moves.remove(9);
                    break;
                default:
                    break;
            }
            bound -= 1;
        }
        return moves1;
    }


    public static int calculateDamage(pokemon pok1, pokemon pok2, move themove, MyPanel panel) {
        Random rand = new Random();
        double damage = 0;
        double part1 = ((2 * pok1.getLvl()) / 5) + 2;
        double part2 = 0;
        if (themove.getStat().equals("physical")) {
            part2 = themove.getPower() * ((double) pok1.getAtk() / (double) pok2.getDef());
        } else {
            part2 = themove.getPower() * ((double) pok1.getSpatk() / (double) pok2.getSpdef());
        }
        damage = (((part1 * part2) / 50) + 2) * themove.calcEffective(pok1, pok2, panel) * ((Math.floor(Math.random() * (100 - 85 + 1) + 85)) / 100.0);
        if ((rand.nextInt(100) + 1) >= themove.getHit()) {
            damage = 0;
        }
        return (int) Math.round(damage);
    }

    public static void battle(pokemon pok1, pokemon pok2, move themove, MyPanel panel) {
        Random rand = new Random();
        int dam1;
        int dam2;
        move themove2 = pok2.getMove1();
        int numb = rand.nextInt(3);
        switch (numb) {
            case 0:
                themove2 = pok2.getMove1();
                break;
            case 1:
                themove2 = pok2.getMove2();
                break;
            case 2:
                themove2 = pok2.getMove3();
                break;
            case 3:
                themove2 = pok2.getMove4();
                break;
        }
        clearBox(panel);
        panel.x_cursor = 2000;
        //comparing spd
        if (pok1.getSpd() > pok2.getSpd()) {
            System.out.println(pok1.getName() + " used " + themove.getName() + "!");
            panel.left1String = pok1.getName() + " used " + themove.getName() + "!";
//            sleep(1500);
            dam1 = calculateDamage(pok1, pok2, themove, panel);
            pok2.decreaseHP(dam1);
            proportion2 = (float) pok2.getHp() / (float) maxhp2;
            //
            if (proportion2 > 0) {
                int healthlost = Math.round(panel.pok2_health - (96 * proportion2));
                for (int j = 0; j < healthlost; j++) {
                    panel.pok2_health -= 1;
                    if (panel.pok2_health  <= 24) {
                        panel.thecolor2 = Color.RED;
                    }
                    else if (panel.pok2_health <= 48) {
                        panel.thecolor2 = Color.YELLOW;
                    }
                    sleep(30);
                }
                if (1500 - (healthlost * 30) > 0) {
                    sleep(1500 - (healthlost * 30));
                }
            } else {
                int healthlost = Math.round(panel.pok2_health);
                for (int j = 0; j < healthlost; j++) {
                    panel.pok2_health -= 1;
                    if (panel.pok2_health  <= 24) {
                        panel.thecolor2 = Color.RED;
                    }
                    else if (panel.pok2_health <= 48) {
                        panel.thecolor2 = Color.YELLOW;
                    }
                    sleep(30);
                }
                panel.pok2_health = 0;
                if (1500 - (healthlost * 30) > 0) {
                    sleep(1500 - (healthlost * 30));
                }
            }
            if (dam1 == 0) {
                System.out.println(pok1.getName() + "'s attack missed!");
                panel.left1String = pok1.getName() + "'s attack missed!";
                sleep(1500);
            } else {
                System.out.println(pok2.getName() + " took " + dam1 + " damage! Its HP is now " + pok2.getHp());
            }
            if (pok2.getHp() > 0) {
                System.out.println(pok2.getName() + " used " + themove2.getName() + "!");
                panel.left1String = pok2.getName() + " used " + themove2.getName() + "!";
                dam2 = calculateDamage(pok2, pok1, themove2, panel);
                pok1.decreaseHP(dam2);
                proportion1 = (float) pok1.getHp() / (float) maxhp1;
                if (proportion1 > 0) {
                    int healthlost = Math.round(panel.pok1_health - (96 * proportion1));
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok1_health -= 1;
                        if (panel.pok1_health  <= 24) {
                            panel.thecolor1 = Color.RED;
                        }
                        else if (panel.pok1_health <= 48) {
                            panel.thecolor1 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                } else {
                    int healthlost = Math.round(panel.pok1_health);
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok1_health -= 1;
                        sleep(30);
                        if (panel.pok1_health  <= 24) {
                            panel.thecolor1 = Color.RED;
                        }
                        else if (panel.pok1_health <= 48) {
                            panel.thecolor1 = Color.YELLOW;
                        }
                    }
                    panel.pok1_health = 0;
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                }
                if (dam2 == 0) {
                    System.out.println(pok2.getName() + "'s attack missed!");
                    panel.left1String = pok2.getName() + "'s attack missed!";
                    sleep(1500);
                } else {
                    System.out.println(pok1.getName() + " took " + dam2 + " damage! Its HP is now " + pok1.getHp());
                }
            }
        } else if (pok2.getSpd() > pok1.getSpd()) {
            System.out.println(pok2.getName() + " used " + themove2.getName() + "!");
            panel.left1String = pok2.getName() + " used " + themove2.getName() + "!";
            dam2 = calculateDamage(pok2, pok1, themove2, panel);
            pok1.decreaseHP(dam2);
            proportion1 = (float) pok1.getHp() / (float) maxhp1;
            if (proportion1 > 0) {
                int healthlost = Math.round(panel.pok1_health - (96 * proportion1));
                for (int j = 0; j < healthlost; j++) {
                    panel.pok1_health -= 1;
                    if (panel.pok1_health  <= 24) {
                        panel.thecolor1 = Color.RED;
                    }
                    else if (panel.pok1_health <= 48) {
                        panel.thecolor1 = Color.YELLOW;
                    }
                    sleep(30);
                }
                if (1500 - (healthlost * 30) > 0) {
                    sleep(1500 - (healthlost * 30));
                }
            } else {
                int healthlost = Math.round(panel.pok1_health);
                for (int j = 0; j < healthlost; j++) {
                    panel.pok1_health -= 1;
                    sleep(30);
                    if (panel.pok1_health  <= 24) {
                        panel.thecolor1 = Color.RED;
                    }
                    else if (panel.pok1_health <= 48) {
                        panel.thecolor1 = Color.YELLOW;
                    }
                }
                panel.pok1_health = 0;
                if (1500 - (healthlost * 30) > 0) {
                    sleep(1500 - (healthlost * 30));
                }
            }
            if (dam2 == 0) {
                System.out.println(pok2.getName() + "'s attack missed!");
                panel.left1String = pok2.getName() + "'s attack missed!";
                sleep(1500);
            } else {
                System.out.println(pok1.getName() + " took " + dam2 + " damage! Its HP is now " + pok1.getHp());
            }
            if (pok1.getHp() > 0) {
                System.out.println(pok1.getName() + " used " + themove.getName() + "!");
                panel.left1String = pok1.getName() + " used " + themove.getName() + "!";
                dam1 = calculateDamage(pok1, pok2, themove, panel);
                pok2.decreaseHP(dam1);
                proportion2 = (float) pok2.getHp() / (float) maxhp2;
                //
                if (proportion2 > 0) {
                    int healthlost = Math.round(panel.pok2_health - (96 * proportion2));
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok2_health -= 1;
                        if (panel.pok2_health  <= 24) {
                            panel.thecolor2 = Color.RED;
                        }
                        else if (panel.pok2_health <= 48) {
                            panel.thecolor2 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                } else {
                    int healthlost = Math.round(panel.pok2_health);
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok2_health -= 1;
                        if (panel.pok2_health  <= 24) {
                            panel.thecolor2 = Color.RED;
                        }
                        else if (panel.pok2_health <= 48) {
                            panel.thecolor2 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    panel.pok2_health = 0;
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                }
                if (dam1 == 0) {
                    System.out.println(pok1.getName() + "'s attack missed!");
                    panel.left1String = pok1.getName() + "'s attack missed!";
                    sleep(1500);
                } else {
                    System.out.println(pok2.getName() + " took " + dam1 + " damage! Its HP is now " + pok2.getHp());
                }
            }
        } else {
            if (rand.nextInt(2) == 0) {
                System.out.println(pok1.getName() + " used " + themove.getName() + "!");
                panel.left1String = pok1.getName() + " used " + themove.getName() + "!";
//            sleep(1500);
                dam1 = calculateDamage(pok1, pok2, themove, panel);
                pok2.decreaseHP(dam1);
                proportion2 = (float) pok2.getHp() / (float) maxhp2;
                //
                if (proportion2 > 0) {
                    int healthlost = Math.round(panel.pok2_health - (96 * proportion2));
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok2_health -= 1;
                        if (panel.pok2_health  <= 24) {
                            panel.thecolor2 = Color.RED;
                        }
                        else if (panel.pok2_health <= 48) {
                            panel.thecolor2 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                } else {
                    int healthlost = Math.round(panel.pok2_health);
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok2_health -= 1;
                        if (panel.pok2_health  <= 24) {
                            panel.thecolor2 = Color.RED;
                        }
                        else if (panel.pok2_health <= 48) {
                            panel.thecolor2 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    panel.pok2_health = 0;
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                }
                if (dam1 == 0) {
                    System.out.println(pok1.getName() + "'s attack missed!");
                    panel.left1String = pok1.getName() + "'s attack missed!";
                    sleep(1500);
                } else {
                    System.out.println(pok2.getName() + " took " + dam1 + " damage! Its HP is now " + pok2.getHp());
                }
                if (pok2.getHp() > 0) {
                    System.out.println(pok2.getName() + " used " + themove2.getName() + "!");
                    panel.left1String = pok2.getName() + " used " + themove2.getName() + "!";
                    dam2 = calculateDamage(pok2, pok1, themove2, panel);
                    pok1.decreaseHP(dam2);
                    proportion1 = (float) pok1.getHp() / (float) maxhp1;
                    if (proportion1 > 0) {
                        int healthlost = Math.round(panel.pok1_health - (96 * proportion1));
                        for (int j = 0; j < healthlost; j++) {
                            panel.pok1_health -= 1;
                            if (panel.pok1_health  <= 24) {
                                panel.thecolor1 = Color.RED;
                            }
                            else if (panel.pok1_health <= 48) {
                                panel.thecolor1 = Color.YELLOW;
                            }
                            sleep(30);
                        }
                        if (1500 - (healthlost * 30) > 0) {
                            sleep(1500 - (healthlost * 30));
                        }
                    } else {
                        int healthlost = Math.round(panel.pok1_health);
                        for (int j = 0; j < healthlost; j++) {
                            panel.pok1_health -= 1;
                            sleep(30);
                            if (panel.pok1_health  <= 24) {
                                panel.thecolor1 = Color.RED;
                            }
                            else if (panel.pok1_health <= 48) {
                                panel.thecolor1 = Color.YELLOW;
                            }
                        }
                        panel.pok1_health = 0;
                        if (1500 - (healthlost * 30) > 0) {
                            sleep(1500 - (healthlost * 30));
                        }
                    }
                    if (dam2 == 0) {
                        System.out.println(pok2.getName() + "'s attack missed!");
                        panel.left1String = pok2.getName() + "'s attack missed!";
                        sleep(1500);
                    } else {
                        System.out.println(pok1.getName() + " took " + dam2 + " damage! Its HP is now " + pok1.getHp());
                    }
                }
            } else {
                System.out.println(pok2.getName() + " used " + themove2.getName() + "!");
                panel.left1String = pok2.getName() + " used " + themove2.getName() + "!";
                dam2 = calculateDamage(pok2, pok1, themove2, panel);
                pok1.decreaseHP(dam2);
                proportion1 = (float) pok1.getHp() / (float) maxhp1;
                if (proportion1 > 0) {
                    int healthlost = Math.round(panel.pok1_health - (96 * proportion1));
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok1_health -= 1;
                        if (panel.pok1_health  <= 24) {
                            panel.thecolor1 = Color.RED;
                        }
                        else if (panel.pok1_health <= 48) {
                            panel.thecolor1 = Color.YELLOW;
                        }
                        sleep(30);
                    }
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                } else {
                    int healthlost = Math.round(panel.pok1_health);
                    for (int j = 0; j < healthlost; j++) {
                        panel.pok1_health -= 1;
                        sleep(30);
                        if (panel.pok1_health  <= 24) {
                            panel.thecolor1 = Color.RED;
                        }
                        else if (panel.pok1_health <= 48) {
                            panel.thecolor1 = Color.YELLOW;
                        }
                    }
                    panel.pok1_health = 0;
                    if (1500 - (healthlost * 30) > 0) {
                        sleep(1500 - (healthlost * 30));
                    }
                }
                if (dam2 == 0) {
                    System.out.println(pok2.getName() + "'s attack missed!");
                    panel.left1String = pok2.getName() + "'s attack missed!";
                    sleep(1500);
                } else {
                    System.out.println(pok1.getName() + " took " + dam2 + " damage! Its HP is now " + pok1.getHp());
                }
                if (pok1.getHp() > 0) {
                    System.out.println(pok1.getName() + " used " + themove.getName() + "!");
                    panel.left1String = pok1.getName() + " used " + themove.getName() + "!";
                    dam1 = calculateDamage(pok1, pok2, themove, panel);
                    pok2.decreaseHP(dam1);
                    proportion2 = (float) pok2.getHp() / (float) maxhp2;
                    //
                    if (proportion2 > 0) {
                        int healthlost = Math.round(panel.pok2_health - (96 * proportion2));
                        for (int j = 0; j < healthlost; j++) {
                            panel.pok2_health -= 1;
                            if (panel.pok2_health  <= 24) {
                                panel.thecolor2 = Color.RED;
                            }
                            else if (panel.pok2_health <= 48) {
                                panel.thecolor2 = Color.YELLOW;
                            }
                            sleep(30);
                        }
                        if (1500 - (healthlost * 30) > 0) {
                            sleep(1500 - (healthlost * 30));
                        }
                    } else {
                        int healthlost = Math.round(panel.pok2_health);
                        for (int j = 0; j < healthlost; j++) {
                            panel.pok2_health -= 1;
                            if (panel.pok2_health  <= 24) {
                                panel.thecolor2 = Color.RED;
                            }
                            else if (panel.pok2_health <= 48) {
                                panel.thecolor2 = Color.YELLOW;
                            }
                            sleep(30);
                        }
                        panel.pok2_health = 0;
                        if (1500 - (healthlost * 30) > 0) {
                            sleep(1500 - (healthlost * 30));
                        }
                    }
                    if (dam1 == 0) {
                        System.out.println(pok1.getName() + "'s attack missed!");
                        panel.left1String = pok1.getName() + "'s attack missed!";
                        sleep(1500);
                    } else {
                        System.out.println(pok2.getName() + " took " + dam1 + " damage! Its HP is now " + pok2.getHp());
                    }
                }
            }
            sleep(1500);
            clearBox(panel);
        }

    }

    public static void menu(pokemon pok1) {
        System.out.println(pok1.getMove1().getName() + ": power = " + pok1.getMove1().getPower() + ", accuracy = " + pok1.getMove1().getHit() + ", type = " + pok1.getMove1().getType() + ", stat = " + pok1.getMove1().getStat());
        System.out.println(pok1.getMove2().getName() + ": power = " + pok1.getMove2().getPower() + ", accuracy = " + pok1.getMove2().getHit() + ", type = " + pok1.getMove2().getType() + ", stat = " + pok1.getMove2().getStat());
        System.out.println(pok1.getMove3().getName() + ": power = " + pok1.getMove3().getPower() + ", accuracy = " + pok1.getMove3().getHit() + ", type = " + pok1.getMove3().getType() + ", stat = " + pok1.getMove3().getStat());
        System.out.println(pok1.getMove4().getName() + ": power = " + pok1.getMove4().getPower() + ", accuracy = " + pok1.getMove4().getHit() + ", type = " + pok1.getMove4().getType() + ", stat = " + pok1.getMove4().getStat());
    }

    public static void sleep(int r) {
        try {
            Thread.sleep(r);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void printMoves(MyPanel panel, pokemon pok1) {
        panel.left1String = pok1.getMove1().getName();
        panel.left2String = pok1.getMove2().getName();
        panel.right1String = pok1.getMove3().getName();
        panel.right2String = pok1.getMove4().getName();
    }

    public static void clearBox(MyPanel panel) {
        panel.left1String = "";
        panel.left2String = "";
        panel.right1String = "";
        panel.right2String = "";
    }

}

class AL extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == event.VK_LEFT)
        {
            themain2.x = 20;
        }
        else if (keyCode == event.VK_RIGHT)
        {
            themain2.x = 180;
        }
        else if (keyCode == event.VK_UP)
        {
            themain2.y = 210;
        }
        else if (keyCode == event.VK_DOWN)
        {
            themain2.y = 240;
        }
        else if (keyCode == event.VK_ENTER) {
            themain2.choiced = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
    }
}
