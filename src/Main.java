import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import static java.awt.event.KeyEvent.VK_ESCAPE;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyMenu myMenu = new MyMenu();
        Thread threadMenu = new Thread(new MyMenu());
        threadMenu.start();
    }



}