
import java.io.*;
import java.util.StringTokenizer;

public class BST {
    //  Estructura de BST por Derek Banas
    //  http://www.newthinktank.com/2013/03/binary-tree-in-java/

    static final String archivo = "diccionario.txt";
    static final String texto = "texto.txt";
    static final String delim = "(,)\t\n ";

    Node root;





    public static void main(String[] args)throws IOException{
        StringTokenizer tokenizer = new StringTokenizer(getDataFile(archivo), delim);
        BST tree = new BST();
//        System.out.println(System.getProperty("user.dir"));
        while(tokenizer.hasMoreTokens()){
            //  popular arbol
            Association<String, String> n = new Association<String, String>(tokenizer.nextToken(), tokenizer.nextToken());
            tree.addNode(n);
        }

        //  In-Order
        //  LEFT -> ROOT -> RIGHT
        inOrder(tree.root);

        //  ahora cargar archivo
        System.out.println();
        tokenizer = new StringTokenizer(getDataFile(texto), delim);
        while(tokenizer.hasMoreTokens()){
            //  popular arbol
            Association d = new Association(tokenizer.nextToken(), "");
            tree.findNode(d);
        }

    }

    public void addNode(Association data){
        Node new_node = new Node(data);

        if (root == null){
            //  si esta vacio mi nodo no tiene hijos por lo tanto es mi siguiente nodo a llenar
            root = new_node;
        } else {
            Node focusNode = root;
            Node parent;

            while (true){
                parent = focusNode;

                if (data.compareTo(focusNode.getData()) == -1){
                    focusNode = focusNode.getLeft();
                    return;
                } else {
                    focusNode = focusNode.getRight();
                    if (focusNode == null){
                        parent.setRight(new_node);
                        return;
                    }
                }
            }
        }

    }

    static void inOrder(Node n){
        if (n != null){
            inOrder(n.getLeft());
            System.out.print(n + " ");
            inOrder(n.getRight());
        }
    }

    public Node findNode(Association data){
        Node focusNode = root;
        while(focusNode.getData().compareTo(data) != 0){
            //  mientras no son iguales no ha encontrado el nodo
            if (data.compareTo(focusNode.getData()) == -1){
                //  es menor
                focusNode = focusNode.getLeft();

            } else {
                focusNode = focusNode.getRight();
            }
            if (focusNode == null){
                //  empty node, no se encontro
                System.out.print("*" + data.getKey() + "*");
                return null;
            }

        }
        return focusNode;
    }

    private static String getDataFile(String archivo) throws IOException, FileNotFoundException{

        BufferedReader reader;
        File file;
        String linea, datos = "";
        try{
            if((new File(archivo)).exists()){ //verificamos que el archivo exista


                reader = new BufferedReader(new FileReader(archivo));

                while((linea = reader.readLine()) != null){
                    // Guardamos cada valor/token en minusculas
                    datos += linea.toLowerCase() + "\t";
                }

                reader.close();
            }
            else{
                System.out.println("El archivo ingresado no fue encontrado.");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return datos;
    }
}
