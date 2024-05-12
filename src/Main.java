import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import static java.awt.event.KeyEvent.VK_ESCAPE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        MyMenu myMenu = new MyMenu();
        Thread treadMenu = new Thread(myMenu);
        treadMenu.start();
    }


}