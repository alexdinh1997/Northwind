package fi.vamk.e1800935.northwind; //your package

import java.io.File;
import java.io.FileWriter;

public class generateControllerandRepository {
    private static File file = new File("U:/Mysql/northwind/src/main/java/fi/vamk/e1800935/northwind"); //your folder
    //Create the file
    public static void checkAndGetFileName(File file) {
        for(File checkFile : file.listFiles()){
            if (checkFile.isDirectory()) {checkAndGetFileName(checkFile);}
            else
                if(checkFile.isFile()){
                    String name = checkFile.getName();
                    String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
                    if(extension.equals("java")) {
                        String newFileName = name.substring(0, name.lastIndexOf('.'));
                        if(!newFileName.equals("generateControllerandRepository") && !newFileName.equals("NorthwindApplication") && !newFileName.contains("Controller") && !newFileName.contains("Repository")){
                            createRepository(newFileName);
                            createController(newFileName);
                        }
                    }
                }
        }
    }

    public static void createRepository(String name){
        try {
            File fileRepo = new File(file + "/" + name + "Repository.java");
            FileWriter write = new FileWriter(fileRepo);

            write.write("package fi.vamk.e1800935.northwind;\n\n");
            write.write("import org.springframework.data.repository.CrudRepository;\n");
            write.write("public interface " + name + "Repository extends " + "CrudRepository<" + name + ", Integer> {\n\n}");
            write.close();
        }
        catch(Exception e){
            System.out.println("File exists");
        }
    }

    public static void createController(String name){
        try {
            File fileCon = new File(file + "/" + name + "Controller.java");
            FileWriter write = new FileWriter(fileCon);
            //import library
            write.write("package fi.vamk.e1800935.northwind;\n\n");
            write.write("import java.util.Optional;\n\n");
            write.write("import org.springframework.beans.factory.annotation.Autowired;\n");
            write.write("import org.springframework.http.MediaType;\n");
            write.write("import org.springframework.web.bind.annotation.RequestMapping;\n");
            write.write("import org.springframework.web.bind.annotation.RequestMethod;\n");
            write.write("import org.springframework.web.bind.annotation.RequestParam;\n");
            write.write("import org.springframework.web.bind.annotation.PathVariable;\n");
            write.write("import org.springframework.web.bind.annotation.RestController;\n");
            write.write("import org.springframework.web.bind.annotation.PathVariable;\n");
            write.write("import org.springframework.web.bind.annotation.RequestBody;\n");
            write.write("import org.springframework.web.bind.annotation.ResponseBody;\n");
            //class
            write.write("public class " + name + "Controller {\n");
            write.write("\t@Autowired\n");
            write.write("\tprivate " + name + "Repository repository;\n");
            //Post method
            write.write("\t@RequestMapping(value = \"/" + name + "\", method = RequestMethod.POST)\n");
            write.write("\tpublic @ResponseBody " + name + " create(@RequestBody final " + name + " item) {\n");
            write.write("\t\treturn repository.save(item);\n\t}\n\n");
            //Get method
            write.write("\t@RequestMapping(value = \"/" + name + "\", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)\n");
            write.write("\tpublic Iterable<" + name + "> orderDetails(@RequestParam(value = \"name\", defaultValue = \"World\") final String name) {\n");
            write.write("\t\treturn repository.findAll();\n\t}\n\n");
            //GetById method
            write.write("\t@RequestMapping(value = \"/" + name + "/{id}\", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)\n");
            write.write("\tpublic Optional<" + name + "> get(@PathVariable(\"id\") final int id) {\n");
            write.write("\t\treturn repository.findById(id);\n\t}\n\n");
            //Put method
            write.write("\t@RequestMapping(value = \"/" + name + "\", method = RequestMethod.PUT)\n");
            write.write("\tpublic @ResponseBody " + name + " update(@RequestBody " + name + " item) {\n");
            write.write("\t\treturn repository.save(item);\n\t}\n\n");
            //Delete method
            write.write("\t@RequestMapping(value = \"/" + name + "\", method = RequestMethod.DELETE)\n");
            write.write("\tpublic void delete(@RequestBody " + name + " item) {\n");
            write.write("\t\trepository.delete(item);\n\t}\n\n}");
            write.close();
            
        }
        catch(Exception e){
            System.out.println("File exists");
        }
    }
    public static void main(String[] args) {
        checkAndGetFileName(file);
    }
}