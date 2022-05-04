import java.awt.FlowLayout;                                     // ESCOPO: Uma área onde algo pode ser visualizado                                                                
import javax.swing.*;                                      // Global(fora do método) e Local(dentro do método)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

                                // Adicionando interface
public class Main extends JFrame implements ActionListener{ 

    // l para Label e Nome com N maiúsculo.... Criar objeto com nome parecido com aquilo que será usado
    JLabel lValor1, lValor2, lResult;
    JTextField tfValor1, tfValor2, tfResult;
    JButton bSoma, bSub, bLimpar, bSair;
    JTextArea taHistorico; 
    JCheckBox cbHistorico;

    Calculadora c = new Calculadora(); // Adicionando classe Calculadora como escopo global 




    public Main(){ // Método construtor
        
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Organiza layout 
        setSize(500, 500); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("Calculadora"); // Definindo título pra janela 

        lValor1 = new JLabel("Base: "); // Criação do objeto
        tfValor1 = new JTextField(5); // Criação do objeto
        tfValor1.requestFocus(true);
        tfValor1.setToolTipText("Inserir o 1° valor"); // Adicionando descrição on hover
        lValor2 = new JLabel("Potencia: "); 
        tfValor2 = new JTextField(5); 

        lResult = new JLabel("Resultado: "); 
        tfResult = new JTextField(10); 
        tfResult.setEditable(false); // Desabilitar o campo editável
        
        add(tfResult); 
        add(lValor1); // Adicionando o objeto na frame
        add(tfValor1); // Adicionando o objeto na frame
        add(lValor2); 
        add(tfValor2); 
        add(lResult); 
        add(tfResult); 
        
        ////////////////////////////////////////////////////////////////////////

        bPoten = new JButton("Potencia");
        bMultP = new JButton("Multiplicar potencias");
        bDivP = new JButton("Dividir potencias");
        bLimpar = new JButton("Limpar");
        bSair = new JButton("Sair");
        taHistorico = new JTextArea(15,15);
        taHistorico.setEditable(false);
        cbHistorico = new JCheckBox("Memorizar");
        
        bSoma.addActionListener(this);
        bSub.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);
        
        add(bSoma);
        add(bSub);
        add(bLimpar);
        add(bSair);
        add(taHistorico);
        add(cbHistorico);

    }

    public static void main(String[] args){ 
        // Referencia        // Instancia
        Main s          =   new Main(); // cria o objeto s do tipo Main
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==bSair){ 
            System.exit(0);
        }
        if(ae.getSource()==bLimpar){
            tfValor1.setText("");
            tfValor2.setText("");
            tfResult.setText("");
            taHistorico.setText("");
        }
        if(ae.getSource()==bPoten){
            int number = Integer.parseInt(tfValor1.getText());
            int power  = Integer.parseInt(tfValor2.getText());

            double result = c.potencia(number,power);

            tfResult.setText(""+result); //parte que vai gravar no historico, copiar esse bloco em todos
                if(cbHistorico.isSelected()){
                    taHistorico.setText(taHistorico.getText() + number+"^"+power+"="+result + "\n");
                }
        }
        if(ae.getSource()==bMultP){
            
        }

        if(ae.getSource()==bPoten){

        }





    }
}