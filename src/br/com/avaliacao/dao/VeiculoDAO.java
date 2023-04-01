/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.dao;
import java.sql.*;
import br.com.avaliacao.dto.VeiculoDTO;

/**
 *
 * @author Renan
 */
public class VeiculoDAO {
    public VeiculoDAO(){
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirVeiculo(VeiculoDTO veiculoDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "INSERT INTO veiculo (modelo_vei, cor_vei, fabricante_vei, placa_vei, proprietario_vei, motor_vei, ano_vei, nro_portas_vei) VALUES " +
                    "('" + veiculoDTO.getModelo_vei() + "', '" + veiculoDTO.getCor_vei() + "', '" + veiculoDTO.getFabricante_vei() + "', '" + veiculoDTO.getPlaca_vei() + "','" + veiculoDTO.getProprietario_vei() + "', '" + veiculoDTO.getMotor_vei() + "', '" + veiculoDTO.getAno_vei() + "','" +
                    veiculoDTO.getNro_portas_vei() + "')";
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarVeiculo(VeiculoDTO veiculoDTO,int opcao){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
           switch(opcao){
               case 1:
                   comando = "select c.* from veiculo c where placa_vei like '" + veiculoDTO.getPlaca_vei() + "%' order by c.placa_vei"; 
                   break;
               case 2:
                   comando = "select c.* from veiculo c where c.id_vei = " + veiculoDTO.getId_vei();
                   break;
               case 3:
                   comando = "select c.id_vei, c.placa_vei from veiculo c ";
                   break;
           }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarVeiculo(VeiculoDTO veiculoDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "UPDATE veiculo SET modelo_vei = '" + veiculoDTO.getModelo_vei() + "', cor_vei = '" + veiculoDTO.getCor_vei() + "', fabricante_vei = '" + veiculoDTO.getFabricante_vei() + "', placa_vei = '" + veiculoDTO.getPlaca_vei() + "', proprietario_vei = '" + veiculoDTO.getProprietario_vei() + "', motor_vei = '" + veiculoDTO.getMotor_vei() + "', ano_vei = '" + veiculoDTO.getAno_vei() + "', nro_portas_vei = '" + veiculoDTO.getNro_portas_vei() + "' WHERE id_vei = " + veiculoDTO.getId_vei();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirVeiculo(VeiculoDTO veiculoDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "DELETE FROM veiculo WHERE id_vei = " + veiculoDTO.getId_vei();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConexaoDAO.CloseDB();
        }

    }
}
