public class move {

    String name;
    int power;
    int hit;
    String type;
    String stat;
    public move(String thename, int thepower, int thehit, String thetype, String thestat) {
        name = thename;
        power = thepower;
        hit = thehit;
        type = thetype;
        stat = thestat;
    }

    public double calcEffective(pokemon you, pokemon opponent, MyPanel panel) {
        double effective = 1.0;
        boolean supeffect = false;
        boolean noteffect = false;
        if (you.getTypes()[0].equals(type) || you.getTypes()[1].equals(type)) {
            effective *= 1.5;
        }
        switch (opponent.getTypes()[0]) {
            case "fire":
                if (type.equals("water")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("grass")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                else if (type.equals("rock")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("fire")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                break;
            case "water":
                if (type.equals("grass")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("fire")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                else if (type.equals("water")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                break;
            case "grass":
                if (type.equals("water")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                else if (type.equals("fire")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("grass")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                break;
            case "rock":
                if (type.equals("water")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("grass")) {
                    effective *= 2;
                    supeffect = true;
                    noteffect = false;
                }
                else if (type.equals("fire")) {
                    effective *= 0.5;
                    supeffect = false;
                    noteffect = true;
                }
                break;
            default:
                break;
        }
        switch (opponent.getTypes()[1]) {
            case "fire":
                if (type.equals("water")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("grass")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("rock")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                } else if (type.equals("fire")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                break;
            case "water":
                if (type.equals("grass")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("fire")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("water")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                break;
            case "grass":
                if (type.equals("water")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("fire")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("grass")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                break;
            case "rock":
                if (type.equals("water")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("grass")) {
                    effective *= 2;
                    supeffect = true;
                    if (noteffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                else if (type.equals("fire")) {
                    effective *= 0.5;
                    noteffect = true;
                    if (supeffect == true) {
                        supeffect = false;
                        noteffect = false;
                    }
                }
                break;
            default:
                break;
        }
        if (supeffect == true) {
            System.out.println("It's supereffective!");
            panel.left2String = "It's supereffective!";

        }
        if (noteffect == true) {
            System.out.println("It's not very effective...");
            panel.left2String = "It's not very effective...";
        }
        return effective;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getHit() {
        return hit;
    }

    public String getType() {
        return type;
    }

    public String getStat() {
        return stat;
    }
}
