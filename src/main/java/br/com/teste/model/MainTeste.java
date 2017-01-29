package br.com.teste.model;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import br.com.teste.util.JsonUtil;

public class MainTeste {
    
    private static JsonUtil jsonUtil = new JsonUtil();

    public static void main(String[] args) {
        
        System.out.println("conteudo do Objeto Json criado : " + criarObjetoJsonComClassePessoa(retornaUmaPessoaQualquer()));
        
        System.out.println("");
        
        System.out.println("conteudo do Objeto Json criado : " + criarObjetoJsonComUmaString("{\"nome\":\"João Espindola\",\"anoNascimento\":1998,\"genero\":\"Masculino\"}"));
        
        System.out.println("");
        
        System.out.println("conteudo do Objeto Json criado : " + criarObjetoJsonComMap(retornaUmMapComUmaInformacaoQualquer()));
        
        System.out.println("");
        
        criarUmArquivoJsonComUmMap(retornaUmMapComUmaInformacaoQualquer(), null, "teste.json");
        
        System.out.println("");
        
        criarUmArquivoJsonComClassePessoa(retornaUmaPessoaQualquer(), null, "teste2.json");
        
    }
    
    private static void criarUmArquivoJsonComClassePessoa(Pessoa pessoa, String pathAndFileName, String fileName){
        jsonUtil.createFileJSON(pessoa, pathAndFileName, fileName);
    }
    
    private static void criarUmArquivoJsonComUmMap(Map<String, String> parameters, String pathAndFileName, String fileName){
        jsonUtil.createFileJSON(parameters, pathAndFileName, fileName);
    }
    
    private static JSONObject criarObjetoJsonComMap(Map<String, String> map){
        return jsonUtil.createObjectJSON(map);
    }
    
    private static JSONObject criarObjetoJsonComUmaString(String textoJson){
        return jsonUtil.createObjectJSON(textoJson);
    }
    
    private static JSONObject criarObjetoJsonComClassePessoa(Pessoa pessoa){
        return jsonUtil.createObjectJSON(pessoa);
    }
    
    private static Pessoa retornaUmaPessoaQualquer(){
        Pessoa pessoa = new Pessoa();
        pessoa.setPaisNascimento("Brasil");
        pessoa.setNome("Fulano de tal");
        pessoa.setGenero("Masculino");
        pessoa.setIdade(26);
        return pessoa;
    }
    
    private static Map<String, String> retornaUmMapComUmaInformacaoQualquer(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("nomeDopai", "Jose");
        map.put("nomeDaMae", "Maria");
        map.put("nomeDaEsposa", "Não Possui");
        map.put("nomeDaAvo", "Matheus");
        map.put("nomeDoCachorro", "Doguinho");
        return map;
    }
    
}
