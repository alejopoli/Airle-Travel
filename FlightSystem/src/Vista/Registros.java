package Vista;

import Negocio.*;
import Entidades.*;
import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class Registros extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    JLabel jlbAirlineTravel;
    JLabel jlbRegistro;
    JLabel jlbDoc_ident;
    JLabel jlbCorreo;
    JLabel jlbClave;
    JLabel jlbNombre;
    JLabel jlbApellido;
    JLabel jlbTelefono;
    JLabel jlbCelular;
    JLabel jlb_x1, jlb_x2;

    JLabel jlbValidarC;
    JLabel jlbValidarP;
    JLabel jlbValidarDI;
    JLabel jlbValidarN;
    JLabel jlbValidarA;
    JLabel jlbValidarT;

    JLabel jlbYatiene;
    JLabel jlbsub;
    JLabel jlbIniciarSesion;
    JButton jbtnRegistrame;

    JTextField jtxtDoc_ident;
    JTextField jtxtCorreo;
    JTextField jtxtClave;
    JTextField jtxtNombre;
    JTextField jtxtApellido;
    JTextField jtxtTelefono;
    JTextField jtxtCelular;

    JComboBox jcbPerfil;
    JComboBox jcbEstado;

    JPanel jpmovedor;
    int x, y;

    public Registros() {
        super.setTitle("Registro");
        super.setSize(658, 710);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);

        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(585, 20, 25, 25);
        jlb_x1.setForeground(Color.DARK_GRAY);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(615, 10, 20, 30);
        jlb_x2.setForeground(Color.DARK_GRAY);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jlbAirlineTravel = new JLabel("Airline Travel");
        jlbAirlineTravel.setBounds(130, 18, 150, 20);
        jlbAirlineTravel.setForeground(Color.BLACK);
        jlbAirlineTravel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        this.add(jlbAirlineTravel);

        jpmovedor = new JPanel();
        jpmovedor.setOpaque(false);
        jpmovedor.setLayout(null);
        jpmovedor.add(jlb_x1);
        jpmovedor.add(jlb_x2);
        jpmovedor.add(jlbAirlineTravel);
        jpmovedor.setBounds(1, 1, 656, 60);
        jpmovedor.addMouseListener(this);
        jpmovedor.addMouseMotionListener(this);
        this.add(jpmovedor);

        jlbRegistro = new JLabel("Registrarte");
        jlbRegistro.setBounds(80, 80, 250, 40);
        jlbRegistro.setForeground(Color.WHITE);
        jlbRegistro.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        this.add(jlbRegistro);

        jlbCorreo = new JLabel("*Correo");
        jlbCorreo.setBounds(15, 25, 120, 25);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCorreo);

        jtxtCorreo = new JTextField("");
        jtxtCorreo.setBounds(15, 50, 250, 30);
        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCorreo.addKeyListener(this);
        this.add(jtxtCorreo);

        jlbValidarC = new JLabel("Ingrese el Correo");
        jlbValidarC.setForeground(Color.RED);
        jlbValidarC.setBounds(15, 75, 250, 27);
        jlbValidarC.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarC.setVisible(false);
        this.add(jlbValidarC);

        jlbClave = new JLabel("*Contraseña");
        jlbClave.setBounds(285, 25, 150, 25);
        jlbClave.setForeground(Color.BLACK);
        jlbClave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbClave);

        jtxtClave = new JPasswordField();
        jtxtClave.setBounds(285, 50, 250, 30);
        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtClave.addKeyListener(this);
        this.add(jtxtClave);

        jlbValidarP = new JLabel("Ingrese la contraseña");
        jlbValidarP.setForeground(Color.RED);
        jlbValidarP.setBounds(285, 75, 250, 27);
        jlbValidarP.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarP.setVisible(false);
        this.add(jlbValidarP);

        JPanel jpinfocuenta = new JPanel();
        jpinfocuenta.setOpaque(false);
        jpinfocuenta.add(jlbCorreo);
        jpinfocuenta.add(jtxtCorreo);
        jpinfocuenta.add(jlbValidarC);
        jpinfocuenta.add(jlbClave);
        jpinfocuenta.add(jtxtClave);
        jpinfocuenta.add(jlbValidarP);
        jpinfocuenta.setLayout(null);
        jpinfocuenta.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Informacion de la Cuenta", 1, 2, new Font("Segoe UI", Font.PLAIN, 15)));
        jpinfocuenta.setBounds(60, 170, 550, 115);
        this.add(jpinfocuenta);

        jlbDoc_ident = new JLabel("*Documento de identidad");
        jlbDoc_ident.setBounds(15, 25, 220, 25);
        jlbDoc_ident.setForeground(Color.BLACK);
        jlbDoc_ident.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbDoc_ident);

        jtxtDoc_ident = new JTextField("");
        jtxtDoc_ident.setBounds(15, 50, 520, 30);
        jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtDoc_ident.addKeyListener(this);
        this.add(jtxtDoc_ident);

        jlbValidarDI = new JLabel("Ingrese el Documento de identidad");
        jlbValidarDI.setForeground(Color.RED);
        jlbValidarDI.setBounds(15, 75, 250, 27);
        jlbValidarDI.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarDI.setVisible(false);
        this.add(jlbValidarDI);

        jlbNombre = new JLabel("*Nombre");
        jlbNombre.setBounds(15, 105, 120, 25);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbNombre);

        jtxtNombre = new JTextField("");
        jtxtNombre.setBounds(15, 130, 250, 30);
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtNombre.addKeyListener(this);
        this.add(jtxtNombre);

        jlbValidarN = new JLabel("Ingrese el Nombre");
        jlbValidarN.setForeground(Color.RED);
        jlbValidarN.setBounds(15, 155, 250, 27);
        jlbValidarN.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarN.setVisible(false);
        this.add(jlbValidarN);

        jlbApellido = new JLabel("*Apellido");
        jlbApellido.setBounds(285, 105, 150, 25);
        jlbApellido.setForeground(Color.BLACK);
        jlbApellido.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbApellido);

        jtxtApellido = new JTextField();
        jtxtApellido.setBounds(285, 130, 250, 30);
        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtApellido.addKeyListener(this);
        this.add(jtxtApellido);

        jlbValidarA = new JLabel("Ingrese el Apellido");
        jlbValidarA.setForeground(Color.RED);
        jlbValidarA.setBounds(285, 155, 250, 27);
        jlbValidarA.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarA.setVisible(false);
        this.add(jlbValidarA);

        jlbTelefono = new JLabel("*Telefono");
        jlbTelefono.setBounds(15, 185, 120, 25);
        jlbTelefono.setForeground(Color.BLACK);
        jlbTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbTelefono);

        jtxtTelefono = new JTextField("");
        jtxtTelefono.setBounds(15, 210, 250, 30);
        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtTelefono.addKeyListener(this);
        this.add(jtxtTelefono);

        jlbValidarT = new JLabel("Ingrese el Telefono");
        jlbValidarT.setForeground(Color.RED);
        jlbValidarT.setBounds(15, 235, 250, 27);
        jlbValidarT.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        jlbValidarT.setVisible(false);
        this.add(jlbValidarT);

        jlbCelular = new JLabel("Celular");
        jlbCelular.setBounds(285, 185, 150, 25);
        jlbCelular.setForeground(Color.BLACK);
        jlbCelular.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCelular);

        jtxtCelular = new JTextField();
        jtxtCelular.setBounds(285, 210, 250, 30);
        jtxtCelular.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        this.add(jtxtCelular);

        jcbPerfil = new JComboBox();
        jcbPerfil.setBorder(null);
        jcbPerfil.setBackground(Color.WHITE);
        jcbPerfil.addItem("Cliente");
        jcbPerfil.setBounds(350, 605, 100, 20);
        jcbPerfil.setVisible(false);
        this.add(jcbPerfil);

        jcbEstado = new JComboBox();
        jcbEstado.setBorder(null);
        jcbEstado.setBackground(Color.WHITE);
        jcbEstado.addItem("Activo");
        jcbEstado.setBounds(490, 605, 100, 20);
        jcbEstado.setVisible(false);
        this.add(jcbEstado);

        JPanel jpinfouser = new JPanel();
        jpinfouser.setOpaque(false);
        jpinfouser.add(jlbDoc_ident);
        jpinfouser.add(jtxtDoc_ident);
        jpinfouser.add(jlbValidarDI);
        jpinfouser.add(jlbNombre);
        jpinfouser.add(jtxtNombre);
        jpinfouser.add(jlbValidarN);
        jpinfouser.add(jlbApellido);
        jpinfouser.add(jtxtApellido);
        jpinfouser.add(jlbValidarA);
        jpinfouser.add(jlbTelefono);
        jpinfouser.add(jtxtTelefono);
        jpinfouser.add(jlbValidarT);
        jpinfouser.add(jlbCelular);
        jpinfouser.add(jtxtCelular);
        jpinfouser.setLayout(null);
        jpinfouser.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1), "Informacion del Usuario", 1, 2, new Font("Segoe UI", Font.PLAIN, 15)));
        jpinfouser.setBounds(60, 300, 550, 275);
        this.add(jpinfouser);

        jbtnRegistrame = new JButton("Registrarme");
        jbtnRegistrame.setBorder(null);
        jbtnRegistrame.setBounds(90, 600, 200, 35);
        jbtnRegistrame.setBackground(new Color(0, 154, 225));
        jbtnRegistrame.setForeground(Color.WHITE);
        jbtnRegistrame.setFocusPainted(false);
        jbtnRegistrame.addActionListener(this);
        jbtnRegistrame.addMouseListener(this);
        jbtnRegistrame.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jbtnRegistrame);

        jlbYatiene = new JLabel("Ya tengo una cuenta");
        jlbYatiene.setBounds(90, 650, 140, 25);
        jlbYatiene.setForeground(Color.BLACK);
        jlbYatiene.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        this.add(jlbYatiene);

        jlbIniciarSesion = new JLabel("Iniciar Sesión");
        jlbIniciarSesion.setBounds(230, 650, 150, 25);
        jlbIniciarSesion.setForeground(new Color(0, 154, 225));
        jlbIniciarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlbIniciarSesion.addMouseListener(this);
        jlbIniciarSesion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlbIniciarSesion);

        jlbsub = new JLabel("_______________");
        jlbsub.setBounds(229, 650, 150, 25);
        jlbsub.setForeground(Color.BLACK);
        jlbsub.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jlbsub.addMouseListener(this);
        jlbsub.setVisible(false);
        jlbsub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlbsub);

        JLabel icono = new JLabel();
        icono.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icons/add user-32.png")));
        icono.setBounds(35, 82, 40, 40);
        this.add(icono);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/Registro.png")));
        fondo.setBounds(0, 0, 658, 710);
        this.add(fondo);

        this.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        UsuarioEnt usuarioE = new UsuarioEnt();
        UsuarioNg usuarioN = new UsuarioNg();
        if (e.getSource() == jbtnRegistrame) {
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro de que quiere registrarse?", "Airline Travel", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.YES_OPTION) {
                if (jtxtDoc_ident.getText().trim().length() == 0 || jtxtCorreo.getText().trim().length() == 0 || jtxtClave.getText().trim().length() == 0 || jtxtNombre.getText().trim().length() == 0 || jtxtApellido.getText().trim().length() == 0 || jtxtTelefono.getText().trim().length() == 0) {
                    Toolkit.getDefaultToolkit().beep();
                    if (jtxtDoc_ident.getText().trim().length() == 0) {
                        jlbValidarDI.setVisible(true);
                        jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarDI.setVisible(false);
                        jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    if (jtxtCorreo.getText().trim().length() == 0) {
                        jlbValidarC.setVisible(true);
                        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarC.setVisible(false);
                        jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    if (jtxtClave.getText().trim().length() == 0) {
                        jlbValidarP.setVisible(true);
                        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarP.setVisible(false);
                        jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    if (jtxtNombre.getText().trim().length() == 0) {
                        jlbValidarN.setVisible(true);
                        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarN.setVisible(false);
                        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    if (jtxtApellido.getText().trim().length() == 0) {
                        jlbValidarA.setVisible(true);
                        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarA.setVisible(false);
                        jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    if (jtxtTelefono.getText().trim().length() == 0) {
                        jlbValidarT.setVisible(true);
                        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    } else {
                        jlbValidarT.setVisible(false);
                        jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                    return;
                }
                if (jtxtDoc_ident.getText().trim().length() > 0) {
                    usuarioE.setDocumento(jtxtDoc_ident.getText());
                }

                if (jtxtCorreo.getText().trim().length() > 0) {
                    usuarioE.setCorreo(jtxtCorreo.getText());
                }

                if (jtxtClave.getText().trim().length() > 0) {
                    usuarioE.setClave(jtxtClave.getText());
                }

                if (jtxtNombre.getText().trim().length() > 0) {
                    usuarioE.setNombre(jtxtNombre.getText());
                }

                if (jtxtApellido.getText().trim().length() > 0) {
                    usuarioE.setApellido(jtxtApellido.getText());
                }

                if (jtxtTelefono.getText().trim().length() > 0) {
                    usuarioE.setTelefono(jtxtTelefono.getText());
                }

                if (jtxtCelular.getText().trim().length() > 0) {
                    usuarioE.setCelular(jtxtCelular.getText());
                }

                usuarioE.setPerfil((String) jcbPerfil.getSelectedItem());
                usuarioE.setEstado((String) jcbEstado.getSelectedItem());

                boolean guarda = usuarioN.guardarUsuario(usuarioE);
                if (guarda) {
                    JOptionPane.showMessageDialog(null, "Se ha registrado un usuario", "Invenfly", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    Login l = new Login();
                    l.setVisible(false);
                    l.jtxtCorreo.setText(jtxtCorreo.getText());
                    l.jtxtClave.setText(jtxtClave.getText());
                    l.jbtnIngresar.doClick();
                    this.dispose();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "El usuario ya estaba registrado", "Invenfly", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        Registros r = new Registros();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpmovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnRegistrame) {
            jbtnRegistrame.setBackground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.DARK_GRAY);
        }
        if (arg0.getSource() == jlbIniciarSesion) {
            jlbIniciarSesion.setForeground(new Color(0, 154, 225));
            jlbsub.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnRegistrame) {
            jbtnRegistrame.setBackground(new Color(0, 123, 183));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(0, 154, 225));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(0, 154, 225));
        }
        if (arg0.getSource() == jlbIniciarSesion) {
            jlbIniciarSesion.setForeground(Color.BLACK);
            jlbsub.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (e.getSource() == jlb_x2) {
            System.exit(0);
        }

        if (e.getSource() == jlbIniciarSesion) {
            this.setVisible(false);
            this.dispose();
            Login l = new Login();
        }

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpmovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == jtxtDoc_ident) {
            if (jtxtDoc_ident.getText().trim().length() < 0) {
                jlbValidarDI.setVisible(true);
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarDI.setVisible(false);
                jtxtDoc_ident.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtCorreo) {
            if (jtxtCorreo.getText().trim().length() < 0) {
                jlbValidarC.setVisible(true);
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarC.setVisible(false);
                jtxtCorreo.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtClave) {
            if (jtxtClave.getText().trim().length() < 0) {
                jlbValidarP.setVisible(true);
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarP.setVisible(false);
                jtxtClave.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtNombre) {
            if (jtxtNombre.getText().trim().length() < 0) {
                jlbValidarN.setVisible(true);
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarN.setVisible(false);
                jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtApellido) {
            if (jtxtApellido.getText().trim().length() < 0) {
                jlbValidarA.setVisible(true);
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarA.setVisible(false);
                jtxtApellido.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtTelefono) {
            if (jtxtTelefono.getText().trim().length() < 0) {
                jlbValidarT.setVisible(true);
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jlbValidarT.setVisible(false);
                jtxtTelefono.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
