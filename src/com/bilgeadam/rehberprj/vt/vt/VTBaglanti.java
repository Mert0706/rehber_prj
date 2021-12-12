package com.bilgeadam.rehberprj.vt.vt;

import java.sql.*;

public class VTBaglanti {

    public static Connection baglantiGetir() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection conn =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/rehber","postgres","postgres");

        return conn;

    }


    public static void baglantiKapat (Connection conn) throws SQLException {
       conn.close();

    }


}
