package com.example.cinema.dao;



import com.example.cinema.model.LichSu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LichSuDAO extends AbstractDAO{
    public List<LichSu> getLichSuByIDUser(int idUser){
        List<LichSu> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            connection = AbstractDAO.getConnection();
            String sql = "select  GIA_VE, h.NGAY_MUA, p.TEN_PHIM, GHE_SO  from suatchieu\n" +
                    "    inner join ve v on suatchieu.ID_SUATCHIEU = v.ID_SUATCHIEU\n" +
                    "                    inner join phim p on suatchieu.ID_PHIM = p.ID_PHIM\n" +
                    "                    inner join hoadon h on v.ID_HOADON = h.ID_HOADON\n" +
                    "                    inner join ghe g on v.ID_GHE = g.ID_GHE\n" +
                    "                    where h.ID_USER = ?\n" +
                    "                    order by h.ID_HOADON desc";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, idUser);
            rs = pstm.executeQuery();
            while(rs.next()){
                LichSu lichSu = new LichSu();
                lichSu.setTenPhim(rs.getString("TEN_PHIM"));
                lichSu.setNgayMua(rs.getString("NGAY_MUA"));
                lichSu.setGiaVe(rs.getInt("GIA_VE"));
                lichSu.setSoGhe(rs.getInt("GHE_SO"));
                list.add(lichSu);

            }
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(connection != null){
                    connection.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return null;
    }
}
