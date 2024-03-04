import java.util.ArrayList;
import java.util.List;

public class heap <T extends Comparable<T>>{
    List<T> myData = new ArrayList<>();

    public boolean add(T data){
        myData.add(data);
        for (int index = myData.size() - 1;index != -1;){
            int father = getFather(index);
            if (father == -1){
                break;
            }
            if (myData.get(father).compareTo(data) < 0){
                T tep = myData.get(father);
                myData.set(father,data);
                myData.set(index,tep);
                index = father;
            }else {
                break;
            }
        }
        return true;
    }

    public T peek(){
        if (myData.isEmpty()){
            return null;
        }
        return myData.get(0);
    }

    public T poll(){
        if (myData.isEmpty()){
            return null;
        }

        T re = myData.get(0);

        int index = 0;

        while (true){
            int left = getLeftChild(index);
            if (left == -1){
                myData.set(index,myData.get(myData.size() - 1));
                myData.remove(myData.size() - 1);
                break;
            }
            int right = left + 1;
            int tep = left;
            if (right < myData.size()){
                if (myData.get(left).compareTo(myData.get(right)) < 0){
                    tep = right;
                }
            }
            myData.set(index,myData.get(tep));
            index = tep;
        }

        return re;
    }
    private int getFather(int index){
        if (index <= 0){
            return -1;
        }
        return (index - 1) / 2;
    }
    private int getLeftChild(int index){
        int re = index * 2 + 1;
        if (re>= myData.size()){
            re = -1;
        }

        return re;
    }

}
