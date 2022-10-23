package tests;

import manage.MyDataparovider;
import model.Board;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @BeforeMethod
    public void preconditions() {
        User user = new User().withEmail("evnikel@gmail.com").withPassword("EB106201eb!");
        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);

    }

    @Test(dataProvider = "boardDataModel",dataProviderClass = MyDataparovider.class)
    public void boardCreation1(Board board) {
        //Board board = new Board().withTitle("QA35");

        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreation();

        app.getBoard().fillInBoardCreationForm(board);

        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }
    @Test(dataProvider = "boardData",dataProviderClass = MyDataparovider.class)
    public void boardCreation2(String title) {
        // Board board = new Board().withTitle("QA35");

        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreation();
        app.getBoard().fillInBoardCreationForm(title);
        app.getBoard().scrolldownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

}