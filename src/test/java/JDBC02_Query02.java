import java.sql.*;

public class JDBC02_Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1-Ilgili driver'i yüklemeliyiz.Msql kullandigimizi bildiriyoruz.
        // Driver'i bulamama ihtimaline karsi  forName metodu icin ClassNotFoundException
        // method signature'imiza exception olarak firlatmamizi istiyor.

        Class.forName("com.mysql.cj.jdbc.Driver");

        //2-Baglantiyi olusturmak icin username ve password girmeliyiz.
        // Burada da bu username ve password'un yanlis olma ihtimaline karsi
        //SQLException firlatmamizi istiyor.

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                "root", "1234");
        //Select * from ogrenciler;
        //3-SQL query'leri icin bir Statement objesi olusturup,javada sql sorgularimiz icin bir alan acacagiz.

        Statement st = con.createStatement();
        // 4-SQL query'lerimizi yazip calistirabiliriz.
        ResultSet veri = st.executeQuery("select * from isciler");
        // 5-Sonuclari görmek icin Iteration ile Set icerisindeki elemanlari while döngusu ile yazdiriyoruz.

        while (veri.next()) {

            System.out.println(veri.getInt(1) + " " + veri.getString(2) + " " + veri.getString(3) +
                    " " + veri.getInt(4) + " " + veri.getString(5));
        }
        //6-Olusturdugumuz nesneleri kapatalim

        st.close();
        con.close();
        veri.close();
    }

}
