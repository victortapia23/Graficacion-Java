package MiniCADApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MiniCAD extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final String[] COLORS = { "Colores", "Rojo", "Verde", "Azul", "Rosado", "Negro" };

    private JTextField txtCorX, txtCorY, txtCor2x, txtCor2y;
    private JButton btnLinea, btnRombo, btnCirculo, btnCuadrado, btnTriangulo, btnRectangulo, btnSalir;
    private JComboBox<String> cmbColores;
    private JSpinner spinnerRotar, spinnerEscalaX, spinnerEscalaY, spinnerTraslacionX, spinnerTraslacionY;
    private JCheckBox chkUniforme;

    private int giro = 0;
    private double escaladoX = 1.0, escaladoY = 1.0;
    private int shapeType = 0;
    private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    private int xShape = 0, yShape = 0, widthShape = 0, heightShape = 0, colorShape = 0;
    private int traslacionX = 0, traslacionY = 0;

    public MiniCAD() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MiniCAD");
        setResizable(false);
        getContentPane().setLayout(null);

        JLabel lblCorX = new JLabel("X=");
        lblCorX.setBounds(10, 10, 20, 25);
        getContentPane().add(lblCorX);

        txtCorX = new JTextField();
        txtCorX.setBounds(35, 10, 50, 25);
        getContentPane().add(txtCorX);

        JLabel lblCorY = new JLabel("Y=");
        lblCorY.setBounds(95, 10, 20, 25);
        getContentPane().add(lblCorY);

        txtCorY = new JTextField();
        txtCorY.setBounds(120, 10, 50, 25);
        getContentPane().add(txtCorY);

        JLabel lblCor2x = new JLabel("Ancho=");
        lblCor2x.setBounds(10, 40, 50, 25);
        getContentPane().add(lblCor2x);

        txtCor2x = new JTextField();
        txtCor2x.setBounds(65, 40, 50, 25);
        getContentPane().add(txtCor2x);

        JLabel lblCor2y = new JLabel("Altura=");
        lblCor2y.setBounds(125, 40, 50, 25);
        getContentPane().add(lblCor2y);

        txtCor2y = new JTextField();
        txtCor2y.setBounds(180, 40, 50, 25);
        getContentPane().add(txtCor2y);

        btnLinea = new JButton("Linea");
        btnLinea.setBounds(10, 70, 80, 30);
        btnLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 = Integer.parseInt(txtCorX.getText());
                y1 = Integer.parseInt(txtCorY.getText());
                x2 = Integer.parseInt(txtCor2x.getText());
                y2 = Integer.parseInt(txtCor2y.getText());
                shapeType = 1;
                repaint();
            }
        });
        getContentPane().add(btnLinea);

        btnRombo = new JButton("Rombo");
        btnRombo.setBounds(100, 70, 80, 30);
        btnRombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                shapeType = 2;
                repaint();
            }
        });
        getContentPane().add(btnRombo);

        btnCirculo = new JButton("Circulo");
        btnCirculo.setBounds(10, 110, 80, 30);
        btnCirculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 3;
                repaint();
            }
        });
        getContentPane().add(btnCirculo);

        btnCuadrado = new JButton("Cuadrado");
        btnCuadrado.setBounds(100, 110, 80, 30);
        btnCuadrado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 4;
                repaint();
            }
        });
        getContentPane().add(btnCuadrado);

        btnTriangulo = new JButton("Triangulo");
        btnTriangulo.setBounds(10, 150, 80, 30);
        btnTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 5;
                repaint();
            }
        });
        getContentPane().add(btnTriangulo);

        btnRectangulo = new JButton("Rectangulo");
        btnRectangulo.setBounds(100, 150, 100, 30);
        btnRectangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xShape = Integer.parseInt(txtCorX.getText());
                yShape = Integer.parseInt(txtCorY.getText());
                widthShape = Integer.parseInt(txtCor2x.getText());
                heightShape = Integer.parseInt(txtCor2y.getText());
                shapeType = 6;
                repaint();
            }
        });
        getContentPane().add(btnRectangulo);

        cmbColores = new JComboBox<>(COLORS);
        cmbColores.setBounds(100, 190, 100, 25);
        cmbColores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                colorShape = cmbColores.getSelectedIndex();
            }
        });
        getContentPane().add(cmbColores);

        JLabel lblRotar = new JLabel("Rotar:");
        lblRotar.setBounds(10, 230, 50, 25);
        getContentPane().add(lblRotar);

        spinnerRotar = new JSpinner(new SpinnerNumberModel(0, 0, 360, 1));
        spinnerRotar.setBounds(60, 230, 60, 25);
        spinnerRotar.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                giro = (int) spinnerRotar.getValue();
                repaint();
            }
        });
        getContentPane().add(spinnerRotar);

        chkUniforme = new JCheckBox("Uniforme");
        chkUniforme.setBounds(130, 230, 100, 25);
        getContentPane().add(chkUniforme);

        JLabel lblEscalaX = new JLabel("Escala X:");
        lblEscalaX.setBounds(10, 260, 70, 25);
        getContentPane().add(lblEscalaX);

        spinnerEscalaX = new JSpinner(new SpinnerNumberModel(1.0, 0, 10, 0.1));
        spinnerEscalaX.setBounds(80, 260, 60, 25);
        spinnerEscalaX.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                escaladoX = (double) spinnerEscalaX.getValue();
                if (chkUniforme.isSelected())
                    escaladoY = escaladoX;
                repaint();
            }
        });
        getContentPane().add(spinnerEscalaX);

        JLabel lblEscalaY = new JLabel("Escala Y:");
        lblEscalaY.setBounds(10, 290, 70, 25);
        getContentPane().add(lblEscalaY);

        spinnerEscalaY = new JSpinner(new SpinnerNumberModel(1.0, 0, 10, 0.1));
        spinnerEscalaY.setBounds(80, 290, 60, 25);
        spinnerEscalaY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                escaladoY = (double) spinnerEscalaY.getValue();
                if (chkUniforme.isSelected())
                    escaladoX = escaladoY;
                repaint();
            }
        });
        getContentPane().add(spinnerEscalaY);

        JLabel lblTraslacionX = new JLabel("Traslación X:");
        lblTraslacionX.setBounds(10, 320, 80, 25);
        getContentPane().add(lblTraslacionX);

        spinnerTraslacionX = new JSpinner(new SpinnerNumberModel(0, -500, 500, 1));
        spinnerTraslacionX.setBounds(100, 320, 60, 25);
        spinnerTraslacionX.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                traslacionX = (int) spinnerTraslacionX.getValue();
                repaint();
            }
        });
        getContentPane().add(spinnerTraslacionX);

        JLabel lblTraslacionY = new JLabel("Traslación Y:");
        lblTraslacionY.setBounds(10, 350, 80, 25);
        getContentPane().add(lblTraslacionY);

        spinnerTraslacionY = new JSpinner(new SpinnerNumberModel(0, -500, 500, 1));
        spinnerTraslacionY.setBounds(100, 350, 60, 25);
        spinnerTraslacionY.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                traslacionY = (int) spinnerTraslacionY.getValue();
                repaint();
            }
        });
        getContentPane().add(spinnerTraslacionY);

        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(10, 390, 170, 30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        getContentPane().add(btnSalir);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 220, 170, 1);
        getContentPane().add(separator);

        JPanel panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                switch (shapeType) {
                    case 1: // Linea
                        g2d.translate(x1 + traslacionX, y1 + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.drawLine(0, 0, x2 - x1, y2 - y1);
                        break;

                    case 2: // Rombo
                        int halfWidth = (int) (widthShape / 2 * escaladoX);
                        int halfHeight = (int) (heightShape / 2 * escaladoY);
                        int[] xPoints = { xShape, xShape + halfWidth, xShape, xShape - halfWidth };
                        int[] yPoints = { yShape - halfHeight, yShape, yShape + halfHeight, yShape };
                        int numPoints = 4;

                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.fillPolygon(xPoints, yPoints, numPoints);
                        break;

                    case 3: // Circulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.fillOval(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;

                    case 4: // Cuadrado
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.fillRect(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;

                    case 5: // Triangulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.fillPolygon(new int[] { 0, (int) (widthShape * escaladoX), (int) (widthShape * escaladoX / 2) },
                                new int[] { 0, 0, (int) (heightShape * escaladoY) }, 3);
                        break;

                    case 6: // Rectangulo
                        g2d.translate(xShape + traslacionX, yShape + traslacionY);
                        g2d.rotate(Math.toRadians(giro));

                        if (colorShape > 0 && colorShape < COLORS.length) {
                            switch (colorShape) {
                                case 1:
                                    g2d.setColor(Color.RED);
                                    break;
                                case 2:
                                    g2d.setColor(Color.GREEN);
                                    break;
                                case 3:
                                    g2d.setColor(Color.BLUE);
                                    break;
                                case 4:
                                    g2d.setColor(Color.PINK);
                                    break;
                                case 5:
                                    g2d.setColor(Color.BLACK);
                                    break;
                            }
                        }
                        g2d.fillRect(0, 0, (int) (widthShape * escaladoX), (int) (heightShape * escaladoY));
                        break;
                }
            }
        };
        panel.setBounds(260, 10, 330, 310);
        getContentPane().add(panel);

        setSize(600, 450);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniCAD().setVisible(true);
            }
        });
    }
}