package jdbcproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ItemDAO {

    // add item
    public void addItem(Item i) {

        try {

            Connection con = DBConnection.getConnection();

            String q = "insert into items(item_name,description,location_found,status) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, i.itemName);
            ps.setString(2, i.description);
            ps.setString(3, i.location);
            ps.setString(4, i.status);

            ps.executeUpdate();

            System.out.println("Item added");

        } catch (Exception e) {

            System.out.println(e);

        }
    }


    // view items
    public void viewItems() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from items");

            System.out.println("\nItems in system:\n");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("item_name");
                String desc = rs.getString("description");
                String loc = rs.getString("location_found");
                String status = rs.getString("status");

                System.out.println(id + " | " + name + " | " + desc + " | " + loc + " | " + status);
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }


    // update status
    public void updateStatus(int id, String status) {

        try {

            Connection con = DBConnection.getConnection();

            String q = "update items set status=? where id=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, status);
            ps.setInt(2, id);

            int r = ps.executeUpdate();

            if (r > 0)
                System.out.println("Status changed");
            else
                System.out.println("Item not found");

        } catch (Exception e) {

            System.out.println(e);

        }
    }


    // delete item
    public void deleteItem(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String q = "delete from items where id=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, id);

            int r = ps.executeUpdate();

            if (r > 0)
                System.out.println("Item deleted");
            else
                System.out.println("Item not found");

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}