package machine;

import java.util.Scanner;

class Coffee {
    int water;

    int milk;
    int beans;
    int cost;
    int cups;
    int money;

    public Coffee() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;

    }

    public Coffee(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;

    }

    public void setWater() {
        System.out.println("Write how many ml of water you want to add: ");
        Scanner sc = new Scanner(System.in);
        this.water = this.water + sc.nextInt();
    }

    public void setMilk() {
        System.out.println("Write how many ml of milk you want to add:");
        Scanner sc = new Scanner(System.in);
        this.milk = this.milk + sc.nextInt();
    }

    public void setBeans() {
        System.out.println("Write how many grams of coffee beans you want to add:");
        Scanner sc = new Scanner(System.in);
        this.beans = this.beans + sc.nextInt();
    }

    public void setCups() {
        System.out.println("Write how many disposable cups you want to add:");
        Scanner sc = new Scanner(System.in);
        this.cups = this.cups + sc.nextInt();
    }

}

public class CoffeeMachine {
    public static void main(String[] args) {
        Coffee machine = new Coffee();
        Coffee espresso = new Coffee(250, 0, 16, 4);
        Coffee late = new Coffee(350, 75, 20, 7);
        Coffee cappuccino = new Coffee(200, 100, 12, 6);
        Object[] coffeeList = {espresso, late, cappuccino};
        while (true) {
            Scanner sc = new Scanner(System.in);
            switch (sc.next().toLowerCase()) {
                case "buy" -> userBuysCoffee(machine, coffeeList);
                case "fill" -> {
                    machine.setWater();
                    machine.setMilk();
                    machine.setBeans();
                    machine.setCups();
                }
                case "take" -> {
                    System.out.println("I gave you " + machine.money);
                    machine.money = 0;
                }
                case "remaining" -> generateMachineValuesList(machine);
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Error action");
            }
        }

    }

    static void userBuysCoffee(Coffee machine, Object[] coffee) {
        Scanner sc = new Scanner(System.in);
        switch (sc.next()) {
            case "1" -> buyCoffee(machine, (Coffee) coffee[0]);
            case "2" -> buyCoffee(machine, (Coffee) coffee[1]);
            case "3" -> buyCoffee(machine, (Coffee) coffee[2]);
            default -> System.out.println("error");
        }

    }

    static void buyCoffee(Coffee machine, Coffee coffee) {
        if (machine.water < coffee.water) {
            System.out.println("Sorry, not enough water!");
        }else if(machine.milk < coffee.milk ){
            System.out.println("Sorry, not enough milk!");
        }else if(machine.beans < coffee.beans){
            System.out.println("Sorry, not enough beans!");
        } else if (machine.cups < coffee.cups) {
            System.out.println("Sorry, not enough cups!");
        } else {
            machine.water -= coffee.water;
            machine.milk -= coffee.milk;
            machine.beans -= coffee.beans;
            machine.cups -= 1;
            machine.money += coffee.cost;
        }
    }

    static void generateMachineValuesList(Coffee machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.water + " ml of water");
        System.out.println((machine.milk + " ml of milk"));
        System.out.println((machine.beans + " g of coffee beans"));
        System.out.println((machine.cups + " disposable cups"));
        System.out.println((machine.money + "$ of money"));
    }


}

