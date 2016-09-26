
/**
 *
 * @author Jessica Linette
 */

package examen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class ConvertidorDeUnidades extends JFrame {
    
    JTextField ventana;
    double resultado;
    JPanel pNum, pOp; //numeros del panel y operaciones
    boolean nAccion = true;
    String operacion;

    public ConvertidorDeUnidades() {
        super();
        setSize(350, 400);
        setTitle("Conversor: Pesos a Dólares");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        JPanel panel = (JPanel) this.getContentPane(); // Caracteristicas del panel
        panel.setLayout(new BorderLayout());

        ventana = new JTextField("0", 20);
        ventana.setBorder(new EmptyBorder(4, 4, 4, 4));
        ventana.setFont(new Font("Times New Roman", Font.BOLD, 25));
        ventana.setHorizontalAlignment(JTextField.RIGHT);
        ventana.setEditable(true);
        ventana.setBackground(Color.WHITE);
        panel.add("North", ventana);

        pNum = new JPanel();
        pNum.setLayout(new GridLayout(4, 3));
        pNum.setBorder(new EmptyBorder(4, 4, 4, 4));

            for (int n = 9; n >= 0; n--) {
                nuevoBotonNumerico("" + n);

            }
            
        nuevoBotonNumerico(".");
        panel.add("Center", pNum);
        
        pOp = new JPanel();
        pOp.setLayout(new GridLayout(6, 1));
        pOp.setBorder(new EmptyBorder(4,4,4,4));

        nuevoBotonOperacion("Convertir");
        nuevoBotonOperacion("CE");
        panel.add("East", pOp);
        
        validate();
        setVisible(true);
        
    }

    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        });
        pNum.add(btn);
    }

    private void numeroPulsado(String digito) {
        if (ventana.getText().equals("0") || nAccion) {
            ventana.setText(digito);
        } 
        else {
                ventana.setText(ventana.getText() + digito);
            }
        nAccion = false;
    }

    private void nuevoBotonOperacion(String operacion) {
        
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.DARK_GRAY);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        pOp.add(btn);
    }

    private void operacionPulsado(String dato) {
        if (dato.equals("Convertir")) {
            resultado = new Double(ventana.getText());
            calcularOperacion();
        } 
            else if (dato.equals("CE")) {
                ventana.setText("0");
                resultado = 0;
                nAccion = true;
            } 
            else {
                operacion = dato;
                    if ((resultado > 0) && !nAccion) {
                        calcularOperacion();
                    } 
                        else {
                        resultado = new Double(ventana.getText());
                        }
            }
            nAccion = true;
    }


    private void calcularOperacion(){

            resultado = (resultado/19);
            ventana.setText("" + resultado);
            operacion = "";
    }    
}
