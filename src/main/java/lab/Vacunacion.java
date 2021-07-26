package lab;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.File;


public class
Vacunacion {
    static final Logger logger = Logger.getLogger(Vacunacion.class.getName());

    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }


    public static boolean validateUser(String username, String contrasena) throws FileNotFoundException {
        Scanner s = new Scanner(new File("usuarios.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        var a = false;
        for (String element : list){
            if (a){
                return element.contains(contrasena);
            }
            if (element.contains(username)) a = true;
        }
        return false;
    }

    public static void visualizarInfo(){

    }

    public static void cambiarEstado(boolean c) throws IOException {
        Scanner sa = new Scanner(new File("centrosVacunacion.txt"));
        logger.info("Escriba la ciudad del local que quiere dar de alta");
        var sc3 = new Scanner(System.in);
        String local = sc3.nextLine();

        ArrayList<String> list = new ArrayList<String>();
        while (sa.hasNext()){
            list.add(sa.next());
        }
        var a = false;
        for (String element : list){
            if (a = true){
                if(c) element = "alta";
                else element = "baja";
                break;
            }
            if (element.contains(local)) a = true;
        }
        System.out.print(list.toString());
        sa.close();
        FileWriter writer = new FileWriter("centrosVacunacion.txt");
        var b = 0;
        for(String str: list) {
            if (b%2!=0){
                writer.write(str + System.lineSeparator());
            }
            else{
                writer.write(str + '\t');
            }
            b++;
        }
        writer.close();
        realizarAccion();
    }

    public static void realizarAccion() throws IOException {
        logger.info("Elija una acción a realizar, ingresar un número del 1 al 4");
        logger.info("1. Visualizar información consolidada\n" +
                        "2. Dar de alta un centro de vacunación\n" +
                        "3. Dar de baja un centro de vacunación\n" +
                        "4. Cerrar sesión");
        var sc2 = new Scanner(System.in);
        var accion = sc2.nextInt();
        if (accion == 1){
            visualizarInfo();
        }
        else if(accion == 2){
            cambiarEstado(true);
        }
        else if(accion == 3){
            cambiarEstado(false);
        }
        else if(accion == 4){
            startProgram();
        }
        else{
            realizarAccion();
        }
    }

    public static void startProgram() throws IOException {
        logger.info("Iniciar sesión");
        logger.info("nombre de usuario:");
        var sc = new Scanner(System.in);
        String username = sc.nextLine();
        logger.info("contraseña:");
        String contrasena = sc.nextLine();
        if (validateUser(username, contrasena)) {
            realizarAccion();
        }else{
            startProgram();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        startProgram();
    }

}
