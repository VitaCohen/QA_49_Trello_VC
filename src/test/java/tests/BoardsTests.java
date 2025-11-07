package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

import java.util.Random;

public class BoardsTests extends AppManager {

    @BeforeMethod
    public void login() {
        User user = User.builder()
                .email("vita.cohen.test49@gmail.com")
                .password("Password123456!")
                .build();
        new HomePage(getDriver()).clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest() {
        int i = new Random().nextInt(1000);
        Board board = Board.builder()
                .boardTitle("Liv" + i)
                .build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        boardsPage.clickBtnCreate();
        Assert.assertTrue(new MyBoardPage(getDriver())
                .validateBoardName(board.getBoardTitle()));
    }

    @Test
    public void createNewBoardNegativeTestEmptyBoardTitle() {
        Board board = Board.builder()
                .boardTitle("")
                .build();
        BoardsPage boardsPage = new BoardsPage(getDriver());
        boardsPage.createNewBoard(board);
        Assert.assertTrue(boardsPage.buttonCreateIsNotClickable());


    }


}
