package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionHelper {
	
	private static Connection conexao = null;
    private PreparedStatement prepStement = null;
	private Object[] bind;
	private String sql;

	/**
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public void conecta() {
        try {
        	Context contextInicial = new InitialContext();
        	Context env = (Context) contextInicial.lookup("java:comp/env");
        	DataSource datasource = (DataSource) env.lookup("jdbc/fa7");

        	if(conexao != null && !conexao.isClosed()){
        		conexao.close();
        	}
            conexao = datasource.getConnection();
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }


    /**
     *
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public int getRowCount() {
    	
    	ResultSet result = execSQL(sql, bind);
        if (result != null) {
            try {
            	int count = 0;
                while (result.next()) {
                	count++;
                }
                return count;
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public ResultSet execSQL(String sql, Object[] bind) {
    	
    	this.sql = sql;
    	this.bind = bind;

        try {
            if (conexao == null || conexao.isClosed()) {
                conecta();
            }
            if (sql == null) {
                return null;
            }

            prepStement = conexao.prepareStatement(sql);

            if (bind != null) {
                for (int i = 0; i < bind.length; i++) {
                    prepStement.setObject(i + 1, bind[i]);
                }
            }
            return prepStement.executeQuery();

        } catch (SQLException e) {
        	e.printStackTrace();
        	return null;
        }
    }


    /**
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public ResultSet execSQL(String sql) {
        return execSQL(sql, null);
    }

    /**
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public boolean execUpdate(String sql, Object[] bind) {
        try {
            if (conexao == null || conexao.isClosed()) {
                conecta();
            }
            prepStement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (bind != null) {
                for (int i = 0; i < bind.length; i++) {
                    prepStement.setObject(i + 1, bind[i]);
                }
            }
            return prepStement.executeUpdate() == 1;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }
    
    
    public int getGeneratedKeys() {
    	ResultSet keys;
		try {
			keys = prepStement.getGeneratedKeys();
			while(keys.next()){
				return keys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

    /**
     * @author Jackson Castro
     * @since 2013-03-31
     */
    public boolean execUpdate(String sql) {
        return execUpdate(sql, null);
    }

    /**
     *
     * @return @throws SQLException
     */
    public boolean testConexao() throws SQLException {
        conecta();
        if (conexao != null) {
            return true;
        } else {
            return false;
        }
    }

    public Connection getConnection() {
        return conexao;
    }
}