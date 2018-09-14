import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Brannon\\Development\\untitled\\src\\datafile.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {

                if(index > 1) {
                    stringBuffer.append(line);
                    stringBuffer.append("\n");
                }
                index++;
            }
            fileReader.close();

            String[] myString = stringBuffer.toString().split(Pattern.quote("|\n"));

            List<String> favs = new ArrayList<>();

            for(String cool : myString){

                String[] array = cool.split("\n");
                String name = array[0].split(Pattern.quote(":"))[1];
                String favorite = array[1].split(Pattern.quote(":"))[1];

                Favorite fav = new Favorite();
                fav.setName(name);
                fav.setFavorite(favorite);

                favs.add(jaxbObjectToXML(fav));
            }

            for(String fav : favs){
                System.out.println(fav);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String jaxbObjectToXML(Favorite customer) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Favorite.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            StringWriter sw = new StringWriter();
            m.marshal(customer, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}
