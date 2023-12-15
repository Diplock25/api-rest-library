package com.diplock.library.queriesdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.swing.JOptionPane;

public class ConsultasDB {
	
	private ConsultasDB() {}
	
	private static String colorVerde(Object x) {
		return "\u001B[92m" + x + "\u001B[0m";
	}
	
	private static String colorCyanAqua(Object x) {
	    return "\u001B[36m" + x + "\u001B[0m";
	}
	
	private static String colorAmarillo(Object x) {
	    return "\u001B[33m" + x + "\u001B[0m";
	}
	
	public static void mostrarTablas(Connection conn) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SHOW tables;");
		    int numberTable = 1; 
		    		
		    while (rs.next()) {
		        String tableName = rs.getString(1);
		        System.out.println("Tabla " + numberTable + ": " + colorCyanAqua(tableName));
		        numberTable++;  
		    }
		    
		    rs.close();
		    stmt.close();
		    conn.close();
		} catch (SQLException e) {
			System.err.println("Error al obtener las tablas: " + e.getMessage());
		}
	}
	
	public static void consultarTabla(Connection conn, String nombreTabla) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM " + nombreTabla);
		    
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnCount = rsmd.getColumnCount();
		    int numberRow = 1;
		    while (rs.next()) {
		    	System.out.print(colorCyanAqua("Registro "+ numberRow + " ==> " + colorAmarillo("["))); 
		        for (int i = 1; i <= columnCount; i++) {
		            String columnName = rsmd.getColumnName(i);
		            String columnValue = rs.getString(i);
		            System.out.print(colorVerde(columnName + ": ") + columnValue + ", ");
		        }
		        System.out.print(colorAmarillo("]"));
		        System.out.println();
		        numberRow++;
		    }
		    
		    
		    rs.close();
		    stmt.close();
		    conn.close();
		} catch (SQLException e) {
			System.err.println("Error al obtener las tablas: " + e.getMessage());
		}
	}
	
	public static void crearTabla(Connection conn, String nombreTabla, String columnas) throws SQLException {
	    Statement stmt = conn.createStatement();
	    String sql = "CREATE TABLE " + nombreTabla + " (" + columnas + ")";
	    stmt.executeUpdate(sql);
	    System.out.println("La tabla " + nombreTabla + " ha sido creada exitosamente.");
	    stmt.close();
	}
	
	public static void eliminarTabla(Connection conn, String nombreTabla) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
		    String sql = "DROP TABLE " + nombreTabla;
		    stmt.executeUpdate(sql);
		    System.out.println(colorVerde("La tabla " + nombreTabla + " ha sido eliminada exitosamente."));
	    
		    stmt.close();
		    conn.close();
		} catch (SQLException e) {
			System.err.println("Error al obtener las tablas: " + e.getMessage());
		}
	}
	
	
	public void actualizarTabla(Connection conn, String nombreTabla, String columna, String nuevoValor, String condicion) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
		    String sql = "UPDATE " + nombreTabla + " SET " + columna + " = '" + nuevoValor + "' WHERE " + condicion;
		    stmt.executeUpdate(sql);
		    System.out.println("La tabla " + nombreTabla + " ha sido actualizada exitosamente.");
		    stmt.close();	
		} catch (SQLException e) {
			System.err.println("Error al actualizar la tabla: " + e.getMessage());
		}
	}
	
	public void actualizarTabla(Connection connection, String tabla, Map<String, Object> valores, String condicion) throws SQLException {
		try {
			String consulta = "UPDATE " + tabla + " SET ";
		    for (String campo : valores.keySet()) {
		        consulta += campo + " = ?, ";
		    }
		    consulta = consulta.substring(0, consulta.length() - 2);
		    consulta += " WHERE " + condicion;

		    PreparedStatement stmt = connection.prepareStatement(consulta);

		    int i = 1;
		    for (Object valor : valores.values()) {
		    	stmt.setObject(i++, valor);
		    }

		    int filasAfectadas = stmt.executeUpdate();
		    System.out.println(filasAfectadas + " filas afectadas.");
		    
		    stmt.close();
		} catch (Exception e) {
			System.err.println("Error al actualizar la tabla: " + e.getMessage());
		}
	    
	}
	
	public void eliminarRegistros(Connection conn, String nombreTabla, String columna, String nuevoValor, String condicion) throws SQLException {
	    try {
	    	String sql = "DELETE FROM " + nombreTabla + " WHERE " + condicion;
	    	PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.executeUpdate(sql);
		    System.out.println("La tabla " + nombreTabla + " ha sido actualizada exitosamente.");
		    stmt.close();
	    } catch (SQLException e) {
	    	System.err.println("Error al eliminar registros: " + e.getMessage());
		}
	}
	
	public static void borrarRegistros(Connection conn, String nombreTabla) {
  	  String sql = "DELETE FROM " + nombreTabla;

  	  int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar todos los registros de la tabla " + nombreTabla + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

  	  if (respuesta == JOptionPane.YES_OPTION) {
  	    try (Statement stmt = conn.createStatement()) {
  	      stmt.executeUpdate(sql);
  	    } catch (SQLException e) {
  	      e.printStackTrace();
  	    }
  	  }
  	}
  
	public static void main(String[] args) throws SQLException{
		
		MiConexion con = new MiConexion();
		Connection conn = con.getConnection();

		ConsultasDB.mostrarTablas(conn);
	}
	
}