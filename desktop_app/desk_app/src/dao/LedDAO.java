package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;

public class LedDAO {

    public static void atualizarEstadoLedMaster(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_1 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }
    
    public static void atualizarEstadoLedQuarto1(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_2 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedSala(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_3 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                System.err.println("A conexão está fechada antes da atualização. Método: atualizarEstadoLedSala");
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedBanheiro(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_4 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedSalaDeJantar(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_5 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedSalaDeEstar(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_6 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedCozinha(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_7 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedLavabo(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_8 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedLavanderia(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_9 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedJardim1(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_10 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedJardim2(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_11 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedJardim3(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_12 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }

    public static void atualizarEstadoLedJardim4(int id_cliente, boolean estado) {
        String sql = "UPDATE ClienteLeds SET led_13 = ? WHERE id_cliente = ?";

        try (Connection connection = Conexao.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            if (connection.isClosed()) {
                return;
            }

            int valorLed = estado ? 1 : 0;
            ps.setInt(1, valorLed);
            ps.setInt(2, id_cliente);
            ps.executeUpdate();
            System.out.println("Atualização do estado do LED na sala bem-sucedida. ID CLIENTE: " + id_cliente);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao tentar atualizar o estado do LED na sala.");
        }
    }
}
