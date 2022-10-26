package Classes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * /**
 *
 * @author alamtrindade
 */
public class Banco {

    Connection connection = null;

    //criar Banco    
    public void criaBanco() {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite
            //TABELA CARRO
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_carro("
                    + "id_car INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "placa_car STRING, "
                    + "marca_car STRING, "
                    + "modelo_car STRING, "
                    + "ano_car INTEGER, "
                    + "cor_car STRING, "
                    + "categoria_car STRING, "
                    + "qtd_portas_car INTEGER, "
                    + "cpf_cli STRING)"
                    + ";");
            //TABELA CLIENTE
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_cliente("
                    + "id_cli INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nome_cli STRING, "
                    + "cpf_cli STRING, "
                    + "endereco_cli STRING, "
                    + "tel_cli STRING,"
                    + "fidelidade_cli INTEGER)"
                    + ";");
            //TABELA MATERIALP
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_materialap("
                    + "id_matp INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "tipo_matp STRING, "
                    + "descricao_matp STRING, "
                    + "qtd_matp INTEGER)"
                    + ";");
            //TABELA MOTO
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_moto("
                    + "id_mot INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "placa_mot STRING, "
                    + "marca_mot STRING, "
                    + "modelo_mot STRING, "
                    + "ano_mot INTEGER, "
                    + "cor_mot STRING, "
                    + "porte_mot STRING, "
                    + "cpf_cli STRING)"
                    + ";");
            //TABELA PESADO
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_pesado("
                    + "id_pesa INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "placa_pesa STRING, "
                    + "marca_pesa STRING, "
                    + "modelo_pesa STRING, "
                    + "ano_pesa INTEGER, "
                    + "cor_pesa STRING, "
                    + "eixo_pesa INTEGER, "
                    + "cacamba_pesa STRING, "
                    + "cpf_cli STRING)"
                    + ";");
            //TABELA PRODUTO
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_produto("
                    + "id_produto INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "tipo_produto STRING, "
                    + "descricao_produto STRING, "
                    + "valor_produto DOUBLE, "
                    + "qtd_produto INTEGER)"
                    + ";");
            //TABELA PROFISSIONAL
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_profissional ("
                    + "id_prof INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nome_prof STRING, "
                    + "cpf_prof STRING, "
                    + "endereco_prof STRING, "
                    + "tel_prof STRING, "
                    + "funcao_prof STRING, "
                    + "salario_prof DOUBLE, "
                    + "ativo_prof BOOLEAN)"
                    + ";");
            //TABELA USER
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_user ("
                    + "id_user INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nome_user STRING, "
                    + "cpf_user STRING, "
                    + "endereco_user STRING, "
                    + "tel_user STRING, "
                    + "email_user STRING, "
                    + "senha_user STRING)"
                    + ";");
            //tabela serviço
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_servico ("
                    + "id_ser INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nome_ser STRING, "
                    + "descricao_ser STRING, "
                    + "preco DOUBLE)"
                    + ";"
            );
            //tabela agenda
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_agenda ("
                    + "id_agenda INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "cpf_user STRING, "
                    + "placa_veiculo STRING, "
                    + "profissional STRING, "
                    + "servico STRING, "
                    + "data STRING, "
                    + "hora STRING, "
                    + "status BOOLEAN, "
                    + "observacoes STRING, "
                    + "preco DOUBLE)"
                    + ";");

            //TABELA VENDA
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tb_venda ("
                    + "id_venda INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "cpf_cliente STRING, "
                    + "id_produto STRING, "
                    + "nome_produto STRING, "
                    + "preco STRING, "
                    + "qtd STRING, "
                    + "totalVenda STRING, "
                    + "data STRING)"
                    + ";");

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }
    }

    public boolean cadastrarServico(Servico servico) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_servico "
                    + "("
                    + "nome_ser, "
                    + "descricao_ser, "
                    + "preco)"
                    + "VALUES("
                    + "'" + servico.getNome_servico() + "', "
                    + "'" + servico.getDescricao_servico() + "', "
                    + "'" + servico.getPreco() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean cadastrarVenda(Venda venda, ArrayList<Produto> alterados) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_venda "
                    + "("
                    + "cpf_cliente, "
                    + "id_produto, "
                    + "nome_produto, "
                    + "preco, "
                    + "qtd, "
                    + "totalVenda, "
                    + "data)"
                    + "VALUES("
                    + "'" + venda.getCPFCliente() + "', "
                    + "'" + venda.getId_produto() + "', "
                    + "'" + venda.getNome_produto() + "', "
                    + "'" + venda.getPreco() + "', "
                    + "'" + venda.getQtd() + "', "
                    + "'" + venda.getTotalVenda() + "', "
                    + "'" + venda.getData() + "'"
                    + ");");

            for (Produto c : alterados) {
                statement.executeUpdate("UPDATE tb_produto SET qtd_produto = "
                        + "" + c.getQuantidade() + ""
                        + " WHERE id_produto = "
                        + "" + c.getId() + ""
                        + ";");
            }
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Servico> CarregarServico() {
        ArrayList<Servico> servicos = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_servico");

            while (rs.next()) {

                int id = rs.getInt("id_ser");
                String nome_servico = rs.getString("nome_ser");
                String descricao_servico = rs.getString("descricao_ser");
                Double preco = rs.getDouble("preco");

                Servico servico = new Servico(nome_servico, descricao_servico, preco);
                servico.setId(id);
                servicos.add(servico);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return servicos;
    }

    public boolean servicoJaExiste(String servico) {

        boolean existe = false;
        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT nome_ser FROM tb_servico WHERE nome_ser LIKE '" + servico + "'");

            while (rs.next()) {
                if (rs.getString("nome_ser").equals(servico)) {
                    System.out.println("CPF DO CARA  : " + rs.getString("cpf_user"));
                    existe = true;
                }

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return existe;

    }

    public boolean veiculoJaExiste(String placa) {

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT placa_car FROM tb_carro WHERE placa_car LIKE '" + placa + "'");
            ResultSet rs1 = statement.executeQuery("SELECT placa_mot FROM tb_moto WHERE placa_mot LIKE '" + placa + "'");
            ResultSet rs2 = statement.executeQuery("SELECT placa_pesa FROM tb_pesado WHERE placa_pesa LIKE '" + placa + "'");

            while (rs.next()) {
                if (rs.getString("placa_car").equals(placa)) {
                    return true;
                }
            }
            while (rs1.next()) {
                if (rs1.getString("placa_mot").equals(placa)) {
                    return true;
                }
            }
            while (rs2.next()) {
                if (rs2.getString("placa_pesa").equals(placa)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean cadastrarAgenda(Agenda agenda) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_agenda "
                    + "("
                    + "cpf_user, "
                    + "placa_veiculo, "
                    + "profissional, "
                    + "servico, "
                    + "data, "
                    + "hora, "
                    + "status, "
                    + "observacoes, "
                    + "preco)"
                    + "VALUES("
                    + "'" + agenda.getCPFCliente() + "', "
                    + "'" + agenda.getPlacaVeiculo() + "', "
                    + "'" + agenda.getCPFProfissional() + "', "
                    + "'" + agenda.getServico() + "', "
                    + "'" + agenda.getData() + "', "
                    + "'" + agenda.getHora() + "', "
                    + "'" + agenda.isStatus() + "', "
                    + "'" + agenda.getObservacoes() + "', "
                    + "'" + agenda.getPreco() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Agenda> CarregarAgendamentos() {
        ArrayList<Agenda> agendamentos = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_agenda");

            while (rs.next()) {

                int id = rs.getInt("id_agenda");
                String CPFCliente = rs.getString("cpf_user");
                String placaVeiculo = rs.getString("placa_veiculo");
                String CPFProfissional = rs.getString("profissional");
                String servico = rs.getString("servico");
                String data = rs.getString("data");
                String hora = rs.getString("hora");
                boolean status = false;
                Double preco = rs.getDouble("preco");
                Object statuss = rs.getObject("status");
                String observacoes = rs.getString("observacoes");

                if (statuss.toString().equals("true")) {
                    status = true;
                }

                Agenda agenda = new Agenda(CPFCliente, placaVeiculo, CPFProfissional, servico, data, hora, status,observacoes, preco);
                agenda.setId(id);
                agendamentos.add(agenda);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return agendamentos;
    }

    public boolean usuarioJaExiste(String CPF) {

        boolean existe = false;
        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT cpf_user FROM tb_user WHERE cpf_user LIKE '" + CPF + "'");

            while (rs.next()) {
                if (rs.getString("cpf_user").equals(CPF)) {
                    System.out.println("CPF DO CARA  : " + rs.getString("cpf_user"));
                    existe = true;
                }

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return existe;

    }

    public boolean cadastrarUsuario(Usuario usuario) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_user "
                    + "("
                    + "nome_user, "
                    + "cpf_user, "
                    + "endereco_user, "
                    + "tel_user, "
                    + "email_user, "
                    + "senha_user)"
                    + "VALUES("
                    + "'" + usuario.getNome() + "', "
                    + "'" + usuario.getCpf() + "', "
                    + "'" + usuario.getEndereco() + "', "
                    + "'" + usuario.getTelefone() + "', "
                    + "'" + usuario.getEmail() + "', "
                    + "'" + usuario.getSenha() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Usuario> CarregarUser() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_user");

            while (rs.next()) {

                int id = rs.getInt("id_user");
                String nome = rs.getString("nome_user");
                String cpf = rs.getString("cpf_user");
                String endereco = rs.getString("endereco_user");
                String telefone = rs.getString("tel_user");
                String email = rs.getString("email_user");
                String senha = rs.getString("senha_user");

                Usuario usuario = new Usuario(nome, cpf, endereco, telefone, email, senha);
                usuario.setId(id);
                usuarios.add(usuario);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return usuarios;
    }

    public boolean cadastrarCliente(Cliente usuario) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_cliente "
                    + "("
                    + "nome_cli, "
                    + "cpf_cli, "
                    + "endereco_cli, "
                    + "tel_cli, "
                    + "fidelidade_cli)"
                    + "VALUES("
                    + "'" + usuario.getNome() + "', "
                    + "'" + usuario.getCpf() + "', "
                    + "'" + usuario.getEndereco() + "', "
                    + "'" + usuario.getTelefone() + "', "
                    + "'" + usuario.getFidelidade() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean clienteJaExiste(String CPF) {

        boolean existe = false;
        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT cpf_cli FROM tb_cliente WHERE cpf_cli LIKE '" + CPF + "'");

            while (rs.next()) {
                if (rs.getString("cpf_cli").equals(CPF)) {
                    System.out.println("CPF DO CARA  : " + rs.getString("cpf_cli"));
                    existe = true;
                }

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return existe;

    }

    public ArrayList<Cliente> CarregarCliente() {
        ArrayList<Cliente> clientes = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_cliente");

            while (rs.next()) {

                int id = rs.getInt("id_cli");
                String nome = rs.getString("nome_cli");
                String cpf = rs.getString("cpf_cli");
                String endereco = rs.getString("endereco_cli");
                String telefone = rs.getString("tel_cli");
                int fidelidade = rs.getInt("fidelidade_cli");

                Cliente cliente = new Cliente(nome, cpf, endereco, telefone, fidelidade);
                cliente.setId(id);
                clientes.add(cliente);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return clientes;
    }

    public boolean cadastrarProfissional(Profissional usuario) {

        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_profissional "
                    + "("
                    + "nome_prof, "
                    + "cpf_prof, "
                    + "endereco_prof, "
                    + "tel_prof, "
                    + "funcao_prof, "
                    + "salario_prof, "
                    + "ativo_prof)"
                    + "VALUES("
                    + "'" + usuario.getNome() + "', "
                    + "'" + usuario.getCpf() + "', "
                    + "'" + usuario.getEndereco() + "', "
                    + "'" + usuario.getTelefone() + "', "
                    + "'" + usuario.getFuncao() + "', "
                    + "'" + usuario.getSalario() + "', "
                    + "'" + usuario.isAtivo() + "' );");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean profissionalJaExiste(String CPF) {

        boolean existe = false;
        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT cpf_prof FROM tb_profissional WHERE cpf_prof LIKE '" + CPF + "'");

            while (rs.next()) {
                if (rs.getString("cpf_prof").equals(CPF)) {
                    System.out.println("CPF DO CARA  : " + rs.getString("cpf_prof"));
                    existe = true;
                }

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return existe;

    }

    public ArrayList<Profissional> CarregaProfissional() {
        ArrayList<Profissional> profissionais = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_profissional");

            while (rs.next()) {

                int id = rs.getInt("id_prof");
                String nome = rs.getString("nome_prof");
                String cpf = rs.getString("cpf_prof");
                String endereco = rs.getString("endereco_prof");
                String telefone = rs.getString("tel_prof");
                String funcao = rs.getString("funcao_prof");
                Double salario = rs.getDouble("salario_prof");
                
                boolean ativo = false;
                Object statuss = rs.getObject("ativo_prof");

                if (statuss.toString().equals("true")) {
                    ativo = true;
                }

                Profissional profissional = new Profissional(nome, cpf, endereco, telefone, funcao, salario);
                profissional.setAtivo(ativo);
                profissional.setId(id);
                profissionais.add(profissional);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return profissionais;
    }

    public boolean cadastrarProduto(Produto produto) {

        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_produto "
                    + "("
                    + "tipo_produto, "
                    + "descricao_produto, "
                    + "valor_produto, "
                    + "qtd_produto)"
                    + "VALUES("
                    + "'" + produto.getTipo() + "', "
                    + "'" + produto.getDescricao() + "', "
                    + "'" + produto.getValor() + "', "
                    + "'" + produto.getQuantidade() + "' );");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public ArrayList<Produto> carregaProduto() {
        ArrayList<Produto> produtos = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_produto");

            while (rs.next()) {

                int id = rs.getInt("id_produto");
                String tipo = rs.getString("tipo_produto");
                String descricao = rs.getString("descricao_produto");
                Double valor = rs.getDouble("valor_produto");
                int quantidade = rs.getInt("qtd_produto");

                Produto produto = new Produto(tipo, descricao, valor, quantidade);
                produto.setId(id);
                produtos.add(produto);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return produtos;
    }

    public boolean cadastrarPesado(Pesado veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_pesado "
                    + "("
                    + "placa_pesa, "
                    + "marca_pesa, "
                    + "modelo_pesa, "
                    + "ano_pesa, "
                    + "cor_pesa, "
                    + "eixo_pesa, "
                    + "cacamba_pesa, "
                    + "cpf_cli) "
                    + "VALUES("
                    + "'" + veiculo.getPlaca() + "', "
                    + "'" + veiculo.getMarca() + "', "
                    + "'" + veiculo.getModelo() + "', "
                    + "'" + veiculo.getAno() + "', "
                    + "'" + veiculo.getCor() + "', "
                    + "'" + veiculo.getEixos() + "', "
                    + "'" + veiculo.getCacamba() + "', "
                    + "'" + veiculo.getCPF() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Pesado> CarregaPesados() {
        ArrayList<Pesado> pesados = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_pesado");

            while (rs.next()) {

                int id = rs.getInt("id_pesa");
                String placa = rs.getString("placa_pesa");
                String marca = rs.getString("marca_pesa");
                String modelo = rs.getString("modelo_pesa");
                int ano = rs.getInt("ano_pesa");
                String cor = rs.getString("cor_pesa");
                int eixos = rs.getInt("eixo_pesa");
                String cacamba = rs.getString("cacamba_pesa");
                String CPF = rs.getString("cpf_cli");

                Pesado pesado = new Pesado(placa, marca, modelo, ano, cor, eixos, cacamba, CPF);
                pesado.setId(id);
                pesados.add(pesado);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return pesados;
    }

    public boolean cadastrarMoto(Moto veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_moto "
                    + "("
                    + "placa_mot, "
                    + "marca_mot, "
                    + "modelo_mot, "
                    + "ano_mot, "
                    + "cor_mot, "
                    + "porte_mot, "
                    + "cpf_cli) "
                    + "VALUES("
                    + "'" + veiculo.getPlaca() + "', "
                    + "'" + veiculo.getMarca() + "', "
                    + "'" + veiculo.getModelo() + "', "
                    + "'" + veiculo.getAno() + "', "
                    + "'" + veiculo.getCor() + "', "
                    + "'" + veiculo.getPorte() + "', "
                    + "'" + veiculo.getCPF() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Moto> CarregaMotos() {
        ArrayList<Moto> motos = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_moto");

            while (rs.next()) {

                int id = rs.getInt("id_mot");
                String placa = rs.getString("placa_mot");
                String marca = rs.getString("marca_mot");
                String modelo = rs.getString("modelo_mot");
                int ano = rs.getInt("ano_mot");
                String cor = rs.getString("cor_mot");
                String porte = rs.getString("porte_mot");
                String CPF = rs.getString("cpf_cli");

                Moto moto = new Moto(placa, marca, modelo, ano, cor, porte, CPF);
                moto.setId(id);
                motos.add(moto);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return motos;
    }

    public boolean cadastrarCarro(Carro veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_carro "
                    + "("
                    + "placa_car, "
                    + "marca_car, "
                    + "modelo_car, "
                    + "ano_car, "
                    + "cor_car, "
                    + "categoria_car, "
                    + "qtd_portas_car, "
                    + "cpf_cli) "
                    + "VALUES("
                    + "'" + veiculo.getPlaca() + "', "
                    + "'" + veiculo.getMarca() + "', "
                    + "'" + veiculo.getModelo() + "', "
                    + "'" + veiculo.getAno() + "', "
                    + "'" + veiculo.getCor() + "', "
                    + "'" + veiculo.getCategoria() + "', "
                    + "'" + veiculo.getPortas() + "', "
                    + "'" + veiculo.getCPF() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarCarro(Carro veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_carro"
                    + " SET "
                    + "marca_car = '" + veiculo.getMarca() + "', "
                    + "modelo_car = '" + veiculo.getModelo() + "', "
                    + "ano_car = " + veiculo.getAno() + ", "
                    + "cor_car = '" + veiculo.getCor() + "', "
                    + "categoria_car = '" + veiculo.getMarca() + "', "
                    + "qtd_portas_car = " + veiculo.getPortas() + " "
                    + "WHERE id_car = " + veiculo.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarMoto(Moto veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_moto"
                    + " SET "
                    + "marca_mot = '" + veiculo.getMarca() + "', "
                    + "modelo_mot = '" + veiculo.getModelo() + "', "
                    + "ano_mot = " + veiculo.getAno() + ", "
                    + "cor_mot = '" + veiculo.getCor() + "', "
                    + "porte_mot = '" + veiculo.getPorte() + "' "
                    + "WHERE id_mot = " + veiculo.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean apagarMoto(Moto veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_moto WHERE id_mot = " + veiculo.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean apagarCarro(Carro veiculo) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_carro WHERE id_car = " + veiculo.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Carro> CarregaCarros() {
        ArrayList<Carro> carros = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_carro");

            while (rs.next()) {

                int id = rs.getInt("id_car");
                String placa = rs.getString("placa_car");
                String marca = rs.getString("marca_car");
                String modelo = rs.getString("modelo_car");
                int ano = rs.getInt("ano_car");
                String cor = rs.getString("cor_car");
                String categoria = rs.getString("categoria_car");
                int portas = rs.getInt("qtd_portas_car");
                String CPF = rs.getString("cpf_cli");

                Carro carro = new Carro(placa, marca, modelo, ano, cor, portas, categoria, CPF);
                carro.setId(id);
                carros.add(carro);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return carros;
    }

    public boolean cadastrarMaterial(Materiap material) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("INSERT INTO tb_materialap "
                    + "("
                    + "tipo_matp, "
                    + "descricao_matp, "
                    + "qtd_matp) "
                    + "VALUES("
                    + "'" + material.getTipo() + "', "
                    + "'" + material.getDescricao() + "', "
                    + "'" + material.getQuantidade() + "'"
                    + ");");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public ArrayList<Materiap> carregaMaterial() {
        ArrayList<Materiap> materiasp = new ArrayList();

        try {

            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            ResultSet rs = statement.executeQuery("SELECT * FROM tb_materialap");

            while (rs.next()) {

                int id = rs.getInt("id_matp");
                String tipo = rs.getString("tipo_matp");
                String descricao = rs.getString("descricao_matp");
                int quantidade = rs.getInt("qtd_matp");

                Materiap materiap = new Materiap(tipo, descricao, quantidade);
                materiap.setId(id);
                materiasp.add(materiap);

            }

        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return materiasp;
    }

    public boolean atualizarAgenda(Agenda agenda) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_agenda"
                    + " SET "
                    + "placa_veiculo = '" + agenda.getPlacaVeiculo() + "', "
                    + "profissional = '" + agenda.getCPFProfissional() + "', "
                    + "servico = '" + agenda.getServico() + "', "
                    + "data = '" + agenda.getData() + "', "
                    + "hora = '" + agenda.getHora() + "', "
                    + "status = '" + agenda.isStatus() + "', "
                    + "preco = '" + agenda.getPreco() + "' "
                    + "WHERE id_agenda = " + agenda.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean atualizarPesado(Pesado pesados) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_pesado"
                    + " SET "
                    + "marca_pesa = '" + pesados.getMarca() + "', "
                    + "modelo_pesa = '" + pesados.getModelo() + "', "
                    + "ano_pesa = " + pesados.getAno() + ", "
                    + "cor_pesa = '" + pesados.getCor() + "', "
                    + "eixo_pesa = '" + pesados.getEixos() + "', "
                    + "cacamba_pesa = '" + pesados.getCacamba() + "' "
                    + "WHERE id_pesa = " + pesados.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarPesado(Pesado pesado) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_pesado WHERE id_pesa = " + pesado.getId() + ";");

            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean apagarAgenda(Agenda agenda) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_agenda WHERE id_agenda = " + agenda.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarUsuario(Usuario usuario) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_user"
                    + " SET "
                    + "nome_user = '" + usuario.getNome() + "', "
                    + "cpf_user = '" + usuario.getCpf() + "', "
                    + "endereco_user = '" + usuario.getEndereco() + "', "
                    + "tel_user = '" + usuario.getTelefone() + "', "
                    + "email_user = '" + usuario.getEmail() + "', "
                    + "senha_user = '" + usuario.getSenha() + "' "
                    + "WHERE id_user = " + usuario.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarUsuario(Usuario usuario) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_user WHERE id_user = " + usuario.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarServico(Servico servico) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_servico"
                    + " SET "
                    + "descricao_ser = '" + servico.getDescricao_servico() + "', "
                    + "preco = '" + servico.getPreco() + "' "
                    + "WHERE id_ser = " + servico.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarServico(Servico servico) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_servico WHERE id_ser = " + servico.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarProfissional(Profissional profissional) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_profissional"
                    + " SET "
                    + "nome_prof = '" + profissional.getNome() + "', "
                    + "endereco_prof = '" + profissional.getEndereco() + "', "
                    + "tel_prof = '" + profissional.getTelefone() + "', "
                    + "funcao_prof = '" + profissional.getFuncao() + "', "
                    + "salario_prof = '" + profissional.getSalario() + "', "
                    + "ativo_prof = '" + profissional.isAtivo() + "' "
                    + "WHERE id_prof = " + profissional.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarProfissional(Profissional profissional) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_profissional WHERE id_prof = " + profissional.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarProduto(Produto produto) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_produto"
                    + " SET "
                    + "descricao_produto = '" + produto.getDescricao() + "', "
                    + "valor_produto = '" + produto.getValor() + "', "
                    + "qtd_produto = " + produto.getQuantidade() + " "
                    + "WHERE id_produto = " + produto.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarProduto(Produto produto) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_produto WHERE id_produto = " + produto.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }

    public boolean atualizarCliente(Cliente cliente) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("UPDATE "
                    + "tb_cliente"
                    + " SET "
                    + "nome_cli = '" + cliente.getNome() + "', "
                    + "endereco_cli = '" + cliente.getEndereco() + "', "
                    + "tel_cli = '" + cliente.getTelefone()+ "', "
                    + "fidelidade_cli = " + cliente.getFidelidade()+ " "
                    + "WHERE id_cli = " + cliente.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;

    }

    public boolean apagarCliente(Cliente cliente) {
        try {
            // Cria a conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:sqlite:baseDrivefy4.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar

            // Roda os comandos para o SQLite            //statement.executeUpdate("CREATE TABLE Pessoas (id INTEGER, name STRING, cpf STRING)");
            statement.executeUpdate("DELETE FROM tb_cliente WHERE id_cli = " + cliente.getId() + ";");
            return true;
        } catch (SQLException e) {
            // Se a mensagem de erro for: "out of memory",
            // Provavelmente erro ao criar(permissão) ou caminho do banco de dados
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }

        return false;
    }
}
