package formula;

import javax.swing.JOptionPane;

public class RaicesConMenu {
    public static void main(String[] args) {
        while (true) {
            
             // Se solicitaa al usuario que ingrese todod los valores de cada una de las varibles
            double a = ingresarDouble("Ingrese el coeficiente a:");
            double b = ingresarDouble("Ingrese el coeficiente b:");
            double c = ingresarDouble("Ingrese el coeficiente c:");

            Raices raices = new Raices(a, b, c);
            
            // Mostrar opciones al usuario
            String[] opciones = {"Calcular raíces", "Cambiar coeficientes", "Reiniciar operación", "Salir"};
            int opcionElegida = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Opciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            // Realizar acción según la opción elegida
            switch (opcionElegida) {
                case 0:
                    raices.calcular();
                    break;
                     // si el usuario quiere cambiar datos 
                case 1:
                    a = ingresarDouble("Ingrese el nuevo coeficiente a:");
                    b = ingresarDouble("Ingrese el nuevo coeficiente b:");
                    c = ingresarDouble("Ingrese el nuevo coeficiente c:");
                    raices.setCoeficientes(a, b, c);
                    break;
                case 2:
                    // Reiniciar operación sin cambiar los coeficientes
                    break;
                case 3:
                     // se sale del programa 
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    System.exit(0);
                    break;
            }
        }
    }
 // En caso que el usuario ingrese datos que no son, como lo podría ser una letra
    private static double ingresarDouble(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
            }
        }
    }
}
 // se calculas las raices
class Raices {
    private double a;
    private double b;
    private double c;

    public Raices(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setCoeficientes(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void calcular() {
        double discriminante = b * b - 4 * a * c;

        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Raíces reales:\nRaíz 1: " + raiz1 + "\nRaíz 2: " + raiz2);
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Raíz única:\nRaíz: " + raiz);
        } else {
            JOptionPane.showMessageDialog(null, "No hay raíces reales.");
        }
    }
}
