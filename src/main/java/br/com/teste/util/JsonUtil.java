package br.com.teste.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;

public class JsonUtil {

    private boolean parameterValid;
    private JSONObject jsonObject;
    private Iterator<?> iterator;
    private String nomeArquivo;
    
    
    public void createFileJSON(Object clazz, String pathAndFileName, String fileName) {

        this.jsonObject = new JSONObject(clazz);
        this.nomeArquivo = null;
        this.parameterValid = false;

        try {

            if (pathAndFileName != null && !pathAndFileName.trim().equals("") || fileName != null && !fileName.trim().equals("")) {
                throw new IllegalArgumentException("Preencha o parametro fileName 'nome do arquivo' ou nome do caminho e nome do arquivo 'pathAndFileName'");
            } else {
                parameterValid = true;
            }

            if (pathAndFileName != null && !pathAndFileName.trim().equals("") || fileName != null && !fileName.trim().equals("")) {
                nomeArquivo = pathAndFileName != null ? pathAndFileName : fileName;
            }

            if (parameterValid) {
              //Escreve no arquivo conteudo do Objeto JSON
                FileWriter writeFile = new FileWriter(nomeArquivo);
                writeFile.write(jsonObject.toString());
                writeFile.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void createFileJSON(Map<String, String> parameters, String pathAndFileName, String fileName) {

        this.iterator = parameters.entrySet().iterator();
        this.jsonObject = new JSONObject();
        this.nomeArquivo = null;
        this.parameterValid = false;

        try {
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) iterator.next();
                jsonObject.put(entry.getKey(), entry.getValue());
            }

            if (pathAndFileName != null && !pathAndFileName.trim().equals("") || fileName != null && !fileName.trim().equals("")) {
                throw new IllegalArgumentException("Preencha o parametro fileName 'nome do arquivo' ou nome do caminho e nome do arquivo 'pathAndFileName'");
            } else {
                parameterValid = true;
            }

            if (pathAndFileName != null && !pathAndFileName.trim().equals("") || fileName != null && !fileName.trim().equals("")) {
                nomeArquivo = pathAndFileName != null ? pathAndFileName : fileName;
            }

            if (parameterValid) {
              //Escreve no arquivo conteudo do Objeto JSON
                FileWriter writeFile = new FileWriter(nomeArquivo);
                writeFile.write(jsonObject.toString());
                writeFile.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonObject);
    }

    /**
     * 
     * Cria um {@link JSONObject} com os parametros contidos no {@link Map}
     * 
     * @param object
     * @return JSONObject
     */
    public JSONObject createObjectJSON(Map<String, String> parameters) {

        Iterator<?> iterator = parameters.entrySet().iterator();

        JSONObject jsonObject = new JSONObject();

        while (iterator.hasNext()) {

            @SuppressWarnings("unchecked")
            Map.Entry<String, String> entry = (Entry<String, String>) iterator.next();
            jsonObject.put(entry.getKey(), entry.getValue());
            
        }

        return jsonObject;
    }

    /**
     * 
     * Cria um {@link JSONObject} atraves de uma {@link String}
     * 
     * @param object
     * @return JSONObject
     */
    public JSONObject createObjectJSON(String json_str) {
        return new JSONObject(json_str);
    }

    /**
     * 
     * Cria um {@link JSONObject} atraves de um {@link Object}
     * 
     * @param object
     * @return JSONObject
     */
    public JSONObject createObjectJSON(Object object) {
        return new JSONObject(object);
    }

}
