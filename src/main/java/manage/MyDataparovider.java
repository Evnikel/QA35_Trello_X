package manage;

import model.Board;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataparovider {

    @DataProvider
    public static Iterator<Object[]> boardData() {
        List<Object[]> list = new ArrayList<>();
        list.add((new Object[]{"qa35 test1"}));
        list.add((new Object[]{"qa35 test2"}));
        return  list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> boardDataModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new Board().withTitle("test3 qa35")});
        list.add(new Object[]{new Board().withTitle("test4 qa35")});
        return list.iterator();
    }

}
