import java.awt.FlowLayout;                                     // ESCOPO: Uma área onde algo pode ser visualizado                                                                
import javax.swing.*;                                      // Global(fora do método) e Local(dentro do método)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

                                // Adicionando interface
public class Main extends JFrame implements ActionListener{ 
    
    // l para Label e Nome com N maiúsculo.... Criar objeto com nome parecido com aquilo que será usado
    JLabel lValor1, lValor2, lValor3, lResult;
    JTextField tfValor1, tfValor2, tfValor3, tfResult;
    JButton bSoma, bSub, bMult, bDiv, bLimpar, bSair;
    JTextArea taHistorico; 
    JCheckBox cbHistorico;
    
    // Criando barra
    JMenuBar mbmenuBar = new JMenuBar();
    // Adicionando itens
    JMenu versionMenu = new JMenu("Info");
    JMenu sobreMenu = new JMenu("Mais");
    // Adicionando subitens aos itens da bar
    JMenuItem authorAction = new JMenuItem("Mylenna");
    JMenuItem versionAction = new JMenuItem("V 1.0 - 2022");
    JMenuItem sobreAction = new JMenuItem("Clique para saber mais");

    JComboBox cbEstado, cbCidade;
    String[] ma = { "", "Imperatriz", "Açailândia", "São Luis" };
    String[] pa = { "", "Belém", "Marabá", "Satarém" };
    String[] pi = { "", "Canto da Serra", "Bom Jesus", "Floriano" };
 
    
    
    Calculadora c = new Calculadora(); // Adicionando classe Calculadora como escopo global 


    public Main(){ // Método construtor
        
        setLayout(new FlowLayout(FlowLayout.CENTER)); // Organiza layout 
        setSize(500, 500); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("Calculadora"); // Definindo título pra janela 

        // Adicionando itens ao frame
        setJMenuBar(mbmenuBar);
        mbmenuBar.add(versionMenu);
        mbmenuBar.add(sobreMenu);

        versionMenu.add(authorAction);
        versionMenu.addSeparator();
        versionMenu.add(versionAction);
        sobreMenu.add(sobreAction);

        lValor1 = new JLabel("Base: "); // Criação do objeto
        tfValor1 = new JTextField(5); // Criação do objeto
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

        String[] estado = { "", "Maranhão", "Pará", "Piauí" };
        cbEstado = new JComboBox(estado);
        cbEstado.addActionListener(this);
        add(cbEstado);

        cbCidade = new JComboBox();
        add(cbCidade);
        
        ////////////////////////////////////////////////////////////////////////

        bSoma = new JButton("+");
        bSub = new JButton("-");
        bMult = new JButton("x");
        bDiv = new JButton("/");
        bLimpar = new JButton("Limpar");
        bSair = new JButton("Sair");
        taHistorico = new JTextArea(15,15);
        taHistorico.setEditable(false);
        cbHistorico = new JCheckBox("Memorizar");
        
        bSoma.addActionListener(this);
        bSub.addActionListener(this);
        bMult.addActionListener(this);
        bDiv.addActionListener(this);
        bLimpar.addActionListener(this);
        bSair.addActionListener(this);
        sobreAction.addActionListener(this);
        
        add(bSoma);
        add(bSub);
        add(bMult);
        add(bDiv);
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
        if(ae.getSource()==bSoma){
            if(tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0 ){
                int num1 = Integer.parseInt(tfValor1.getText());
                int num2  = Integer.parseInt(tfValor2.getText());

                int result = c.soma(num1,num2);

                tfResult.setText(""+result); //parte que vai gravar no historico
                if(cbHistorico.isSelected()){
                    taHistorico.setText(taHistorico.getText() + num1+"+"+num2+"="+result + "\n");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(ae.getSource()==bSub){
            if(tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0 ){
                int num1 = Integer.parseInt(tfValor1.getText()); //pegando valores
                int num2  = Integer.parseInt(tfValor2.getText());

                int result = c.subtrai(num1, num2); // usando a função 

                tfResult.setText(""+result); //parte que vai gravar no historico
                if(cbHistorico.isSelected()){
                    taHistorico.setText(taHistorico.getText() + num1+"-"+num2+" = "+result+"\n");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(ae.getSource()==bMult){
            if(tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0 ){
                int num1 = Integer.parseInt(tfValor1.getText());
                int num2  = Integer.parseInt(tfValor2.getText());

                int result = c.multiplica(num1, num2);

                tfResult.setText(""+result); //parte que vai gravar no historico
                if(cbHistorico.isSelected()){
                    taHistorico.setText(taHistorico.getText() + num1+" x "+num2+" = "+result+"\n");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(ae.getSource()==bDiv){
            if(tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0 ){
                int num1 = Integer.parseInt(tfValor1.getText());
                int num2  = Integer.parseInt(tfValor2.getText());

                float result = c.divide(num1, num2);

                tfResult.setText(""+result); //parte que vai gravar no historico
                if(cbHistorico.isSelected()){
                    taHistorico.setText(taHistorico.getText() + num1+"/"+num2+ result+"\n");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(ae.getSource()==sobreAction){
            new Sobre();
        }
        if (ae.getSource()==cbEstado){
            switch (cbEstado.getSelectedIndex()) {
                case 0:
                    cbCidade.removeAllItems();
                    break;
                case 1:
                    cbCidade.removeAllItems();
                    for(int i=0; i<=3; i++)
                        cbCidade.insertItemAt(ma[i], i);
                    break;
                case 2:
                    cbCidade.removeAllItems();
                    for(int i=0; i<=3; i++)
                        cbCidade.insertItemAt(pa[i], i);
                    break;
                case 3:
                    cbCidade.removeAllItems();
                    for(int i=0; i<=3; i++)
                        cbCidade.insertItemAt(pi[i], i);
                    break;
                default:
                    break;
            }
        }
    }
}