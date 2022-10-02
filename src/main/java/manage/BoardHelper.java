package manage;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreation() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[aria-label='BoardIcon']"));
    }

    public void fillInBoardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),board.getTitle());
    }

    public void scrolldownTheForm() {
        Actions action= new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover']"));
        Rectangle rect = container.getRect();
        int x = rect.getX()+20;
        int y =rect.getY()+rect.getHeight()/2;
        action.moveByOffset(x,y).click().perform();
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void returnToHomePage() {
        click(By.cssSelector(".m2N684FcksCyfT"));

    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item"))
                .size()-1-recentlyViewedBoards();
    }
    public int recentlyViewedBoards(){
        return wd.findElements(By.xpath("//*[contains(@class,'icon-clock')]/../..//div"))
                .size();
    }
}
