/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao.ctr;
import br.com.avaliacao.dao.ConexaoDAO;
import java.sql.ResultSet;
import br.com.avaliacao.dto.VeiculoDTO;
import br.com.avaliacao.dao.VeiculoDAO;

/**
 *
 * @author Renan
 */
public class VeiculoCTR {
    VeiculoDAO veiculoDAO = new VeiculoDAO();
    
    public VeiculoCTR(){}
    
    public String inserirVeiculo(VeiculoDTO veiculoDTO){
        try{
            if(veiculoDAO.inserirVeiculo(veiculoDTO)){
                return "VEÍCULO CADASTRADO COM SUCESSO!";
            }else{
                return "VEÍCULO NÃO CADASTRADO!";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "VEICULO NÃO CADASTRADO!";
        }
    }
    
    public String excluirVeiculo(VeiculoDTO veiculoDTO){
        try{
            if(veiculoDAO.excluirVeiculo(veiculoDTO)){
                return "VEÍCULO EXCLUIDO COM SUCESSO!";
            }else{
                return "VEÍCULO NÃO EXCLUIDO!";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "VEICULO NÃO EXCLUIDO!";
        }
    }
    
    public ResultSet consultarVeiculo(VeiculoDTO veiculoDTO, int opcao){
        ResultSet rs = null;
        rs = veiculoDAO.consultarVeiculo(veiculoDTO, opcao);
        
        return rs;
    }
    
    public String alterarVeiculo(VeiculoDTO veiculoDTO){
        try{
            if(veiculoDAO.alterarVeiculo(veiculoDTO)){
                return "VEICULO ALTERADO COM SUCESSO!!";
            }else{
                return "VEICULO NÃO ALTERADO!";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "VEICULO NÃO ALTERADO!";
        }
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
