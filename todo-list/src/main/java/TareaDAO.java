
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {
    private static final String URL = "jdbc:sqlite:tasks.db";

    public TareaDAO() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            String sql = "CREATE TABLE IF NOT EXISTS tareas (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "nombre TEXT NOT NULL, " +
                         "descripcion TEXT, " +
                         "completada INTEGER DEFAULT 0" +
                         ");";
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarTarea(String nombre, String descripcion) {
        String sql = "INSERT INTO tareas(nombre, descripcion) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerTareas() {
        List<String> tareas = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion, completada FROM tareas";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                tareas.add(rs.getInt("id") + ": " + rs.getString("nombre") +
                           " - " + rs.getString("descripcion") +
                           (rs.getInt("completada") == 1 ? " [COMPLETADA]" : ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }
}
