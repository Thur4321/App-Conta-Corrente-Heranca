package contacorrenteherança;

import javax.swing.JOptionPane;

public class ContaCorrenteHerança {

    public static void main(String[] args) {

        String operações[] = {"Listar informações", "Saque", "Depósito", "Sair"};

        ContaCorrente objConta = null;

        ContaEspecial especial = null;

        String nome = JOptionPane.showInputDialog(null, "Informe o nome dos titulares:", "Conta", 3);

        int númeroConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número da sua conta:", "Conta", 3));

        if (JOptionPane.showConfirmDialog(null, "Sua conta é especial?", "Automóvel", JOptionPane.YES_NO_OPTION, 3) == 0) {
            float limite = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o limite desejado:", "Conta", 3));
            especial = new ContaEspecial(limite, nome, númeroConta);
        } else {
            objConta = new ContaCorrente(nome, númeroConta);
        }

        JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso.", "Conta", 1);

        String opçãoUser = "";

        while (!opçãoUser.equals(operações[3])) {
            opçãoUser = (String) JOptionPane.showInputDialog(null, "Selecione a operação desejada:", "Conta", 3, null, operações, operações[0]);

            switch (opçãoUser) {
                case "Listar informações":
                    if (objConta != null) {
                        JOptionPane.showMessageDialog(null, "As informações da sua conta são:\n" + objConta, "Conta", 1);
                    } else if (especial != null) {
                        JOptionPane.showMessageDialog(null, "As informações da sua conta são:\n" + especial, "Conta", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cadastre seus dados", "Conta", 1);
                    }

                    break;
                case "Saque":
                    if (objConta != null) {
                        float saque = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do seu saque:", "Conta", 3));
                        boolean sacou = objConta.saque(saque);
                        if (sacou) {
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.", "Conta", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saque indisponível, saldo insuficiente.", "Conta", 1);
                        }
                    } else if (especial != null) {
                        float saque = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do seu saque:", "Conta", 3));
                        boolean sacou = especial.saque(saque);
                        if (sacou) {
                            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.", "Conta", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Saque indisponível, saldo insuficiente.", "Conta", 1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cadastre seus dados", "Conta", 1);
                    }

                    break;
                case "Depósito":
                    if (objConta != null) {
                        float depósito = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do seu depósito:", "Conta", 3));
                        objConta.depósito(depósito);
                        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.", "Conta", 1);
                    } else if (especial != null) {
                        float depósito = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o valor do seu depósito:", "Conta", 3));
                        if (especial.limite() == true && depósito + especial.saldo <= especial.getLimite()) {
                            especial.depósito(depósito);
                            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.", "Conta", 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "Depósito indisponível, extrapola seu limite de saldo.", "Conta", 1);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Cadastre seus dados", "Conta", 1);
                    }
            }
        }
        System.exit(0);
    }

}
