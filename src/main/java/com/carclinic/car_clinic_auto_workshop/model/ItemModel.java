package com.carclinic.car_clinic_auto_workshop.model;

import com.carclinic.car_clinic_auto_workshop.db.DbConnection;
import com.carclinic.car_clinic_auto_workshop.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.carclinic.car_clinic_auto_workshop.constant.Query.*;

public class ItemModel {

    public boolean saveItem(ItemDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(SAVE_ITEM);

        statement.setString(1, dto.getItemId());
        statement.setString(2, dto.getModel());
        statement.setString(3, dto.getDescription());
        statement.setDouble(4, dto.getUnitPrice());
        statement.setInt(5, dto.getQtyOnHand());

        return statement.executeUpdate() > 0;
    }

    public boolean updateItem(ItemDTO dto) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_ITEM);

        statement.setString(1, dto.getModel());
        statement.setString(2, dto.getDescription());
        statement.setDouble(3, dto.getUnitPrice());
        statement.setInt(4, dto.getQtyOnHand());
        statement.setString(5, dto.getItemId());

        return statement.executeUpdate() > 0;
    }

    public boolean deleteItem(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_ITEM);

        statement.setString(1, id);

        return statement.executeUpdate() > 0;
    }

    public ItemDTO searchItem(String id) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection ();
        PreparedStatement statement = connection.prepareStatement(SEARCH_ITEM);
        
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        ItemDTO dto = null;

        if(resultSet.next()) {
            String item_id = resultSet.getString(1);
            String item_model = resultSet.getString(2);
            String description = resultSet.getString(3);
            Double unit_price = resultSet.getDouble(4);
            int qty_on_hand = resultSet.getInt(5);

            dto = new ItemDTO(item_id, item_model, description, unit_price, qty_on_hand);
        }
        return dto;
    }

    public List<ItemDTO> getAllItem() throws SQLException {
        
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(LOAD_ALL_ITEM);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<ItemDTO> ItemDtoList = new ArrayList<>();

        while(resultSet.next()) {
            ItemDtoList.add(
                    new ItemDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getInt(5)
                    )
            );
        }
        return ItemDtoList;
    }
}
