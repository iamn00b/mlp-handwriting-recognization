import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*
    how to use:
    java MLPinput <file destination>
*/
public class MLPinput{
    public static ArrayList<Integer> arrLabel = new ArrayList<Integer>(); //data label
    public static ArrayList<ArrayList> arrData = new ArrayList<ArrayList>(); //data pixel array 2D
    public static ArrayList<Boolean> arrIsDiff = new ArrayList<Boolean>();

    public static ArrayList[] read(String path){
        BufferedReader br = null;
        String[] input = new String[2];
        try {    
            br = new BufferedReader(new FileReader(path));
            br.readLine(); // buang line pertama
            String[] arrInput;
            String currentLine; 
            while((currentLine = br.readLine()) != null){
                //System.out.println(currentLine);
                ArrayList<Integer> arrInnerData = new ArrayList<Integer>();
                arrInput = currentLine.split(",");
                for(int ii =0; ii<arrInput.length; ii++){
                    if(ii==0)
                        arrLabel.add(Integer.parseInt(arrInput[ii]));
                    else
                        arrInnerData.add(Integer.parseInt(arrInput[ii]));
                }
                arrData.add(arrInnerData);
            }
            arrData = preprocessing(arrData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        ArrayList[] output = new ArrayList[2];
        output[0] = arrLabel;
        output[1] = arrData;
        return output;

    }

    
    //buat debug print array label
    public static void printLabel(ArrayList<Integer> arr){
        for(Integer item : arr){
            System.out.print(item+" ");
        }
    }

    //buat debug print array data
    public static void printData(ArrayList<ArrayList> arr){
        for(ArrayList<Integer> row : arr){
            for(Integer col : row)
                System.out.print(col+" ");
            System.out.println();
        }
    }

    public static ArrayList preprocessing(ArrayList<ArrayList> arr){
        int limit = arr.get(0).size();

        for(int i = 0; i < limit; i++){
            arrIsDiff.add(checkColumn(arr, i));
        }

        ArrayList<ArrayList> arrNewData = new ArrayList<ArrayList>(); //data pixel array 2D
<<<<<<< HEAD
        for(int i = 0; i < limit; i++){
=======
        for(int i = 0; i < arr.size(); i++){
>>>>>>> 166a3d4100919420d47c3797d63060f931e59b21
            ArrayList<Integer> row  = arr.get(i);
            
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            for (int j = 0; j < row.size(); j++){
                if(arrIsDiff.get(j)){
                    newRow.add(row.get(j));
                }
            }
            arrNewData.add(newRow);   
        }
        //printData(arrNewData);
        return arrNewData;
    }

    public static void deleteColumn(ArrayList<ArrayList> arr, Integer col){
        for(ArrayList row : arr){
           arr.remove(col);
        }
    }

    public static boolean checkColumn(ArrayList<ArrayList> arr, Integer col){
        boolean isDiff = false;
        int currentValue = (int)arr.get(0).get(col);
        for(ArrayList row : arr){
            if(currentValue != (int)row.get(col)){
                isDiff = true;
                break;
            }   
        }
        return isDiff;
    }

    /*
    public static void main( String[] args) {
      
      BufferedReader br = null;
        String[] input = new String[2];
        try {    
            br = new BufferedReader(new FileReader(args[0]));
            br.readLine(); // buang line pertama
            String[] arrInput;
            String currentLine; 
            while((currentLine = br.readLine()) != null){
                //System.out.println(currentLine);
                ArrayList<Integer> arrInnerData = new ArrayList<Integer>();
                arrInput = currentLine.split(",");
                for(int ii =0; ii<arrInput.length; ii++){
                    if(ii==0)
                        arrLabel.add(Integer.parseInt(arrInput[ii]));
                    else
                        arrInnerData.add(Integer.parseInt(arrInput[ii]));
                }
                arrData.add(arrInnerData);
            }
            arrData = preprocessing(arrData);
            printData(arrData);

    
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } */
}